package Presenter;

import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Service.Service;
import Model.Writable.FileHandler;
import Model.Writable.Writable;
import View.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler());

    }

    public void getHumanListInfo() {
        String info = service.getHumanListInfo();
        view.printAnswer(info);
    }

    public void addHuman(int Id, String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        service.addHuman(Id++, name, gender, null, null, birthDate, deathDate);
        getHumanListInfo();
    }

    public void addWedding(int Id1, int Id2) {
        service.addWedding(Id1, Id2);
        getHumanListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void save() {
        service.save();

    }

    public void read() {
        service.read();

    }


    public void addParent(int childId, int Id1, int Id2) {
        service.addParent(childId, Id1, Id2);
    }

}
