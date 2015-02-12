package String;

public class MyStringBuffer {
	private char[] base;
	private int capacity;
	private int entryPoint;
	
	MyStringBuffer(){
		capacity = 16;
		base = new char[capacity];
		entryPoint = 0;
	}
	
	public static void main(String[] args) {
		MyStringBuffer sb = new MyStringBuffer();
		sb.append("asdf");
		sb.append("qwer");
		sb.append("zxcv");
		sb.append("yuiopghjkl");
		System.out.println(sb.retString());
	}
	
	public void append(String a){
		if (a.length()+entryPoint <= capacity){
			for(int i=0;i<a.length();i++){
				base[entryPoint+i] = a.charAt(i);
			}
			entryPoint += a.length();
		}
		else {
			capacity = a.length()+entryPoint<2*capacity ? 2*capacity:a.length()+entryPoint;
			char[] temp = new char[capacity];
			for(int i=0;i<entryPoint;i++){
				temp[i] = base[i]; 
			}
			base = temp;
			for(int i=0;i<a.length();i++){
				base[entryPoint+i] = a.charAt(i);
			}
			entryPoint += a.length();
		}
	}
	
	public String retString(){
		return new String(base,0,entryPoint);
	}
}
