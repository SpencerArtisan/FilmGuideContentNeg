package rewardsonline.films;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class FilmListResource extends Resources<FilmResource> {
    public FilmListResource(List<Film> films, String title) throws Exception {
        super(new FilmResourceAssembler().toResources(films), getSelfLink(title));
    }

    private static Link getSelfLink(String title) throws Exception {
        URI uri = linkTo(methodOn(FilmsController.class).findFilms(title)).toUri();
        return new Link(uri.toString().replace("%2520", "%20"), "self");
    }
}
