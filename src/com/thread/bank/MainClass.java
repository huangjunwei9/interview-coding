/**���ܣ����Ա�ͳ���Ա��ӵ��ͬһ���˱�������ͬʱ���Զ��˱����з��ʣ�Ϊ���д����յ���Ǯ������ʹ��synchronizedͬ�����Ʒ�ֹ�����߳�ͬʱ�����˱���
 *��1�������Ա�߳����˱��ϴ�300Ԫ�Ĺ��̣������δ��룬ÿ�δ���100Ԫ��ÿ����һ�ζ���Ϣ4000���롣
 *��2��������Ա�߳����˱���ȡ150Ԫ�Ĺ��̣�������ȡ����ÿ��ȡ��50Ԫ��  ÿ����һ�ζ���Ϣ4000���롣
 * ע�⣺������һ���˲����˱�ʱ����������һ��ʹ���˱���
 * **/

package com.thread.bank;

public class MainClass {

	/**���캯��**/
	public MainClass() {
		
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.moneyset(0);
		bank.accountant.start();
		bank.cashier.start();


	}

}
