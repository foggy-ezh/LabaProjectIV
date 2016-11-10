package com.training.lab.interpreter;

import com.training.lab.constant.Constant;

/**
 * Created by USER on 07.11.2016.
 */
public class MathBracketContainer extends AbstractMathOperation {
    public MathBracketContainer() {
        super.setPriority(Constant.BRACKET_DEFINE_PRIORITY);
    }

    @Override
    public void interpret(MathExpressionContext context) {}
}
