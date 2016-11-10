package com.training.lab.constant;

import java.util.regex.Pattern;

/**
 * Created by USER on 07.10.2016.
 */
 public class Constant {

 private Constant(){}

 public static final String FILE_NAME = "data/TextData.txt";

 public static final Pattern MATH_EXPRESSION_PATTERN = Pattern.compile("[+\\-*/\\d()]+");
 public static final Pattern PUNCTUATION_PATTERN = Pattern.compile("[\\t'\"!?.;, -]+");

 public static final String TEXT_SPLIT_REGEX = ("(?<=[!?.;])(?=\\t)|(?<=\\t)(?=\\w)");
 public static final String PARAGRAPH_SPLIT_REGEX = ("(?<=[!?.;])(?= )");
 public static final String SENTENCE_SPLIT_REGEX = ("(?<=['\"!?.;, ])(?=.)|(?<=.)(?=['\"!?.;, ])");

 public static final int PLUS_MINUS_OPERATION_PRIORITY = 0;
 public static final int MULTIPLY_DIVIDE_OPERATION_PRIORITY = 1;
 public static final int INCREMENT_DECREMENT_OPERATION_PRIORITY = 2;
 public static final int BRACKET_DEFINE_PRIORITY = -1;
 }
