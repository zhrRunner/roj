<template>
  <div id="basicLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <GlobalHeader />
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        <div>
          <p>
            &copy; <span id="year">2024</span> &nbsp;
            <a href="https://zhr.wiki" target="_blank"> ORJ by zouhr </a>
          </p>
        </div>
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#basicLayout {
}

#basicLayout .header {
  margin-bottom: 16px;
  box-shadow: #eee 1px 1px 5px;
}

#basicLayout .content {
  background-color: rgba(50, 50, 50, 0.1);
  margin-bottom: 16px;
  padding: 20px;
  border-radius: 8px; /* 可选：让边角变圆滑 */
}

#basicLayout .footer {
  //background: #efefef;
  padding: 16px;
  position: relative; /* 可选：让底部固定在页面底部 */
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
  overflow: visible;
}
</style>
<script setup lang="ts">
import GlobalHeader from "@/components/GlobalHeader.vue";
</script>
