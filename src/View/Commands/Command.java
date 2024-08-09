package View.Commands;

import View.ConcoleUI;

public abstract class Command {   //  соблюдается  Принцип инверсии зависимостей
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
