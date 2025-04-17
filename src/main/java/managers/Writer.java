package managers;

import interfaces.Writable;

import java.io.BufferedOutputStream;
import java.io.File;

public class Writer implements Writable {
    private File filename = new File("data.csv");
    @Override
    public void writeCollection(){

    }
}
