package Entity;

import Base.Entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Twitt extends BaseEntity {
    private String title;
    private String text;
    private ZonedDateTime zonedDateTime;
    @ManyToOne
    private Account account;

    @Override
    public String toString() {
        return "Twitt{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }

    @OneToMany(mappedBy = "twitt", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "twitt", cascade = CascadeType.ALL)
    private List<Likes> likes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public Twitt(String title, String text, ZonedDateTime zonedDateTime, Account account) {
        this.title = title;
        this.text = text;
        this.zonedDateTime = zonedDateTime;
        this.account = account;
    }


    public Twitt() {
    }
}
