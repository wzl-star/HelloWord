public class HomeWork05{
	public static void main(String[] args) {
		//原来的总钱
		double money =100000;
		//通过的次数
		int num = 0;
		while(money >= 1000) {
			if(money > 50000) {
			money *= 0.95;
			num++;
			}else if(money <= 50000) {
				money -= 1000;
				num++;
			}
		}
		System.out.println("通过的次数"+num);
	}
}