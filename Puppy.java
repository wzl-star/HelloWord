public class Puppy {                                              //公开的类Puppy
	int puppyAge;                                                 //定义整数型成员变量puppyAge
	public Puppy(String name) {                                   //定义puppy类的方法
		System.out.println("小狗的名字是"+name);               //打印输出小狗的名字是+变量puppy的参数
	}
	
	public void setAge(int age) {                                 //定义setAge的方法
		puppyAge=age;                                 //将setAge的方法的参数age的值赋予给puppyAge
	}
	
	public int getAge() {                                         //定义getAge的方法
		System.out.println("小狗年龄"+puppyAge);        //打印输出小狗年龄+变量puppyAge（即age的值）         
		return puppyAge;                              //返回puppyage的值
	}
	public static void main(String[] arges) {         //主方法入口
		Puppy mypuppy = new Puppy("tommy");           //Puppy类中实例化mypuppy=新的Puppy类的参数
		mypuppy.setAge(2);                            //访问实例变量mypuppy的setAge的方法并赋值
		mypuppy.getAge();                             //访问实例变量mypuppy的getAge的方法
		System.out.println("变量值"+mypuppy.puppyAge);  //打印输出变量值+实例变量mypuppy下的puppyAge
	}
}