package ru.otus.spring.domain;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class File {
    public String getName() {
        return name;
    }

    final private String name;

    final private int countQuestions;

    final private int countCorrectAnswers;

    final private String positiveAnswer;

    final private String negativeAnswer;

    public File(String name, int countQuestions, int countCorrectAnswers, String positiveAnswer, String negativeAnswer) {
        this.name = name;
        this.countQuestions = countQuestions;
        this.countCorrectAnswers = countCorrectAnswers;
        this.positiveAnswer = positiveAnswer;
        this.negativeAnswer = negativeAnswer;
    }

    public List<String[]> getList() throws IOException {

        //чтение CSV файла
        CSVReader reader = new CSVReader(new BufferedReader(new FileReader(name)),
                ',', '"', 0);
        return reader.readAll();
    }

    public int[] getAnswers(List<String[]> list) throws IOException {
        int[] answers = new int[countQuestions];
        for (int i = 0; i < countQuestions; i++) {
            String temp = Arrays.toString(list.get(i));
            System.out.println(temp.substring(1, temp.length() - 1));
            Scanner sc = new Scanner(System.in);
            answers[i] = sc.nextInt();
        }
        return answers;
    }

    public int getCountAnswers(List<String[]> list, int[] array) {
        int countAnswers = 0;
        for (int i = 0; i < countQuestions; i++) {
            String temp = Arrays.toString(list.get(i + 1 + countQuestions));
            if (Integer.valueOf(temp.substring(1, temp.length() - 1)) == array[i]) {
                countAnswers++;
            }
        }
        return countAnswers;
    }

    public String getResultAnswer(int countAnswers) {
        if (countCorrectAnswers <= countAnswers) {
            return negativeAnswer;
        } else
            return positiveAnswer;
    }

    @Override
    public boolean equals(Object csv) {
        if (csv == null) {
            return false;
        }
        if (csv.getClass() != File.class) {
            return false;
        }
        File cmp = (File) csv;
        return cmp.name.equals(this.name) &&
                cmp.countCorrectAnswers == this.countCorrectAnswers &&
                cmp.countQuestions == this.countQuestions &&
                cmp.negativeAnswer.equals(this.negativeAnswer) &&
                cmp.positiveAnswer.equals(this.positiveAnswer);
    }

}





