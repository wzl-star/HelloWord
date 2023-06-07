public class ArrayExercise01{
	public static void main(String[] args) {
		char[]n1 = new char[26];
		for(int i = 0; i < n1.length; i++ ) {
			n1[i] = (char)('A'+ i);
			System.out.println(n1[i]);
		}
	}
}