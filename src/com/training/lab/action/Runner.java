package com.training.lab.action;

import com.training.lab.chain.AbstractTextHandler;
import com.training.lab.chain.NonTerminalTextHandler;
import com.training.lab.chain.TerminalTextHandler;
import com.training.lab.composite.ITextComponent;
import com.training.lab.composite.TextComposite;
import com.training.lab.constant.Constant;
import com.training.lab.exception.CantReadDataFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by USER on 02.11.2016.
 */
public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        TextFileReader textFileReader = new TextFileReader();
        AbstractTextHandler sentenceParser = new NonTerminalTextHandler(Constant.SENTENCE_SPLIT_REGEX);
        AbstractTextHandler paragraphParser = new NonTerminalTextHandler(sentenceParser, Constant.PARAGRAPH_SPLIT_REGEX);
        AbstractTextHandler textParser = new NonTerminalTextHandler(paragraphParser, Constant.TEXT_SPLIT_REGEX);
        String text;
        try {
            text = textFileReader.getTextFromFile();
        } catch (CantReadDataFileException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        }
        if(text.isEmpty()){
            LOGGER.log(Level.FATAL, "EMPTY DATA FILE");
            throw new RuntimeException();
        }
        ITextComponent textComposite = textParser.executeTextOperation(text);
        System.out.println(textComposite.toString());
        TextAction action = new TextAction();
        action.printInAlphabetOrder(((TextComposite)textComposite).getTextComponents());
    }
}
