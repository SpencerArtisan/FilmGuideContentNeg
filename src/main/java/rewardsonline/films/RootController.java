package rewardsonline.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
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
@ExposesResourceFor(RootResource.class)
@RequestMapping("/")
public class RootController {
	// REST using Message Converters
	@RequestMapping(method = RequestMethod.GET, produces = {"application/hal+json"})
	public @ResponseBody RootResource getRoot() throws Exception {
		return new RootResource();
	}

	// HTML via Tiles views
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute(getRoot());
        return "root";
    }
}