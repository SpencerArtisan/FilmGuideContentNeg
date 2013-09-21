package rewardsonline.films;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class FilmResourceAssembler extends ResourceAssemblerSupport<Film, FilmResource> {
    public FilmResourceAssembler() {
        super(FilmsController.class, FilmResource.class);
    }

    @Override
    public FilmResource toResource(Film film) {
        FilmResource resource = createResourceWithId(film.getId(), film);
        resource.setFilm(film);
        return resource;
    }
}
