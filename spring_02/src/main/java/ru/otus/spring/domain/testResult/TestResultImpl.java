//package ru.otus.spring.domain.testResult;
//
//import java.io.IOException;
//
//public class TestResultImpl implements TestResult {
//
//
//   private int  countAnswers;
//
//    public TestResultImpl(int countAnswers) {
//        this.countAnswers = countAnswers;
//    }
//
//    @Override
//        public String getResultAnswer() throws IOException {
//        if (5 <= countAnswers) {
//            return TextAnswer.NegativeText.getText();
//        } else return TextAnswer.PositiveRext.getText() ;
//    }
//}
