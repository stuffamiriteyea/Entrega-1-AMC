package classes;

import java.lang.Math;

public class Bmachine {
	private int[] d;
	private double [] a;
	private	double [] b;
	private	double [][] w;
	
	public Bmachine(int [] d, double [] a, double [] b, double [][] w) {
			super();
			this.d = d;
			this.a = a;
			this.b = b;
			this.w = w;
		}
	
	
	
	public int[] getD() {
		return d;
	}

	public void setD(int[] d) {
		this.d = d;
	}

	public double[] getA() {
		return a;
	}

	public void setA(double[] a) {
		this.a = a;
	}

	public double[] getB() {
		return b;
	}

	public void setB(double[] b) {
		this.b = b;
	}

	public double[][] getw() {
		return w;
	}

	public void setW(double[][] w) {
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "[" + b + ", " + a + ", " + w + "]";
		}
	
	public double energia(double[] v, double[] h) {				
		return (-produto(a,v) - produto(b,h) - produto(ProdutoMatriz(w, v),h));			
		}
		
		//- Implementar um m�todo que calcule o produto interno de dois vetores dados:
	public double produto( double [] vec1, double [] vec2 ) {
		   int linha = vec1.length;  
		   double r=0;
		   for(int i=0; i< linha; i++) 
		        r+=vec1[i]*vec2[i];
		   return r;    
		
		}
		
		//- Implementar um m�todo que calcule o produto interno de uma vetores dados:
	public double[] ProdutoMatriz(double[][] matriz, double[] vetor) {
		    int linha = matriz.length;
		    int coluna= matriz[0].length;

		    double[] r = new double[linha];

		    for (int i = 0; i < linha; i++) {
		        double sum = 0;
		        for (int j = 0; j < coluna; j++) {
		            sum += matriz[i][j]* vetor[j];}
		        r[i] = sum;
		        }
		    return r; 
		    }

		
	public double[] DecomporV(int i) throws Exception {
			int n = d.length;
			double[] r = new double[n];
			
			double prod = d[0];
			for (int j = 1; j < n;j++)
				prod *= d[j];
			if (i < 0 || i >= prod)
				throw new Error("valor de i impossível");
				
			for(int j = 1; j <= n; j++) {
				r[n-j] = i % d[n-j];
				i /= d[n-j];
			}
			return r;
		}
	
	public double[] DecomporH (int i) throws Exception{
			int n = b.length;
			double[] r = new double[n];
		
			double prod = 2;
			for (int j = 1; j < n;j++)
				prod *= 2;
			if (i < 0 || i >= prod)
				throw new Error("valor de i impossível");
			
			for(int j = 1; j <= n; j++) {
				r[n-j] = i % 2;
				i /= 2;
			}
			return r;
		}
	
	public double ConstZ () throws Exception {
			
		double prod = d[0];
		double Z = 0;
		
		for (int i = 1; i < d.length;i++)
			prod *= d[i];
		for(int i = 0; i < prod; i++) {
			for(int j = 0; j < Math.pow(2, b.length); j++) {
				Z += Math.exp(- energia( DecomporV(i), DecomporH(j)) );
			}
		}
		return Z;
	}
	
		public void Update(double [] Aa, double [] Bb, double [][] Ww) {
			setA(Aa);
			setB(Bb);
			setW(Ww);
		}
}
				
		

