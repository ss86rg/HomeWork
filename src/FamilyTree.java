import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Animals<T>>  implements Iterable<T>, Serializable{

    private int humansId;
    private final List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public void add (T human){
        humanList.add(human);
        human.setId(humansId++);
        addToParents(human);
        addToChildren(human);


    }



    public T getById (int id) {
        if (!checkId(id)) {
            return null;
        }
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;

    }


    public List<T> getSiblings(int id) {
        T human = getById(id);

        if (human == null) {
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human) && !res.contains(child)) {
                    res.add(child);
                }

            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }


    public boolean setWedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setWedding(human1,human2);

        }
        return false;
    }

    public boolean setWedding (T human1, T human2){
        if (human1.getMarried()== null && human2.getMarried() == null){
            human1.setMarried(human2);
            human2.setMarried(human1);
            return true;
        } else {
            return false;
        }
    }




    private void addToParents(T human) {
        for (T parent : human.getParents()) {
            parent.addChild(human);

        }
    }

    private void addToChildren(T human) {
        for (T child : human.getChildren()) {
            child.addParent(human);

        }
    }

    public boolean remove (int eId){
        if (checkId(eId)) {
            T human = getById(eId);
            return humanList.remove(human);
        }
        return false;
    }



    private boolean checkId(int id) {
        return id < humansId && id>=0;
    }

    public String getInfo () {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    public void sortByName(){humanList.sort(new FamilyTreeComparatorByName<T>());

    }
    public void sortByAge(){humanList.sort(new FamilyTreeComparatorByAge<T>());

    }

    @Override
    public String toString () {
        return getInfo();
    }




    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }


}


