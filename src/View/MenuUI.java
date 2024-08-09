package View;

import View.Commands.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuUI {
    private List<Command> commandList;

    public MenuUI(ConcoleUI concoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new getHumanListInfo(concoleUI));
        commandList.add(new addHuman(concoleUI));
        commandList.add(new addWedding(concoleUI));
        commandList.add(new addParent(concoleUI));
        commandList.add(new sortByName(concoleUI));
        commandList.add(new sortByAge(concoleUI));
        commandList.add(new Save(concoleUI));
        commandList.add(new Read(concoleUI));
        commandList.add(new Finish(concoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
