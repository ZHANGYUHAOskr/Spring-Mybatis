package com.zyh.shop.service;

import com.zyh.shop.bean.Article;
import com.zyh.shop.bean.ArticleType;
import com.zyh.shop.untis.Pager;

import java.util.List;
import java.util.Map;

public interface ShopService {

    List<ArticleType> getArticleTypes();

    Map<String, Object> login(String loginNmae, String passWord);

    List<ArticleType> loadFirstArticleTypes();

    List<Article> searchArticles(String typeCode, String secondType, String title, Pager pager);

    List<ArticleType> loadSecondTypes(String typeCode);

    void deleteById(String id);

    Article getArtcleById(String id);

    void updateArticle(Article article);

    void saveArticle(Article article);
}
