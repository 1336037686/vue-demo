/* 包含多个事件回调函数的对象 */

import user from '../api/user'
import da from "element-ui/src/locale/lang/da";

export default {
  /**
   * 登陆
   * @param commit
   * @param obj
   * @param data
   */
  login: ({commit}, {obj, data}) =>{
    user.login(obj, data)
  },
  /**
   * 退出
   * @param commit
   * @param state
   * @param obj
   */
  logout: ({commit, state}, obj) => {
    state.loginUser = ''
    user.logout(obj)
  },

  /**
   * 查询用户
   * @param state
   * @param obj
   * @param pageNum
   */
  getUsers: ({state},{obj, pageNum}) => {
    user.selectUsers(obj, pageNum)
  },

  /**
   * 添加用户
   * @param state
   * @param obj
   * @param user
   */
  insertUser: ({state}, {obj, data}) => {
    user.insertUser(obj, data)
  },

  /**
   * 根据ID查询用户
   * @param state
   * @param obj
   * @param id
   */
  getUserById: ({state}, {obj, id}) => {
    user.getUserById(obj, id)
  },

  /**
   * 修改用户
   * @param state
   * @param obj
   * @param data
   */
  updateUser: ({state}, {obj, data}) => {
    user.updateUser(obj, data)
  },

  /**
   * 删除用户
   * @param state
   * @param obj
   * @param id
   */
  deleteUser: ({state}, {obj, id}) => {
    user.deleteUser(obj, id)
  },

  /**
   * 搜索查找用户
   * @param state
   * @param obj
   * @param data
   */
  searchUser: ({state}, {obj, data, pageNum}) => {
    user.searchUser(obj, data, pageNum)
  }
}

