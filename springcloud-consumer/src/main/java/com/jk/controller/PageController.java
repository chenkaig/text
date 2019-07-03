package com.jk.controller;

import com.jk.model.News;
import com.jk.service.NewsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @RequestMapping("toShow")
    public String toShow(){
        return "show";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "addDialog";
    }


    @Autowired
    private NewsServiceFeign feign;

    @RequestMapping("toUpdate")
    public String toUpdate(@RequestParam(value = "id") Integer id, Model model){
       News news =  feign.selectNewsById(id);
       model.addAttribute("jour",news);
        return "updateDialog";
    }
}
