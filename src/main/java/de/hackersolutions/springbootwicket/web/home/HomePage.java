package de.hackersolutions.springbootwicket.web.home;

import de.hackersolutions.springbootwicket.web.BasePage;
import de.hackersolutions.springbootwicket.web.about.About;
import de.hackersolutions.springbootwicket.web.notizen.NotizenPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;


public class HomePage extends BasePage {
    public HomePage(){
        super(Model.of("Start"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new BookmarkablePageLink<String>("startPage", HomePage.class));
        add(new BookmarkablePageLink<String>("aboutPage", About.class));
        add(new BookmarkablePageLink<String>("notizenPage", NotizenPage.class));
    }
}
