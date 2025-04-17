package commands;

import models.DragonCollection;

public class Info extends Command {
    public Info(){
        super("Info","Вывести информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    @Override
    public void execute(){
        DragonCollection.printInfo();
    }
}
