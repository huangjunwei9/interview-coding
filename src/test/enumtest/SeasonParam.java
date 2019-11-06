package test.enumtest;

/**
 * @Author 黄军威
 * @create 2019/9/30 16:15
 * @email hjunwei@foxmail.com
 */
public class SeasonParam{
    public static void main(String[] args) {
        //直接初始化
        SeasonEnum season1 = SeasonEnum.SPRING;
        //调用SeasonEnum枚举类的getChinese()方法获取SPRING的中文值
        System.out.println(season1.getChinese());
    }
}


enum SeasonEnum {
    //枚举类的实例对象，必须在最前面先定义，而且必须每个实例对象都必须维护上成员变量以实例化
    SPRING("春天"),
    SUMMER("夏天", "summer"),
    AUMUTN("秋天", "autumn"),
    WINTER("冬天", "winter"),
    ALLSEASON("全部季节");

    //成员变量
    private String chinese;
    private String english;

    //枚举类型的构造函数，默认为private，因为枚举类型的初始化要在当前枚举类中完成。
    SeasonEnum (String chinese){
        this.chinese= chinese;
    }

    SeasonEnum (String chinese, String english){
        this.chinese= chinese;
        this.english= english;
    }

    //获取中文名称
    public String getChinese(){
        return chinese;
    }

    //获取英文名称
    public String getEnglish(){
        return english;
    }
}


