package JavaAbstract;

public class GoodCalc extends Calculator {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	@Override
	public double average(int[] a) {
		double sum = 0;
		double ave = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
			ave = (double) sum / a.length;
		}
		return ave;
	}
	
	public static void main(String[] args) {
		GoodCalc gc = new GoodCalc();
		System.out.println(gc.add(10, 20));
		System.out.println(gc.subtract(20, 10));
		System.out.println(gc.average(new int[] {11, 23, 35}));
	}

}
