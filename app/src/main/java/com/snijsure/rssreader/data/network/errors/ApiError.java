package com.snijsure.rssreader.data.network.errors;

public class ApiError extends Throwable {
    private int statusCode;
    private String message;

//    @Override
//    public String getMessage() { return message;}

    public ApiError() {
        super("Неизвестная ошибка сервера");
    }

    public ApiError(int statusCode) {
        super("Неизвестная ошибка "+ statusCode);
    }
}
