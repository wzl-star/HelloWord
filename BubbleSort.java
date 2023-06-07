public class BubbleSort{
	public static void main(String[] args) {
		int [] n1 = {24, 69, 80, 57, 13};
		int n2 =0;
		for(int j =0; j < n1.length-1; j++) {
		for(int i =0; i < n1.length-j-1; i++) {
			if(n1[i] > n1[i+1]) {
				n2 = n1[i];
				n1[i] = n1[i+1];
				n1[i+1]= n2;
			}
		}
	}
	 for(int f =0; f < n1.length; f++) {
		System.out.println(n1[f]);
	}
}
}