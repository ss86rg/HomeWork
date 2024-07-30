package View;

import Presenter.Presenter;

import java.awt.*;
import java.util.Scanner;

public class ConcoleUI {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MenuUI menu;

    public ConcoleUI(System.in) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MenuUI(this);
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }
    public void addHuman(){presenter.getHumanListInfo();}

    public void addWedding() { presenter.getHumanListInfo(); }


    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[1-7]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void Finish() {
        System.out.println("Приятно было пообщаться");


    }

}
