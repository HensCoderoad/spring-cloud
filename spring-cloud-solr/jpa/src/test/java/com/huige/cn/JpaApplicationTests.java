package com.huige.cn;

import com.huige.cn.entity.Article;
import com.huige.cn.repositiry.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrDataQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {


    @Autowired
    SolrTemplate solrTemplate;

    @Autowired
    ArticleRepository articleRepository;


    //添加


    /**
     * 怎么把数据库中的内容添加到 我们的solr中
     * 常用的方式：第一个  代码操作
     * 第二个 图形化界面 （需要配置）
     * 第三个：实时同步
     * 第四个：代码+定时同步
     */

    @Test
    public void contextLoads() {
        System.out.println(solrTemplate);
        List<Article> all = articleRepository.findAll();
        System.out.println(all);
        solrTemplate.saveBeans("arcticle",all);
        solrTemplate.commit("arcticle");
//        SolrDataQuery solrDataQuery   = new SimpleQuery("*:*");
//        solrTemplate.delete("arcticle",solrDataQuery);
//        solrTemplate.commit("arcticle");


//        for (int i = 0; i < 50; i++) {
//            Article article = new Article();
//            article.setAuthor("辉哥" + i);
//            article.setTopic("江苏事故" + i);
//            article.setContent("江苏是个飘摇的地方 如果想短命请去" + i);
//
//
//            articleRepository.save(article);
//
//        }

    }


}
