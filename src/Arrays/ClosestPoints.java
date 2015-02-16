package Arrays;

import java.util.*;

public class ClosestPoints {

	public static void main(String[] args){
		
		
	Collection<Point> Points = new ArrayList<Point>();
	Point origin = new Point(0,0);
	Points.add(new Point(1,2,origin));
	Points.add(new Point(-1,2,origin));
	Points.add(new Point(1,-2,origin));
	Points.add(new Point(-1,3,origin));
	Points.add(new Point(2,2,origin));
	Points.add(new Point(-1,-1,origin));
	Points.add(new Point(4,2,origin));
	Points.add(new Point(-1,-2,origin));
	Points.add(new Point(3,2,origin));
	Points.add(new Point(1,1,origin));
	
	Collection<Point> closestPoints = new ClosestPoints().getClosestPoints(Points, 2);
	System.out.println(closestPoints);
	}
	
	public Collection<Point> getClosestPoints(Collection<Point> Points, int k){
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k);
		
		/* nlogn approach
		for (Point x:Points){
			pq.offer(x);
		}
		for(int i=0; i<10-k;i++){
			pq.poll();
		}
		*/
		
		for (Point x:Points){
			if(pq.size() < k){
				pq.offer(x);
			}
			else{ 								 // tradition implementation of compareTo minheap, swap it maxheap
				if (pq.peek().compareTo(x) < 0){ // here we have swapped meaning of compareTo variables so careful
					pq.poll();					 // nlogk approach
					pq.offer(x);
				}
			}
		}
		
		return pq;
	}
	
}

class Point implements Comparable<Point>{
	int x,y;
	double dist;
	
	Point(int x, int y, Point origin){
		this.x = x;
		this.y = y;
		this.dist = Math.hypot(x-origin.x, y-origin.y );
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Point p){
		return Double.valueOf(p.dist).compareTo(this.dist);
	}
	
	public String toString(){
		return "("+this.x+","+this.y+")";
	}
}