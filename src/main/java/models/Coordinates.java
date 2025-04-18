package models;

public class Coordinates {
    private long x; //Максимальное значение поля: 353
    private Integer y; //Поле не может быть null
    public Coordinates(){}
    public Coordinates(long x, Integer y){
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    public void setX(Long x){
        this.x = x;
    }
    public void setY(Integer y){
        this.y = y;
    }
}

