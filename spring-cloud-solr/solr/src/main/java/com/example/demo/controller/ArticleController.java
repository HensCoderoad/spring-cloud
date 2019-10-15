package com.example.demo.controller;

import com.example.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @Autowired
//    private SimpleSolrRepository<Article,Integer>  simpleSolrRepository;


    @Autowired
    private SolrTemplate solrTemplate;

    /**
     * 发布任何东西都需要审核
     * <p>
     * <p>
     * <p>
     * <p>
     * 通过审核的时候 才放到solr库里让搜索
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 当然不是
     * 百分之90以上 都修改的时候 去导入到数据库中
     * <p>
     * soleTemplate .saveBean() //有的话 就修改 没有的话就添加
     * <p>
     * //你的solr的数据 是什么时候加入solr数据库里的?、
     * status
     * <p>
     * <p>
     * <p>
     * <p>
     * 第一个 如果项目在定项目的时候 就是用了solr
     * <p>
     * 不会做批量导入  因为上线时 数据库是清空的
     * <p>
     * 百分之90以上的 都是在更新的时候 进行导入的
     * <p>
     * <p>
     * <p>
     * <p>
     * 第二种情况  我们半路使用solr   有真实的数据   正在线上
     * <p>
     * <p>
     * 我们需要做批量导入   不可以这样回答
     * <p>
     * 第一个 图形化界面
     * 第二个：自定义一个工程   自己编写代码  去操作就行了   //最常用
     * 百分之90以上的 都是在更新的时候 进行导入的
     * <p>
     * <p>
     * 实时更新
     * <p>
     * <p>
     * <p>
     * 添加
     * solr
     * <p>
     * 修改
     * 修改一下
     * <p>
     * 删除
     * 删除一下
     * <p>
     * <p>
     * 我们的数据如何做到实时同步
     * 实时同步
     * 全量和增量
     * 定时+代码
     *
     * @param keywords
     * @param page
     * @return
     */


    @GetMapping("search")
    public List<Article> search(String keywords, int page) {


        Criteria criteria = new Criteria("keywords").contains(keywords);


        Pageable pageable = new SolrPageRequest(page, 10);

        SimpleQuery simpleQuery = new SimpleQuery(criteria, pageable);
        List<Article> arcticle = solrTemplate.queryForPage("arcticle", simpleQuery, Article.class).getContent();

        // List<Article> content = arcticle.getContent();

        return arcticle;


    }

}
