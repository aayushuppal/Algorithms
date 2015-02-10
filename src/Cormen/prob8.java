package Cormen;
public class prob8 {

	
	public static void main(String[] args) {
	String a = "yellow";
	String b = "llowye";
	a = a.concat(a);
	if(a.contains(b)){ System.out.println("b is a rotation of a"); }
	else{ System.out.println("not a rotation"); }
	}

}
