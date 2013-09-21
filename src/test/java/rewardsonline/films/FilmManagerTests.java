package rewardsonline.films;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:system-test-config.xml" })
public class FilmManagerTests {
	private final int N_FILMS_EXPECTED = 1;

	@Autowired
	private FilmManager filmManager;

	@Test
	public void testList() throws Exception {
		List<Film> films = filmManager.findAllFilms();
		assertTrue("No such film", films != null && films.size() != 0);
		checkFilms(films);
	}

	@Test @DirtiesContext
	public void testShow() throws Exception {
		Film film = filmManager.getFilm(FilmTestConstants.TEST_FILM_ID);

		System.out.println(film);
		assertNotNull("No such film", film);
		assertEquals(FilmTestConstants.TEST_FILM_TITLE, film.getTitle());
	}

	private void checkFilms(List<Film> films) {
		assertEquals(N_FILMS_EXPECTED, films.size());
		for (Film film : films) {
			System.out.println(film);
		}
	}
}