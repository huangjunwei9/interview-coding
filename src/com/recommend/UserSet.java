package com.recommend;

/**
 * @Author �ƾ���
 * @create 2019/8/31 21:56
 * @email hjunwei@foxmail.com
 */
import java.util.ArrayList;
import java.util.List;

public class UserSet {

    //�û��б�
    public List<User> userArrayList = new ArrayList<>();

    /** ���캯�� */
    public UserSet() {
    }

    /** �½�һ���û� */
    public User newOneUser(String userRealName) {
        return new User(userRealName);
    }

    /** ��ȡ��position���û� */
    public User getUserByPosition(int position) {
        return userArrayList.get(position);
    }

    /** �����û�����ȡUser���� */
    public User getUserByUsername(String username) {
        for (User user : userArrayList) {
            if (user.userRealName.equals(username)) {
                return user;
            }
        }
        return null;
    }


    /** �û����洢�û�������userRealName���û������ĵ�Ӱ�б�ArrayList */
    public final class User {
        //���û�������
        public String userRealName;

        //���û������ĵ�ӰList����
        public List<Movie> movieArrayList = new ArrayList<>();

        /** ���캯�� */
        private User(String userRealName) {
            this.userRealName = userRealName;
        }

        /** �����û�����Ȥ�ĵ�ӰList��������ӵ�Ӱ����Ӱ�� + ���֣� */
        public User addMovie(String movieName, int score) {
            this.movieArrayList.add(new Movie(movieName, score));
            return this;
        }

        /** �ѵ�ǰ�û�User���� ���뵽UserSet���� ���û�����userArrayList�� */
        public void addUserToUserSet() {
            userArrayList.add(this);
        }

        /** ���ݵ�Ӱ���ҵ�Movie���� */
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


    /** ��Ӱ���洢��Ӱ����Ψһ������Ӱ���� */
    public final class Movie implements Comparable<Movie> {
        public String movieName; //��Ӱ��
        public int movieScore;   //��Ӱ����

        /** ���캯������Ӱ�� + ���֣� */
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
            return movieScore > o.movieScore ? -1 : 1;//�����ǰ��Ӱ���ִ��ڶ���o�ĵ�Ӱ���֣��򷵻�-1�����򷵻�1
        }
    }

}










