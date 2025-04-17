package managers.commands;

import models.Dragon;
import managers.CollectionManager;
import models.DragonType;

public class Group_counting_by_type extends Command{
    public Group_counting_by_type(){
        super("Group_counting_by_type", "сгруппировать элементы коллекции по значению поля type, вывести количество элементов в каждой группе");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        for(DragonType cnt: DragonType.values()) {
            Integer value = 0;
            System.out.println("Вывод драконов типа " + cnt.toString() + " {");
            for (Dragon dragon : collectionManager.getCollection()) {
                if(dragon.getType() == cnt){
                    System.out.println(dragon.toString());
                    value++;
                }
            }
            System.out.println("}\nДраконов типа " + cnt.toString() +  ": " + value + "\n");
        }
    }
}
