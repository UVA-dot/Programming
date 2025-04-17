import commands.Command;
import commands.Commands;
import models.Dragon;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import models.Dragon;
import models.DragonCollection;

public class Main {
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Введите путь к файлу csv");
        }
        else{
            LinkedList<Dragon> result = new LinkedList<>();
            String FilePath = args[0];
            Reader fileReader = new Reader(FilePath);
            result = fileReader.readCollection();
            DragonCollection.setDragons(result);
            System.out.println("\nПожалуйста введите команду");
            commandloop();
        }
    }
    private static void commandloop(){
        Scanner scanner = new Scanner(System.in);
        String curcmd;
        while(scanner.hasNext()){
            String line = scanner.nextLine().trim();
            if(!line.equals("")){
                if(line.toUpperCase().equals("EXIT")) break;
                else{
                    String[] input = line.split(" ");
                    curcmd = input[0];
                    Command cmd = Commands.getCommand(curcmd);
                    if(cmd == null){
                        System.out.println("Команда не найдена");
                        Commands.getCommand("help").execute();
                    }
                    else{
                        boolean isArg = false;
                        String args = null;
                        try{
                            args = input[1];
                            isArg = true;
                            cmd.setScanner(scanner);
                        }
                        catch (ArrayIndexOutOfBoundsException e){}
                        if(isArg){
                            try{
                                cmd.execute(args);
                            }
                            catch (ArrayIndexOutOfBoundsException e){
                                System.out.println("Команда не подразумевает аргументов");
                            }
                        }
                        else{
                            try{
                                if(cmd.executeScanner()){
                                    cmd.execute(scanner);
                                }
                                else{
                                    cmd.execute();
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e){
                                System.out.println("Ожидались параметры для этой команды");
                            }
                        }
                    }
                }
            }
        }
    }
}

