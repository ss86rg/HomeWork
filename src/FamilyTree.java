import java.util.ArrayList;
import java.util.List;

public class FamilyTree{

    private long humanId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add (Human human){
        if (human == null) {
            return;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);

        }
    }



    public Human getById (long id) {
        if (!checkId(id)) {
            return null;
        }
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;

    }


    public List<Human> getSiblings(int id) {
        Human human = getById(id);

        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human) && !res.contains(child)) {
                    res.add(child);
                }

            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }


    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1,human2);

        }
        return false;
    }


    public boolean setWedding(Human human1, Human human2) {
        if (human1.getMarried() == null && human2.getMarried() == null) {

            human1.setMarried(human1);
            human2.setMarried(human2);
            return true;

        } else {
            return false;
        }
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);

        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);

        }
    }

    public boolean remove (long eId){
        if (checkId(eId)) {
            Human human = getById(eId);
            return humanList.remove(human);
        }
        return false;
    }



    private boolean checkId(long id) {return id < humanId && id>=0;}

    public String getInfo () {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString () {
        return getInfo();
    }

}


