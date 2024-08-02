package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.Human.Gender;
import Model.Human.Human;

import java.time.LocalDate;
import java.util.List;

public class Service  {
    private int Id;
    private List<Human> humanList;
    private FamilyTree familyTree;



    private Human getById ;
    public  Service(){
        familyTree = new FamilyTree();


    }

    public void addHuman(int Id, String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(Id++,name,gender,parent1,parent2,birthDate, null);
        familyTree.add(human);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("������ �������������:\n");
        for (Object human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public void save(){

    }
    public void read(){

    }

    public void addWedding(int Id1, int Id2) {
        Human human1 = (Human) familyTree.getById(Id1);
        Human human2 = (Human) familyTree.getById(Id2);

        if (human1 != null && human2 != null) {
            boolean success = familyTree.setWedding(human1, human2);
            if (success) {
                System.out.println("������� ������� ��������� ����� " + human1.getName() + " � " + human2.getName());
            } else {
                System.out.println("�� ������� �������� ������� ����� " + human1.getName() + " � " + human2.getName() + ". ��������, ���� �� ��� ��� ������� � �����.");
            }
        } else {
            System.out.println("������: ���� �� ��������� Id �� ������ � ������.");
        }


    }
}
