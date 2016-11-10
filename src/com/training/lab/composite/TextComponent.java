package com.training.lab.composite;

/**
 * Created by USER on 02.11.2016.
 */
public interface TextComponent {
    void operation();
    void addComponent(TextComponent c);
    void removeComponent(TextComponent c);
    Object getChild(int index);
}
