<template>
  <el-row>
    <el-col :span="24">
      <el-card class="box-card card bg">
        <Data/>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import Data from "../Data/Data";

  export default {
    name: "HomeBody",
    components: {Data}
  }
</script>

<style scoped>
  .card {
    margin-top: 10px;
  }

  .bg {
    box-shadow: 8px 8px 5px #888888;
  }
</style>
