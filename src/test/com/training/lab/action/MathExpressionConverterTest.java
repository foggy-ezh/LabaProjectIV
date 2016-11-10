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
        converter.convertExpression("13+(3++)");
        Assert.assertEquals(converter.calculateExpression(), 17, 0.01);
    }
}
