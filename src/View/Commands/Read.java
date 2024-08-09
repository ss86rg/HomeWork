package View.Commands;

import View.ConcoleUI;

public class Read extends Command{
    public Read(ConcoleUI concoleUI){
       super(concoleUI);
       description = "Загрузить данные древа";
   }

        @Override
        public void execute() {
        concoleUI.read();
   }
}
