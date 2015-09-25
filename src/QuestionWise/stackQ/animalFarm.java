public abstract class Animal {
	String id;
	int timeStamp;
	
	Animal(String n){
		id = n;
	}
	
	void setTimeStamp(int x) {
		n = x;
	}
	
	boolean isOlder(Animal x){
		return this.timeStamp < x.timeStamp;
	}
}


class Dog extends Animal {
	Dog(String id){
		super(id);
	}
}


class Cat extends Animal {
	Cat(String id){
		super(id);
	}
}

public class AnimalFarm {
	List<Dog> dogList = new LinkedList<Dog>();
	List<Cat> catList = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueueAny(Animal a){
		a.setTimeStamp(order);
		order++;
		
		if (a instanceOf Dog) {
			dogList.addLast((Dog)a);
		} else if (a instanceOf Cat){
			catList.addLast((Cat)a);
		}
	}
	
	public Animal dequeueAny(){
		Dog dog = dogList.peek();
		Cat cat = catList.peek();
		
		if (dog.isOlder(Cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	
	public Dog dequeueDog(){
		return dogList.poll();
	}
	
	public Cat dequeueCat() {
		return catList.poll();
	}
}