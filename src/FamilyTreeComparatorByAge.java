import java.io.Serializable;
import java.util.Comparator;

public class FamilyTreeComparatorByAge<T extends Animals> implements Comparator<T>, Serializable {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
