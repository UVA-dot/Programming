package managers;

import interfaces.Collectionable;
import models.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

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
        System.out.println("Коллекция очищена успешно!\n");
    }
    public void max_by_weight(CollectionManager collectionManager){
        Dragon max_weight_dragon = collectionManager.getCollection().getFirst();
        Long max_weight = collectionManager.getCollection().getFirst().getWeight();
        for(Dragon dragon: collectionManager.getData().getCollection()){
            if(dragon.getWeight() > max_weight){
                max_weight_dragon = dragon;
                max_weight = dragon.getWeight();
            }
        }
        System.out.println(max_weight_dragon.toString());
    }
    public void head(CollectionManager collectionManager){
        if(collectionManager.getCollection() != null) {
            System.out.println("1-ый элемент коллекции {");
            System.out.println(collectionManager.getCollection().getFirst().toString());
            System.out.println("}");
        }
        else{
            System.out.println("Коллекция пуста");
        }
    }
    public void group_by(CollectionManager collectionManager){
        for(DragonType cnt: DragonType.values()) {
            Integer value = 0;
            System.out.println("Вывод драконов типа " + cnt.toString() + " {");
            for (Dragon dragon : collectionManager.getCollection()) {
                if(dragon.getType() == cnt){
                    System.out.println(dragon.toString());
                    value++;
                }
            }
            System.out.println("}\nДраконов типа " + cnt.toString() +  ": " + value + "\n");
        }
    }
    public void update_id(String data, CollectionManager collectionManager){

    }
    public void filter(String data, CollectionManager collectionManager){
        boolean found = false;
        try {
            Integer value = Integer.parseInt(data);
            for (Dragon dragon : collectionManager.getCollection()) {
                if (dragon.getCharacter() != null && dragon.getCharacter().ordinal() < value) {
                    System.out.println(dragon.toString());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Дракона с меньшим значением характера не найдено");
            }
        }catch (NumberFormatException e){
            System.out.println("Параметр команды должен быть числом");
        }
    }
    public void remove_head(CollectionManager collectionManager){
        if(collectionManager.getData() != null) {
            System.out.println("1-ый элемент коллекции {");
            System.out.println(collectionManager.getCollection().getFirst().toString());
            Dragon dragon = collectionManager.getCollection().getFirst();
            System.out.println("}");
            collectionManager.remove(dragon);
            System.out.println("Успешно удалён");
        }
        else {
            System.out.println("Коллекция пуста, показывать и удалять нечего");
        }
    }
    public void remove_by_id(String data, CollectionManager collectionManager){
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
    public void add(Scanner scanner){
        Validator validator = new Validator();
        Dragon dragon = new Dragon();
        DragonHead dragonHead = new DragonHead();
        Coordinates coordinates = new Coordinates();
        ConsoleManager consoleManager = new ConsoleManager(scanner, CommandManager.getCommandManager(), validator);
        dragon.setId(consoleManager.setId());
        dragon.setCreationDate(consoleManager.setTime());
        while(true) {
            System.out.println("Введите поле name элемента: ");
            String name = consoleManager.inputFieldString();
            if (validator.validatingName(name)) {
                dragon.setName(name);
                break;
            }
            System.out.println("Поле не может быть пустым: ");
        }
        while(true){
            System.out.println("Введите поле x: ");
            long x = Long.parseLong(String.valueOf(consoleManager.inputFieldNumber()));
            if(validator.validatingX(x)){
                coordinates.setX(x);
                break;
            }
            System.out.println("Поле должно быть числом, максимальное значение поля 353");
        }
        while(true){
            System.out.println("Введите поле y:");
            Integer y = consoleManager.inputFieldNumber();
            if(validator.validatingY(y)){
                coordinates.setY(y);
                break;
            }
            System.out.println("Поле не может быть null");
        }
        dragon.setCoordinates(coordinates);
        while(true){
            System.out.println("Введите поле age: ");
            Integer age = consoleManager.inputFieldNumber();
            if(validator.validatingAge(age)){
                dragon.setAge(age);
                break;
            }
            System.out.println("Поле должно быть больше 0 и не может быть null");
        }
        while(true){
            System.out.println("Введите поле weight: ");
            Long weight = Long.parseLong(String.valueOf(consoleManager.inputFieldNumber()));
            if(validator.validatingWeight(weight)){
                dragon.setWeight(weight);
                break;
            }
            System.out.println("Поле должно быть больше 0");
        }
        while(true){
            System.out.println("Введите поле type: ");
            String type = consoleManager.inputFieldString();
            if(validator.validatingType(type)){
                dragon.setType(DragonType.valueOf(type));
                break;
            }
            System.out.println("Значения поля нет в enum DragonType");
        }
        while(true){
            System.out.println("Введите поле character: ");
            String character = consoleManager.inputFieldString();
            if(validator.validatingChar(character)){
                dragon.setCharacter(DragonCharacter.valueOf(character));
                break;
            }
            System.out.println("Значения поля нет в enum DragonCharacter");
        }
        System.out.println("Введите поле size");
        Float size = Float.parseFloat(String.valueOf(consoleManager.inputFieldFloatNumber()));
        dragonHead.setSize(size);
        dragon.setHead(dragonHead);
        collection.put(dragon);
        System.out.println("Дракон успешно добавлен в коллекцию!");
    }
    @Override
    public void put(Dragon dragon){
        dragons.add(dragon);
        System.out.println("Dragon" + dragon.getName() + " добавлен в коллекцию");
    }
}
