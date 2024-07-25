import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Service {

    private Human human;
    private FamilyTree familyTree;
    private List<Human> humanList;



   public Service(){
       familyTree = new FamilyTree();
       human = new Human();
       humanList = new List<Human>() {
           @Override
           public int size() {
               return 0;
           }

           @Override
           public boolean isEmpty() {
               return false;
           }

           @Override
           public boolean contains(Object o) {
               return false;
           }

           @Override
           public Iterator<Human> iterator() {
               return null;
           }

           @Override
           public Object[] toArray() {
               return new Object[0];
           }

           @Override
           public <T> T[] toArray(T[] a) {
               return null;
           }

           @Override
           public boolean add(Human human) {
               return false;
           }

           @Override
           public boolean remove(Object o) {
               return false;
           }

           @Override
           public boolean containsAll(Collection<?> c) {
               return false;
           }

           @Override
           public boolean addAll(Collection<? extends Human> c) {
               return false;
           }

           @Override
           public boolean addAll(int index, Collection<? extends Human> c) {
               return false;
           }

           @Override
           public boolean removeAll(Collection<?> c) {
               return false;
           }

           @Override
           public boolean retainAll(Collection<?> c) {
               return false;
           }

           @Override
           public void clear() {

           }

           @Override
           public Human get(int index) {
               return null;
           }

           @Override
           public Human set(int index, Human element) {
               return null;
           }

           @Override
           public void add(int index, Human element) {

           }

           @Override
           public Human remove(int index) {
               return null;
           }

           @Override
           public int indexOf(Object o) {
               return 0;
           }

           @Override
           public int lastIndexOf(Object o) {
               return 0;
           }

           @Override
           public ListIterator<Human> listIterator() {
               return null;
           }

           @Override
           public ListIterator<Human> listIterator(int index) {
               return null;
           }

           @Override
           public List<Human> subList(int fromIndex, int toIndex) {
               return null;
           }
       };


   }

    public void addHuman(String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
       int Id = 0;
       Human human = new Human(Id++,name,gender,parent1,parent2,birthDate, null);
        familyTree.add(human);
    }
    public String getHumansListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список Родственниов:\n");

        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }



    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByDeathDate() {
        familyTree.sortByDeathDate();
    }
    @Override
    public String toString() {
        return getHumansListInfo();
   };
}
