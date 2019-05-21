package classes;
import java.util.Arrays;
import classes.Inicializacao;

public class TestCD {
	
	public static void main(String[] args) {
		Sample S = new Sample();
		
		double[] v = {1,2,3};
		double[] h = {1.0, 0.0, 1.0, 0.0, 0.0};
		
		for(int i=0; i<2; i++)
			S.add(v);
		double[] v1 = {0,2,3};
		S.add(v1);
		
		GBMachine G = Inicializacao.init(S,5);
		
		ContrastiveDivergence cd = new ContrastiveDivergence(G,S);
		
		/*System.out.println("Unif:");
		System.out.println(cd.unif());
		System.out.println();
		
		System.out.println("Matriz W:");
		for(int i = 0; i < cd.gbm.getB().length; i++) {
			for(int j = 0; j < cd.gbm.getB().length; j++)
				System.out.print("  " + cd.gbm.getW()[i][j]);
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Probh com j = 2:");
		System.out.println(cd.probh(2,v));
		System.out.println();
		
		System.out.println("Algoritmo 1:");
		System.out.println(Arrays.toString(cd.alg1(v)));
		System.out.println();
		
		System.out.println("Gradiente de v por h:");
		for(int i = 0; i < cd.gbm.getB().length; i++) {
			for(int j = 0; j < cd.gbm.getB().length; j++)
				System.out.print("  "+cd.grad(v,h)[i][j]);
			System.out.println();
		}
		System.out.println();
		
		double[] a = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
		System.out.println("a:");
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		cd.gbm.setA(a);
		System.out.println("Pesquisa em a com i = 0 e j = 0:");
		System.out.println(cd.pesquisaa(cd.gbm.getA(), 0, 0));
		System.out.println();
		
		double[][] w = {{0.1, 0.2, 0.3},
						{0.4, 0.5, 0.6},
						
						{0.7, 0.8, 0.9},
						{0.11, 0.21, 0.31},
						{0.41, 0.51, 0.61},
						
						{0.71, 0.81, 0.91},
						{0.12, 0.22, 0.32},
						{0.22, 0.32, 0.42},
						{0.52, 0.62, 0.72}};
		
		System.out.println("Nova matriz W:");
		for(int i = 0; i < w.length; i++) {
			for(int j = 0; j < w[0].length; j++)
				System.out.print("  " + w[i][j]);
			System.out.println();
		}
		System.out.println();
		
		cd.gbm.setW(w);
		
		System.out.println("pesquisa em W com k = 3 i =2 e j = 1:");
		System.out.println(cd.pesquisaw(cd.gbm.getW(), 3, 2, 1));
		System.out.println();*/
		
		System.out.println(Arrays.toString(cd.gbm.getD() ) );
		System.out.println();
		

		System.out.println("a:");
		System.out.println(Arrays.toString(cd.gbm.getA()));
		System.out.println();
		
		System.out.println("Matriz W:");
		for(int i = 0; i < cd.gbm.getA().length; i++) {
			for(int j = 0; j < cd.gbm.getB().length; j++)
				System.out.print("  " + cd.gbm.getW()[i][j]);
			System.out.println();
		}
		System.out.println();
		
		System.out.println("probv com h, k = 0, i = 0:");
		System.out.println(cd.probv(h, 0, 0));
		System.out.println();
		
		System.out.println("Algoritmo 2:");
		System.out.println(Arrays.toString(cd.alg2(h)));
		System.out.println();
		
	}
}
