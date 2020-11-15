package de.hackersolutions.springbootwicket.web.notizen;

import de.hackersolutions.springbootwicket.domain.Notiz;
import de.hackersolutions.springbootwicket.web.BasePage;
import de.hackersolutions.springbootwicket.web.notizen.panels.NotizenAnlegenPanel;
import de.hackersolutions.springbootwicket.web.notizen.panels.NotizenAnzeigenPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import java.util.ArrayList;
import java.util.List;

public class NotizenPage extends BasePage {

    private final IModel<List<Notiz>> notizListModel = new ListModel<>(new ArrayList<>());

    public NotizenPage() {
        super(Model.of("Notizen"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        NotizenAnlegenPanel notizenAnlegenPanel = new NotizenAnlegenPanel("notizenAnlegen", notizListModel);
        add(notizenAnlegenPanel);

        NotizenAnzeigenPanel notizenAnzeigenPanel = new NotizenAnzeigenPanel("notizenAnzeigen", notizListModel);
        add(notizenAnzeigenPanel);
    }
}
