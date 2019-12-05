<template>
  <el-row>
    <!--heard-->
    <el-row>
      <DataHeader/>
    </el-row>
    <!--body-->
    <el-row class="space">
      <DataBody/>
    </el-row>
    <!--footer-->
    <el-row class="space">
      <DataFooter/>
    </el-row>
  </el-row>
</template>

<script>
    import DataHeader from "./DataHeader";
    import DataBody from "./DataBody";
    import DataFooter from "./DataFooter";
    export default {
        name: "Data",
      components: {DataFooter, DataBody, DataHeader}
    }
</script>

<style scoped>
  .space {
    margin-top: 20px;
  }
</style>
