<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <a-space>
          <img src="../assets/logo.png" class="logo" />
          <div class="name">ROJ</div>
        </a-space>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        <a href="https://zhr.wiki" target="_blank"> zhr's blog by zouhr </a>
        <a-link @click="handleClick">用户协议</a-link>
        <a-modal
          v-model:visible="visible"
          @ok="handleOk"
          @cancel="handleCancel"
          okText="同意"
          cancelText="不同意"
        >
          <template #title> ROJ用户协议 </template>
          <div>现在占个坑，开发中...</div>
        </a-modal>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#userLayout {
  text-align: center;
  background: url("https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202408201057226.jpeg")
    0% 0% / cover;
}

#userLayout .header {
  margin-top: 16px;
  margin-bottom: 16px;
}

#userLayout .name {
  font-size: 24px;
  color: #fff;
  font-weight: bold;
  margin-left: 10px;
}

#userLayout .content {
  margin-bottom: 16px;
  padding: 20px;
}

#userLayout .footer {
  padding: 16px;
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}

#userLayout .logo {
  width: 64px;
  height: 64px;
}
</style>
<script setup lang="ts">
import { ref } from "vue";

const visible = ref(false);

const handleClick = () => {
  visible.value = true;
};

const handleOk = () => {
  visible.value = false;
};

const handleCancel = () => {
  visible.value = false;
};
</script>
