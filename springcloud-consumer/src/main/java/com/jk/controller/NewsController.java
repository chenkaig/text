package com.jk.controller;

import com.jk.model.Author;
import com.jk.model.News;
import com.jk.model.Type;
import com.jk.service.NewsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsServiceFeign  feign;


    @Autowired
    private RedisTemplate  redisTemplate;

    @PostMapping("addNews")
    public News addNews(){
        News news = new News();
        news.setJtitle("李晨冰冰分手");
        news.setKeywords("分手");
        news.setContent("李晨范冰冰分手，范冰冰疑似怀孕");
        news.setReleaseTime(new Date());
        news.setTypeId(1);
        news.setUserId(1);
        news = feign.addNews(news);
        return news;

    }


    @GetMapping("selectNews")
    public HashMap<String,Object> selectNews(@RequestParam(value = "start") Integer  start,
                                             @RequestParam(value = "pageSize") Integer pageSize){
        HashMap<String,Object> map = feign.selectNews(start,pageSize);
        return map;
    }

    @GetMapping("selectAuthor")
    public List<Author>  selectAuthor(){
        List<Author>  list = feign.selectAuthor();
        return list;
    }

    @GetMapping("selectType")
    public List<Type>  selectType(){
        List<Type>  list = feign.selectType();
        return list;
    }

    @PostMapping("saveNews")
    public void saveNews(News news){
        feign.saveNews(news);
    }

    @PostMapping("updateNews")
    public void updateNews(News  news){
        feign.updateNews(news);
    }

    @PostMapping("deleteNews")
    public void deleteNews(@RequestParam(value = "id") Integer id){
        feign.deleteNews(id);
    }



}
