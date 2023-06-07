import java.util.Scanner;
public class HomeWork06{
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入数字");
		int num = myScanner.nextInt();
		if(num>0) {
			System.out.println("该数字大于0");
		}else if (num<0) {
			System.out.println("该数字小于0");
		}else{
		System.out.println("该数字等于0");
		}
	}
}


