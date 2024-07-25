import java.io.Serializable;
import java.util.Comparator;

public class FamilyTreeComparatorByName implements Comparator<Human>, Serializable {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
