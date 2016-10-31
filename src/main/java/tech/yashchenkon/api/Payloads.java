package tech.yashchenkon.api;

import tech.yashchenkon.request.RequestWrapper;

import java.util.function.Function;
/**
 * @author Mykola Yashchenko
 */
public class Payloads {

    public static Function<RequestWrapper, String> body() {
        return req -> "Body: \n" + new String(req.toByteArray());
    }

    public static Function<RequestWrapper, String> contentType() {
        return req -> "Content type: \n" + req.getContentType();
    }

    public static Function<RequestWrapper, String> method() {
        return req -> "Method: \n: " + req.getContentType();
    }

    public static Function<RequestWrapper, String> url() {
        return req -> "URI: \n" + req.getContentType();
    }
}
