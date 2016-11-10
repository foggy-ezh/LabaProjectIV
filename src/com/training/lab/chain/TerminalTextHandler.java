package com.training.lab.chain;

import com.training.lab.composite.ComponentLeaf;
import com.training.lab.composite.ComponentLeafType;
import com.training.lab.composite.TextComponent;
import com.training.lab.constant.Constant;
import com.training.lab.exception.EmptyTextDataException;
import com.training.lab.interpreter.MathExpressionConverter;

/**
 * Created by USER on 02.11.2016.
 */
public class TerminalTextHandler extends AbstractTextHandler {
    private ComponentLeafType type;

    @Override
    public TextComponent executeTextOperation(String text) throws EmptyTextDataException {
        if (Constant.PUNCTUATION_PATTERN.matcher(text).find()) {
            type = ComponentLeafType.PUNCTUATION;
        } else if (Constant.MATH_EXPRESSION_PATTERN.matcher(text).matches()) {
            MathExpressionConverter converter = new MathExpressionConverter();
            text = String.valueOf(converter.convertExpression(text).calculateExpression());
            type = ComponentLeafType.NUMBER;
        } else {
            type = ComponentLeafType.WORD;
        }
        return new ComponentLeaf(type, text);
    }
}
