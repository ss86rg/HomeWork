package View.Commands;

import View.ConcoleUI;

public class sortByAge extends Command {
    public sortByAge(ConcoleUI concoleUI) {
        super(concoleUI);
        description = "����������� �� ��������";
    }

    @Override
    public void execute() {
        concoleUI.sortByAge();
    }
}
