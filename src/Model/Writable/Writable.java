package Model.Writable;

import java.io.Serializable;
                                       //    Соблюдается Принцип разделения интерфейса
public interface Writable {

    void save(Serializable serializable, String filePath);
    Object read (String filePath);
}
