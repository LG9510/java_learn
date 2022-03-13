package com.baeldung.jsonpath.introduction;

import com.jayway.jsonpath.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationIntegrationTest {
    private InputStream jsonInputStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream("intro_api.json");
    private String jsonDataSourceString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\z").next();

    @Test
    public void givenJsonPathWithoutPredicates_whenReading_thenCorrect() {
        String jsonPathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
        String jsonpathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][*]";

        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        String jsonPathCreatorName = jsonContext.read(jsonPathCreatorNamePath);
        List<String> jsonPathCreatorLocation = jsonContext.read(jsonpathCreatorLocationPath);

        assertEquals("Jayway Inc.", jsonPathCreatorName);
        assertThat(jsonPathCreatorLocation.toString(), containsString("Malmo"));
        assertThat(jsonPathCreatorLocation.toString(), containsString("San Francisco"));
        assertThat(jsonPathCreatorLocation.toString(), containsString("Helsingborg"));
    }

    @Test
    public void givenJsonPathWithFilterPredicate_whenReading_thenCorrect() {
        Filter expensiveFilter = Filter.filter(Criteria.where("price").gt(20.00));
        List<Map<String, Object>> expensive = JsonPath.parse(jsonDataSourceString).read("$['book'][?]", expensiveFilter);
        predicateUsageAssertionHelper(expensive);
    }

    @Test
    public void givenJsonPathWithCustomizedPredicate_whenReading_thenCorrect() {
        Predicate expensivePredicate = context -> Float.valueOf(context.item(Map.class)
                .get("price").toString()) > 20.00;
        List<Map<String, Object>> expensive = JsonPath.parse(jsonDataSourceString)
                .read("$['book'][?]", expensivePredicate);
        predicateUsageAssertionHelper(expensive);

    }

    @Test
    public void givenJsonPathWithInlinePredicate_whenReading_thenCorrect() {
        List<Map<String, Object>> expensive = JsonPath.parse(jsonDataSourceString)
                .read("$['book'][?(@['price'] > $['price range']['medium'])]");
        predicateUsageAssertionHelper(expensive);
    }

    private void predicateUsageAssertionHelper(List<?> predicate) {
        assertThat(predicate.toString(), CoreMatchers.containsString("Beginning JSON"));
        assertThat(predicate.toString(), CoreMatchers.containsString("JSON at Work"));
        assertThat(predicate.toString(), not(CoreMatchers.containsString("Learn JSON in a DAY")));
        assertThat(predicate.toString(), not(CoreMatchers.containsString("JSON: Questions and Answers")));
    }
}
