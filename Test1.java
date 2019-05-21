package classes;

import java.util.Arrays;


public class Test1 {
	
	public static void main(String[] args) throws Exception{
		
		/*Sample B = new Sample();
		int Z[]= {1, 2, 3, 5, 0};
		int Y[]= {0, 2, 1, 4, 1};
		int X[]= {1, 0, 3, 3, 0};
		int z[]= {0,2,4};
		int y[]= {1,3,0};
		int x[]= {1,3,2};
		
		B.add(Z);
		B.add(Y);
		B.add(X);
		
		System.out.println("B = " + B);
		System.out.println("B.element(1) = " + Arrays.toString(B.element(1)));
		System.out.println("B.domain = " + Arrays.toString(B.domain()));
		
		System.out.println("B.count(z, y) = " + B.count(z, y));
		System.out.println("B.count(z, y) = " + B.count(z, x));*/
		
		
		
		
		
		
		
		int[] d = {9, 8, 7};
		double[] d1 = {9, 8, 7};
		int[] d2 = {3, 2, 3};
		double[] a = {6, 5, 4};
		double[] b = {3, 2, 1};
		
		
		double[] v = {1, 0, 2};
		double[] h = {1, 1, 0};
		
		double[][] w = {{1,2,3},{4,5,6},{7,8,9}};
		
		Bmachine Nova = new Bmachine(d, a, b, w);
		
		/*System.out.println(Nova.produto(v,h));
		System.out.println( Arrays.toString( Nova.getA() ) );
		Nova.setA(b);
		System.out.println( Arrays.toString( Nova.getA() ) );*/
		
		System.out.println("produto(d1,a) = "+Nova.produto(d1,a));
		System.out.println("ProdutoMatriz(w,d1) = "+ Arrays.toString(Nova.ProdutoMatriz(w,d1)));
		
		System.out.println("energy(d1, a) = " + Nova.energy(d1, a));
		
		Nova.setD(d2);
		
		System.out.println("DecomporV(5) = " + Arrays.toString(Nova.DecomporV(5)));
		/*System.out.println("DecomporH(4) = " +Arrays.toString(Nova.DecomporH(4)));*/
		
		System.out.println("constantZ = " + Nova.constantZ());
		
		double z = Nova.constantZ();
		
		System.out.println("prob(v, h) = " + Nova.prob(v, h, z));
		System.out.println("probm(v) = " + Nova.probm(v, z));
		
		GBMachine A = new GBMachine(d2, a, b, w);
		
		System.out.println("v traçado = " + Arrays.toString(A.vTransform(v)));
		
	}
}
