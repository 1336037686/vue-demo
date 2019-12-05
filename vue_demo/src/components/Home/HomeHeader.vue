<template>
  <el-row>
    <el-col :span="24" class="bg">
      <el-menu class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1">处理中心</el-menu-item>
        <el-submenu index="2">
          <template slot="title">我的工作台</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
          <el-menu-item index="2-3">选项3</el-menu-item>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项1</el-menu-item>
            <el-menu-item index="2-4-2">选项2</el-menu-item>
            <el-menu-item index="2-4-3">选项3</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="3" class="user">
          <template slot="title">
            <el-avatar :size="30" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
            <span> {{$store.state.loginUser}}</span>
          </template>
          <el-menu-item index="3-1">修改信息</el-menu-item>
          <el-menu-item index="3-1" @click="logout">退出</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "HomeHeader",
    methods: {
      logout() {
        this.$store.dispatch("logout", this);
      }
    }
  }
</script>

<style scoped>
  .bg
  {
    box-shadow: 8px 8px 5px #888888;
  }

  .user {
    margin-left: 80%;
  }
</style>
