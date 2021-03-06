package com.example.demo.config;

import com.example.demo.entity.Article;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;

@Configuration
public class MyConfig {
    SolrClient solrClient;

    public MyConfig(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrClient);
    }

    @Bean
    public SimpleSolrRepository solrTemplate1() {

        return new SimpleSolrRepository(solrTemplate(), Article.class);
    }
}
