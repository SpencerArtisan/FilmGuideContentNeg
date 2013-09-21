package rewardsonline.films;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film implements Identifiable<Integer> {
    @Id
    @JsonIgnore
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "VOTES")
    private int votes;

    @Column(name = "RATING")
    private float rating;

    protected Film() {
    }

    public Film(String title, int votes, float rating) {
        this.title = title;
        this.votes = votes;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}