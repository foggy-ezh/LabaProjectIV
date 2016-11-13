package com.training.lab.chain;

import com.training.lab.composite.ComponentLeaf;
import com.training.lab.composite.ComponentLeafType;
import com.training.lab.composite.ITextComponent;
import com.training.lab.constant.Constant;
import com.training.lab.interpreter.MathExpressionConverter;

/**
 * Created by USER on 02.11.2016.
 */
public class TerminalTextHandler extends AbstractTextHandler {
    private static ComponentLeafType type;

    @Override
    public ITextComponent executeTextOperation(String text){
        if (Constant.PUNCTUATION_PATTERN.matcher(text).matches()) {
            type = ComponentLeafType.PUNCTUATION;
        } else if (Constant.MATH_EXPRESSION_PATTERN.matcher(text).matches()) {
            MathExpressionConverter converter = new MathExpressionConverter();
            text = String.valueOf((int)(converter.convertExpression(text).calculateExpression()));
            type = ComponentLeafType.NUMBER;
        } else {
            type = ComponentLeafType.WORD;
        }
        return new ComponentLeaf(type, text);
    }
}
