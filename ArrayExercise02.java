public class ArrayExercise02{
	public static void main(String[] args) {
		int [] n1 = {4, -1, 9, 10, 23};
		int n2 = 0;
		for(int i = 0; i < 5; i++) {
			if(n1[i] > n2) {
				n2 = n1[i];
			}
		}
		System.out.println(n2);
	}
}