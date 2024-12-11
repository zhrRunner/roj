<template>
  <div id="app">
    <!--    通过路由判断当前页面是否是用户页面-->
    <template v-if="route.path.startsWith('/user')">
      <router-view />
    </template>
    <template v-else>
      <BasicLayout />
    </template>
  </div>
</template>

<style>
#app {
}
</style>
<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import { onMounted } from "vue";
import { useRoute } from "vue-router";

const route = useRoute();

/**
 * 全局初始化， 有全局单词调用的代码，都可以写到这里
 */
const doInit = () => {
  console.log("hello welcome to ROJ");
};

onMounted(() => {
  doInit();
});
</script>
