package JUnitTest;

public class Calculator {
	public double sum(double n1, double n2) {
		return n1+n2;
	}
public static void main(String[] args) {
	Calculator c = new Calculator();
	
	double res = c.sum(10, 20);
	if(res != 30) {
		System.err.println("err :" + res);
	}
	double res2 = c.sum(1.1, 2);
	if(res2 != 3.1) {
		System.err.println("err : " + res2);
	}
	double res3 = c.sum(1.1, -2);
		if(res3 != -0.9 ) {
			System.err.println("err : " + res3);
	}
}
}