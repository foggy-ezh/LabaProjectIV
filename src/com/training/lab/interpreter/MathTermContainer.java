package com.training.lab.interpreter;

/**
 * Created by USER on 07.11.2016.
 */
public class MathTermContainer extends AbstractMathOperation {

    private int number;

    public MathTermContainer(int number) {this.number = number;}

    @Override
    public void interpret(MathExpressionContext context) {
        context.pushValue(number);
    }
}
