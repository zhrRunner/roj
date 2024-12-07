<template>
  <div id="app">
    <BasicLayout />
    <!--    <router-view />   这个用于显示不同的页面，如果加上会出现两个页面-->
  </div>
</template>

<style>
#app {
}
</style>
<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
const store = useStore();

router.beforeEach((to, from, next) => {
  // 仅管理员可访问，判断当前用户是否有管理员权限
  if (to.meta?.access === "canAdmin") {
    if (store.state.user.loginUser?.role !== "admin") {
      next({ path: "/noAuth" });
      return;
    }
  }
  next();
});
</script>
