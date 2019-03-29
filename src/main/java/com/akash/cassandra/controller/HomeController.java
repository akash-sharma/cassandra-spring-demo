package com.akash.cassandra.controller;

import com.akash.cassandra.dao.NovelDao;
import com.akash.cassandra.entity.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private NovelDao novelDao;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save() {
        Novel novel = new Novel();
        novel.setAuthor("amit");
        novel.setCategory("horror");
        novel.setGenre("fun");
        novel.setName("mecbeth");
        novelDao.upsert(novel);
        return "saved";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String findAllByCategoryAndAuthor() {
        List<Novel> novels = novelDao.findAllByCategoryAndAuthor("horror", "amit");
        for(Novel novel : novels) {
            System.out.println(novel);
        }
        return ""+novels.size();
    }

    @RequestMapping(value = "/findByGroup", method = RequestMethod.GET)
    @ResponseBody
    public String findGroupedGenreByCategoryAndAuthor() {
        List<Novel> novels = novelDao.findGroupedGenreByCategoryAndAuthor("horror", "amit");
        for(Novel novel : novels) {
            System.out.print(novel.getGenre() + " ");
            System.out.println(novel.getGroupCount());
        }
        return ""+novels.size();
    }
}