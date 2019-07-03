package com.jk.service;

import com.jk.mapper.NewsMapper;
import com.jk.model.Author;
import com.jk.model.News;
import com.jk.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper  newsMapper;

    @Override
    @PostMapping("addNews")
    public News addNews(@RequestBody News news) {
        news.setJid(222);
        return news;
    }

    @Override
    @GetMapping("selectNews/{start}/{pageSize}")
    public HashMap<String, Object> selectNews(@PathVariable(value = "start") Integer start,@PathVariable(value = "pageSize") Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer sum = newsMapper.selectCount();
        map.put("total",sum);
        List<News> list = newsMapper.selectNews(start,pageSize);
        map.put("rows",list);
        return map;
    }

    @Override
    @GetMapping("selectAuthor")
    public List<Author> selectAuthor() {
        return newsMapper.selectAuthor();
    }

    @Override
    @GetMapping("selectType")
    public List<Type> selectType() {
        return newsMapper.selectType();
    }

    @Override
    @PostMapping("saveNews")
    public void saveNews(@RequestBody News news) {
        newsMapper.saveNews(news);
    }

    @Override
    @RequestMapping("toUpdate/{id}")
    public News selectNewsById(@PathVariable(value = "id") Integer id) {
        return newsMapper.selectNewsById(id);
    }

    @Override
    @PostMapping("updateNews")
    public void updateNews(@RequestBody News news) {
        newsMapper.updateNews(news);
    }

    @Override
    @PostMapping("deleteNews/{id}")
    public void deleteNews(@PathVariable(value = "id") Integer id) {
        newsMapper.deleteNews(id);
    }
}
