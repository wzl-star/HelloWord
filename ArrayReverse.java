public class ArrayReverse{
	public static void main(String[] args) {
		int [] arr = {11, 22, 33, 44, 55, 66};
		int n1 = 0;
		for(int i =0; i < arr.length/2; i++) {
			n1 = arr[i];
			arr[i] =arr[arr.length-1-i];
			arr[arr.length-1-i] = n1;
		}
		for(int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}