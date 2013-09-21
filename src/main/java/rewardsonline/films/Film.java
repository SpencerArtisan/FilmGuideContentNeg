package rewardsonline.films;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film extends ResourceSupport {
    @Id
    @JsonIgnore
    @Column(name = "ID")
    private Integer entityId;

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

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
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