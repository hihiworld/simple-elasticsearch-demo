package com.yaologos.searchhouse.controller;

import com.yaologos.searchhouse.service.SearchService;
import com.yaologos.searchhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private SearchService searchService;

    @GetMapping("/searchIndex")
    public String searchIndex(){
        return "searchIndex";
    }

    /**
     * 使用web方式创建elastic文档，这里使用最简单的方式
     *
     * @param username 前端传输的用户名
     * @return 是否创建成功
     */
    @ResponseBody
    @PostMapping("/createDoc")
    public boolean translate(@RequestParam(required = false, name = "username") String username){
        return searchService.index(username);
    }

    @ResponseBody
    @PostMapping("/deleteDoc")
    public boolean delete(@RequestParam("name") String username){
        return searchService.remove(username);
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<String> results = searchService.query(keyword);
        model.addAttribute("results", results);
        return "resultPage";
    }
}