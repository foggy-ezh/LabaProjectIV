package com.training.lab.interpreter;


import com.training.lab.constant.Constant;

import java.util.ArrayDeque;

/**
 * Created by USER on 07.11.2016.
 */
public class MathExpressionConverter {
    private ArrayDeque<AbstractMathOperation> convertedExpression = new ArrayDeque<>();
    private ArrayDeque<AbstractMathOperation> operationStack = new ArrayDeque<>();
    private boolean nextNumberIsNegative;
    private StringBuilder numberContainer = new StringBuilder();

    public MathExpressionConverter convertExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            switch (current) {
                case '+':
                    addPlusOperation(expression, i);
                    break;
                case '-':
                    addMinusOperation(expression, i);
                    break;
                case '/':
                    addOperation(new MathOperationDivide());
                    break;
                case '*':
                    addOperation(new MathOperationMultiply());
                    break;
                case '(':
                    addOperation(new MathBracketContainer());
                    break;
                case ')':
                    pollTillBracket();
                    break;
                default:
                    addNumber(expression, i);
                    break;
            }
        }

        while (!operationStack.isEmpty()) {
            convertedExpression.addLast(operationStack.pollLast());
        }
        return  this;
    }

    public double calculateExpression() {
        MathExpressionContext context = new MathExpressionContext();
        for (AbstractMathOperation currentOperation : convertedExpression) {
            currentOperation.interpret(context);
        }
        return context.popValue();
    }

    private void addNumber(String expression, int position) {
        //Добавляем цифру в контейнер текущего числа
        numberContainer.append(expression.charAt(position));
        if (position < expression.length()-1 && Character.isDigit(expression.charAt(position + 1))) { // Проверяет является ли следующий символ в исходной строке цифрой
            return;
        }
        // Иначе если это конец текущего числа и следующий символ уже не цифра
        // проверяем будет ли число отрицательным(nextNumberIsNegative)
        // добавляем число в очередь и очищаем контейнер
        if (nextNumberIsNegative) {
            numberContainer.insert(0, "-");
            nextNumberIsNegative = false;
        }
        convertedExpression.addLast(new MathTermContainer(Integer.parseInt(numberContainer.toString())));
        numberContainer = new StringBuilder();
    }

    private void addMinusOperation(String expression, int position) {
        //Если текущий элемент не первый и предыдущий элемент "-",
        //значит мы уже учли текущий минус как операцию декремента
        if (position != 0 && expression.charAt(position - 1) == '-') {
            return;
        }
        //Если следующий элемент является минусом, то добавляем операцию декремента в стек операций
        if (expression.charAt(position + 1) == '-') {
            addOperation(new MathOperationDecrement());
            return;
        }

        //Проеверям является ли текущий символ началом выражения или же
        //предыдущий символ не является цифрой и не является закрывающейся скобочкой,
        //значит минус указывает на то, что число отрицательное
        if (position == 0) {
            nextNumberIsNegative = true;
            return;
        } else {
            Character c = expression.charAt(position - 1);
            if (!Character.isDigit(c) && c != ')') {
                nextNumberIsNegative = true;
                return;
            }
        }

    //Иначе считаем, что минус это операция вычитания и добавляем ее в стек операций
    addOperation(new MathOperationMinus());
}

    private void addPlusOperation(String expression, int position) {
        //Если текущий элемент не первый и предыдущий элемент "+",
        //значит мы уже учли текущий плюс как операцию инкремента
        if (position != 0 && expression.charAt(position - 1) == '+') {
            return;
        }
        //Если следующий элемент является плюсом, то добавляем операцию инкремента в стек операций
        if (expression.charAt(position + 1) == '+') {
            addOperation(new MathOperationIncrement());
            return;
        }
        //Иначе считаем, что плюс это операция сложения и добавляем ее в стек операций
        addOperation(new MathOperationPlus());
    }

    private void addOperation(AbstractMathOperation currentOperation) {
        //Добавляем операцию в стек операций, если это скобочка, то сразу добавляем в стек,
        //иначе предварительно проверяем стек опреций,
        //на наличие операций с большим приорететом или равным текущей операции,
        //если такие имеются, то добавляем их в финальное выражение
        if (currentOperation.getPriority() != Constant.BRACKET_DEFINE_PRIORITY) {
            while (operationStack.peekLast() != null &&
                    operationStack.peekLast().getPriority() >= currentOperation.getPriority()) {
                convertedExpression.addLast(operationStack.pollLast());
            }
        }
        operationStack.addLast(currentOperation);
    }

    private void pollTillBracket() {
        //Добавляем в финальное выражение все опрерации подряд, пока не встретим скобочку,
        //тогда прекращаем добавление и удаляем скобочку из стека операций
        while (operationStack.peekLast().getPriority() != Constant.BRACKET_DEFINE_PRIORITY) {
            convertedExpression.addLast(operationStack.pollLast());
        }
        operationStack.removeLast();
    }

}
