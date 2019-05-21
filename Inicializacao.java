package classes;

import java.util.Random;

public class Inicializacao {
	public static Sample S;
	public static int sum;
	public static int[] d;
	
	public static double F(double i, double k) {
		double [] veci = {i} ;  
		double [] veck = {k};
		double count = S.count(veci, veck);
		double length = S.length();
		double F = ( count / length );
		return F;
	}
	
	public static double[] novoA() {
		double [] A = new double[sum];
		int aux=0;
		
		for(int i = 0; i<d.length; i++) {
			for (int k=0; k<d[i]; k++) {
				for(int l=0; l<i; l++)
					aux+=d[l];
				aux+=k;
				
				
				if(F(i,k) == 1)
					A[aux] = 100;
				else if (F(i,k) == 0)
					A[aux] = -100;
				else
					A[aux] = Math.log( (F(i,k) / (1 - F(i,k)) ) );
				
				aux = 0;
			}
		}
		return A;
	}
	
	public static double []novoB(double b){
		double []B = new double [(int) b];
		for (int j=0; j < b; j++) {
				B[j]= 0;
		}
		return B;
	}
	
	public static double gaussW(double mean, double standdev) {	
		Random gauss = new Random();
		double g = mean+gauss.nextGaussian()*standdev;
			return g;		
	}
	
	//metodo que altera os limites da distribuicao uniforme para [-0.01; 0.01]
	public static double uniformW() {
		Random uniform = new Random();	
		double u = uniform.nextDouble();
		double x =(u * 0.02) - 0.01;
		return x;
	}
	
	public static double[][] novoWu(double b) {
		
		double [][]r = new double [sum][(int) b];
		
		for (int i=0; i < sum; i++) {
			for (int j=0; j < b; j++) {
				r[i][j] = uniformW();
			}
		}
		return r;		
		}
	
	public static double[][] novoWg(double b) {
		
		double mean = 0.0;
		double standdev = 0.01;
		
		double [][]r = new double [sum][(int) b];
		
		for (int i=0; i < sum; i++) {
			for (int j=0; j < b; j++) {
				r[i][j] = gaussW(mean, standdev);
			}
		}
		return r;
		
		}
	
	
	public static GBMachine init(Sample Samp, double b) {
		
		S = Samp;
		d = S.domain();
		for(int i = 0; i < d.length; i++)
			sum  += d[i];
		
		double[][] w1 = novoWu(b);
		//double[][] w2 = novoWg(b);
		double[] a = novoA();
		double[] bb = novoB(b);
		GBMachine G = new GBMachine(d, a, bb, w1);
		return G;
		
	}

}
