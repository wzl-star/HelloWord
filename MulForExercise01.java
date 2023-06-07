import java.util.Scanner;
public class MulForExercise01{
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		double sum = 0;
		for(int i = 1; i <= 3; i++) {
			double totoal = 0;
			int num1 = 0;
			for(int j = 1; j <= 5; j++) {
				System.out.println("请输入第"+i+"班第"+j+"个学生的成绩");
				double score = myScanner.nextDouble();
				if(score >= 60) {
					System.out.println("恭喜你及格了");
					num1++;
				}
				totoal += score;
				System.out.println("这是第"+i+"班的及格人数为"+num1);
			}
			    System.out.println("这是第"+i+"班的平均为"+totoal/5); 
			    sum += totoal;
		}       
		         System.out.println("这是所有班的平均成绩"+sum/15);
	}
}