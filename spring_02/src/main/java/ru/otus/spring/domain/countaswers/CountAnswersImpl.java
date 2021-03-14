//package ru.otus.spring.domain.countaswers;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import ru.otus.spring.domain.answers.AnswersArray;
//import ru.otus.spring.domain.testResult.TestResult;
//import ru.otus.spring.domain.testResult.TestResultImpl;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class CountAnswersImpl implements CountAnswers {
//
//    @Autowired
//    AnswersArray array;
//
//    List<String[]> list;
//
//    public CountAnswersImpl(List<String[]> list) {
//        this.list = list;
//    }
//
//    public int getCountAnswers() throws IOException {
//        int [] ar=array.getAnswers();
//      int countAnswers = 0;
//        for (int i = 0; i < list.size(); i++) {
//            String temp = Arrays.toString(list.get(i));
//            if (Integer.valueOf(temp.substring(1, temp.length() - 1)) == ar[i]) {
//                countAnswers++;
//            }
//        }
//    return  countAnswers ;
//    }
//}
