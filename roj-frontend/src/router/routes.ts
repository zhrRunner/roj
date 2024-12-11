import { RouteRecordRaw } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import CalendarView from "@/views/CalendaeView.vue";
import AdminView from "@/views/AdminView.vue";
import NoAuthView from "@/views/NoAuthView.vue";
import ACCESS_ENUM from "@/access/accessEnum";
import AboutView from "@/views/AboutView.vue";
import UserLayout from "@/layouts/UserLayout.vue";
import UserLoginView from "@/views/UserLoginView.vue";
import UserRegisterView from "@/views/UserRegisterView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "用户",
    component: UserLayout,
    meta: {
      hideInMenu: true,
    },
    children: [
      {
        path: "/user/login",
        name: "用户登录",
        component: UserLoginView,
      },
      {
        path: "/user/register",
        name: "用户注册",
        component: UserRegisterView,
      },
    ],
  },
  {
    path: "/",
    name: "浏览题目",
    component: HomeView,
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/hide",
    name: "隐藏页面",
    component: HomeView,
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
      hideInMenu: true,
    },
  },
  {
    path: "/noAuth",
    name: "无权限页面",
    component: NoAuthView,
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/admin",
    name: "管理员页面",
    component: AdminView,
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/about",
    name: "关于我",
    component: AboutView,
    meta: {
      access: ACCESS_ENUM.NOT_LOGIN,
    },
  },
  {
    path: "/calendar",
    name: "calendar",
    component: CalendarView,
  },
];
