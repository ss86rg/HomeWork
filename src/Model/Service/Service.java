package Model.Service;

import Model.FamilyTree.Animals;
import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Writable.Writable;

import java.time.LocalDate;

public class Service {
    private int Id;
    private FamilyTree<Human> familyTree;
    private Writable writable;

                                               //    соблюдается Принцип подстановки Лисков
    public Service(Writable writable) {
        familyTree = new FamilyTree<Human>();
        this.writable = writable;

    }


    public void addHuman(int Id, String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(Id++, name, gender, null, null, birthDate, null);
        familyTree.add((Human) human);
    }


    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }


    public void addWedding(int Id1, int Id2) {
        Human human1 = (Human) familyTree.getById(Id1);
        Human human2 = (Human) familyTree.getById(Id2);
        familyTree.setWedding((Human) human1, (Human) human2);


    }


    public void addParent(int childId, int Id1, int Id2) {
        Human child = (Human) familyTree.getById(childId);
        Human parent1 = (Human) familyTree.getById(Id1);
        Human parent2 = (Human) familyTree.getById(Id2);

        if (child != null && parent1 != null && parent2 != null) {
            child.addParent(parent1);
            child.addParent(parent2);
            parent1.addChild(child);
            parent2.addChild(child);

        }
    }




    public void read() {
        String filePath = "src/FT.txt";
        familyTree = (FamilyTree) writable.read(filePath);

    }

    public void save() {
        String filePath = "src/FT.txt";
        writable.save(familyTree, filePath);

    }

    public String getHumanListInfo() {
        return familyTree.toString();
    }
}