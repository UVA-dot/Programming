package models;

import models.Coordinates;
import java.time.LocalDateTime;

public class Dragon {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле не может быть null
    private long weight; //Значение поля должно быть больше 0
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonHead head;
    public Dragon(){}
    public Dragon(Integer id,
                  String name,
                  Coordinates coordinates,
                  LocalDateTime creationdate,
                  Integer age,
                  long weight,
                  DragonType type,
                  DragonCharacter character,
                  DragonHead head){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationdate;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this. character = character;
        this.head = head;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public DragonHead getHead() {
        return head;
    }

    public DragonType getType() {
        return type;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public long getWeight() {
        return weight;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
    @Override
    public String toString(){
        return ("id: " + id + "\nname: " + name + "\ncoordinates: " + coordinates.getX() + ", " + coordinates.getY() + "\ncreationDate: " + creationDate + "\nage: " + age + "\nweight: " + weight + "\ntype: " + type + "\ndragoncharacter: " + character + "\ndragonhead: " + head.getSize());
    }
}
