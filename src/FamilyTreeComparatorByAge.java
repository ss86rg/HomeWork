import java.io.Serializable;
import java.util.Comparator;

public class FamilyTreeComparatorByAge implements Comparator<Human>, Serializable {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
