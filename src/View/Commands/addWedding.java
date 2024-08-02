package View.Commands;

import View.ConcoleUI;

public class addWedding extends Command {
    public addWedding(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Добавить супружескую связь";

    }

    @Override
    public void execute() {
        int Id1=0;
        int Id2=0;
        concoleUI.addWedding(Id1,Id2);
    }
}
