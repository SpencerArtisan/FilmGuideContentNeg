package rewardsonline.films;

import org.springframework.hateoas.ResourceSupport;

public class FilmResource extends ResourceSupport {
    public String title;
    public int votes;
    public float rating;

    public void setFilm(Film film) {
        title = film.getTitle();
        votes = film.getVotes();
        rating = film.getRating();
    }
}
