package com.iceDarron.core.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iceDarron.core.distribute.WebAPI;
import com.iceDarron.core.cache.RedisManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iceDarron.core.service.IBookService;
import com.iceDarron.data.po.Book;
import redis.clients.jedis.Jedis;

/**
 * @author IceDarron
 * @Description [用于图书对象的controller]
 * @since 20170721
 */
@Controller
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    @Autowired
    private RedisManger redisManger;

    /**
     * 获取所有书籍
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public String getBookAll(HttpServletRequest request,
                             HttpServletResponse response, Model model) {
        List<Book> bookList = this.bookService.getBookAll();
        response.setCharacterEncoding("utf-8");
        logger.info("获取所有书籍信息");
        return JSON.toJSONString(bookList);
    }

    /**
     * 增加书籍
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(HttpServletRequest request,
                          HttpServletResponse response, Model model) {
        List<Book> listBook = new ArrayList<Book>();
        Book book = new Book();
        book.setC_ID(UUID.randomUUID().toString().replace("-", ""));
        listBook.add(book);
        int count = this.bookService.addBook(listBook);
        response.setCharacterEncoding("utf-8");
        logger.info("增加书籍信息" + count);
        return JSON.toJSONString("success");
    }

    /**
     * 更新书籍
     */
    @RequestMapping(value = "/book/{C_ID}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateBook(HttpServletRequest request,
                             HttpServletResponse response, Model model) {
        String str = "";
        try {
            str = WebAPI.getBody(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Book> listBook = new ArrayList<Book>();
        Book book = JSONObject.parseObject(str, Book.class);
        listBook.add(book);
        int count = this.bookService.updateBook(listBook);
        response.setCharacterEncoding("utf-8");
        logger.info("更新书籍信息" + count);
        return JSON.toJSONString("success");
    }

    /**
     * 删除书籍
     */
    @RequestMapping(value = "/book/{c_ID}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBook(HttpServletRequest request,
                             HttpServletResponse response, Model model,
                             @PathVariable("c_ID") String c_ID) {
        List<Book> listBook = new ArrayList<Book>();
        Book book = new Book();
        book.setC_ID(c_ID);
        listBook.add(book);
        int count = this.bookService.deleteBook(listBook);
        response.setCharacterEncoding("utf-8");
        logger.info("删除书籍信息" + count);
        return JSON.toJSONString("success");
    }

    /**
     * 通过条件获取书籍
     */
    @RequestMapping(value = "/getBookByCondition", method = RequestMethod.GET)
    @ResponseBody
    public String getBookByCondition(HttpServletRequest request,
                                     HttpServletResponse response, Model model) {
        String str = "";
        try {
            str = WebAPI.getBody(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Book book = JSONObject.parseObject(str, Book.class); // 前台传递过来的条件

        List<Book> listBook = new ArrayList<Book>();
        // 查询符合条件的所有书籍

        response.setCharacterEncoding("utf-8");
        logger.info("获取符合条件书籍信息");
        return JSON.toJSONString(listBook);
    }

    /**
     * 获取所有书籍分类
     */
    @RequestMapping(value = "/getBookCategory", method = RequestMethod.GET)
    @ResponseBody
    public String getBookCategory(HttpServletRequest request,
                                  HttpServletResponse response, Model model) {
        response.setCharacterEncoding("utf-8");
        logger.info("获取所有书籍信息");

        Jedis jedis = redisManger.getResource();
        jedis.set("name", "xinxin111222");
        System.out.println(jedis.get("name"));
        return JSON.toJSONString("");
    }
}
