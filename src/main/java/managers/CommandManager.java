package managers;

import interfaces.Commandable;
import managers.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CommandManager implements Commandable<Command> {
    private static HashMap<String, Command> commands = new HashMap<>();
    private static List<Command> latestCommands = new ArrayList<>();
    private static CommandManager commandManager;
    private CommandManager(){}
    static{
        commands.put("HELP", new Help());
        commands.put("INFO", new Info());
        commands.put("CLEAR", new Clear());
        commands.put("SHOW", new Show());
        commands.put("EXIT", new Exit());
        commands.put("REMOVE_BY_ID", new Remove_by_id());
        commands.put("HEAD", new Head());
        commands.put("REMOVE_HEAD", new Remove_head());
        commands.put("HISTORY", new History());
        commands.put("MAX_BY_WEIGHT", new Max_by_weight());
        commands.put("GROUP_COUNTING_BY_TYPE", new Group_counting_by_type());
        commands.put("SAVE", new Save());
        commands.put("EXECUTE_SCRIPT", new Execute_script());
        commands.put("FILTER", new Filter_less_than_character());
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
