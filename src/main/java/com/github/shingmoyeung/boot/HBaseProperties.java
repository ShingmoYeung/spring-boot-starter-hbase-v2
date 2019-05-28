package com.github.shingmoyeung.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 10:39.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: HBase Properties
 */
@ConfigurationProperties(prefix = "spring.data.hbase")
public class HBaseProperties {
    /**
     * HBase Zookeeper连接主机名/IP
     */
    private String quorum;
    /**
     * HBase数据根目录
     */
    private String rootDir;
    /**
     * Zookeeper节点目录
     */
    private String nodeParent;

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getNodeParent() {
        return nodeParent;
    }

    public void setNodeParent(String nodeParent) {
        this.nodeParent = nodeParent;
    }
}