package com.jx.agile.auth.controller.access;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/01/16:34
 * @Description:
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jx.agile.core.web.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 账号注册处理器
 */
@Slf4j
@RequestMapping("/reset")
@RestController
public class ResetController {


    @GetMapping("/register")
    public Result index() {

        log.info("index");
        return null;
    }

}
