package managers.commands;

import models.Dragon;
import managers.CollectionManager;

public class Max_by_weight extends Command {
    public Max_by_weight(){
        super("Max_by_weight", "Выводит любой элемент коллекции, значение поля weight, которого является максимальным");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.max_by_weight(collectionManager);
    }
}
