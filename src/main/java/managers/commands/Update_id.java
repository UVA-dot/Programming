package managers.commands;

import managers.CommandManager;
import models.Dragon;
import managers.CollectionManager;

import java.util.Scanner;

public class Update_id extends Command {
    public Update_id(){
        super("Update_id", "Обновить значение элемента коллекции, id которого равен введённому параметру");
    }

    @Override
    public void execute(String data) throws ArrayIndexOutOfBoundsException {
        CollectionManager collectionManager = CollectionManager.getData();
        collectionManager.update_id(data, collectionManager);
    }
}
