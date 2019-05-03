package classes;

import java.util.Arrays;

public class Test {
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		double[] d = {1.0,0.0,1.0};
		double[] a = {2.0,3.0,1.0};
		double[] b = {1.0,0.0,1.0};
		double[] v = {1.0,0.0,1.0};
		double[] h = {1.0,0.0,1.0};
		double[][] w = {{1.0,0.0,1.0}, {1.0,0.0,1.0}};
		Bmachine Nova = new Bmachine(d, a, b, w);
		System.out.println(Nova.produto(v,h));
		System.out.println( Arrays.toString( Nova.getA() ) );
		Nova.setA(b);
		System.out.println( Arrays.toString( Nova.getA() ) );
	}
}
