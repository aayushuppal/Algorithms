package pastAmaz;

public class ClockAngle {

	public static void main(String[] args) {
		String input ="3:30";
		String[] S= input.split(":");
		int[] I = new int[S.length];
		int i=0;
		for(String x:S){
			I[i]=Integer.parseInt(x);
			i++;
		}
		int AngleOfHour = I[0]*5*6; 
		int AngleOfMin = I[1]*6;
		System.out.println(AngleOfMin-AngleOfHour);
	}

}
