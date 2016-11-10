package com.training.lab.composite;

import java.util.ArrayList;

/**
 * Created by USER on 02.11.2016.
 */
public class TextComposite implements TextComponent {
    private ArrayList<TextComponent> textComponents = new ArrayList<>();
    @Override
    public void operation() {
    }

    @Override
    public void addComponent(TextComponent c) {
        textComponents.add(c);
    }

    @Override
    public void removeComponent(TextComponent c) {
        textComponents.remove(c);
    }

    @Override
    public Object getChild(int index) {
        return textComponents.get(index);
    }
}
