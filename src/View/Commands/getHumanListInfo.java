package View.Commands;

import View.ConcoleUI;

public class getHumanListInfo extends Command {
    public getHumanListInfo(ConcoleUI concoleUI) {
        super(concoleUI);
        description= "Список родственников";
    }



    public void execute(){
        concoleUI.getHumanListInfo();
    }
}
