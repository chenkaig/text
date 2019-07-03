package com.jk.mapper;

import com.jk.model.Author;
import com.jk.model.News;
import com.jk.model.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    Integer selectCount();

    List<News> selectNews(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    List<Author> selectAuthor();

    List<Type> selectType();

    void saveNews(News news);

    News selectNewsById(Integer id);

    void updateNews(News news);

    void deleteNews(Integer id);
}
