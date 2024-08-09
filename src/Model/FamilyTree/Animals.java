package Model.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
                                             //    Соблюдается Принцип разделения интерфейса
public interface Animals <E>extends Serializable {

    int getId();
    void setId(int id);
    void add (E human);
    String getName();
    int getAge();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getChildren();
    E getMarried();
    void setMarried(E human);

    boolean addParent(E parent);
    boolean addChild(E child);
    boolean setWedding (E human1, E human2);
    List<E> getParents();
}
