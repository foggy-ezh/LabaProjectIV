package com.training.lab.chain;

import com.training.lab.composite.ITextComponent;
import com.training.lab.composite.TextComposite;

import java.util.regex.Pattern;

/**
 * Created by USER on 02.11.2016.
 */
public class NonTerminalTextHandler extends AbstractTextHandler {
    private Pattern splitPattern;
    private ITextComponent textComponent = new TextComposite();

    public NonTerminalTextHandler(String regex) {
        super.successor = new TerminalTextHandler();
        this.splitPattern = Pattern.compile(regex);
    }

    public NonTerminalTextHandler(AbstractTextHandler successor, String regex) {
        super.successor = successor;
        this.splitPattern = Pattern.compile(regex);
    }

    @Override
    public ITextComponent executeTextOperation(String text) {
        try {
            String[] splitData = currentDataParser(text);
            for (String str : splitData) {
                textComponent.addComponent(successor.executeTextOperation(str));
            }
            return textComponent;
        } finally {
            textComponent = new TextComposite();
        }
    }

    private String[] currentDataParser(String currentData) {
        if (splitPattern != null) {
            return splitPattern.split(currentData);
        }
        return null;
    }
}
