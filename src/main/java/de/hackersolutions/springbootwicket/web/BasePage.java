package de.hackersolutions.springbootwicket.web;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {

    private MarkupContainer defaultModal;
    private IModel<String> pageTitle = Model.of("Default Page Title");

    public BasePage(PageParameters params) {
        super(params);
        initPage();
    }

    public BasePage() {
        initPage();
    }

    public BasePage(IModel<String> pageTitle) {
        initPage();
        this.pageTitle = pageTitle;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Label("pageTitle", pageTitle));
    }

    private void initPage() {
        defaultModal = new EmptyPanel("defaultModal");
        defaultModal.setOutputMarkupId(true);
        add(defaultModal);
    }

    public void replaceDefaultModal(ModalWindow newModal) {
        defaultModal.replaceWith(newModal);
        defaultModal = newModal;
        defaultModal.setOutputMarkupId(true);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
    }
}
