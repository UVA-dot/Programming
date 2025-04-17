package managers;

import interfaces.Readable;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.FileReader;
public class Reader implements Readable {
    private String name;
    Reader(){
        this.name = "";
    }
    public Reader(String name){
        this.name = name;
    }
    public void setname(String name){
        this.name = name;
    }
    public String getname(){
        return this.name;
    }
    public LinkedList<Dragon> readCollection(){
        LinkedList<Dragon> dragons = new LinkedList<Dragon>();
        List<String> data = new ArrayList<>();
        try(FileReader fr = new FileReader(name)) {
            String line = "";
            int cnt;
            while((cnt = fr.read()) != -1){
                if((char) cnt == '\n'){
                    data.add(line);
                    line = "";
                }
                else {
                    line += (char) cnt;

                }

            }
            data.add(line);
        }

        catch(IOException e){
            System.out.println("Ошибка при чтении файла " + e.getMessage());
        }
        for(int i=1;i<data.size();i++){
            dragons.add(CSVconverting(data.get(i)));
        }
        return dragons;
    }
    public static Dragon CSVconverting(String line){
        String[] CSV = line.split(",");
        Integer id = Integer.parseInt(String.valueOf(CSV[0]));
        String name = String.valueOf(CSV[1]);
        Long x = Long.parseLong(String.valueOf(CSV[2]));
        Integer y = Integer.parseInt(String.valueOf(CSV[3]));
        Coordinates coordinates = new Coordinates(x, y);
        LocalDateTime localDateTime = LocalDateTime.parse(String.valueOf(CSV[4]));
        Integer age = Integer.parseInt(String.valueOf(CSV[5]));
        Long weight = Long.parseLong(String.valueOf(CSV[6]));
        DragonType type = DragonType.valueOf(String.valueOf(CSV[7]));
        DragonCharacter character = DragonCharacter.valueOf(String.valueOf(CSV[8]));
        Float headsize = Float.parseFloat(String.valueOf(CSV[9]));
        DragonHead head = new DragonHead(headsize);
        Dragon dragon = new Dragon(id,
                name,
                coordinates,
                localDateTime,
                age,
                weight,
                type,
                character,
                head);
        return dragon;
    }

}
