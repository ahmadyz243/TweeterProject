package Entity;

import Base.Entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Likes extends BaseEntity {
    public Likes() {
    }

    public Likes(int likerid, Twitt twitt) {
        this.likerid = likerid;
        this.twitt = twitt;
    }

    private int likerid;
    @ManyToOne
    private Twitt twitt;

    public int getLikerid() {
        return likerid;
    }

    public void setLikerid(int likerid) {
        this.likerid = likerid;
    }

    public Twitt getTwitt() {
        return twitt;
    }

    public void setTwitt(Twitt twitt) {
        this.twitt = twitt;
    }
}
