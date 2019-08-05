package com.zyh.shop.mapper;

import com.zyh.shop.bean.Article;
import com.zyh.shop.untis.Pager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {

//    List<Article> searchArticles(@Param("typeCode") String typeCode, @Param("secondType") String secondType
//            , @Param("title") String title);

    List<Article> searchArticles(@Param("typeCode") String typeCode, @Param("secondType") String secondType, @Param("title") String title, @Param("pager") Pager pager);

    int count(@Param("typeCode") String typeCode, @Param("secondType") String secondType,@Param("title") String title);

    @Delete("delete from ec_article where id = #{id}")
    void deleteById(String id);

    @Select("select * from ec_article where id = #{das}")
    @ResultMap("articleResultMap")
    Article getArticleById(String id);

    void update(Article article);

    void save(Article article);

//    int count(@Param("typeCode") String typeCode, @Param("secondType") String secondType, @Param("title") String title);
}
