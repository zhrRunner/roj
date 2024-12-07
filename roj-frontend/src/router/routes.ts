import { RouteRecordRaw } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import ClendarView from "@/views/ClendarView.vue";
import AdminView from "@/views/AdminView.vue";
import NoAuthView from "@/views/NoAuthView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "浏览题目",
    component: HomeView,
  },
  {
    path: "/noAuth",
    name: "无权限页面",
    component: NoAuthView,
  },
  {
    path: "/admin",
    name: "管理员页面",
    component: AdminView,
    meta: {
      aceess: "canAdmin",
    },
  },
  {
    path: "/about",
    name: "关于我",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/clendar",
    name: "clendar",
    component: ClendarView,
  },
];
