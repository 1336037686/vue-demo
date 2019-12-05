<!--登陆界面表单体-->
<template>
  <el-form :model="userForm" :rules="rules" ref="userForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="用户名" prop="name">
      <el-input v-model="userForm.name"></el-input>
    </el-form-item>
    <el-form-item label=" 密码" prop="pass">
      <el-input type="password" v-model="userForm.pass"></el-input>
    </el-form-item>
    <el-form-item>
      <el-col :span="12">
        <el-button type="primary" @click="submitForm">登陆</el-button>
      </el-col>
      <el-col :span="12">
        <el-button @click="resetForm('userForm')">重置</el-button>
      </el-col>
    </el-form-item>
  </el-form>
</template>

<script>
    export default {
      name: "LoginBody",
      data() {
        return {
          userForm: {
            name: '',
            pass: ''
          },
          rules: {
            name: [
              { required: true, message: '请输入用户名称', trigger: 'blur' }
            ],
            pass: [
              { required: true, message: '请输入密码', trigger: 'blur' }
            ]
          }
        };
      },
      methods: {
        submitForm() {
          if(this.userForm.name == '' || this.userForm.pass == '') {
            this.$message({
              message: "填写错误",
              type: "error"
              })
            return
          }
          this.$store.dispatch('login', {obj:this, data: this.userForm})
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
</script>

<style scoped>

</style>
