package Model.Service;

import Model.FamilyTree.Animals;
import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Writable.Writable;

import java.time.LocalDate;

public class Service<T extends Animals<T>> {
    private int Id;
    private FamilyTree<T> familyTree;
    private Writable writable;


    public Service(Writable writable) {
        familyTree = new FamilyTree<T>();
        this.writable = writable;

    }


    public void addHuman(int Id, String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(Id++, name, gender, null, null, birthDate, null);
        familyTree.add((T) human);
    }


    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }


    public void addWedding(int Id1, int Id2) {
        T human1 = (T) familyTree.getById(Id1);
        T human2 = (T) familyTree.getById(Id2);

        if (human1 != null && human2 != null) {
            boolean success = familyTree.setWedding((T) human1, (T) human2);
            if (success) {
                System.out.println("Супруг " + human1.getName() + " и Супруга  " + human2.getName());
            } else {
                System.out.println(" id Супруга" + human1.getName() + " и  Супруги нет в списке" + human2.getName());
            }
        } else {
            System.out.println("Не верно введены Id родственников.");
        }

    }


    public void addParent(int childId, int Id1, int Id2) {
        T child = (T) familyTree.getById(childId);
        T parent1 = (T) familyTree.getById(Id1);
        T parent2 = (T) familyTree.getById(Id2);

        if (child != null && parent1 != null && parent2 != null) {
            child.addParent(parent1);
            child.addParent(parent2);
            parent1.addChild(child);
            parent2.addChild(child);
            System.out.println("Родители  добавлены для " + child.getName());
        } else {
            System.out.println("Не удалось добавить родителей. Проверьте Id.");
        }
    }


    public void read() {
        String filePath = "src/FT.txt";
        familyTree = (FamilyTree) writable.read(filePath);
        System.out.println("Древо загружено, нажмите 1");
    }

    public void save() {
        String filePath = "src/FT.txt";
        writable.save(familyTree, filePath);
        System.out.println("Древо сохранено");
    }

    public String getHumanListInfo() {
        return familyTree.toString();
    }
}