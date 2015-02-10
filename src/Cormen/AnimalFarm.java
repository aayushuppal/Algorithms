package Cormen;

import java.util.*;

public class AnimalFarm{
	static int o = 0;
	public static void main(String[] args){
		AnimalFarm pobj = new AnimalFarm();
		Animal[] anims = new Animal[10];
		
		for(int i=0;i<10;i++){
			if(i%2==0){
				anims[i] = pobj.new Dog();
			}
			else{
				anims[i] = pobj.new Cat();
				}
		}
		
		AnimalShelter as = pobj.new AnimalShelter();
		for (Animal x:anims){
			as.enqueueAnimal(x);
			}

		System.out.println(as.dequeueAnimal().order);
		System.out.println(as.dequeueCat().order);
		System.out.println("debug point");
	}
	
	public class Animal{
		String type;
		int order;
		Animal(){
			order = o;
			o++;
		}
		
		public boolean isOlderThan(Animal a){
			if (this.order < a.order){
				return true;
			}
			else return false;
		}
		
	}
	
	public class AnimalShelter{
		Queue<Dog> dogs = new LinkedList<Dog>();
		Queue<Cat> cats = new LinkedList<Cat>();
		
		public void enqueueAnimal(Animal a){
			if(a instanceof Dog){
				dogs.add((Dog) a);
			} else if(a instanceof Cat){
				cats.add((Cat) a);
			}
		}
		
		public Dog dequeueDog(){
			return dogs.poll();
		}
		public Cat dequeueCat(){
			return cats.poll();
		}
		
		public Animal dequeueAnimal(){
			if(cats.peek().order < dogs.peek().order){
				return cats.poll();
			} else {
				return dogs.poll();
			}
		}
	}
	public class Dog extends Animal{
		Dog(){
			super();
			type = "Dog";
		}
	}
	
	public class Cat extends Animal{
		Cat(){
			super();
			type = "Cat";
		}
	}
	
}

