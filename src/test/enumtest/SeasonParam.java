package test.enumtest;

/**
 * @Author �ƾ���
 * @create 2019/9/30 16:15
 * @email hjunwei@foxmail.com
 */
public class SeasonParam{
    public static void main(String[] args) {
        //ֱ�ӳ�ʼ��
        SeasonEnum season1 = SeasonEnum.SPRING;
        //����SeasonEnumö�����getChinese()������ȡSPRING������ֵ
        System.out.println(season1.getChinese());
    }
}


enum SeasonEnum {
    //ö�����ʵ�����󣬱�������ǰ���ȶ��壬���ұ���ÿ��ʵ�����󶼱���ά���ϳ�Ա������ʵ����
    SPRING("����"),
    SUMMER("����", "summer"),
    AUMUTN("����", "autumn"),
    WINTER("����", "winter"),
    ALLSEASON("ȫ������");

    //��Ա����
    private String chinese;
    private String english;

    //ö�����͵Ĺ��캯����Ĭ��Ϊprivate����Ϊö�����͵ĳ�ʼ��Ҫ�ڵ�ǰö��������ɡ�
    SeasonEnum (String chinese){
        this.chinese= chinese;
    }

    SeasonEnum (String chinese, String english){
        this.chinese= chinese;
        this.english= english;
    }

    //��ȡ��������
    public String getChinese(){
        return chinese;
    }

    //��ȡӢ������
    public String getEnglish(){
        return english;
    }
}


