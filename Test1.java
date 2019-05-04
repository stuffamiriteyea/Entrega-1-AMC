package classes;

import java.util.Arrays;

public class Test1 {
	
	public static void main(String[] args) throws Exception{
		
		Sample B = new Sample();
		int Z[]= {1 , 2, 3, 0, 5};
		int Y[]= {0 , 2, 1, 0, 4};
		int X[]= {1 , 0, 3, 1, 3};
		int z[]= {0,2,4};
		int y[]= {1,3,3};
		int x[]= {1,3,2};
		
		B.add(Z);
		B.add(Y);
		B.add(X);
		
		System.out.println(B);
		System.out.println(Arrays.toString(B.element(1)));
		System.out.println(Arrays.toString(B.domain()));
		
		System.out.println(B.count(z, y));
		System.out.println(B.count(z, x));
		
		double[] a = {1.0, 0.0};
		double[] b = {1.0, 0.0};
		
		double[] v = {0.0,1.0};
		double[] h = {1.0,1.0};
		
		double[][] w = {{1.0,0.0}, {1.0,0.0}};
		
		Bmachine Nova = new Bmachine( B.domain(), a, b, w);
		
		System.out.println(Nova.produto(v,h));
		System.out.println( Arrays.toString( Nova.getA() ) );
		Nova.setA(b);
		System.out.println( Arrays.toString( Nova.getA() ) );
		
		int ind1 = 47;
		System.out.println(Arrays.toString( Nova.DecomporV(ind1) ));
		int ind2 = 2;
		System.out.println(Arrays.toString( Nova.DecomporH(ind2) ));	
		
		System.out.println(Nova.prob(v, h));
		System.out.println(Nova.probm(v));
		System.out.println(Nova.energy(v, h));
		System.out.println(Nova.constantZ());
		
		double[] va = {1.0,2.0,3.0,4.0}; 
		System.out.println(Nova.classify(va));
		
	}
}
