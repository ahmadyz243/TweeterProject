package Entity;

import Base.Entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends BaseEntity {
    private String text;
    private int writerid;
    @ManyToOne
    private Twitt twitt;

    public Comment(String text, int writerid, Twitt twitt) {
        this.text = text;
        this.writerid = writerid;
        this.twitt = twitt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWriterid() {
        return writerid;
    }

    public void setWriterid(int writerid) {
        this.writerid = writerid;
    }

    public Twitt getTwitt() {
        return twitt;
    }

    public void setTwitt(Twitt twitt) {
        this.twitt = twitt;
    }

    public Comment() {
    }
}
