package com.ax.demo.api;

import com.ax.demo.entity.Student;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HomeAPI {

    @ApiOperation(value = "首页接口")
    @RequestMapping(value = "/home.do")
    Object ipLogPageInfo();

    @ApiOperation(value = "编辑公告", notes = "编辑公告notes")
    @PostMapping(value = "/edit")
    Student edit(
            @ApiParam(name = "bis_key", value = "公告key", required = true) String bisKey,
            @ApiParam(name = "title", value = "公告标题", required = true) @RequestParam String title,
            @ApiParam(name = "content", value = "公告内容", required = true) String content);


    @ApiOperation(value = "编辑公告", notes = "编辑公告notes")
    @PostMapping(value = "/edit2")
    List<Student> edit2(
            @ApiParam(name = "bis_key", value = "公告key", required = true) String bisKey,
            @ApiParam(name = "title", value = "公告标题", required = true) @RequestParam String title,
            @ApiParam(name = "content", value = "公告内容", required = true) String content);
}
