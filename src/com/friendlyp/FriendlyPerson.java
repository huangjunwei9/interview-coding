package com.friendlyp;

import java.util.*;

public class FriendlyPerson {
    private String name; //����

    private Set friend; //���˵�����

    /**
     * ���캯��
     * */
    public FriendlyPerson() {
        this.name = "";
    }

    /**
     * ���캯��
     * */
    public FriendlyPerson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set getFriend() {
        return friend;
    }

    public void setFriend(Set friend) {
        this.friend = friend;
    }

    public void printName(){
        System.out.print(name);
    }

    /**
     * ��ӡ�б�
     * */
    public void printArrayList(){
        List<Float> arrayList = new ArrayList<>();
        arrayList.add((float)1.0);
        arrayList.add((float)2.0);

        //��������1
        System.out.println("\n��������1");
        Iterator iterator = arrayList.iterator();
        for(;iterator.hasNext();){
            System.out.print(iterator.next() + ", ");
        }

        //��������2
        System.out.println("\n��������2");
        for(Float data:arrayList){
            System.out.print(data + ", ");
        }

        //��������3��������ʷ���ʹ��������������죩
        System.out.println("\n��������3");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + ", ");
        }
    }


}
