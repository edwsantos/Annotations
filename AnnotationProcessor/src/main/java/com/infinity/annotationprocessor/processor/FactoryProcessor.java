package com.infinity.annotationprocessor.processor;

import com.google.auto.service.AutoService;
import com.infinity.annotationprocessor.definition.FactoryElement;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes("com.infinity.annotationprocessor.definition.FactoryElement")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class FactoryProcessor extends AbstractProcessor {
    private Messager messager;
    private Filer filter;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.filter = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try{

            for(int i=0; i<5; i++){
                messager.printMessage(
                        Diagnostic.Kind.WARNING,
                        "*******************************************************");
            }

            // Get the classes annotated
            final Set<? extends Element> classesWithFactoryAnnotation = roundEnv.getElementsAnnotatedWith(FactoryElement.class);

            //Create the factory class
            String factoryName = getFactoryName(classesWithFactoryAnnotation.iterator().next().getAnnotation(FactoryElement.class));
            String factoryTypeName = getFactoryTypeName(classesWithFactoryAnnotation.iterator().next().getAnnotation(FactoryElement.class));

            JavaFileObject factoryFile = this.filter.createSourceFile("com.infinity.annotation.processingexample." + factoryName);
            PrintWriter fileWriter = new PrintWriter(factoryFile.openWriter());
            fileWriter.println("package com.infinity.annotation.processingexample;");
            fileWriter.println("");
            fileWriter.println("import java.util.NoSuchElementException;");
            fileWriter.println("");
            fileWriter.println("public class " + factoryName + "{");
            fileWriter.println("");
            fileWriter.println("public " + factoryTypeName + " getCreditCard(String creditCardName) {");
            fileWriter.println("switch (creditCardName.toUpperCase()) {");

            //Loop over classes with the annotation
            for (Element classWithFactoryAnnotation : classesWithFactoryAnnotation) {
                FactoryElement annotation = classWithFactoryAnnotation.getAnnotation(FactoryElement.class);
                // Create a switch by each class annotated
                fileWriter.println("case \"" + annotation.id().toUpperCase()  + "\" :");
                fileWriter.println("return new " + classWithFactoryAnnotation.getSimpleName() + "();");
            }
            fileWriter.println("default: ");
            fileWriter.println("throw new NoSuchElementException(\"No Element found\");");
            fileWriter.println("}");//closes switch
            fileWriter.println("}");//closes method
            fileWriter.println("}");//closes class
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private String getFactoryTypeName(FactoryElement annotation){
        String factoryClassName;
        try{
            final Class factoryType = annotation.type();
            factoryClassName = factoryType.getSimpleName();
        } catch (MirroredTypeException e) {
            factoryClassName = ((DeclaredType)e.getTypeMirror()).asElement().getSimpleName().toString();
        }
        return factoryClassName;
    }

    private String getFactoryName(FactoryElement annotation) {
        return getFactoryTypeName(annotation) + "Factory";
    }
}
