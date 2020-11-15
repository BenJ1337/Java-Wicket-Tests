package de.hackersolutions.springbootwicket.domain;

import java.io.Serializable;

public class Notiz implements Serializable {
    private String titel;
    private String text;

    public Notiz(String titel, String text) {
        this.titel = titel;
        this.text = text;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
