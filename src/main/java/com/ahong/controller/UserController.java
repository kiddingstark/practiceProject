package com.ahong.controller;

import com.ahong.PO.ResponsePo;
import com.ahong.PO.User;
import com.ahong.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 使用Springsecurity框架则无需login的controller层
     * @param userCode
     * @param password
     * @param session
     * @param request
     * @return
     */

    /**
     * 定义统一的异常拦截器取消try catch不优雅的写法
     */
    @PostMapping("/login")
    public ResponsePo<User> login(String userCode, String password, HttpSession session, HttpServletRequest request) {
        User user = null;
        try {
            user = userService.login(userCode, password);
            System.out.println("sessionId:" + session.getId());
            session.setAttribute("userCode", user.getUserCode());
        } catch (Exception e) {
            log.error("error:" + e.getMessage());
            return ResponsePo.fail(e.getMessage());
        }
        return ResponsePo.success(user);
    }

    /**
     * 校验
     *
     * @param user
     * @return
     */
    @GetMapping("/addUser")
    public ResponsePo addUser(@RequestBody @Validated User user) {
        return ResponsePo.OK();
    }

}
