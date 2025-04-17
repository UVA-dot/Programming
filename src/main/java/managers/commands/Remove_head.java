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
        if(CollectionManager.getData() != null) {
            System.out.println("1-ый элемент коллекции {");
            System.out.println(collectionManager.getCollection().getFirst().toString());
            Dragon dragon = collectionManager.getCollection().getFirst();
            System.out.println("}");
            collectionManager.remove(dragon);
            System.out.println("Успешно удалён");
        }
        else {
            System.out.println("Коллекция пуста, показывать и удалять нечего");
        }
    }
}
