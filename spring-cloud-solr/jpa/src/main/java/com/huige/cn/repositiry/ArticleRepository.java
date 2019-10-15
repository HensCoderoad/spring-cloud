package com.huige.cn.repositiry;


import com.huige.cn.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 使用SpringdataJPA
 * 第一步 加入依赖
 * 第二步L配置 链接的是什么数据库
 * <p>
 * 第三步: 定义一个持久层接口  继承JpaRepository   有2个泛型
 * 第一个泛型表示  这个持久层操作的表对应的实体类
 * 第二个泛型 表示这个实体类中 主键的类型
 */


/**
 * 数据库中的数据导入到我们的 solr中 （实际中没有这一步 ）
 * solr 中的数据 如何和数据库同步
 *
 * sorl的复制域 来解决使用多个or 和like
 *
 */

public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {


}
