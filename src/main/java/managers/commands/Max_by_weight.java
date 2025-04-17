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
        Dragon max_weight_dragon = collectionManager.getCollection().getFirst();
        Long max_weight = collectionManager.getCollection().getFirst().getWeight();
        for(Dragon dragon: collectionManager.getData().getCollection()){
            if(dragon.getWeight() > max_weight){
                max_weight_dragon = dragon;
                max_weight = dragon.getWeight();
            }
        }
        System.out.println(max_weight_dragon.toString());
    }
}
