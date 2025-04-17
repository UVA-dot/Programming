package managers.commands;

import managers.CollectionManager;

public class Show extends Command {
    public Show(){
        super("Show","Вывести все элементы коллекции в строковом представлении");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.print();
    }
}
