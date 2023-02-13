import { createRouter, createWebHistory } from "vue-router";
import SignUp from "@/components/signup.vue";
import LogIn from "@/components/login.vue";
import RoadMap from "@/view/user/roadmap.vue";
import CourseView from "@/view/user/courseView.vue";
import UserHome from "@/view/user/userhome.vue";
import ChapterView from "@/view/user/chapterView.vue";
import RoadMapFactory from "@/view/admin/roadmapFactory.vue"
import AdminHome from "@/view/admin/adminHome.vue"
import FrqExamView from "@/view/exam/frqExamView.vue"
import FrqExamSubmitView from "@/view/exam/frqExamSubmitView.vue"
import ExamPurchaseView from "@/view/exam/examPurchaseView.vue"
import AdminUserView from "@/view/admin/adminUserView"
import UserPendingView from "@/view/user/userPendingView"
import McqExamView from "@/view/exam/mcqExamView"
import ChapterFrame from "@/view/user/chapterFrame"
import Store from "@/store"
// path: '/',
//     redirect: "/login",
//     component: LoginLayout,
const routes = [
  {
    path: "/",
    name: "Home",
    component: () => import("../view/home.vue"),
  },
  {
    path: "/mcqexamview/:examId",
    name: "McqExamView",
    component: McqExamView,
  }, 
  {
    path: "/frqexamview/:examId",
    name: "FrqExamView",
    component: FrqExamView,
  },
  {
    path: "/adminuserview",
    name: "AdminUserView",
    component: AdminUserView,
  },
  {
  path:"/chapterframe/:chapterId",
  name:"ChapterFrame",
  component:ChapterFrame,
  },
  {
    path: "/frqexamsubmitview/:examId",
    name: "FrqExamSubmitView",
    component: FrqExamSubmitView,
  },
  {
    path: "/adminhome",
    name: "AdminHome",
    component: AdminHome,
  },
  {
    path: "/userpendingview",
    name: "UserPendingView",
    component: UserPendingView,
  },
  {
    path: "/roadmapFactory/:userEmail",
    name: "RoadMapFactory",
    component: RoadMapFactory,
  },
  {
    path: "/roadmap",
    name: "RoadMap",
    component: RoadMap,
  },
  {
    path: "/chapterView/:courseId",
    name: "ChapterView",
    component: ChapterView,
  },
  {
    path: "/courseView",
    name: "CourseView",
    component: CourseView,
  },
  {
    path: "/userhome",
    name: "UserHome",
    component: UserHome,
  },
  {
    path: "/signup",
    name: "SignUp",
    component: SignUp,
  },
  {
    path: "/login",
    name: "LogIn",
    component: LogIn,
  },
  {
    path: "/exampurchaseview/:examId",
    name: "ExamPurchaseView",
    component: ExamPurchaseView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  const isLoggedIn = Store.state.isLogin;
  const isRoadmapExist = Store.state.isRoadmap;

  if (to.path === "/login" && isLoggedIn) {
    next("/");
  }else if(to.path === "/userpendingview" && isRoadmapExist){
    next("/")
  }else {
    next();
  }

});

export default router;

