package com.github.shingmoyeung.api;

import com.github.shingmoyeung.template.HBaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Scan;

import java.util.List;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 10:49.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: Interface that specifies a basic set of Hbase operations, implemented by {@link HBaseTemplate}.
 * Not often used, but a useful option to enhance testability, as it can easily be mocked or stubbed.
 */
public interface HBaseOperations {
    /**
     * Executes the given action against the specified table handling resource management.
     * <p>
     * Application exceptions thrown by the action object get propagated to the caller (can only be unchecked).
     * Allows for returning a result object (typically a domain object or collection of domain objects).
     *
     * @param tableName the target table
     * @param <T> action type
     * @return the result object of the callback action, or null
     */
    <T> T execute(String tableName, TableCallback<T> mapper);

    /**
     * Scans the target table, using the given column family.
     * The content is processed row by row by the given action, returning a list of domain objects.
     *
     * @param tableName target table
     * @param family column family
     * @param <T> action type
     * @return a list of objects mapping the scanned rows
     */
    <T> List<T> find(String tableName, String family, RowMapper<T> mapper);

    /**
     * Scans the target table, using the given column family.
     * The content is processed row by row by the given action, returning a list of domain objects.
     *
     * @param tableName target table
     * @param family column family
     * @param qualifier column qualifier
     * @param <T> action type
     * @return a list of objects mapping the scanned rows
     */
    <T> List<T> find(String tableName, String family, String qualifier, RowMapper<T> mapper);

    /**
     * Scans the target table using the given {@link Scan} object. Suitable for maximum control over the scanning
     * process.
     * The content is processed row by row by the given action, returning a list of domain objects.
     *
     * @param tableName target table
     * @param scan table scanner
     * @param <T> action type
     * @return a list of objects mapping the scanned rows
     */
    <T> List<T> find(String tableName, Scan scan, RowMapper<T> mapper);

    /**
     * Gets an individual row from the given table. The content is mapped by the given action.
     *
     * @param tableName target table
     * @param rowName row name
     * @param mapper row mapper
     * @param <T> mapper type
     * @return object mapping the target row
     */
    <T> T get(String tableName, String rowName, RowMapper<T> mapper);

    /**
     * Gets an individual row from the given table. The content is mapped by the given action.
     *
     * @param tableName target table
     * @param rowName row name
     * @param familyName column family
     * @param mapper row mapper
     * @param <T> mapper type
     * @return object mapping the target row
     */
    <T> T get(String tableName, String rowName, String familyName, RowMapper<T> mapper);

    /**
     * Gets an individual row from the given table. The content is mapped by the given action.
     *
     * @param tableName target table
     * @param rowName row name
     * @param familyName family
     * @param qualifier column qualifier
     * @param mapper row mapper
     * @param <T> mapper type
     * @return object mapping the target row
     */
    <T> T get(String tableName, String rowName, String familyName, String qualifier, RowMapper<T> mapper);

    /**
     * 执行put update or delete
     * @param tableName
     * @param action
     */
    void execute(String tableName, MutatorCallback action);

    /**
     *
     * @param tableName
     * @param mutation
     */
    void saveOrUpdate(String tableName, Mutation mutation);

    /**
     *
     * @param tableName
     * @param mutations
     */
    void saveOrUpdates(String tableName, List<Mutation> mutations);
}