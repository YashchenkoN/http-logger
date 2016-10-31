package tech.yashchenkon.httplogger.api;

/**
 * @author Mykola Yashchenko
 */
@FunctionalInterface
public interface ConditionalLogger<T> {
    void logIfNecessary(T object);
}
