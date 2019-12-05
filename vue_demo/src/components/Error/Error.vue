<template>
    <el-row>
      <el-col :span="8" :offset="8">
        <el-image :src="src"></el-image>
      </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "Error",
        data() {
          return {
            src: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575458591533&di=11ce1a899ff35c8b018c7fda3b1b886c&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F018fcc5543eb240000019ae9f1cf41.jpg%401280w_1l_2o_100sh.png'
          }
        }
    }
</script>

<style scoped>

</style>
