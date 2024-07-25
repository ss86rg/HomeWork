import java.util.Comparator;
import java.util.Iterator;

public class FamilyTreeComparatorByName <Human> implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {
     return o1.getName().compareTo(o2.getName());
    }
}
