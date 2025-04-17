package managers.commands;

import managers.CollectionManager;

public class Head extends Command {
    public Head(){
        super("Head","Выводит первый элемент коллекции");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        if(collectionManager.getCollection() != null) {
            System.out.println("1-ый элемент коллекции {");
            System.out.println(collectionManager.getCollection().getFirst().toString());
            System.out.println("}");
        }
        else{
            System.out.println("Коллекция пуста");
        }
    }
}
