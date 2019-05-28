package com.github.shingmoyeung.api;

import org.apache.hadoop.hbase.client.BufferedMutator;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 10:50.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: callback for hbase put delete and update.
 */
public interface MutatorCallback {
    /**
     * 使用mutator api to update put and delete
     *
     * @param mutator
     * @throws Throwable
     */
    void doInMutator(BufferedMutator mutator) throws Throwable;
}