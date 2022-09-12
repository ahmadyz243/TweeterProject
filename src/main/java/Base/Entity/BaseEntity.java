package Base.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BaseEntity(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    private int id;

    public BaseEntity() {
    }
}
