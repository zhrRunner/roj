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
import ACCESS_ENUM from "@/access/accessEnum";
import { onMounted } from "vue";

const router = useRouter();
const store = useStore();

/**
 * 全局初始化， 有全局单词调用的代码，都可以写到这里
 */
const doInit = () => {
  console.log("hello welcome to ROJ");
};

onMounted(() => {
  doInit();
});

router.beforeEach((to, from, next) => {
  // 仅管理员可访问，判断当前用户是否有管理员权限
  if (to.meta?.access === ACCESS_ENUM.ADMIN) {
    if (store.state.user.loginUser?.userRole !== ACCESS_ENUM.ADMI) {
      next("/noAuth");
      return;
    }
  }
  next();
});
</script>
