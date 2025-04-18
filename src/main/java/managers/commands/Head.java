package managers.commands;

import managers.CollectionManager;

public class Head extends Command {
    public Head(){
        super("Head","Выводит первый элемент коллекции");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.head(collectionManager);
    }
}
