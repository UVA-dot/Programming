package commands;

import models.DragonCollection;

public class Clear extends Command{
    public Clear(){
        super("Clear", "Очистить коллекцию");

    }
    @Override
    public void execute(){
        DragonCollection.clear();
        System.out.println("Коллекция очищена успешно!\n");
    }
}
