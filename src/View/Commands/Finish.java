package View.Commands;

import View.ConcoleUI;

public class Finish extends Command {
    public Finish(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Завершить работу";

    }

    @Override
    public void execute() {
        concoleUI.Finish();
    }
}
