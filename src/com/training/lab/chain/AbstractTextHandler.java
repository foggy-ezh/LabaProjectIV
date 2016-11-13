package com.training.lab.chain;

import com.training.lab.composite.ITextComponent;

/**
 * Created by USER on 02.11.2016.
 */
abstract public class AbstractTextHandler {
    protected AbstractTextHandler successor;
    abstract public ITextComponent executeTextOperation(String text);

}
