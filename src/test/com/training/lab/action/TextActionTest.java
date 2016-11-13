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
//        try {
/*            String str = textFileReader.getTextFromFile();
            String[] str2 = Pattern.compile(Constant.TEXT_SPLIT_REGEX).split(str);
            System.out.println(Arrays.toString(Pattern.compile(Constant.TEXT_SPLIT_REGEX).split(str)));
            System.out.println(str2[2].codePointAt(0));
            String[] str3 = Pattern.compile(Constant.PARAGRAPH_SPLIT_REGEX).split(str2[1]);
            System.out.println(Arrays.toString(Pattern.compile(Constant.PARAGRAPH_SPLIT_REGEX).split(str2[1])));
            String[] str4 = Pattern.compile(Constant.SENTENCE_SPLIT_REGEX).split(str3[0]);
            System.out.println(Arrays.toString(Pattern.compile(Constant.SENTENCE_SPLIT_REGEX).split(str3[0])));*/
/*            Matcher m = Constant.MATH_EXPRESSION_PATTERN.matcher("123fs24345");
            System.out.println(m.matches());
        int i = 10;
        i--;
        StringBuilder numberCotnainer = new StringBuilder("abc");
        AbstractMathOperation math = new MathOperationPlus();
        System.out.println((math.getClass()==MathOperationPlus.class)+"sfsdf "+i+numberConainer);
        if (true){
            numberConainer.insert(0,"-");
        }
        --i;
        System.out.println("potom - "+numberConainer+i);
        String str = "13+(13--)";
        Matcher m1 = Pattern.compile("\\d--").matcher(str);
        while(m1.find()){
        }
        m1.replaceFirst("\\d-1");
        System.out.println(str);*/
//        }catch (CantReadDataFileException e){
//            Assert.fail(e.getMessage(),e);
//        }
    }

}