# ROJ在线刷题网站项目笔记

## 一、项目前期准备

### 核心业务流程

<img src="https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202412061513348.png" style="zoom:50%;" />

<img src="https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202412061514515.png" alt="image-20241206151435442" style="zoom:50%;" />

### 技术选型

前端：

​		Vue3、Arco Design 组件库、手撸项目模板、在线代码编辑器、在线文档浏览

后端：

​		SSM、Java 进程控制、Java 安全管理器、部分 JVM 知识点

​		虚拟机（云服务器）、Docker（代码沙箱实现）

​		Spring Cloud 微服务 、消息队列

### 架构设计

<img src="/Users/hrz/Library/Application Support/typora-user-images/image-20241206152400951.png" alt="image-20241206152400951" style="zoom:50%;" />

### 环境选择

系统环境

​	mac OS Sequoia  15.0.1

前端

​	NodeJS  v18.16.0

​	npm  9.5.1

​	@vue/cli 5.0.8



## 二、环境搭建

### 前端环境搭建

在终端根目录*/Users/hrz*下

```bash
vue create roj-frontend
```

按照如下配置即可

![image-20241206160115032](https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202412061601073.png)

---

在WebStorm中打开项目

尝试运行项目

![image-20241206160710834](https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202412061607941.png)

在浏览器中看到如下页面说明配置成功：

<img src="https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202412061610966.png" alt="image-20241206161014860" style="zoom: 25%;" />

此时，我们在webstorm里使用格式化快捷键 option + command + L是会报错的，需要进行如下设置：

<img src="https://zhr-blog.oss-cn-beijing.aliyuncs.com/blog/202412061614860.png" alt="image-20241206161424805" style="zoom:33%;" />

再次使用快捷键发现不会报错

----

引入组件库 

我们使用字节旗下的arco design中的vue组件库 [arco design vue](https://arco.design/vue/docs/start)

在终端中执行即可

```bash
npm install --save-dev @arco-design/web-vue
```

修改main.ts文件 进行组件的完整引入

```ts
import { createApp } from "vue";
import App from "./App.vue";
import ArcoVue from "@arco-design/web-vue";
import "@arco-design/web-vue/dist/arco.css";
import router from "./router";
import store from "./store";

createApp(App).use(ArcoVue).use(store).use(router).mount("#app");

```



已经观看到2.16
