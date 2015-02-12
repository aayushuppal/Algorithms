package String;

public class RemoveWhitespaces {

	public static void main(String[] args) {
		String s = "abc def ghi";
		//s = s.replaceAll("\\s", "");
		
		StringBuilder sb = new StringBuilder();
		int initial = 0;
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '||i==s.length()-1){
				if(i==s.length()-1){sb.append(s.substring(initial, i+1));}
				else {	sb.append(s.substring(initial, i)); }
				initial = i+1;
			}
		}
		
		System.out.println(sb);
	}

}
