package test.com.training.lab.action;

import com.training.lab.interpreter.MathExpressionConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by USER on 10.11.2016.
 */
public class MathExpressionConverterTest {
    @Test
    public void convertExpression(){
        MathExpressionConverter converter = new MathExpressionConverter();
        Assert.assertEquals(converter.convertExpression("8+-9").calculateExpression(), -1, 0.1);
    }
}
