package com.training.lab.action;

import com.training.lab.composite.ComponentLeaf;
import com.training.lab.composite.ComponentLeafType;
import com.training.lab.composite.ITextComponent;
import com.training.lab.composite.TextComposite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by USER on 13.11.2016.
 */
public class TextAction {
    public void FirstToLastLexemeChange(ArrayList<ITextComponent> text) {
        for (ITextComponent component : text) {
            if (component.getClass().equals(TextComposite.class)) {
                FirstToLastLexemeChange(((TextComposite) component).getTextComponents());
            } else {
                //При первой встрече компонента Leaf с типом "WORD" меняем его с
                //последним элементом типа "WORD", так как последний элемент предложения
                //будет знаком пунктуации, то берем предпоследний элемент спика.
                if (ComponentLeafType.WORD.toString().equals(((ComponentLeaf) component).getTypeName())) {
                    text.set(text.indexOf(component), text.get(text.size() - 2));
                    text.set((text.size() - 2), component);
                    return;
                }
            }
        }
    }

    public void DeleteLexeme(ArrayList<ITextComponent> text, char firstLetter, int length) {
        Iterator it = text.iterator();
        while (it.hasNext()) {
            ITextComponent component = (ITextComponent) it.next();
            if (component.getClass().equals(TextComposite.class)) {
                DeleteLexeme(((TextComposite) component).getTextComponents(), firstLetter, length);
            } else {
                if (ComponentLeafType.WORD.toString().equals(((ComponentLeaf) component).getTypeName()) &&
                        component.toString().charAt(0) == firstLetter &&
                        component.toString().length() == length) {
                    it.remove();
                }
            }
        }
    }

    public void printInAlphabetOrder(ArrayList<ITextComponent> text) {
        List<String> allWords = getAllWords(text);
        if (!allWords.isEmpty()) {
            Collections.sort(allWords);
            char temp = allWords.get(0).charAt(0);
            for (String str : allWords) {
                if(temp != str.charAt(0)){
                    System.out.println("\n");
                    temp = str.charAt(0);
                }
                System.out.print(str +" ");
            }
            System.out.println("\n");
        }
    }

    private List<String> getAllWords(ArrayList<ITextComponent> text) {
        List<String> allWords = new ArrayList<>();
        for (ITextComponent component : text) {
            if (component.getClass().equals(TextComposite.class)) {
                List<String> temp = getAllWords(((TextComposite) component).getTextComponents());
                if (!temp.isEmpty()) {
                    allWords.addAll(temp);
                }
            } else {
                if (ComponentLeafType.WORD.toString().equals(((ComponentLeaf) component).getTypeName())) {
                    allWords.add((component.toString().toLowerCase()));
                }
            }
        }
        return allWords;
    }

}
