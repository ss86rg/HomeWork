package View.Commands;

import View.ConcoleUI;

public class addParent extends Command{

    public addParent(ConcoleUI concoleUI){
        super(concoleUI);
        description = "Добавить родителя к ребенку";
    }

    @Override
    public void execute() {
        int Id1=0;
        int Id2=0;
        int childId = 0;
        concoleUI.addParent(childId,Id1,Id2);
    }
}
