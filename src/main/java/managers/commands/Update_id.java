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
       try{
            Integer id = Integer.parseInt(data);
            Dragon dragon = collectionManager.search(id);
            if(dragon != null){
                Scanner scanner = this.scanner;
                System.out.println("Введите какое поле хотите изменить");
            }
       }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Элемент с таким id не найден\nПопробуйте другой");
       }
    }
}
