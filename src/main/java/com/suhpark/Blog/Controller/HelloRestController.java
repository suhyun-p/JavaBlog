package com.suhpark.Blog.Controller;

import com.suhpark.Blog.Entity.Hello;
import com.suhpark.Blog.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloRestController {
    @Autowired
    private HelloDao helloDao;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Hello add(Hello hello) {

        Hello helloData = helloDao.save(hello);

        return helloData;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Hello> list(Model model) {

        List<Hello> helloList = helloDao.findAll();

        return helloList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "hello, world!";
    }
}
