package rewardsonline.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rewardsonline.films.Film;
import rewardsonline.films.FilmManager;

import java.util.List;

/**
 * A controller handling requests for showing and updating an Film.
 */
@Controller
@RequestMapping("/")
public class ApplicationController {
	// REST using Message Converters
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody String findFilms() throws Exception {
		return null;
	}

	// HTML via Tiles views
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        return "welcome";
    }
}