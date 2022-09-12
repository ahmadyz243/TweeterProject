package Entity;

import Base.Entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Account extends BaseEntity {
    public Account() {
    }

    public Account(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    private String nickname;
    private String username;
    private String password;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Twitt> tweetList;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Twitt> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Twitt> tweetList) {
        this.tweetList = tweetList;
    }
}
