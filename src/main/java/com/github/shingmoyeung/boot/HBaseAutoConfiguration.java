package com.github.shingmoyeung.boot;

import com.github.shingmoyeung.template.HBaseTemplate;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA 2019.
 * User: shingmoyeung.
 * Date: 2019-05-17.
 * Time: 10:39.
 * To change this template use File Or Preferences | Settings | Editor | File and Code Templates.
 * File Description: HBase Auto Configuration
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(HBaseProperties.class)
@ConditionalOnClass(HBaseTemplate.class)
public class HBaseAutoConfiguration {
    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";
    private static final String HBASE_ROOTDIR = "hbase.rootdir";
    private static final String HBASE_ZNODE_PARENT = "zookeeper.znode.parent";

    @Autowired
    private HBaseProperties hBaseProperties;

    @Bean
    @ConditionalOnMissingBean(HBaseTemplate.class)
    public HBaseTemplate hbaseTemplate() {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set(HBASE_QUORUM, this.hBaseProperties.getQuorum());
        configuration.set(HBASE_ROOTDIR, this.hBaseProperties.getRootDir());
        configuration.set(HBASE_ZNODE_PARENT, this.hBaseProperties.getNodeParent());
        return new HBaseTemplate(configuration);
    }
}