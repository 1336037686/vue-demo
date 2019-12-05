<template>
  <el-row>
    <el-col :span="24">
      <el-table :data="$store.state.userPageInfo.list" style="width: 100%">
        <el-table-column prop="id" label="ID" width="180">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="180">
        </el-table-column>
        <el-table-column prop="age" label="年龄">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="deleteHandle(scope.row)" type="text">删除</el-button>
            <el-button type="text" @click="updateHandler(scope.row)">编辑</el-button>
          </template>
          <el-dialog title="编辑" :visible.sync="updateDialogVisible" width="30%" :append-to-body="true" >
            <el-form ref="updateForm" :model="updateForm" label-width="80px">
              <el-form-item label="ID">
                <el-input type="text" v-model="updateForm.id" disabled></el-input>
              </el-form-item>
              <el-form-item label="姓名">
                <el-input type="text" v-model="updateForm.name"></el-input>
              </el-form-item>
              <el-form-item label="密码">
                <el-input type="password" v-model="updateForm.pass"></el-input>
              </el-form-item>
              <el-form-item label="年龄">
                <el-input type="text" v-model="updateForm.age"></el-input>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="updateDialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="onUpdateSubmit">确 定</el-button>
            </span>
          </el-dialog>
        </el-table-column>
      </el-table>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "DataBody",
    data() {
      return {
        updateDialogVisible: false,
        updateForm: {
          id: '123456',
          name: '',
          pass: '',
          age: ''
        }
      }
    },
    methods: {
      //删除
      deleteHandle(obj) {
        this.$confirm('确定删除' + obj.id + '?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$store.dispatch('deleteUser', {obj: this, id: obj.id})
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      //编辑
      updateHandler(obj) {
        this.updateDialogVisible = true
        this.$store.dispatch('getUserById', {obj: this, id: obj.id})
      },
      //更新
      onUpdateSubmit(){
        this.$store.dispatch('updateUser', {obj: this, data: this.updateForm})
        this.$store.dispatch("getUsers", {obj: this, pageNum: this.$store.state.userPageInfo.pageNum})
        this.updateDialogVisible = false
      }
    }
  }

</script>

<style scoped>

</style>
