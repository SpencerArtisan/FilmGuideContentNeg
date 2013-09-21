package rewardsonline.films;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.ui.ExtendedModelMap;

/**
 * Unit test for the FilmController implementation.
 */
public class FilmsControllerTests {
	private FilmsController controller;
	private StubFilmManager filmManager;

	@Before
	public void setUp() throws Exception {
		filmManager = new StubFilmManager();
		controller = new FilmsController(filmManager);
	}

	@Test
	@DirtiesContext
	public void testShow() throws Exception {
		ExtendedModelMap model = new ExtendedModelMap();
		String view = controller.show(StubFilmManager.TEST_FILM_ID, model);
		assertEquals("films/show", view);
		assertEquals(StubFilmManager.TEST_FILM_TITLE, ((Film) model.get("film")).getTitle());
	}
}