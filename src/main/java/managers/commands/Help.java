package managers.commands;

import managers.CommandManager;
import managers.commands.Command;

public class Help extends Command {
    public Help(){
        super("Help","Вывести справку по доступным командам");
    }
    @Override
    public void execute(){
        System.out.println("Список доступных команд:");
        CommandManager commandManager = CommandManager.getCommandManager();
        for(Command cmd: commandManager.getCommands().values()){
            System.out.println(cmd.getName() + ": " + cmd.getDescription());
        }
    }
}
