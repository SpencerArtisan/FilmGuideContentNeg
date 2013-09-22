package rewardsonline.films;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class RootResource extends ResourceSupport {
    public RootResource() throws Exception {
        URI uri = linkTo(methodOn(FilmsController.class).findFilms("QUERY_PARAM")).toUri();
        add(new Link(uri.toString().replace("QUERY_PARAM", "{title}"), "findFilms"));
    }

    public String getHref(String rel) {
        return getLink(rel).getHref().replace('(', '{').replace(')', '}');
    }
}
