public class HomeWork09{
	public static void main(String[] args) {
	A01 a01 = new A01();
	double [] arr = {10.0 ,12.5,13.4};
	System.out.println(a01.max(arr));
	A02 a02 = new A02();
	String [] strs = {"tom", "mary"};
	int index =a02.find("hsp",strs);
	System.out.println(index);
	}
}
class A01{
	public double max(double[] arr) {
		double max = arr[0];
		for (int i=0; i<arr.length;i++) {
			if(max < arr[i]) {
				max= arr[i];
			}
		}
		return max;
	}
}
class A02{
	public int find(String findStr, String[] strs) {
		for(int i=0; i<strs.length; i++) {
			if(findStr.equals(strs[i])) {
				return i;
			}
		}
		return -1;
	}
}
class Book{
	String name;
	double price;
	public Book(String name,double price) {
		this.name = name;
		this.price = price;
	}
	public void updatePrice() {
		if(this.price >150) {
			this.price = 150;
		}else if(this.price >100) {
			this.price = 100;
		}
	}
}