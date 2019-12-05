<template>
  <el-row>
    <el-col :span="7">
      <el-form :inline="true" :model="search">
        <el-form-item label="">
          <el-input v-model="search.message" placeholder="搜索信息"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearch">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <el-col :span="3" :offset="14">
      <el-button type="success" @click="dialogVisible = true" >添加数据</el-button>
      <el-button type="primary" @click="reflushData">刷新数据</el-button>
    </el-col>
    <el-dialog title="表单弹框" :visible.sync="dialogVisible" width="30%" :append-to-body="true" >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="姓名">
          <el-input type="text" v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password" v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input type="text" v-model="form.age"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancleInsert">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </span>
    </el-dialog>
  </el-row>
</template>

<script>
    export default {
        name: "DataHeader",
        data() {
          return {
            dialogVisible:false,
            form: {
              name: '',
              password:'',
              age: ''
            },
            search: {
              message: ''
            }
          }
        },
        methods: {
          // 刷新数据
          reflushData() {
            this.$store.dispatch("getUsers", {obj: this, pageNum: this.$store.state.userPageInfo.pageNum})
          },
          //取消
          cancleInsert() {
            this.form.name = ''
            this.form.password = ''
            this.form.age = ''
            this.dialogVisible = false
          },
          //添加
          onSubmit() {
            this.$store.dispatch("insertUser", {obj: this, data: this.form})
            this.$store.dispatch("getUsers", {obj: this, pageNum: this.$store.state.userPageInfo.pageNum})
            this.dialogVisible = false;
          },
          //查询
          onSearch() {
            this.$store.state.userSearchData = this.search.message
            if(this.$store.state.userSearchData === '') {
              this.$store.dispatch("getUsers", {obj: this, pageNum: 1})
            } else {
              this.$store.dispatch("searchUser", {obj: this, data: this.$store.state.userSearchData, pageNum: 1})
            }
          }
        }
    }
</script>

<style scoped>

</style>
