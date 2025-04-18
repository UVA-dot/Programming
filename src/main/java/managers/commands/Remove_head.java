package managers.commands;

import models.Dragon;
import managers.CollectionManager;

public class Remove_head extends Command {
    public Remove_head(){
        super("Remove_head", "Вывести первый элемент коллекции и удалить его");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.remove_head(collectionManager);
    }
}
