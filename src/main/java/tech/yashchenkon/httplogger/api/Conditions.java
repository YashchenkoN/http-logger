package tech.yashchenkon.httplogger.api;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Mykola Yashchenko
 */
public class Conditions {

    @SafeVarargs
    public static Predicate<HttpServletRequest> exclude(final Predicate<HttpServletRequest>... filters) {
        return Stream.of(filters)
                .map(Predicate::negate)
                .reduce(Predicate::and)
                .orElse($ -> true);
    }

    public static Predicate<HttpServletRequest> contentTypes(String... contentTypes) {
        return value -> Arrays.asList(contentTypes).contains(value.getContentType());
    }
}
