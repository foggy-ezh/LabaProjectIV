package com.training.lab.chainofresponsibility;

import com.training.lab.composite.TextComponent;
import com.training.lab.composite.TextComposite;
import com.training.lab.exception.EmptyTextDataException;

import java.util.regex.Pattern;

/**
 * Created by USER on 02.11.2016.
 */
public class NonTerminalTextHandler extends AbstractTextHandler {
    private Pattern splitPattern;

    public NonTerminalTextHandler(Pattern splitPattern) {
        this.splitPattern = splitPattern;
    }

    public NonTerminalTextHandler(AbstractTextHandler successor, String regex) {
        setTextComponent(new TextComposite());
        setSuccessor(successor);
        this.splitPattern= Pattern.compile(regex);
    }

    @Override
    public TextComponent executeTextOperation(String text) throws EmptyTextDataException{
        String[] splitData = currentDataParser(text);
        for(String str : splitData){
            getTextComponent().addComponent(getSuccessor().executeTextOperation(str));
        }
        return getTextComponent();
    }

    public String[] currentDataParser(String currentData){
        if(splitPattern!= null){
            return splitPattern.split(currentData);
        }
        return null;
    }
}
