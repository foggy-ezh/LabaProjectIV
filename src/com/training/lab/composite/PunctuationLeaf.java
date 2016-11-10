package com.training.lab.composite;

/**
 * Created by USER on 06.11.2016.
 */
public class PunctuationLeaf implements TextComponent {
    private String punctuation;

    public PunctuationLeaf(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public void operation() {
    }

    @Override
    public void addComponent(TextComponent c) {}

    @Override
    public void removeComponent(TextComponent c) {}

    @Override
    public Object getChild(int index) {
        return null;
    }
}
