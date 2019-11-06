package com.thread.bank;

public class Bank implements Runnable{
	int money;//�������ܹ�ӵ�е�Ǯ
	int moneyAccountant;//����յ���Ǯ

	Thread accountant;//���
	Thread cashier;//����
	
	public Bank() {
		accountant = new Thread(this);//�����߳�
		cashier = new Thread(this);
	}
	
	/**����Ǯ������*/
	public void moneyset(int moneyIn){
		money  = moneyIn;
	}
	
	/**���߳̽��뵽cpu����*/
	public void run(){
		Thread t = Thread.currentThread();
		if(t == accountant){
			accountant = t;
			t.setName("���");
			addMoney(300);//ͬ�����Ƶ���Ǯ����
		}
		if(t == cashier){
			cashier = t;
			t.setName("����");
			addMoney(150);
		}
		System.out.println(t.getName()+"�߳�ִ���ѽ�����\n");
	}
	
	/**Ϊ������Ǯ �ķ���������Ҫ���ơ����������߳�����ͬ������*/
	public synchronized void addMoney(int amount){

		//���Ա ��Ϣʽ ��Ǯ
		if(Thread.currentThread() == accountant){
			for(int i = 1; i<=3; i++){
				money = money + amount/3;
				System.out.print("("+ i + "). " + Thread.currentThread().getName() + "Ŀǰ����" + amount*i/3 + "Ԫ��........");
				try{
					Thread.sleep(4000);//�ó�CPUʹ��Ȩ����2000���룬���ǲ��ͷ�ͬ����
				}
				catch(InterruptedException e){
					System.out.println(Thread.currentThread().getName() + "��ʼ��˯2000����\n");
					if(Thread.currentThread().isInterrupted() == true){
						System.out.println(Thread.currentThread().getName() + "���ڳ�˯");
					}
					else{
						System.out.println(Thread.currentThread().getName() + "��ǰ������˯");
					}
				}
				System.out.println(Thread.currentThread().getName() + "������˯" + i);
			}
			
		}
		
		//����Ա ��Ϣʽ ��Ǯ
		if(Thread.currentThread() == cashier){
			for(int i = 1; i<=3; i++){
				money = money - amount/3;
				System.out.print("(" + i + ")." + Thread.currentThread().getName() + "Ŀǰ����" + amount*i/3 + "Ԫ��........");
				try{
					Thread.sleep(4000);//�ó�CPUʹ��Ȩ����2000���룬���ǲ��ͷ�ͬ����
				}
				catch(InterruptedException e){
					System.out.println("��ʼ��˯2000����\n");
					if(Thread.currentThread().isInterrupted() == true){
						System.out.println(Thread.currentThread().getName() + "���ڳ�˯");
					}
					else{
						System.out.println(Thread.currentThread().getName() + "��ǰ������˯");
					}
				}
				System.out.println(Thread.currentThread().getName() + "������˯" + i);
			}
		}	
		
		System.out.println("��Ǯ�ɹ���Ŀǰ���������Ϊ��" + money + "Ԫ��");
		
	} 

}















