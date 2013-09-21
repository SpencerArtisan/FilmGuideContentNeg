package rewardsonline.films.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rewardsonline.films.Film;
import rewardsonline.films.FilmManager;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("filmManager")
public class JpaFilmManager implements FilmManager {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Film> findAllFilms() {
        return (List<Film>) sessionFactory.getCurrentSession()
                .createQuery("select a from Film a").list();
    }

    @Transactional(readOnly = true)
    public List<Film> findFilms(String title) {
        try {
            String query = "select f from Film f where title LIKE concat(:title,'%')";
            return (List<Film>) sessionFactory.getCurrentSession().createQuery(query).setParameter("title", title).list();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public Film getFilm(int id) {
        try {
            String query = "select f from Film f where id = :id";
            return (Film) sessionFactory.getCurrentSession().createQuery(query).setParameter("id", id).uniqueResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}