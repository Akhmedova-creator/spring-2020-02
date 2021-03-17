package ru.otus.spring.domain.inpStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@PropertySource("classpath:conf.properties")
@Service
public class InputSteamImpl implements ImpStream{

    @Value("${pathname}")
    private String pathname;

    @Override
    public InputStream getSteam() {
       return getClass().getClassLoader().getResourceAsStream(pathname);
    }
}
