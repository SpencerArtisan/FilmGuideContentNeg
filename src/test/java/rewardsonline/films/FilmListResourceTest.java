package rewardsonline.films;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilmListResourceTest {
    protected MockHttpServletRequest request;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        RequestContextHolder.setRequestAttributes(requestAttributes);
    }

    @Test
    public void testFindFilmsLink() throws Exception {
        List<Film> films = new ArrayList<Film>();
        String link = new FilmListResource(films, "Film Title").getLink("self").getHref();
        assertEquals("http://localhost/films?title=Film%20Title", link);
    }
}
