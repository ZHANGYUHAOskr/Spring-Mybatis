package com.zyh.shop.service;

import com.zyh.shop.bean.Article;
import com.zyh.shop.bean.ArticleType;
import com.zyh.shop.bean.User;
import com.zyh.shop.mapper.ArticleMapper;
import com.zyh.shop.mapper.ArticleTypeMapper;
import com.zyh.shop.mapper.UserMapper;
import com.zyh.shop.untis.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    //得到数据访问层对象
    private ArticleTypeMapper articleTypeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleType> getArticleTypes() {
        return articleTypeMapper.getArticleTypes();
    }

    @Override
    public Map<String, Object> login(String loginNmae, String passWord)  {
        Map<String,Object> results = new HashMap<>();
        //1.判断是否参数是否为空
        if (StringUtils.isEmpty(loginNmae) || StringUtils.isEmpty(passWord)){
            //参数为空了
            results.put("code",1);
            results.put("msg","值为空");
        }else {
            //根据登录名称去查询用户对象
            User user = userMapper.login(loginNmae);
            if (user != null){
                //判断密码
                if (user.getPassword().equals(passWord)){
                    //登录成功
                    //应该将登录成功的用户存到session回话中
                    results.put("code",0);
                    results.put("msg",user);
                }else {
                    //密码错误
                    results.put("code",2);
                    results.put("msg","密码错误");
                }
            }else {
                //登录名不存在
                results.put("code",3);
                results.put("msg","用户名不存在");
            }
        }

        return results;
    }

    @Override
    public List<ArticleType> loadFirstArticleTypes() {
        List<ArticleType> articleTypes = articleTypeMapper.getFirstArticleTypes();
        return articleTypes;
    }

    @Override
    public List<ArticleType> loadSecondTypes(String typeCode) {
        List<ArticleType> articleTypes = articleTypeMapper.loadSecondTypes(typeCode+"%",typeCode.length()+4);
        return articleTypes;
    }

    @Override
    public void deleteById(String id) {
        articleMapper.deleteById(id);
    }

    @Override
    public Article getArtcleById(String id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void saveArticle(Article article) {
        article.setCreateDate(new Date());
        articleMapper.save(article);
    }

    @Override
    public List<Article> searchArticles(String typeCode, String secondType, String title, Pager pager) {
        int count = articleMapper.count(typeCode,secondType,title);
        pager.setTotalCount(count);
        return articleMapper.searchArticles(typeCode,secondType,title,pager);
    }
}
