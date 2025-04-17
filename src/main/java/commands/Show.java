package commands;

import models.DragonCollection;

public class Show extends Command{
    public Show(){
        super("Show","Вывести все элементы коллекции в строковом представлении");
    }
    @Override
    public void execute(){
        DragonCollection.print();
    }
}
