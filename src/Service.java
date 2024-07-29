import java.time.LocalDate;
import java.util.List;

public class Service  {
    private int Id;
    private List<Human> humanList;
    private FamilyTree familyTree;
    public  Service(){
        familyTree = new FamilyTree();


    }

    public void addHuman(int Id,String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(Id++,name,gender,parent1,parent2,birthDate, null);
        familyTree.add(human);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родственников:\n");
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
}
