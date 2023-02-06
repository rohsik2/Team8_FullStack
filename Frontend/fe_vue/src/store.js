// store.js
import Vuex from "vuex";

export default new Vuex.Store({
  state: {
    isLogin: false,
    subjects: [],
    jwt: null,
  },
  mutations: {
    setLoginStatus(state, status) {
      state.isLogin = status;
    },
    setSubjectsStatus(state, subjects) {
      state.subjects = subjects;
    },
    setJwtToken(state, token) {
      state.jwt = token;
    },
    ifTokenVal(state) {
      if (state.jwt == null) {
        state.isLogin = false;
        return false;
      }
      state.isLogin = true;
      return true;
    },
    logout(state, status) {
      state.jwt = null;
      state.isLogin = status;
    },
  },
  actions: {
    ifTokenVal: ({ commit }) => {
      commit("ifTokenVal");
    },
    logout: ({ commit }) => {
      commit("logout");
    },
  },
});
