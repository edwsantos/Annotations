# Annotations
In this repo, you are going to find projects with different examples of annotations.

## What is an annotation?
Annotations are basically tags that we can add to java code in order to:
* Inform the compiler about warning or errors.
* Manipulate the source code at compilation time.
* Modify or examine behaviour at runtime.

## Characteristics of annotations
* Annotations can have attributes
* Annotations can be placed for: classes, interfaces, , methods, fields. Furthermore, we can set where the annotation
is going to be placed, for example, we can create an annotation that only applies for methods so that if a developer
places the annotation on a class, there will be a compiler error.

## Retention policy
To understand the retention policy, we need to keep in mind 3 stages in the development process: 
1. Coding
2. Compiling time 
3. Runtime

So that, the first stage is coding, when you *codes* the app (Coding), then, when you're ready, you *compile* the 
application (compiling time) and finally you *executes* the application (runtime).

Having said this, when we are creating a new annotation, we can define the what point the annotation should be discarded:
1. **SOURCE**: Annotations set with retention policy as SOURCE will be retained only in the source code and will be 
discarded during compiling time.
2. **CLASS**: Annotations set with retention policy as CLASS will be retained untill compiling time and will be discarded
during runtime.
*This is the default value*
3. **RUNTIME**: Annotations set with retention policy as RUNTIME will be available to the JVM during runtime.