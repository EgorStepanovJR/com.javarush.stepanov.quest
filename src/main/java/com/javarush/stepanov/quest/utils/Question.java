package com.javarush.stepanov.quest.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter
@ToString
public class Question {
    private int id;
    private String text;
    private List<Answer> answerList;
}
