package com.friendlyp;

import java.util.*;

public class FriendlyPerson {
    private String name; //姓名

    private Set friend; //此人的朋友

    /**
     * 构造函数
     * */
    public FriendlyPerson() {
        this.name = "";
    }

    /**
     * 构造函数
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
     * 打印列表
     * */
    public void printArrayList(){
        List<Float> arrayList = new ArrayList<>();
        arrayList.add((float)1.0);
        arrayList.add((float)2.0);

        //遍历方法1
        System.out.println("\n遍历方法1");
        Iterator iterator = arrayList.iterator();
        for(;iterator.hasNext();){
            System.out.print(iterator.next() + ", ");
        }

        //遍历方法2
        System.out.println("\n遍历方法2");
        for(Float data:arrayList){
            System.out.print(data + ", ");
        }

        //遍历方法3（随机访问法，使用索引，这种最快）
        System.out.println("\n遍历方法3");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + ", ");
        }
    }


}
