import java.util.Scanner;
public class ArrayReduce{
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n1[] = {1 , 2 , 3 , 4 , 5};
		do{
			int n2[] = new int [n1.length - 1];
			for(int i = 0; i < n1.length-1; i++) {
				n2[i] = n1[i];
			}
			n1 = n2;
			for(int i = 0; i < n1.length; i++) {
				System.out.println(n1[i] + "\t");
			}
			if(n1.length <= 1) {
				System.out.println("退出程序");
				break;
			} 
			System.out.println("请输入是否缩减");
			char key = myScanner.next().charAt(0);
			if(key == 'y'){
			break;
			}
		}while(true);
}
}