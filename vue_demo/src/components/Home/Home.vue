<template>
    <el-row>
      <!--header-->
      <el-row>
        <el-col :span="24">
          <HomeHeader/>
        </el-col>
      </el-row>
      <!--body-->
      <el-row>
        <el-col :span="24">
          <HomeBody/>
        </el-col>
      </el-row>
      <!--footer-->

    </el-row>
</template>

<script>
    import HomeHeader from "./HomeHeader";
    import HomeBody from "./HomeBody";
    export default {
        name: "Home",
      components: {HomeBody, HomeHeader}
    }
</script>

<style scoped>

</style>
