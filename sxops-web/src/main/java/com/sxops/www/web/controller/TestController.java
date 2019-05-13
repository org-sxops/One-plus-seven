package com.sxops.www.web.controller;

import com.sxops.www.dao.model.LUserInfo;
import com.sxops.www.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RequestMapping("test")
@RestController
@Api(value = "测试接口", tags = "测试接口")
public class TestController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "新增接口,[geweiHome@163.com]")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "名称", paramType = "query"),
    })
    @GetMapping("addUser")
    public LUserInfo addUser( LUserInfo userInfo) {
        userInfoService.insert(userInfo);
        return userInfo;
    }


    @ApiOperation(value = "查询接口,[geweiHome@163.com]")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "名称", paramType = "query"),
            @ApiImplicitParam(name = "phoneNum", value = "手机号", paramType = "query")
    })
    @GetMapping("getUser")
    public List<LUserInfo> getUser(@ApiIgnore LUserInfo userInfo) {
        List<LUserInfo> userList = userInfoService.select(userInfo);
        return userList;
    }


}
