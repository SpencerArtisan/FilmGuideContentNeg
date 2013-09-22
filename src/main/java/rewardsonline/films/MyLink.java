package rewardsonline.films;

import org.springframework.hateoas.Link;

import javax.xml.bind.annotation.XmlAttribute;

public class MyLink extends Link {
    @XmlAttribute
    private boolean templated = true;

    public MyLink(String href) {
        super(href);
    }

    public MyLink(String href, String rel) {
        super(href, rel);
    }

    public MyLink() {
    }

    public boolean isTemplated() {
        return templated;
    }

    public void setTemplated(boolean templated) {
        this.templated = templated;
    }
}
