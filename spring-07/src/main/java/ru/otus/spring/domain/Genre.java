package ru.otus.spring.domain;

import lombok.Getter;

@Getter
public class Genre {
    private final String name;

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
