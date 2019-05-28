package com.github.shingmoyeung.api;

import org.apache.hadoop.hbase.client.Result;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 10:53.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: Callback for mapping rows of a {@link ResultScanner} on a per-row basis. Implementations of this interface perform the actual work of mapping each row to a result object, but don't need to worry about exception handling.
 */
public interface RowMapper<T> {
    /**
     *
     * @param result
     * @param rowNum
     * @return
     * @throws Throwable
     */
    T mapRow(Result result, int rowNum) throws Throwable;
}