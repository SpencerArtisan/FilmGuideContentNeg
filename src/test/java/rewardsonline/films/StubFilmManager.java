package rewardsonline.films;

import java.util.List;

public class StubFilmManager implements FilmManager, FilmTestConstants {
	@Override
	public List<Film> findFilms(String number) {
		return null;
	}

    @Override
    public Film getFilm(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
	public List<Film> findAllFilms() {
		return null;
	}
}
