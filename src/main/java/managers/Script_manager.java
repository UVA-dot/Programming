package managers;

import managers.commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Script_manager {
    private File file_name;
    public Script_manager(File f){
        this.file_name = f;
    }
    public void exec() {
        try {
            Scanner scanner = new Scanner(this.file_name);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(!line.equalsIgnoreCase("EXIT")){
                    String[] input = line.split(" ");
                    String cmd = input[0];
                    CommandManager commandManager = CommandManager.getCommandManager();
                    Command getcomm = commandManager.getCommand(cmd);
                    if(getcomm != null){
                        commandManager.updateHistory(getcomm);
                        boolean isArg = false;
                        String arg = null;
                        try{
                            arg = input[1];
                            isArg = true;
                            getcomm.setScanner(scanner);
                        }catch (ArrayIndexOutOfBoundsException e){

                        }
                        if(isArg){
                            try{
                                getcomm.execute(arg);
                            }
                            catch (ArrayIndexOutOfBoundsException e){
                                System.out.println("Не указаны параметры для команды");
                            }
                        }
                        else{
                            try{
                                if(getcomm.executeScanner()){
                                    try {
                                        getcomm.execute(scanner);
                                    }catch(NoSuchElementException e){
                                        System.out.println("Ошибка при исполнении команды, требующей ввода полей с информацией о персонаже. Проверьте правильность ввода полей в скрипте");
                                    }
                                }
                                else{
                                    getcomm.execute();
                                }
                            }catch(ArrayIndexOutOfBoundsException e){
                                System.out.println("Не указаны параметры для команды");
                            }
                        }
                    }
                }
                else{
                    System.out.println("Команда не распознана");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Файл со скриптом не был найден");
        }
        catch(NullPointerException e){
            System.out.println("Пустой файл");
        }
    }
}
