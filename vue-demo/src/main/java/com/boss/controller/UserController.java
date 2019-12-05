package com.boss.controller;

import com.boss.pojo.base.GlobalResponse;
import com.boss.pojo.dto.UserBaseDTO;
import com.boss.pojo.entity.User;
import com.boss.pojo.vo.UserBaseVO;
import com.boss.pojo.vo.UserInsertVo;
import com.boss.pojo.vo.UserVO;
import com.boss.service.IUserService;
import com.boss.util.MD5Util;
import com.boss.util.SnowFlake;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LGX_TvT
 * @date 2019-12-04 16:21
 */
@RestController
public class UserController {

    @Autowired
    IUserService userService;


    /**
     * 用户登陆
     * @param userBaseVO
     * @return
     */
    @PostMapping("/login")
    public GlobalResponse doLogin(@RequestBody UserBaseVO userBaseVO){
        System.out.println(userBaseVO);
        UserBaseDTO loginUser = userService.login(new UserBaseDTO(userBaseVO.getName(), userBaseVO.getPassword()));
        System.out.println(loginUser.getName() + "," + loginUser.getPassword());
        if(loginUser != null) {
            return new GlobalResponse(200, loginUser.getName());
        }
        return new GlobalResponse(400, null);
    }

    /**
     * 根据页面获取用户列表
     * @param page
     * @return
     */
    @GetMapping("/users/{page}")
    public GlobalResponse doGetUsers(@PathVariable("page") Integer page){
        PageInfo<UserVO> pageInfo = userService.getUsers(page, 20);
        return new GlobalResponse(200, pageInfo);
    }

    /**
     * 用户增加
     * @param userInsertVo
     * @return
     */
    @PostMapping("/insert")
    public GlobalResponse doInsertUser(@RequestBody UserInsertVo userInsertVo) {
        User u = new User(SnowFlake.nextId() + "", userInsertVo.getName(), MD5Util.md5(userInsertVo.getPassword()), userInsertVo.getAge());
        if (userService.insertUser(u) > 0) {
            return new GlobalResponse(200, "添加成功");
        }
        return new GlobalResponse(400, "添加失败");
    }

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public GlobalResponse doGetUserById(@PathVariable("id") String id) {
        User user = userService.getUserById(id);
        if(user != null) {
            return new GlobalResponse(200, user);
        }
        return new GlobalResponse(400, user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public GlobalResponse doUpdateUser(@RequestBody User user) {
        System.out.println(user);
        int result = userService.updateUser(user);
        if(result > 0) {
            return new GlobalResponse(200, "修改成功");
        }
        return new GlobalResponse(400, "修改失败");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public GlobalResponse doDeleteUser(@PathVariable("id") String id) {
        if(userService.deleteUser(id) > 0) {
            return new GlobalResponse(200, "删除成功");
        }
        return new GlobalResponse(400, "删除失败");
    }

    @GetMapping("/search/{data}/{page}")
    public GlobalResponse doSearchUser(@PathVariable("data") String data, @PathVariable("page") Integer page) {
        PageInfo<UserVO> pageInfo = userService.searchUsers(data, page, 20);
        return new GlobalResponse(200, pageInfo);
    }


}
