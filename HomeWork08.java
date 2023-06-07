public class HomeWork08{
	public static void main(String[] args) {
		int [] arr = new int[10];
		int n1 = 0;
		int sum =0;
		for(int i = 0; i < arr.length; i++ ) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		for(int j=0; j <arr.length-1;j++) {
		for(int i=0; i <arr.length-1-j; i++) {
			if(arr[i] <arr[i+1]) {
				n1= arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=n1;
			}
		}
		}
		for(int i=0; i <10; i++) {
			System.out.print(arr[i]+" ");
			sum += arr[i];
		}
		System.out.println();
		System.out.println("平均值是"+sum/10);
		System.out.println("最大值是"+arr[0]);
		System.out.println("最大值下标是"+0);
	}
}