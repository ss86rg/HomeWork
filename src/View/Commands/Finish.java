package View.Commands;

import View.ConcoleUI;

public class Finish extends Command {
    public Finish(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Завершение работы";

    }

    @Override
    public void execute() {
        concoleUI.Finish();
    }
}
