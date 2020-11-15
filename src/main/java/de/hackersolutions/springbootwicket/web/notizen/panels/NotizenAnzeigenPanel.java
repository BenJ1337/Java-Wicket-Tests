package de.hackersolutions.springbootwicket.web.notizen.panels;

import de.hackersolutions.springbootwicket.domain.Notiz;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

public class NotizenAnzeigenPanel extends GenericPanel<List<Notiz>> {
    public NotizenAnzeigenPanel(String id, IModel<List<Notiz>> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
        ListView<Notiz> listview = new ListView<Notiz>("listview", getModelObject()) {
            protected void populateItem(ListItem<Notiz> item) {
                item.add(new Label("titel", new PropertyModel<String>(item.getModel(), "titel")));
                item.add(new Label("text", new PropertyModel<String>(item.getModel(), "text")));
                item.add(new AjaxLink<Void>("notizLoeschen") {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        NotizenAnzeigenPanel.this.getModelObject().remove(item.getModelObject());
                        target.add(NotizenAnzeigenPanel.this);
                    }
                });
            }
        };
        add(listview);
    }
}
