package rewardsonline.films;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * A controller handling requests for showing and updating an Film.
 */
@Controller
@RequestMapping("/films")
public class FilmsController {
	private FilmManager filmManager;

	@Autowired
	public FilmsController(FilmManager filmManager) {
		this.filmManager = filmManager;
	}

	// REST using Message Converters

	@RequestMapping(method = RequestMethod.GET,
			produces = {"application/json", "application/xml"})
	public @ResponseBody List<Film> findFilms(@RequestParam("title") String title) throws Exception {
		return filmManager.findFilms(title);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
			produces = {"application/json", "application/xml"})
	public @ResponseBody Film getFilmDetails(@PathVariable int id) throws Exception {
		return filmManager.getFilm(id);
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