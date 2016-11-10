package com.training.lab.chainofresponsibility;

import com.training.lab.composite.PunctuationLeaf;
import com.training.lab.composite.WordLeaf;
import com.training.lab.composite.NumberLeaf;
import com.training.lab.composite.TextComponent;
import com.training.lab.constant.Constant;
import com.training.lab.exception.EmptyTextDataException;

/**
 * Created by USER on 02.11.2016.
 */
public class TerminalTextHandler extends AbstractTextHandler {

    @Override
    public TextComponent executeTextOperation(String text) throws EmptyTextDataException {
        if(Constant.PUNCTUATION_PATTERN.matcher(text).find()){
            setTextComponent(new PunctuationLeaf(text));
        }
        else if(Constant.MATH_EXPRESSION_PATTERN.matcher(text).matches()){
            setTextComponent(new NumberLeaf(text));
        } else{
            setTextComponent(new WordLeaf(text));
        }
        return getTextComponent();
    }
}
