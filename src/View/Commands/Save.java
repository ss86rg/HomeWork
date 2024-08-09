package View.Commands;

import View.ConcoleUI;

public class Save extends Command{

    public Save(ConcoleUI concoleUI){
       super(concoleUI);
       description = "Сохранить записи";
   }
        @Override
        public void execute() { concoleUI.save();}
}
