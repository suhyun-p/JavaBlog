package com.suhpark.Blog.Controller;

import com.suhpark.Blog.Entity.Hello;
import com.suhpark.Blog.dao.HelloDao;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "HelloController", description = "Hello Controllers Description")
@RestController
@RequestMapping(value="/hello")
public class HelloRestController {
    @Autowired
    private HelloDao helloDao;

    @ApiOperation(value = "회원 추가")
    @ApiImplicitParams({
            // @ApiImplicitParam(name = "id", value = "ID", required = false, dataType = "int", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "name", value = "이름", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Hello add(String name) {

        Hello hello = new Hello(name);
        Hello helloData = helloDao.save(hello);

        return helloData;
    }

    @ApiOperation(value = "회원 조회")
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
