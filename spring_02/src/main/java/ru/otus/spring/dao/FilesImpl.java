package ru.otus.spring.dao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.File;
@PropertySource("classpath:conf.properties")
@Component
public class FilesImpl implements Files {

  @Value ("${filename}")
  private String name;

   @Value("${countQuestions}")
  private int countQuestions;

  @Value("${countCorrectAnswers}")
  private int countCorrectAnswers;

  @Value("${negativeAnswer}")
  private String negativeAnswer;

  @Value("${positiveAnswer}")
  private String positiveAnswer;

  @Override
  public File getFile() { return new File(name,countQuestions,countCorrectAnswers,negativeAnswer,positiveAnswer);
  }

}

