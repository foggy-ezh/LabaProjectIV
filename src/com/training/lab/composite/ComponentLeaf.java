package com.training.lab.composite;

/**
 * Created by USER on 02.11.2016.
 */
public class ComponentLeaf implements TextComponent {
    private ComponentLeafType type;
    private String textPart;

    public ComponentLeaf(ComponentLeafType type, String textPart) {
        this.type = type;
        this.textPart = textPart;
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

    @Override
    public String toString() {
        return textPart;
    }
}
