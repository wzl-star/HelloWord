public class dowhile{                                       //公共的类dowhile
	public static void main(String[] args) {                //类中主方法
		int x=10;                                           //定义10赋值给x
		do {                                                // do循环开头
			System.out.println("x的值是"+x);                 // 打印出"x的值是"+x
			x++;                                           // x自增
			System.out.println("\n");                      // 换行
		}while(x<20);                                      // 当x的值小于20里面，就一直在do中循环
	}                                                       // 当X的值大于等于20时，就停止do中循环
}