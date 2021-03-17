package ru.otus.spring.domain.testResult;

public enum TextAnswer {

    NegativeText("You did not pass the test("),
    PositiveText("You passed the test!!!");

    public String getText() {
        return text;
    }

    private String text;

    TextAnswer(String text) {
        this.text = text;
    }
}
