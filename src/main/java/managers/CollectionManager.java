package managers;

import interfaces.Collectionable;
import models.Dragon;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class CollectionManager implements Collectionable<Dragon> {
    private static final LocalDateTime localdatetime;
    static{
        localdatetime = LocalDateTime.now();
    }
    private static CollectionManager collection;
    private LinkedList<Dragon> dragons = new LinkedList<Dragon>();
    @Override
    public void setCollection(LinkedList<Dragon> dragons){
        this.dragons = dragons;
    }
    @Override
    public LinkedList<Dragon> getCollection(){
        return dragons;
    }
    private CollectionManager(){
    }

    @Override
    public void printInfo(){
        System.out.println("Тип коллекции: " + dragons.getClass().getName() + "\nДата инициализации: " + localdatetime + "\nКоличество элементов: " + dragons.size());
    }
    @Override
    public void print(){
        if(dragons.size() == 0){
            System.out.println("Коллекция пуста");
        }
        for(Dragon dragon: dragons){
            System.out.println("Дракон "+ dragon.getId() + " {");
            System.out.println(dragon.toString());
            System.out.println("}");
        }
    }
    @Override
    public void clear(){
        dragons.clear();
    }
    @Override
    public Dragon search(int id){
        for(Dragon dragon:dragons) {
            if (id == dragon.getId()) {
                return dragon;
            }
        }
        System.out.println("Объекта с таким id не найдено в коллекции");
        return null;
    }
    @Override
    public void remove(Dragon dragon){
        dragons.remove(dragon);
    }
    public static CollectionManager getData(){
        if(collection == null) {
            collection = new CollectionManager();
        }
        return collection;
    }
    @Override
    public void put(Dragon dragon){
        dragons.add(dragon);
        System.out.println("Dragon" + dragon.getName() + " добавлен в коллекцию");
    }
}
