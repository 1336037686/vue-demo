package com.boss.service;

import com.boss.pojo.dto.UserBaseDTO;
import com.boss.pojo.entity.User;
import com.boss.pojo.vo.UserVO;
import com.github.pagehelper.PageInfo;

/**
 * @author LGX_TvT
 * @date 2019-12-04 16:23
 */
public interface IUserService {

    UserBaseDTO login(UserBaseDTO userBaseDTO);

    PageInfo<UserVO> getUsers(int pageNum, int pageSize);

    PageInfo<UserVO> searchUsers(String data, int pageNum, int pageSize);

    Integer insertUser(User user);

    User getUserById(String id);

    Integer updateUser(User user);

    Integer deleteUser(String id);
}
