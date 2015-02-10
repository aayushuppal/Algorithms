package Stacks;
import java.util.Scanner;
import java.util.Stack;

// 0-origin 1-destination 2-buffer

public class HanoiTower {
	static int count =0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("input hanoi tower input");
		int n = in.nextInt();
		in.close();
		HanoiTower pobj = new HanoiTower();
		Tower[] towers = new Tower[3];

		for(int i=0; i<3;i++){
			towers[i] = pobj.new Tower(i);
		}
		
		for (int i=n;i>=1;i--){
			towers[0].addDisc(i);
		}
		
		towers[0].moveDiscs(n,towers[0],towers[1],towers[2]);
		System.out.println("all discs shifted to destination");
		System.out.println("no. of steps taken = "+count);
	}
	
	public class Tower{
		Stack<Integer> discs = new Stack<Integer>();
		int index;
		Tower(int i){
			discs = new Stack<Integer>();
			index = i;
		}
		public void addDisc(int a){
			discs.push(a);
		}
		
		public Integer towerPop(){
			return discs.pop();
		}
		public void moveDiscs(int n, Tower towers_origin, Tower towers_destination, Tower towers_buffer){
			if(n>0){
				moveDiscs(n-1,towers_origin,towers_buffer,towers_destination);
				moveTopDisc(towers_origin,towers_destination);
				moveDiscs(n-1,towers_buffer,towers_destination,towers_origin);
			}
		}
		
		public void moveTopDisc(Tower towers_origin, Tower towers_destination){
			towers_destination.addDisc(towers_origin.towerPop());
			count++;
		} 
	}
	
}
