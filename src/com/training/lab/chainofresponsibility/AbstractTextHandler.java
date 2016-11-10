package com.training.lab.chainofresponsibility;

import com.training.lab.composite.TextComponent;
import com.training.lab.exception.EmptyTextDataException;

import java.util.regex.Pattern;

/**
 * Created by USER on 02.11.2016.
 */
abstract public class AbstractTextHandler {
    private TextComponent textComponent;
    private AbstractTextHandler successor = new TerminalTextHandler();

    public TextComponent getTextComponent() {
        return textComponent;
    }

    public AbstractTextHandler getSuccessor() {
        return successor;
    }

    public void setTextComponent(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    public void setSuccessor(AbstractTextHandler successor) {
        this.successor = successor;
    }



    abstract public TextComponent executeTextOperation(String text) throws EmptyTextDataException;


}
