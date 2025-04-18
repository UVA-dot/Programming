package managers.commands;

import managers.Script_manager;

import java.io.File;
import java.util.Stack;

public class Execute_script extends Command{
    public Execute_script(){
        super("Execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");

    }
    @Override
    public void execute(String filename){
        File file = new File(filename);
        if(file.exists()){
            Script_manager scriptManager = new Script_manager(file);
            try{
                scriptManager.exec();
            }
            catch (StackOverflowError e){
                System.out.println("Файл-скрипт составлен неверно");
            }
        }
        else{
            System.out.println("Файл-скрипт с таким именем не был найден");
        }
    }
}
