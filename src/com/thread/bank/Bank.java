package com.thread.bank;

public class Bank implements Runnable{
	int money;//该银行总共拥有的钱
	int moneyAccountant;//会计收到的钱

	Thread accountant;//会计
	Thread cashier;//出纳
	
	public Bank() {
		accountant = new Thread(this);//创建线程
		cashier = new Thread(this);
	}
	
	/**设置钱的数量*/
	public void moneyset(int moneyIn){
		money  = moneyIn;
	}
	
	/**让线程进入到cpu队列*/
	public void run(){
		Thread t = Thread.currentThread();
		if(t == accountant){
			accountant = t;
			t.setName("会计");
			addMoney(300);//同步机制的收钱方法
		}
		if(t == cashier){
			cashier = t;
			t.setName("出纳");
			addMoney(150);
		}
		System.out.println(t.getName()+"线程执行已结束！\n");
	}
	
	/**为银行收钱 的方法，方法要求会计、出纳两个线程满足同步机制*/
	public synchronized void addMoney(int amount){

		//会计员 休息式 收钱
		if(Thread.currentThread() == accountant){
			for(int i = 1; i<=3; i++){
				money = money + amount/3;
				System.out.print("("+ i + "). " + Thread.currentThread().getName() + "目前收了" + amount*i/3 + "元。........");
				try{
					Thread.sleep(4000);//让出CPU使用权至少2000毫秒，但是不释放同步锁
				}
				catch(InterruptedException e){
					System.out.println(Thread.currentThread().getName() + "开始沉睡2000毫秒\n");
					if(Thread.currentThread().isInterrupted() == true){
						System.out.println(Thread.currentThread().getName() + "正在沉睡");
					}
					else{
						System.out.println(Thread.currentThread().getName() + "提前结束沉睡");
					}
				}
				System.out.println(Thread.currentThread().getName() + "结束沉睡" + i);
			}
			
		}
		
		//出纳员 休息式 收钱
		if(Thread.currentThread() == cashier){
			for(int i = 1; i<=3; i++){
				money = money - amount/3;
				System.out.print("(" + i + ")." + Thread.currentThread().getName() + "目前收了" + amount*i/3 + "元。........");
				try{
					Thread.sleep(4000);//让出CPU使用权至少2000毫秒，但是不释放同步锁
				}
				catch(InterruptedException e){
					System.out.println("开始沉睡2000毫秒\n");
					if(Thread.currentThread().isInterrupted() == true){
						System.out.println(Thread.currentThread().getName() + "正在沉睡");
					}
					else{
						System.out.println(Thread.currentThread().getName() + "提前结束沉睡");
					}
				}
				System.out.println(Thread.currentThread().getName() + "结束沉睡" + i);
			}
		}	
		
		System.out.println("收钱成功！目前银行内余额为：" + money + "元。");
		
	} 

}















