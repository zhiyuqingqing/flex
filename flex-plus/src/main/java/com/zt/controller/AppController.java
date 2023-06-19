package com.zt.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.zt.dto.AppSmsDTO;
import com.zt.plus.domain.Test;
import com.zt.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lengleng
 * @date 2021/9/16 移动端登录
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app")
@Api(tags = "移动端登录模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppController {
    @Autowired
    private AppService appService;

    @PostMapping("/sms")
    @ApiOperation("返回用户信息")
    public R<String> sendSmsCode(@Valid @RequestBody AppSmsDTO sms) {
        Test test = appService.sendSmsCode(sms.getPhone());
        return R.ok(JSONUtil.toJsonStr(test));
    }
}
