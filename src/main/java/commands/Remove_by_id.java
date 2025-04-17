package commands;

import models.Dragon;
import models.DragonCharacter;
import models.DragonCollection;

import java.text.spi.NumberFormatProvider;

public class Remove_by_id extends Command{
    public Remove_by_id(){
        super("Remove_by_id", "Удаляет элемент по заданному id");
    }
    @Override
    public void execute(String data){
        try{
            Integer id = Integer.parseInt(data);
            Dragon dragon = DragonCollection.search(id);
            if(dragon != null) {
                DragonCollection.remove(dragon);
                System.out.println("Элемент с id = " + id + " успешно удалён!");
            }
        }
        catch (NumberFormatException e){
            System.out.println("ID должен быть целым числом");
        }
        catch (NullPointerException ignored){}
    }
}
