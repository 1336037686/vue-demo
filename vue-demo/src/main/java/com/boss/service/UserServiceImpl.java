package com.boss.service;

import com.boss.dao.UserMapper;
import com.boss.pojo.dto.UserBaseDTO;
import com.boss.pojo.entity.User;
import com.boss.pojo.vo.UserVO;
import com.boss.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LGX_TvT
 * @date 2019-12-04 16:23
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBaseDTO login(UserBaseDTO userBaseDTO) {
        User user = userMapper.getUserByName(userBaseDTO.getName());
        if(user == null) {
            return null;
        } else if(MD5Util.md5(userBaseDTO.getPassword()).equals(user.getPassword())) {
            return new UserBaseDTO(user.getName(), user.getPassword());
        }
        return null;
    }

    @Override
    public PageInfo<UserVO> getUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.getAllUser();
        List<UserVO> userVOs = new ArrayList<>();
        if(list != null) {
            list.forEach(e -> {
                userVOs.add(new UserVO(e.getId(), e.getName(), e.getAge()));
            });
        }
        PageInfo<UserVO> pageInfo = new PageInfo<UserVO>(userVOs);
        return pageInfo;
    }

    @Override
    public PageInfo<UserVO> searchUsers(String data, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.searchUser(data);
        List<UserVO> userVOs = new ArrayList<>();
        if(list != null) {
            list.forEach(e -> {
                userVOs.add(new UserVO(e.getId(), e.getName(), e.getAge()));
            });
        }
        PageInfo<UserVO> pageInfo = new PageInfo<UserVO>(userVOs);
        return pageInfo;
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer updateUser(User user) {
        if(user.getPassword().length() == 32) {
            return userMapper.updateUserExcludePassword(user);
        }
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(String id) {
        return userMapper.deleteUserById(id);
    }


}
