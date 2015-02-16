package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class KevinBacon {
	
	static int baconNumber = Integer.MAX_VALUE;
	
	HashSet<Actor> AllActors = new HashSet<Actor>();
	
	public static void main(String[] args) {
	KevinBacon network = new KevinBacon();
	Actor K = network.new Actor("K");
	Actor A1 = network.new Actor("A1");
	Actor A2 = network.new Actor("A2");
	Actor A3 = network.new Actor("A3");
	Actor A4 = network.new Actor("A4");
	Actor A5 = network.new Actor("A5");
	
	network.connect(K, A1);
	network.connect(K, A3);
	network.connect(A2, A1);
	network.connect(A2, A4);
	network.connect(A2, A3);
	network.connect(A4, A5);
	network.connect(A5, A3);
	
	
	
	System.out.println(ModifiedBFS(A1, K));
	}
	
	public class Actor{
		String name;
		Actor link;
		HashSet<Actor> adj = new HashSet<Actor>(); 
		Actor(String a){
			this.name = a;
		}
	}
	
	
	public void connect(Actor a, Actor b){
		if(!AllActors.contains(a)){
			AllActors.add(a);
		}
		if(!AllActors.contains(b)){
			AllActors.add(b);
		}
		a.link = b;
		b.link = a;
		a.adj.add(b);
		b.adj.add(a);
	}

	public static int BaconNumber(KevinBacon network, Actor A, Actor K){	
		return 0;
	}
	
	public static void Dijkstra(KevinBacon network,Actor A){
		HashSet<Actor> Visited = new HashSet<Actor>();
		HashSet<Actor> UnVisited = network.AllActors;
		HashMap<Actor,Integer> DMap = new HashMap<Actor,Integer>();
		
		for(Actor x:network.AllActors){
			if(x == A){
				DMap.put(x, 0);
				VisitUnVisit(x,Visited, UnVisited);
			}
			if (x == A.link){
				DMap.put(x, 1);
			}
			DMap.put(x, Integer.MAX_VALUE);
		}
		
		while(!UnVisited.isEmpty()){
			
		}
		
	}
	
	public static void VisitUnVisit(Actor A, HashSet<Actor> Visited, HashSet<Actor> UnVisited){
		Visited.add(A);
		UnVisited.remove(A);
	}
	
	public static int ModifiedBFS(Actor A, Actor K){
		HashMap<Actor,Integer> Traved = new HashMap<Actor,Integer>();
		System.out.println(A.name);
		Traved.put(A,0);
		Queue<Actor> qe = new LinkedList<Actor>();

		for (Actor x:A.adj){
			if(x == K){
				return 1;
			}
			System.out.println(x.name);
			Traved.put(x,Traved.get(A)+1);
			qe.add(x);
		}
		
		while(!qe.isEmpty()){
			Actor z = qe.remove();
			for(Actor x:z.adj){
				if (!Traved.containsKey(x)){
					if(x == K && Traved.get(z)+1 < baconNumber ){
						baconNumber = Traved.get(z)+1;
					}
					System.out.println(x.name);
					Traved.put(x,Traved.get(z)+1);
					qe.add(x);
				}
			}
		}
		
		return baconNumber;
	}

}
