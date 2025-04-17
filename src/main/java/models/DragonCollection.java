package models;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class DragonCollection {
    private static final LocalDateTime localdatetime;
    static{
        localdatetime = LocalDateTime.now();
    }
    private static LinkedList<Dragon> dragons = new LinkedList<Dragon>();
    public static void setDragons(LinkedList<Dragon> dragons){
        DragonCollection.dragons = dragons;
    }
    public static void printInfo(){
        System.out.println("Тип коллекции: " + dragons.getClass().getName() + "\nДата инициализации: " + localdatetime + "\nКоличество элементов: " + dragons.size());
    }
    public static void print(){
        if(dragons.size() == 0){
            System.out.println("Коллекция пуста");
        }
        for(Dragon dragon: dragons){
            System.out.println("Дракон "+ dragon.getId() + " {");
            dragon.print();
            System.out.println("}");
        }
    }
    public static void clear(){
        dragons.clear();
    }
    public static Dragon search(int id){
        for(Dragon dragon:dragons) {
            if (id == dragon.getId()) {
                return dragon;
            }
        }
        System.out.println("Объекта с таким id не найдено в коллекции");
        return null;
    }
    public static void remove(Dragon dragon){
        dragons.remove(dragon);
    }
    public static LinkedList<Dragon> getData(){
        if(dragons.size() != 0) {
            return dragons;
        }
        return null;
    }
    public static void put(Dragon dragon){
        dragons.add(dragon);
        System.out.println("Dragon" + dragon.getName() + " добавлен в коллекцию");
    }
}
