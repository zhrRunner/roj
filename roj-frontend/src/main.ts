import { createApp } from "vue";
import App from "./App.vue";
import ArcoVue from "@arco-design/web-vue";
import "@arco-design/web-vue/dist/arco.css";
import router from "./router";
import store from "./store";
import "@/plugins/axios";
import "@/access/index"; // 引入之后就可以使用权限控制了
import "bytemd/dist/index.css"; // 引入编辑器样式

createApp(App).use(ArcoVue).use(store).use(router).mount("#app");
