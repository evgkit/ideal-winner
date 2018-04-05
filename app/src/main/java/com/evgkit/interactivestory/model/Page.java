package com.evgkit.interactivestory.model;


import java.util.ArrayList;
import java.util.List;

public class Page {
    private int pageId;
    private int imageId;
    private int textId;
    private List<Choice> choices = new ArrayList<>();
    private boolean isFinalPage = false;

    public Page(int pageId, int imageId, int textId) {
        this.pageId = pageId;
        this.imageId = imageId;
        this.textId = textId;
        isFinalPage = true;
    }

    public Page(int pageId, int imageId, int textId, List<Choice> choices) {
        this.pageId = pageId;
        this.imageId = imageId;
        this.textId = textId;
        this.choices = choices;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void setChoice(Choice choice, int index) {
        this.choices.set(index, choice);
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }
}
