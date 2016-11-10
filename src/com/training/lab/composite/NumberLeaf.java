package com.training.lab.composite;

/**
 * Created by USER on 02.11.2016.
 */
public class NumberLeaf implements TextComponent {
    private int currentNumber;

    public NumberLeaf(String s) {
//        Here we get string with mathematical expression and send it to Interpreter
//        this.currentNumber = ;
    }

    @Override
    public void operation() {

    }

    @Override
    public void addComponent(TextComponent c) {

    }

    @Override
    public void removeComponent(TextComponent c) {

    }

    @Override
    public Object getChild(int index) {
        return null;
    }
}
