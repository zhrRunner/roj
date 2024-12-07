import { StoreOptions } from "vuex";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "未登录",
      role: "guest",
    },
  }),
  actions: {
    async getLoginUser({ commit, state }, payload) {
      // TODO 改为远程登录请求信息
      commit("updateUser", { userName: "zouhr" });
    },
  },
  mutations: {
    updateUser(state, payload) {
      state.loginUser = payload;
    },
  },
} as StoreOptions<any>;
