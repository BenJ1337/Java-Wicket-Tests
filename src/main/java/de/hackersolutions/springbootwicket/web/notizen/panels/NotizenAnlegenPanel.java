package de.hackersolutions.springbootwicket.web.notizen.panels;

import de.hackersolutions.springbootwicket.domain.Notiz;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.List;


public class NotizenAnlegenPanel extends GenericPanel<List<Notiz>> {

    private final IModel<Notiz> notiz = Model.of(new Notiz(null,null));

    public NotizenAnlegenPanel(String id, IModel<List<Notiz>> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Notiz> form = new Form<>("notizForm", notiz);
        add(form);
        form.add(new FeedbackPanel("feedback"));
        TextField<String> titel = new TextField<>("notizTitel", new PropertyModel<String>(notiz, "titel"));
        form.add(titel);
        TextArea<String> text = new TextArea<>("notizText", new PropertyModel<String>(notiz, "text"));
        form.add(text);
        form.add(new AjaxButton("notizSpeichern") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                Notiz notizObj = notiz.getObject();
                if(notizObj != null) {
                    if(StringUtils.isBlank(notizObj.getTitel())) {
                        form.error("Der Titel darf nicht leer sein!");
                    }
                    if(StringUtils.isBlank(notizObj.getText())) {
                        form.error("Der Text darf nicht leer sein!");
                    }
                }
                if(!form.hasErrorMessage()) {
                    NotizenAnlegenPanel.this.getModelObject().add(notiz.getObject());
                    form.setDefaultModelObject(new Notiz(null,null));
                }

                target.add(getPage());
            }
        });
    }
}
