<template>
  <el-row>
    <el-col :span="6" :offset="9" class="login">
      <div class="grid-content bg-purple-light">
        <el-card class="box-card bg">
          <div class="clearfix text">
            <LoginHeader/>
          </div>
          <el-row>
            <el-col :span="20" :offset="2" class="loginBody">
              <LoginBody/>
            </el-col>
          </el-row>
        </el-card>
      </div>
    </el-col>
  </el-row>
</template>

<script>
    import LoginHeader from "./LoginHeader";
    import LoginBody from "./LoginBody";
    export default {
      name: "Login",
      components: {LoginBody, LoginHeader}
    }
</script>

<style scoped>
  .text {
    text-align: center;
  }
  .loginBody {
    margin-top: 20px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 100%;
  }

  .bg
  {
    box-shadow: 8px 8px 5px #888888;
  }

</style>
