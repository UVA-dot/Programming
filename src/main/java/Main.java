import managers.*;
import managers.commands.Command;
import models.Dragon;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Введите путь к файлу csv в аргумент командной строки");
        } else {
            CollectionManager collectionManager = CollectionManager.getData();
            LinkedList<Dragon> result;
            String FilePath = args[0];
            Reader fileReader = new Reader(FilePath);
            result = fileReader.readCollection();
            collectionManager.setCollection(result);
            System.out.println("Пожалуйста введите команду");
            Scanner scanner = new Scanner(System.in);
            CommandManager commandManager = CommandManager.getCommandManager();
            ConsoleManager consoleManager = new ConsoleManager(scanner, commandManager);
            consoleManager.execute();
        }
    }
}

