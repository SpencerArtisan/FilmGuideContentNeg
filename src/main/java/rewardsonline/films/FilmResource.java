package rewardsonline.films;

import org.springframework.hateoas.ResourceSupport;

public class FilmResource extends ResourceSupport {
    public String title;
    public int votes;
    public float rating;

    public String getTitle() {
        return title;
    }

    public int getVotes() {
        return votes;
    }

    public float getRating() {
        return rating;
    }

    public void setFilm(Film film) {
        title = film.getTitle();
        votes = film.getVotes();
        rating = film.getRating();
    }
}
