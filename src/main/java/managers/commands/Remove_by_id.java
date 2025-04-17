package managers.commands;

import models.Dragon;
import managers.CollectionManager;

public class Remove_by_id extends Command {
    public Remove_by_id(){
        super("Remove_by_id", "Удаляет элемент по заданному id");
    }
    @Override
    public void execute(String data){
        CollectionManager collectionManager = CollectionManager.getData();
        try{
            Integer id = Integer.parseInt(data);
            Dragon dragon = collectionManager.search(id);
            if(dragon != null) {
                collectionManager.remove(dragon);
                System.out.println("Элемент с id = " + id + " успешно удалён!");
            }
        }
        catch (NumberFormatException e){
            System.out.println("ID должен быть целым числом");
        }
        catch (NullPointerException ignored){}
    }
}
