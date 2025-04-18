package managers;
import interfaces.Console;
import managers.commands.Command;

import java.util.Scanner;

public class ConsoleManager implements Console{
    private Scanner scanner;
    private CommandManager commandManager;
    public ConsoleManager(Scanner scanner, CommandManager commandManager){
        this.commandManager = commandManager;
        this.scanner = scanner;
    }
    public void execute(){
        String curcmd;
        while(scanner.hasNext()){
            String line = scanner.nextLine().trim();
            if(!line.isEmpty()){
                if(line.equalsIgnoreCase("EXIT")) break;
                else{
                    String[] input = line.split(" ");
                    curcmd = input[0];
                    Command cmd = commandManager.getCommand(curcmd);
                    if(cmd == null){
                        System.out.println("Команда не найдена");
                        commandManager.getCommand("help").execute();
                    }
                    else{
                        commandManager.updateHistory(cmd);
                        boolean isArg = false;
                        String args = null;
                        try{
                            args = input[1];
                            isArg = true;
                            cmd.setScanner(scanner);
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                        }
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
