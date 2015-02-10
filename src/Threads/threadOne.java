package Threads;
import java.util.*;

public class threadOne implements Runnable{
	String name;
	int time;
	Random r = new Random();
	
	threadOne(String a){
		this.name = a;
		time = r.nextInt(999);
	}
	
	public void run(){
		try{
			System.out.printf("%s and %d\n",name,time);
			Thread.sleep(time);
			System.out.printf("%s done\n",name);
		} catch (Exception e){
			
		}
	}
	
	public static void main(String[] args){
		Thread t1 = new Thread(new threadOne("one"));
		Thread t2 = new Thread(new threadOne("two"));
		Thread t3 = new Thread(new threadOne("three"));
		Thread t4 = new Thread(new threadOne("four"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
