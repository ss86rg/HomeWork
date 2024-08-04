package View.Commands;

import View.ConcoleUI;

public class sortByName extends Command {
    public sortByName(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "Сортировка по имени";
    }

    @Override
    public void execute() {
        concoleUI.sortByName();

    }
}
