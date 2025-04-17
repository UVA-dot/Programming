package commands;

import models.DragonCollection;

public class Head extends Command{
    public Head(){
        super("Head","Выводит первый элемент коллекции");
    }
    @Override
    public void execute(){
        if(DragonCollection.getData() != null) {
            System.out.println("1-ый элемент коллекции {");
            DragonCollection.getData().getFirst().print();
            System.out.println("}");
        }
        else{
            System.out.println("Коллекция пуста");
        }
    }
}
