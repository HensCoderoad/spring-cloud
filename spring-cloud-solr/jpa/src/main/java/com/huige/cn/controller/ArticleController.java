package com.huige.cn.controller;

import com.huige.cn.entity.Article;
import com.huige.cn.repositiry.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {


    /**
     * 第一个问题:每次查询 都要链接数据库    数据库承载压力大   占用资源高   效率低下
     * <p>
     * 第二个问题： 我们做查询 可能查询的是这个主题任何的一个资源  这个时候 我们编写sql或者编写业务逻辑很麻烦 要用很多个字段 使用or和like 或者模糊查询
     * <p>
     * <p>
     * <p>
     * <p>
     * 全文搜索  搜索引擎     lucence
     * <p>
     * solr
     * <p>
     * ealeacsearch
     */

    @Autowired
    private SolrTemplate solrTemplate;


    @GetMapping("search")
    public List<Article> search(String keywords, int page) {

        Criteria criteria = new Criteria("keywords").contains(keywords);

        Pageable pageable = new SolrPageRequest(page - 1, 10);

        SimpleQuery simpleQuery = new SimpleQuery(criteria, pageable);
        ScoredPage<Article> arcticle = solrTemplate.queryForPage("arcticle", simpleQuery, Article.class);

        List<Article> content = arcticle.getContent();

        return content;


    }

}
