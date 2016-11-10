package com.training.lab.interpreter;

/**
 * Created by USER on 07.11.2016.
 */
public abstract class AbstractMathOperation {
    private int priority;

    public void setPriority(int i){
        this.priority=i;
    }
    public int getPriority() {
        return priority;
    }
    public abstract void interpret(MathExpressionContext context);
}
