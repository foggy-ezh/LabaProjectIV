package com.training.lab.interpreter;

import java.util.ArrayDeque;

/**
 * Created by USER on 07.11.2016.
 */
public class MathExpressionContext {
    private ArrayDeque<Double> context = new ArrayDeque<>();

    public Double popValue(){
        return context.pop();
    }
    public void pushValue(double value){
        context.push(value);
    }

}
