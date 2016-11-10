package com.training.lab.interpreter;

import com.training.lab.constant.Constant;

/**
 * Created by USER on 07.11.2016.
 */
public class MathOperationMultiply extends AbstractMathOperation {
    public MathOperationMultiply() {
        super.setPriority(Constant.MULTIPLY_DIVIDE_OPERATION_PRIORITY);
    }

    @Override
    public void interpret(MathExpressionContext context) {
        Double secondTerm = context.popValue();
        Double firstTerm = context.popValue();
        context.pushValue(firstTerm * secondTerm);
    }
}
