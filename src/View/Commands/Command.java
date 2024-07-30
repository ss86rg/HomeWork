package View.Commands;

import View.ConcoleUI;

public abstract class Command {
    String description;
    ConcoleUI concoleUI;

    public Command(ConcoleUI consoleUI) {
        this.concoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
