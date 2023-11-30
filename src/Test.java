
import java.time.LocalDate;


public class Test {
    public static void main(String[] args) {

        FamilyTree  tree = testTree();
        System.out.println(tree);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male,  null, null, LocalDate.of(1977, 6,21), null);
//
//
        Human masha = new Human("Маша", Gender.Female, null, null, LocalDate.of(1986, 6, 15), null);
        tree.add(masha);
        tree.add(vasya);

        tree.setWedding(vasya, masha);

        Human lena = new Human("Лена", Gender.Female, null, null, LocalDate.of(1990,7,23), null);

        Human ivan = new Human("Иван", Gender.Male,null, null, LocalDate.of(1994, 7, 1), null);

        tree.add (lena);
        tree.add (ivan);


        return tree;
    }
}








