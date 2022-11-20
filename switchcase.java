public class switchcase{
	public static void main(String[] args) {
		char x='d';                            //定义字符X的类型char,并将d值赋予x
		switch(x) {                            //switch方法中调用x
		case 'a':                              //当符合a情况就输出下面打印
		System.out.println("优秀");
		break;                                 //从这里跳出switch语法
		case 'b':
		case 'c':                              //当符合b、c情况就输出下面打印
		System.out.println("良好");
		break;                                 //从这里跳出switch语法
		case 'd':                              //当符合d情况就输出下面打印
		System.out.println("及格");
		break;                                 //从这里跳出switch语法
		default:                               //当上述情况都不符合就输出下面打印
		System.out.println("未知等级");
		}
		System.out.println("等级是"+x);          //主方法的输出打印，不受switch影响
	}
}