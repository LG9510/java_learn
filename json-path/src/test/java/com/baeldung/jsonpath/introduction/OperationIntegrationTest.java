package com.baeldung.jsonpath.introduction;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

public class OperationIntegrationTest {
    private InputStream jsonInputStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream("intro_api.json");
    private String jsonDataSourceString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\z");

    @Test
    public void givenJsonPathWithoutPredicates_whenReading_thenCorrect() {

    }
}
