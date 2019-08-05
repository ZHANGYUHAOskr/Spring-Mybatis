package com.zyh.shop.mapper;

import com.zyh.shop.bean.ArticleType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleTypeMapper {

    @Select("select * from ec_article_type where code = #{xxx}")
    ArticleType getTypeByCode(String typeCode);

    @Select("select * from ec_article_type")
    List<ArticleType> getArticleTypes();

    @Select("select * from ec_article_type where length(code) = 4")
    List<ArticleType> getFirstArticleTypes();

    @Select("select * from ec_article_type where code like #{typeCode} and length(code) = #{len}")
    List<ArticleType> loadSecondTypes(@Param("typeCode") String typeCode, @Param("len") int i);
}
