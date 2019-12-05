/*
Vuex store对象模块
 */
import Vue from 'vue'
import Vuex from 'vuex'
import state from './state'
import getters from './getters'
import mutations from './mutations'
import actions from './actions'

Vue.use(Vuex)

//向外暴露store对象
export default new Vuex.Store({
  state,
  getters,
  actions,
  mutations
})
