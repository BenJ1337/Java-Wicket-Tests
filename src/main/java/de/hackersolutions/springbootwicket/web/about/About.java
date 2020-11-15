package de.hackersolutions.springbootwicket.web.about;

import de.hackersolutions.springbootwicket.web.BasePage;
import de.hackersolutions.springbootwicket.web.home.HomePage;
import de.hackersolutions.springbootwicket.web.notizen.NotizenPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

public class About extends BasePage {

    public About() {
        super(Model.of("About"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new BookmarkablePageLink<String>("startPage", HomePage.class));
        add(new BookmarkablePageLink<String>("aboutPage", About.class));
        add(new BookmarkablePageLink<String>("notizenPage", NotizenPage.class));
    }
}
