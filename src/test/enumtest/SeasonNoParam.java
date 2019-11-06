package test.enumtest;

import java.sql.SQLOutput;

/**
 * @Author 黄军威
 * @create 2019/9/30 16:31
 * @email hjunwei@foxmail.com
 */
public class SeasonNoParam {
    public static void main(String[] args) {
        SeasonEnum2 season1 = SeasonEnum2.SPRING;

        SeasonEnum2 season2 = SeasonEnum2.valueOf("WINTER");

        switch (season1){
            case SPRING:
                System.out.println("SPRING");
                break;
            case SUMMER:
                System.out.println("SUMMER");
                break;
            case AUTUMN:
                System.out.println("AUTUMN");
                break;
        }


        switch (season2){
            case SPRING:
                System.out.println("SPRING");
                break;
            case SUMMER:
                System.out.println("SUMMER");
                break;
            case AUTUMN:
                System.out.println("AUTUMN");
                break;
            default :
                if(season2 == SeasonEnum2.WINTER){
                    System.out.println("WINTER");
                }else{
                    System.out.println("the season does not exist");
                }

        }


    }
}


/**
 *  枚举类的后缀建议为Enum，枚举类型的实例对象建议全大写（这样做符合JAVA的规范）
 */
enum SeasonEnum2{
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

}
