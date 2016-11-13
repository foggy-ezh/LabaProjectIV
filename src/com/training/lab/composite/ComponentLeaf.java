package com.training.lab.composite;

/**
 * Created by USER on 02.11.2016.
 */
public class ComponentLeaf implements ITextComponent {
    private ComponentLeafType type;
    private String textPart;

    public ComponentLeaf(ComponentLeafType type, String textPart) {
        this.type = type;
        this.textPart = textPart;
    }

    public String getTypeName() {
        return type.name();
    }

    @Override
    public void addComponent(ITextComponent c) {}

    @Override
    public String toString() {
        return textPart;
    }
}
