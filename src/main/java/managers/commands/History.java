package managers.commands;

import managers.CommandManager;

public class History extends Command{
    public History(){
        super("History", "Выводит последние 10 команд(без аргументов)");
    }
    @Override
    public void execute(){
        CommandManager commandManager = CommandManager.getCommandManager();
        commandManager.printHistory();
    }
}
