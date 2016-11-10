package com.training.lab.chain;

import com.training.lab.composite.TextComponent;
import com.training.lab.exception.EmptyTextDataException;

/**
 * Created by USER on 02.11.2016.
 */
abstract public class AbstractTextHandler {
    protected AbstractTextHandler successor = new TerminalTextHandler();

    abstract public TextComponent executeTextOperation(String text) throws EmptyTextDataException;

}
