/**功能：会计员和出纳员，拥有同一个账本，他俩同时可以对账本进行访问，为银行打入收到的钱。这里使用synchronized同步机制防止两个线程同时访问账本。
 *（1）、会计员线程在账本上存300元的过程：分三次存入，每次存入100元，每存入一次都休息4000毫秒。
 *（2）、出纳员线程在账本上取150元的过程：分三次取出，每次取出50元，  每存入一次都休息4000毫秒。
 * 注意：当其中一个人操作账本时，不允许另一人使用账本。
 * **/

package com.thread.bank;

public class MainClass {

	/**构造函数**/
	public MainClass() {
		
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.moneyset(0);
		bank.accountant.start();
		bank.cashier.start();


	}

}
