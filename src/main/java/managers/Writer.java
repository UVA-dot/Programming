package managers;

import interfaces.Writable;
import models.Dragon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer implements Writable {
    private File filename = new File("data1.csv");
    @Override
    public void writeCollection(){
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            CollectionManager collectionManager = CollectionManager.getData();
            String models = "id,name,x,y,creationDate,age,weight,type,character,headSize\n";
            bos.write(models.getBytes());
            for(Dragon dragon: collectionManager.getCollection()){
                String data = dragon.getId().toString() + ","
                        + dragon.getName() + ","
                        + dragon.getCoordinates().getX()
                        + "," + dragon.getCoordinates().getY().toString()
                        + "," + dragon.getCreationDate().toString()
                        + "," + dragon.getAge().toString()
                        + "," + dragon.getWeight()
                        + "," + dragon.getType().toString()
                        + "," + dragon.getCharacter().toString()
                        + "," + dragon.getHead().getSize().toString() + "\n";
                bos.write(data.getBytes());

            }
            bos.flush();
            System.out.println("Данные успешно сохранены в файл: data.csv1");
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }
}
