package com.github.shingmoyeung.exception;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 11:00.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: HBase Data Access exception.
 */
public class HBaseSystemException extends UnsupportedOperationException {
    public HBaseSystemException(Exception cause) {
        super(cause.getMessage(), cause);
    }

    public HBaseSystemException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
}