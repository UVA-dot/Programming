package commands;

public class Help extends Command {
    public Help(){
        super("Help","Вывести справку по доступным командам");
    }
    @Override
    public void execute(){
        System.out.println("Список доступных команд:");
        for(Command cmd: Commands.getCommands().values()){
            System.out.println(cmd.getName() + ": " + cmd.getDescription());
        }
    }
}
