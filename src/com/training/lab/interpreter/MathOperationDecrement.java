package com.training.lab.interpreter;

import com.training.lab.constant.Constant;

/**
 * Created by USER on 10.11.2016.
 */
public class MathOperationDecrement extends AbstractMathOperation {
    public MathOperationDecrement() {
        setPriority(Constant.INCREMENT_DECREMENT_OPERATION_PRIORITY);
    }

    @Override
    public void interpret(MathExpressionContext context) {
        context.pushValue(context.popValue()-1);
    }
}
