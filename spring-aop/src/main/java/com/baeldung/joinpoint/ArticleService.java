package com.baeldung.joinpoint;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {

    public List<String> gerArticleList() {
        return Arrays.asList("Article 1", "Article 2");
    }

    public List<String> getArticleList(String startsWithFilter) {
        if (StringUtils.isBlank(startsWithFilter)) {
            throw new IllegalStateException("startWithFilter can't be blank");
        }

        return gerArticleList().stream()
                .filter(a -> a.startsWith(startsWithFilter))
                .collect(toList());
    }
}
