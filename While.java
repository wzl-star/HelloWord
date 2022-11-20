public class While{
	public static void main(String[] args) {
		int a=20;
		while(a<30) {                            //里面必须是布尔表达式
			System.out.println("a的值是"+a);
			a++;                                 //更新式
			System.out.println("\n");	
		}
	}
}