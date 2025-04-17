package commands;

import models.Dragon;
import models.DragonCharacter;
import models.DragonCollection;

public class Remove_head extends  Command{
    public Remove_head(){
        super("Remove_head", "Вывести первый элемент коллекции и удалить его");
    }
    @Override
    public void execute(){
        if(DragonCollection.getData() != null) {
            System.out.println("1-ый элемент коллекции {");
            DragonCollection.getData().getFirst().print();
            Dragon dragon = DragonCollection.getData().getFirst();
            System.out.println("}");
            DragonCollection.remove(dragon);
            System.out.println("Успешно удалён");
        }
        else {
            System.out.println("Коллекция пуста, показывать и удалять нечего");
        }
    }
}
