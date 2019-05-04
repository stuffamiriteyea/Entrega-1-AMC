package classes;

import java.lang.Math;


public class Bmachine {
	private double[] d;
	private double [] a;
	private	double [] b;
	private	double [][] w;
	
	public Bmachine(double [] d, double [] a, double [] b, double [][] w) {
			super();
			this.d = d;
			this.a = a;
			this.b = b;
			this.w = w;
		}
	
	public double[] getD() {
		return d;
	}

	public void setD(double[] d) {
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
	
	public double energy(double[] v, double[] h) {				
		return (-produto(a,v) - produto(b,h) - produto(ProdutoMatriz(w, v),h));			
		}
		
		//- Implementar um método que calcule o produto interno de dois vetores dados:
	public double produto( double [] vec1, double [] vec2 ) {
		   int linha = vec1.length;  
		   double r=0;
		   for(int i=0; i< linha; i++) 
		        r+=vec1[i]*vec2[i];
		   return r;    
		
		}
		
		//- Implementar um método que calcule o produto interno de uma vetores dados:
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
	
	public double[] DecomporV(double [] d, int i) {
		int n = d.length;
		double[] r = new double[n];
		
		//double prod = d[0];
		//for (int j=1; j<n;j++)
		//	prod *= d[j];
		//if (i < 0 || i > prod)
		//	EXIT
			
		for(int j = 1; j <= n; j++) {
			r[n-j] = i % d[n-j];
			i /= d[n-j];
		}
		return r;
	}
	
	public double[] DecomporH (int i) {
		int n = b.length;
		double[] r = new double[n];
	
		//double prod = d[0];
		//for (int j=1; j<n;j++)
		//	prod *= 2;
		//if (i < 0 || i > prod)
		//	EXIT
		
		for(int j = 1; j <= n; j++) {
			r[n-j] = i % 2;
			i /= 2;
		}
		return r;
	}
	
	public double constantZ() { //está a devolver 1, apenas para as outras funções funcionarem
		return 1;
	}
	
	public double prob(double [] v, double[] h) {
		return (1/constantZ())*(Math.exp(-energy(v,h)));
	}
	
	public double probm(double[]v) {
		double r=0;
		for (int i=0; i<Math.pow(2, b.length); i++) {
			double h[]=DecomporH(i);
			r+=prob(v,h);
		}
		return r;
	}
	
	public int classify(double[]v) {
		double vaux []= new double [v.length+1];
		for (int i=0; i<v.length; i++) 
			vaux[i]=v[i];
		double p=0;
		int c=0;
		for (int j=0;j<d[-1]; j++) {
			vaux[-1]=j;
			double paux=probm(vaux);
			if (paux>p) {
				p=paux;
				c=j;
			}
		
		}
		return c;
	}

	
	public void Update(double [] Aa, double [] Bb, double [][] Ww) {
		setA(Aa);
		setB(Bb);
		setW(Ww);
	}

}
