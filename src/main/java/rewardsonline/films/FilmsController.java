package rewardsonline.films;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * A controller handling requests for showing and updating an Film.
 */
@Controller
@ExposesResourceFor(Film.class)
@RequestMapping("/films")
public class FilmsController {
	private FilmManager filmManager;

	@Autowired
	public FilmsController(FilmManager filmManager) {
		this.filmManager = filmManager;
	}

	// REST using Message Converters

	@RequestMapping(method = RequestMethod.GET, produces = {"application/hal+json"})
	public @ResponseBody FilmListResource findFilms(@RequestParam("title") String title) throws Exception {
		List<Film> films = filmManager.findFilms(title);
        return new FilmListResource(films, title);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/hal+json"})
	public @ResponseBody FilmResource getFilmDetails(@PathVariable int id) throws Exception {
        Film film = filmManager.getFilm(id);
        FilmResourceAssembler assembler = new FilmResourceAssembler();
        return assembler.toResource(film);
	}

	// HTML via Tiles views

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable int id, Model model) throws Exception {
		model.addAttribute(getFilmDetails(id));
		return "films/show";
	}

    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam("title") String title, Model model) throws Exception {
        model.addAttribute("films", findFilms(title));
        return "films/list";
    }
}