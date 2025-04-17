package commands;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Command {
    private String name;
    private String description;
    protected boolean flagscanner = false;
    protected Scanner scanner;
    public Command(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Scanner getScreen(){
        return scanner;
    }
    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }
    public boolean executeScanner(){
        return flagscanner;
    }
    public void execute() throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }
    public void execute(String data) throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }
    public void execute(Scanner scanner) throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }
}
