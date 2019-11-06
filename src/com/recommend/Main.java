package com.recommend;

/**
 * @Author 黄军威
 * @create 2019/8/31 21:58
 * @email hjunwei@foxmail.com
 */

import java.util.*;


/**
 * 假设有7个人像向你分别推荐了电影，
 * 你是其中的小明，你自己也看过一些电影，
 * 你自己看过的不想看，只想看没有看过的，且推荐度高，评分高的电影，示例数据如下：
 * */
public class Main {

    public static void main(String[] args) {

        //输入用户集合，Movie
        UserSet userSet = new UserSet();
        userSet.newOneUser("小明")
                .addMovie("中国合伙人", 50)
                .addMovie("太平轮", 30)
                .addMovie("荒野猎人", 45)
                .addMovie("老炮儿", 50)
                .addMovie("我的少女时代", 30)
                .addMovie("肖洛特烦恼", 45)
                .addMovie("火星救援", 50)
                .addUserToUserSet();

        userSet.newOneUser("小红")
                .addMovie("小时代4", 40)
                .addMovie("荒野猎人", 30)
                .addMovie("我的少女时代", 50)
                .addMovie("肖洛特烦恼", 50)
                .addMovie("火星救援", 30)
                .addMovie("后会无期", 30)
                .addUserToUserSet();


        userSet.newOneUser("小阳")
                .addMovie("小时代4", 20)
                .addMovie("中国合伙人", 50)
                .addMovie("我的少女时代", 30)
                .addMovie("老炮儿", 50)
                .addMovie("肖洛特烦恼", 45)
                .addMovie("速度与激情7", 50)
                .addUserToUserSet();

        userSet.newOneUser("小四")
                .addMovie("小时代4", 50)
                .addMovie("中国合伙人", 30)
                .addMovie("我的少女时代", 40)
                .addMovie("匆匆那年", 40)
                .addMovie("速度与激情7", 35)
                .addMovie("火星救援", 35)
                .addMovie("后会无期", 45)
                .addUserToUserSet();

        userSet.newOneUser("六爷")
                .addMovie("小时代4", 20)
                .addMovie("中国合伙人", 40)
                .addMovie("荒野猎人", 45)
                .addMovie("老炮儿", 50)
                .addMovie("我的少女时代", 20)
                .addUserToUserSet();

        userSet.newOneUser("小李")
                .addMovie("荒野猎人", 50)
                .addMovie("盗梦空间", 50)
                .addMovie("我的少女时代", 30)
                .addMovie("速度与激情7", 50)
                .addMovie("蚁人", 45)
                .addMovie("老炮儿", 40)
                .addMovie("后会无期", 35)
                .addUserToUserSet();

        userSet.newOneUser("隔壁老王")
                .addMovie("荒野猎人", 50)
                .addMovie("中国合伙人", 40)
                .addMovie("我的少女时代", 10)
                .addMovie("Phoenix", 50)
                .addMovie("甄嬛传", 40)
                .addMovie("The Strokes", 50)
                .addUserToUserSet();

        userSet.newOneUser("邻村小芳")
                .addMovie("小时代4", 40)
                .addMovie("我的少女时代", 45)
                .addMovie("匆匆那年", 45)
                .addMovie("甄嬛传", 25)
                .addMovie("The Strokes", 30)
                .addUserToUserSet();


        /*
         * 假设有7个人(你的朋友)向你分别推荐了电影，
         * 你是其中的小明，你自己也看过一些电影，
         * 电影推荐条件：过滤掉自己看过的电影，保留推荐度高或评分高的电影
         * */
        Recommend recommend = new Recommend();


        //返回朋友们为“小明”推荐的电影列表
        List<UserSet.Movie> recommendMovies = recommend.recommend("小明", userSet);
        System.out.println("-----------------------");
        for (UserSet.Movie movie : recommendMovies) {
            System.out.println("电影名：" + movie.movieName +"，评分："+ movie.movieScore + "；");
        }
    }


}

/* 备份测试数据
 {
 "小明":{
     "中国合伙人":5,
     "太平轮":3,
     "荒野猎人":4.5,
     "老炮儿":5,
     "我的少女时代":3,
     "肖洛特烦恼":4.5,
     "火星救援":5
 },
 "小红":{
     "小时代4":4,
     "荒野猎人":3,
     "我的少女时代":5,
     "肖洛特烦恼":5,
     "火星救援":3,
     "后会无期":3
 },
 "小阳":{
     "小时代4":2,
     "中国合伙人":5,
     "我的少女时代":3,
     "老炮儿":5,
     "肖洛特烦恼":4.5,
     "速度与激情7":5
 },
 "小四":{
     "小时代4":5,
     "中国合伙人":3,
     "我的少女时代":4,
     "匆匆那年":4,
     "速度与激情7":3.5,
     "火星救援":3.5,
     "后会无期":4.5
 },
 "六爷":{
     "小时代4":2,
     "中国合伙人":4,
     "荒野猎人":4.5,
     "老炮儿":5,
     "我的少女时代":2
 },
 "小李":{
     "荒野猎人":5,
     "盗梦空间":5,
     "我的少女时代":3,
     "速度与激情7":5,
     "蚁人":4.5,
     "老炮儿":4,
     "后会无期":3.5
 },
 "隔壁老王":{
     "荒野猎人":5,
     "中国合伙人":4,
     "我的少女时代":1,
     "Phoenix":5,
     "甄嬛传":4,
     "The Strokes":5
 },
 "邻村小芳":{
     "小时代4":4,
     "我的少女时代":4.5,
     "匆匆那年":4.5,
     "甄嬛传":2.5,
     "The Strokes":3
 }
 }

 * */
