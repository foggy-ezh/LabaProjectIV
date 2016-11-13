package com.training.lab.composite;

import java.util.ArrayList;

/**
 * Created by USER on 02.11.2016.
 */
public class TextComposite implements ITextComponent {
    private ArrayList<ITextComponent> textComponents = new ArrayList<>();

    public ArrayList<ITextComponent> getTextComponents() {
        return textComponents;
    }

    @Override
    public void addComponent(ITextComponent c) {
        textComponents.add(c);
    }

    @Override
    public String toString() {
        return textComponents.toString();
    }
}
