package test.com.training.lab.action;

import com.training.lab.action.TextAction;
import com.training.lab.action.TextFileReader;
import com.training.lab.composite.ComponentLeaf;
import com.training.lab.composite.ComponentLeafType;
import com.training.lab.composite.ITextComponent;
import com.training.lab.composite.TextComposite;
import com.training.lab.constant.Constant;
import com.training.lab.exception.CantReadDataFileException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by USER on 03.11.2016.
 */
public class TextActionTest {
    @Test
    public void testAction(){
        ITextComponent c1 = new ComponentLeaf(ComponentLeafType.WORD , "a1");
        ITextComponent c2 = new ComponentLeaf(ComponentLeafType.WORD , "b2");
        ITextComponent c3 = new ComponentLeaf(ComponentLeafType.WORD , "c3");
        ITextComponent t1 = new TextComposite();
        t1.addComponent(c1);
        t1.addComponent(c2);
        t1.addComponent(c3);
        ITextComponent t2 = new TextComposite();
        t2.addComponent(c1);
        t2.addComponent(c2);
        t2.addComponent(c3);
        ArrayList<ITextComponent> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        TextAction action = new TextAction();
        action.FirstToLastLexemeChange(list);
        System.out.println(list.toString());
        action.printInAlphabetOrder(list);
        System.out.println(list.toString());
        action.DeleteLexeme(list, "c".charAt(0), 2);
        System.out.println(list.toString());
        Assert.assertEquals(list.toString(), "[[b2, a1], [b2, a1]]");
    }

}