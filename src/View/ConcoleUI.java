package View;

import Model.Human.Gender;
import Model.Human.Human;
import Presenter.Presenter;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConcoleUI implements View{
    private static final String INPUT_ERROR = "Ошибка, введите значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MenuUI menu;
    private int Id;

    public ConcoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MenuUI(this);
    }

    private void hello(){
        System.out.println("\n\n Здравствуйте!\n");
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
    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите пол (male/female)");
        Gender gender = null;
        boolean genderValid = false;
        while (!genderValid) {
            try {
                gender = Gender.valueOf(scanner.nextLine());
                genderValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Не верное значение введите male или female.");
            }
        }

        System.out.println("Дата рождения (формат yyyy-MM-dd)");
        LocalDate birthDate = null;
        boolean validBirthDate = false;

        while (!validBirthDate) {
            String birthDateInput = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(birthDateInput);
                validBirthDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Не верное значение, введите дату по образцу");
            }
        }


        System.out.println("Дата смерти  (Введите yyyy-MM-dd, или Enter если нет даты )");
        LocalDate deathDate = null;
        String deathDateInput = scanner.nextLine();
        if (!deathDateInput.isEmpty()) {
            deathDate = LocalDate.parse(deathDateInput);
        }

        presenter.addHuman(Id++,name,gender,null,null,birthDate, deathDate);}

    public void addWedding (int Id1, int Id2) {
        System.out.println("Номер супруга");
        Id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Номер супруги");
        Id2 = Integer.parseInt(scanner.nextLine());
        presenter.addWedding(Id1,Id2); }

    public void addParent(int childId, int Id1, int Id2) {
        System.out.println("Выбрать  Id ребенка, которому добавить отца и мать");
        childId = Integer.parseInt(scanner.nextLine());
        System.out.println("Id отца");
        Id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Id матери");
        Id2 = Integer.parseInt(scanner.nextLine());
        presenter.addParent(childId,Id1, Id2);
    }


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
        if (text.matches("[1-9]+")){
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
        System.out.println("Досвидания");

    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }


    }
    public void save(){
        presenter.save();
    }

    public void read(){
        presenter.read();
    }


}
