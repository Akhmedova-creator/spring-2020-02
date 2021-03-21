package ru.otus.domain.inpStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.otus.config.SpringBootConf;


@Service
public class InputStreamImpl implements InputStream {
    final private String pathName;

    @Autowired
    public InputStreamImpl(SpringBootConf conf) {
        this.pathName = conf.getPathName();
    }


    public String getPathName() {
        return pathName;
    }


    @Override
    public java.io.InputStream getSteam()
    {
       return getClass().getClassLoader().getResourceAsStream(pathName);
    }
}
