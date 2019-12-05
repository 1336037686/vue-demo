import axios from 'axios'
import da from "element-ui/src/locale/lang/da";

/**
 * 用户操作
 */
export default {
  /**
   * 登陆
   * @param obj
   * @param user
   */
  login: function (obj, user) {
    axios.post("/login", {"name": user.name, "password": user.pass})
      .then(function (response) {
        if(response.data.code === 200) {
          obj.$store.state.loginUser = response.data.msg
          window.localStorage['access-token'] = response.data.msg;
          obj.$message('登录成功');
          obj.$router.push('/home')
        } else if(response.data.code === 400) {
          obj.$store.state.loginUser = ''
          obj.$message('登录失败');
          obj.$router.push('/')
        }
      })
      .catch(function (error) {
        console.log(error)
      });
  },
  /**
   * 退出
   * @param obj
   */
  logout: function (obj) {
    window.localStorage.removeItem('access-token')
    obj.$router.push('/')
  },

  /**
   * 根据页面查询用户
   * @param page
   */
  selectUsers: function (obj, pageNum) {
    axios.get("/users/" + pageNum)
      .then(function (response) {
       if(response.data.code === 200) {
         obj.$store.state.userPageInfo = response.data.msg
         obj.$store.state.currentUserPageNum = response.data.msg.pageNum
       }
      })
      .catch(function (error) {
        console.log(error)
      });
  },

  /**
   * 添加用户
   * @param obj
   * @param user
   */
  insertUser: function (obj, user) {
    axios.post("/insert", {"name": user.name, "password": user.password, "age": user.age})
      .then(function (response) {
        if(response.data.code === 200) {
          obj.$message('添加成功');
          user.name = ''
          user.password = ''
          user.age = ''
        } else {
          obj.$message('添加失败');
        }
      })
      .catch(function (error) {
        console.log(error)
      });
  },

  /**
   * 根据id查询用户
   * @param obj
   * @param id
   */
  getUserById: function (obj, id) {
    axios.get("/user/" + id)
      .then(function (response) {
        if(response.data.code === 200) {
          obj.updateForm.id = response.data.msg.id
          obj.updateForm.name = response.data.msg.name
          obj.updateForm.pass = response.data.msg.password
          obj.updateForm.age = response.data.msg.age
        }
      })
      .catch(function (error) {
        console.log(error)
      });
  },

  /**
   * 更新用户
   * @param obj
   * @param user
   */
  updateUser: function (obj, user) {
    axios.post("/update", {"id": user.id, "name": user.name, "password": user.pass, "age": user.age})
      .then(function (response) {
        if(response.data.code === 200) {
          obj.$message('修改成功');
          obj.updateForm.id = ''
          obj.updateForm.name = ''
          obj.updateForm.pass = ''
          obj.updateForm.age = ''
        } else {
          obj.$message('修改失败');
        }
      })
      .catch(function (error) {
        console.log(error)
      });
  },

  /**
   * 删除用户
   * @param obj
   * @param id
   */
  deleteUser: function (obj, id) {
    axios.get("/delete/" + id)
      .then(function (response) {
        if(response.data.code === 200) {
          obj.$message('删除成功');
        } else {
          obj.$message('删除失败');
        }
      })
      .catch(function (error) {
        console.log(error)
      });
  },

  /**
   * 搜索查找用户
   * @param page
   */
  searchUser: function (obj, data, pageNum) {
    axios.get("/search/" + data + "/" + pageNum)
      .then(function (response) {
        if(response.data.code === 200) {
          obj.$store.state.userPageInfo = response.data.msg
          obj.$store.state.currentUserPageNum = response.data.msg.pageNum
        }
      })
      .catch(function (error) {
        console.log(error)
      });
  },
}
