package rewardsonline.films;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RootResourceTest {
    protected MockHttpServletRequest request;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        RequestContextHolder.setRequestAttributes(requestAttributes);
    }

    @Test
    public void testFindFilmsLink() throws Exception {
        String link = new RootResource().getLink("findFilms").getHref();
        assertEquals("http://localhost/films?title={title}", link);
    }

    @Test
    public void testTemplatedLink() throws Exception {
        assertEquals("a", new RootResource().getLinks().toString());
    }
}
