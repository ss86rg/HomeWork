package View.Commands;

import View.ConcoleUI;

public class addWedding extends Command {
    public addWedding(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Добавить супружескую связь";

    }

    @Override
    public void execute() {
        concoleUI.addWedding();
    }
}
