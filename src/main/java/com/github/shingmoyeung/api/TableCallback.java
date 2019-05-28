package com.github.shingmoyeung.api;

import com.github.shingmoyeung.template.HBaseTemplate;
import org.apache.hadoop.hbase.client.Table;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 10:53.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: Callback interface for Hbase code. To be used with {@link HBaseTemplate}'s execution methods, often as anonymous classes within a method implementation without having to worry about exception handling.
 */
public interface TableCallback<T> {
    /**
     * Gets called by {@link HBaseTemplate} execute with an active Hbase table. Does need to care about activating or closing down the table.
     *
     * @param table active Hbase table
     * @return a result object, or null if none
     * @throws Throwable thrown by the Hbase API
     */
    T doInTable(Table table) throws Throwable;
}