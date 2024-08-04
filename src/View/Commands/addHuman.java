package View.Commands;

import View.ConcoleUI;

public class addHuman extends Command {


    public addHuman(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Добавление родственника";
    }

    @Override
    public void execute() {
        concoleUI.addHuman();
    }


}
