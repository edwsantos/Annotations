# New annotation and processing example
In this module we are going to use annotations for creating a factory (if you don't know what a factory is, you can 
check my factory pattern repository by [clicking here](/edwsantos/DesignPatterns/tree/master/factory/README.md)).

We're going to create a simple **factory of credit cards** (like in the repository above).

So the idea in this example is:
* To create a new annotation for the elements of the factory and use it on the corresponding classes.
* With annotation processing, read the classes annotated and create a factory method class with the corresponding 
    if statements according the factory elements.

### To set up the project
We´re going to use:
* Maven: We are going to use maven as our dependency management tool.
* Google Auto-Service: this is a library to generate processor metadata file