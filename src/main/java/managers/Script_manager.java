package managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Script_manager {
    private File file_name;
    public Script_manager(File f){
        this.file_name = f;
    }
    public void exec() {
        try {
            Scanner scanner = new Scanner(this.file_name);
            CommandManager commandManager = CommandManager.getCommandManager();
            Validator validator = new Validator();
            ConsoleManager consoleManager = new ConsoleManager(scanner, commandManager, validator);
            consoleManager.executeConsole();
        }
        catch(FileNotFoundException e){
            System.out.println("Файл со скриптом не был найден");
        }
        catch(NullPointerException e){
            System.out.println("Пустой файл");
        }
    }
}
