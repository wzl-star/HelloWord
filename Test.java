public class Test{
	public static void main(String[] args) {
		int a=10;
		int b=20;
		int c=25;
	    int d=30;
	    System.out.println("a+b的值="+(a+b));
	    System.out.println("a-b的值="+(a-b));
	    System.out.println("a*b的值="+(a*b));
	    System.out.println("b/a的值="+(b/a));
	    System.out.println("b%a的值="+(b%a));
	    System.out.println("a++的值="+(a++));            // a++的值是10，a的值是11
	    System.out.println("a--的值="+(a--));            // a--的值是11，a的值是10
	    System.out.println("++a的值="+(++a));            // ++a的值是11，a的值是11
	    System.out.println("--a的值="+(--a));            // --a的值是10，a的值是10
	    System.out.println("d++的值="+(d++));            // d++的值是30，d的值是31
	    System.out.println("d--的值="+(d--));            // d--的值是31，d的值是30
	    System.out.println("++d的值="+(++d));            // ++d的值是31，d的值是31
	    System.out.println("--d的值="+(--d));            // --d的值是30，d的值是30
	}
}