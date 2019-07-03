package com.jk.service;

import com.jk.model.Author;
import com.jk.model.News;
import com.jk.model.Type;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public interface NewsService {
    @PostMapping("addNews")
    News addNews(News news);
    @GetMapping("selectNews/{start}/{pageSize}")
    HashMap<String, Object> selectNews(@PathVariable(value = "start") Integer start,
                                       @PathVariable(value = "pageSize") Integer pageSize);
    @GetMapping("selectAuthor")
    List<Author> selectAuthor();

    @GetMapping("selectType")
    List<Type> selectType();

    @PostMapping("saveNews")
    void saveNews(News news);

    @RequestMapping("toUpdate/{id}")
    News selectNewsById(@PathVariable(value = "id") Integer id);

    @PostMapping("updateNews")
    void updateNews(News news);

    @PostMapping("deleteNews/{id}")
    void deleteNews(@PathVariable(value = "id") Integer id);
}
