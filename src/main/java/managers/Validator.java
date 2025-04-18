package managers;

import models.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Validator {
    public Validator(){
    }
    public boolean validatingName(String name){
        return name != null && !name.isEmpty();
    }
    public boolean validatingX(Long x){
        return x <= 353;
    }
    public boolean validatingY(Integer y){
        return y != null;
    }
    public boolean validatingAge(Integer age){
        return age != null && age > 0;
    }
    public boolean validatingWeight(Long weight){
        return weight > 0;
    }
    public boolean validatingType(String type){
        boolean flag = false;
        for(DragonType dragonType: DragonType.values()){
            if(dragonType.toString().equals(type)){
                flag = true;
            }
        }
        return flag;
    }
    public boolean validatingChar(String character){
        boolean flag = false;
        for(DragonCharacter dragonCharacter: DragonCharacter.values()){
            if(dragonCharacter.toString().equals(character)){
                flag = true;
            }
        }
        return flag;
    }
}
