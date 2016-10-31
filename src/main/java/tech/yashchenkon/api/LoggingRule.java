package tech.yashchenkon.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Mykola Yashchenko
 */
public class LoggingRule<T> implements ConditionalLogger<T> {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ConditionalLogger.class);

    protected Predicate<T> predicate;
    protected Stream<Function<T, String>> payloads;

    public LoggingRule(Predicate<T> predicate, Function<T, String>... payloads) {
        this.predicate = predicate;
        this.payloads = Stream.of(payloads);
    }

    @Override
    public void logIfNecessary(T request) {
        if (predicate.test(request)) {
            payloads.forEach(a -> LOGGER.debug(a.apply(request)));
        }
    }
}
