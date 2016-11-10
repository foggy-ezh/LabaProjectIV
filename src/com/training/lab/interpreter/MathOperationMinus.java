package com.training.lab.interpreter;

import com.training.lab.constant.Constant;

/**
 * Created by USER on 07.11.2016.
 */
public class MathOperationMinus extends AbstractMathOperation {
    public MathOperationMinus() {
        super.setPriority(Constant.PLUS_MINUS_OPERATION_PRIORITY);
    }

    @Override
    public void interpret(MathExpressionContext context) {
        Double secondTerm=context.popValue();
        Double firstTerm=context.popValue();
        context.pushValue(firstTerm-secondTerm);
    }
}
