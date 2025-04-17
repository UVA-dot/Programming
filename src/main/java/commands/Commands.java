package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Commands {
    private static HashMap<String, Command> commands;
    private static List<Commands> latestCommands = new ArrayList<>();
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
    }
    public static HashMap<String, Command> getCommands(){
        return commands;
    }
    public static Command getCommand(String nameOfCmd){
        Optional<Command> cmd  = Optional.ofNullable(commands.get(nameOfCmd.toUpperCase()));
        return cmd.orElse(null);
    }

}
