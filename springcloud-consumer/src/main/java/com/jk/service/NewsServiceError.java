package com.jk.service;

import com.jk.model.Author;
import com.jk.model.News;
import com.jk.model.Type;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/error")
@Component
public class NewsServiceError implements NewsServiceFeign{
    private static final String errorName="网络异常";

    @Override
    public News addNews(News news) {
        return null;
    }

    @Override
    public HashMap<String, Object> selectNews(Integer start, Integer pageSize) {
        return null;
    }

    @Override
    public List<Author> selectAuthor() {
        return null;
    }

    @Override
    public List<Type> selectType() {
        return null;
    }

    @Override
    public void saveNews(News news) {

    }

    @Override
    public News selectNewsById(Integer id) {
        return null;
    }

    @Override
    public void updateNews(News news) {

    }

    @Override
    public void deleteNews(Integer id) {

    }
}
