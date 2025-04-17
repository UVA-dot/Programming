package interfaces;

import managers.commands.Command;

import java.util.HashMap;

public interface Commandable<T> {
    public void printHistory();
    public void updateHistory(T element);
    public HashMap<String, T> getCommands();
    public Command getCommand(String nameOfCmd);
}
