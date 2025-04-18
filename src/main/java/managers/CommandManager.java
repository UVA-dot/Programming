package managers;

import interfaces.Commandable;
import managers.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CommandManager implements Commandable<Command> {
    private static HashMap<String, Command> commands;
    private static List<Command> latestCommands = new ArrayList<>();
    private static CommandManager commandManager;
    private CommandManager(){}
    static{
        commands = new HashMap<>();
        Command help = commands.put("HELP", new Help());
        Command info = commands.put("INFO", new Info());
        Command clear = commands.put("CLEAR", new Clear());
        Command show = commands.put("SHOW", new Show());
        Command exit = commands.put("EXIT", new Exit());
        Command remove_by_id = commands.put("REMOVE_BY_ID", new Remove_by_id());
        Command head = commands.put("HEAD", new Head());
        Command remove_head = commands.put("REMOVE_HEAD", new Remove_head());
        Command History = commands.put("HISTORY", new History());
        Command Max_by_weight = commands.put("MAX_BY_WEIGHT", new Max_by_weight());
        Command Group_counting_by_type = commands.put("GROUP_COUNTING_BY_TYPE", new Group_counting_by_type());
        Command Save = commands.put("SAVE", new Save());
        Command Execute_script = commands.put("EXECUTE_SCRIPT", new Execute_script());
        Command Filter_less_than_character = commands.put("FILTER", new Filter_less_than_character());
    }
    @Override
    public HashMap<String, Command> getCommands(){
        return commands;
    }
    @Override
    public Command getCommand(String nameOfCmd){
        Optional<Command> cmd  = Optional.ofNullable(commands.get(nameOfCmd.toUpperCase()));
        return cmd.orElse(null);
    }
    public static CommandManager getCommandManager(){
        if(commandManager == null){
            commandManager = new CommandManager();
        }
        return commandManager;
    }
    @Override
    public void updateHistory(Command cmd){
        if(latestCommands.size() >= 10) latestCommands = latestCommands.subList(0, 9);
        latestCommands.add(cmd);
    }
    @Override
    public void printHistory(){
        System.out.println("Последние 10 команд: ");
        for(Command cmd: latestCommands){
            System.out.println(cmd.getName());
        }
    }

}
