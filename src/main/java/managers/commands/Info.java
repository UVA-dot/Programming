package managers.commands;

import managers.CollectionManager;

public class Info extends Command {
    public Info(){
        super("Info","Вывести информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
    @Override
    public void execute(){
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.printInfo();
    }
}
