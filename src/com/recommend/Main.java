package com.recommend;

/**
 * @Author �ƾ���
 * @create 2019/8/31 21:58
 * @email hjunwei@foxmail.com
 */

import java.util.*;


/**
 * ������7����������ֱ��Ƽ��˵�Ӱ��
 * �������е�С�������Լ�Ҳ����һЩ��Ӱ��
 * ���Լ������Ĳ��뿴��ֻ�뿴û�п����ģ����Ƽ��ȸߣ����ָߵĵ�Ӱ��ʾ���������£�
 * */
public class Main {

    public static void main(String[] args) {

        //�����û����ϣ�Movie
        UserSet userSet = new UserSet();
        userSet.newOneUser("С��")
                .addMovie("�й��ϻ���", 50)
                .addMovie("̫ƽ��", 30)
                .addMovie("��Ұ����", 45)
                .addMovie("���ڶ�", 50)
                .addMovie("�ҵ���Ůʱ��", 30)
                .addMovie("Ф���ط���", 45)
                .addMovie("���Ǿ�Ԯ", 50)
                .addUserToUserSet();

        userSet.newOneUser("С��")
                .addMovie("Сʱ��4", 40)
                .addMovie("��Ұ����", 30)
                .addMovie("�ҵ���Ůʱ��", 50)
                .addMovie("Ф���ط���", 50)
                .addMovie("���Ǿ�Ԯ", 30)
                .addMovie("�������", 30)
                .addUserToUserSet();


        userSet.newOneUser("С��")
                .addMovie("Сʱ��4", 20)
                .addMovie("�й��ϻ���", 50)
                .addMovie("�ҵ���Ůʱ��", 30)
                .addMovie("���ڶ�", 50)
                .addMovie("Ф���ط���", 45)
                .addMovie("�ٶ��뼤��7", 50)
                .addUserToUserSet();

        userSet.newOneUser("С��")
                .addMovie("Сʱ��4", 50)
                .addMovie("�й��ϻ���", 30)
                .addMovie("�ҵ���Ůʱ��", 40)
                .addMovie("�Ҵ�����", 40)
                .addMovie("�ٶ��뼤��7", 35)
                .addMovie("���Ǿ�Ԯ", 35)
                .addMovie("�������", 45)
                .addUserToUserSet();

        userSet.newOneUser("��ү")
                .addMovie("Сʱ��4", 20)
                .addMovie("�й��ϻ���", 40)
                .addMovie("��Ұ����", 45)
                .addMovie("���ڶ�", 50)
                .addMovie("�ҵ���Ůʱ��", 20)
                .addUserToUserSet();

        userSet.newOneUser("С��")
                .addMovie("��Ұ����", 50)
                .addMovie("���οռ�", 50)
                .addMovie("�ҵ���Ůʱ��", 30)
                .addMovie("�ٶ��뼤��7", 50)
                .addMovie("����", 45)
                .addMovie("���ڶ�", 40)
                .addMovie("�������", 35)
                .addUserToUserSet();

        userSet.newOneUser("��������")
                .addMovie("��Ұ����", 50)
                .addMovie("�й��ϻ���", 40)
                .addMovie("�ҵ���Ůʱ��", 10)
                .addMovie("Phoenix", 50)
                .addMovie("��ִ�", 40)
                .addMovie("The Strokes", 50)
                .addUserToUserSet();

        userSet.newOneUser("�ڴ�С��")
                .addMovie("Сʱ��4", 40)
                .addMovie("�ҵ���Ůʱ��", 45)
                .addMovie("�Ҵ�����", 45)
                .addMovie("��ִ�", 25)
                .addMovie("The Strokes", 30)
                .addUserToUserSet();


        /*
         * ������7����(�������)����ֱ��Ƽ��˵�Ӱ��
         * �������е�С�������Լ�Ҳ����һЩ��Ӱ��
         * ��Ӱ�Ƽ����������˵��Լ������ĵ�Ӱ�������Ƽ��ȸ߻����ָߵĵ�Ӱ
         * */
        Recommend recommend = new Recommend();


        //����������Ϊ��С�����Ƽ��ĵ�Ӱ�б�
        List<UserSet.Movie> recommendMovies = recommend.recommend("С��", userSet);
        System.out.println("-----------------------");
        for (UserSet.Movie movie : recommendMovies) {
            System.out.println("��Ӱ����" + movie.movieName +"�����֣�"+ movie.movieScore + "��");
        }
    }


}

/* ���ݲ�������
 {
 "С��":{
     "�й��ϻ���":5,
     "̫ƽ��":3,
     "��Ұ����":4.5,
     "���ڶ�":5,
     "�ҵ���Ůʱ��":3,
     "Ф���ط���":4.5,
     "���Ǿ�Ԯ":5
 },
 "С��":{
     "Сʱ��4":4,
     "��Ұ����":3,
     "�ҵ���Ůʱ��":5,
     "Ф���ط���":5,
     "���Ǿ�Ԯ":3,
     "�������":3
 },
 "С��":{
     "Сʱ��4":2,
     "�й��ϻ���":5,
     "�ҵ���Ůʱ��":3,
     "���ڶ�":5,
     "Ф���ط���":4.5,
     "�ٶ��뼤��7":5
 },
 "С��":{
     "Сʱ��4":5,
     "�й��ϻ���":3,
     "�ҵ���Ůʱ��":4,
     "�Ҵ�����":4,
     "�ٶ��뼤��7":3.5,
     "���Ǿ�Ԯ":3.5,
     "�������":4.5
 },
 "��ү":{
     "Сʱ��4":2,
     "�й��ϻ���":4,
     "��Ұ����":4.5,
     "���ڶ�":5,
     "�ҵ���Ůʱ��":2
 },
 "С��":{
     "��Ұ����":5,
     "���οռ�":5,
     "�ҵ���Ůʱ��":3,
     "�ٶ��뼤��7":5,
     "����":4.5,
     "���ڶ�":4,
     "�������":3.5
 },
 "��������":{
     "��Ұ����":5,
     "�й��ϻ���":4,
     "�ҵ���Ůʱ��":1,
     "Phoenix":5,
     "��ִ�":4,
     "The Strokes":5
 },
 "�ڴ�С��":{
     "Сʱ��4":4,
     "�ҵ���Ůʱ��":4.5,
     "�Ҵ�����":4.5,
     "��ִ�":2.5,
     "The Strokes":3
 }
 }

 * */
