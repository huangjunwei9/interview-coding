package com.recommend;

/**
 * @Author 黄军威
 * @create 2019/8/31 21:56
 * @email hjunwei@foxmail.com
 */
import java.util.ArrayList;
import java.util.List;

public class UserSet {

    //用户列表
    public List<User> userArrayList = new ArrayList<>();

    /** 构造函数 */
    public UserSet() {
    }

    /** 新建一个用户 */
    public User newOneUser(String userRealName) {
        return new User(userRealName);
    }

    /** 获取第position个用户 */
    public User getUserByPosition(int position) {
        return userArrayList.get(position);
    }

    /** 根据用户名获取User对象 */
    public User getUserByUsername(String username) {
        for (User user : userArrayList) {
            if (user.userRealName.equals(username)) {
                return user;
            }
        }
        return null;
    }


    /** 用户。存储用户的姓名userRealName、用户看过的电影列表ArrayList */
    public final class User {
        //该用户的姓名
        public String userRealName;

        //该用户看过的电影List集合
        public List<Movie> movieArrayList = new ArrayList<>();

        /** 构造函数 */
        private User(String userRealName) {
            this.userRealName = userRealName;
        }

        /** 往该用户感兴趣的电影List集合中添加电影（电影名 + 评分） */
        public User addMovie(String movieName, int score) {
            this.movieArrayList.add(new Movie(movieName, score));
            return this;
        }

        /** 把当前用户User对象 加入到UserSet对象 的用户集合userArrayList中 */
        public void addUserToUserSet() {
            userArrayList.add(this);
        }

        /** 根据电影名找到Movie对象 */
        public Movie findMovieByMovieNameOfMovie(String movieName) {
            for (Movie movie : movieArrayList) {
                if (movie.movieName.equals(movieName)) {
                    return movie;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "User{" +
                    "movieName='" + userRealName + '\'' +
                    '}';
        }
    }


    /** 电影。存储电影名（唯一）、电影评分 */
    public final class Movie implements Comparable<Movie> {
        public String movieName; //电影名
        public int movieScore;   //电影评分

        /** 构造函数（电影名 + 评分） */
        public Movie(String movieName, int movieScore) {
            this.movieName = movieName;
            this.movieScore = movieScore;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "movieName='" + movieName + '\'' +
                    ", movieScore=" + movieScore +
                    '}';
        }

        @Override
        public int compareTo(Movie o) {
            return movieScore > o.movieScore ? -1 : 1;//如果当前电影评分大于对象o的电影评分，则返回-1，否则返回1
        }
    }

}










