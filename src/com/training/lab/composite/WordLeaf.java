package com.training.lab.composite;

/**
 * Created by USER on 02.11.2016.
 */
public class WordLeaf implements TextComponent {
    private String word;

    public WordLeaf(String word) {
        this.word = word;
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
