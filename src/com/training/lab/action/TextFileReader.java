package com.training.lab.action;

import com.training.lab.constant.Constant;
import com.training.lab.exception.CantReadDataFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by USER on 02.11.2016.
 */
public class TextFileReader {

    public String getTextFromFile() throws CantReadDataFileException {
        try{
            return Files.lines(Paths.get(Constant.FILE_NAME)).collect(Collectors.joining());
        } catch (IOException e) {
            throw new CantReadDataFileException("CANT READ DATA FROM FILE", e.getCause());
        }
    }
}
