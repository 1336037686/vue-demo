<template>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-pagination  layout="prev, pager, next" :total="$store.state.userPageInfo.pages" :current-page="$store.state.userPageInfo.pageNum" @current-change="updatePage"></el-pagination>
      </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "DataFooter",
        data () {
          return {
         }
        },
        mounted() {
          this.$store.dispatch("getUsers", {obj: this, pageNum: 1})
        },
        methods: {
          updatePage(val) {
            if(this.$store.state.userSearchData === '') {
              this.$store.dispatch("getUsers", {obj: this, pageNum: val})
            } else {
              this.$store.dispatch("searchUser", {obj: this, data: this.$store.state.userSearchData, pageNum: val})
            }

          }
        }
    }
</script>

<style scoped>

</style>
