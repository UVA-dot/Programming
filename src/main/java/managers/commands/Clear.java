package managers.commands;

import managers.CollectionManager;

public class Clear extends Command {
    public Clear(){
        super("Clear", "Очистить коллекцию");

    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.clear();
    }
}
