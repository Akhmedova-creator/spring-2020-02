package ru.otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.service.TestService;
import ru.otus.service.TestServiceImpl;

import java.io.IOException;
import java.util.Locale;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TestApplication.class, args);

		TestService testService = context.getBean(TestServiceImpl.class);
		try {
			System.out.println(testService.getTest().getResultAnswer());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
