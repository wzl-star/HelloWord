public class HomeWork07{
	public static void main(String[] args) {
		int cost = 0;
		for(int i = 1; i < 100; i++) {
			if(i % 5 != 0) {
				cost++;
				System.out.print(+i+"\t ");
				if(cost % 5 == 0) {
					System.out.println();
				}
			}
		}
    }
}