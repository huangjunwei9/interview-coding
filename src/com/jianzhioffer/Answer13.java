package com.jianzhioffer;

/**   1 2 3 4 5 6 7 8 9   -----> 1 3 5 7 9   2 4 6 8
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * */
public class Answer13 implements  AnswerBase {
    /**   1 2 3 4 5 6 7 8 9   -----> 1 3 5 7 9   2 4 6 8
     * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
     * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
     * */
    public static void main(String [] args){
        Answer13 answer13 = new Answer13();
        answer13.printMain();
    }

    /**
     * ����answer����ں���
     */
    @Override
    public void printMain() {
        int [] array = {1,2,3,5,6,7};
        System.out.println(reOrderArray(array));
    }

    /** ð�ݷ�
     * 1.�����ǰ����������ǰһ����ż�����򽻻�λ��
     * 2.���򲻱�
     * @param array
     * @return
     */
    private int [] reOrderArray(int[] array) {
        int i = 0;
        int j = 0;
        int temp = 0;
        if(array.length == 0){
            System.out.println("����Ϊ�գ��������ȷ��ʽ��int����");
            return array;
        }
        for(i=0; i<array.length; i++){
            for(j = array.length-1; j>i; j--){
                if( ((array[j] & 1) ==1) && ((array[j-1] & 1) == 0)){//ǰż���棬����
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
}
