package rewardsonline.films;

import java.util.List;

public interface FilmManager {
	List<Film> findAllFilms();
	List<Film> findFilms(String number);
    Film getFilm(int id);
}