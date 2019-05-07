package classes;

import java.lang.Math;

public class Bmachine {
	private int[] d;
	private double [] a;
	private	double [] b;
	private	double [][] w;
	
	//construtor da Bmachine com os atributos d, a, b, w
	public Bmachine(int [] d, double [] a, double [] b, double [][] w) {
			super();
			this.d = d;
			this.a = a;
			this.b = b;
			this.w = w;
		}
	
	//get e set para cada atributo da Bmachine
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

	public double[][] getW() {
		return w;
	}

	public void setW(double[][] w) {
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "[" + b + ", " + a + ", " + w + "]";
		}
	
	//para um vetor de variaveis visiveis e um de variaveis escondidas devolve a energia
	public double energy(double[] v, double[] h) {				
		return (-produto(a,v) - produto(b,h) - produto(ProdutoMatriz(w, h),v));			
		}
		
	//MÈtotodo que calcule o produto interno de dois vetores dados
	public double produto( double [] vec1, double [] vec2 ) {
		   int linha = vec1.length;  
		   double r=0;
		   for(int i=0; i< linha; i++) 
		        r+=vec1[i]*vec2[i];
		   return r;    
		
		}
		
	//MÈtodo que calcule o produto de um vetor e uma matriz dados
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

	//dado um indice i devolve o vetor v correspondente a esse Ìndice
	public double[] DecomporV(int i) throws Exception {
			int n = d.length;
			double[] r = new double[n];
			
			double prod = d[0];
			for (int j = 1; j < n;j++)
				prod *= d[j];
			if (i < 0 || i >= prod) {
				throw new Error("valor de i imposs√≠vel");
			}
			for(int j = 1; j <= n; j++) {
				r[n-j] = i % d[n-j];
				i /= d[n-j];
			}
			return r;
		}
	
	//dado um indice i devolve o vetor h correspondente a esse Ìndice
	public double[] DecomporH (int i) throws Exception{
			int n = b.length;
			double[] r = new double[n];
		
			double prod = 2;
			for (int j = 1; j < n;j++)
				prod *= 2;
			if (i < 0 || i >= prod)
				throw new Error("valor de i imposs√≠vel");
			
			for(int j = 1; j <= n; j++) {
				r[n-j] = i % 2;
				i /= 2;
			}
			return r;
		}
	
	//calculo da constante Z para uma dada Bmachine
	public double constantZ () throws Exception {
			
		double prod = d[0];
		double Z = 0;
		
		for (int k = 1; k < d.length;k++)
			prod *= d[k];
		for(int i = 0; i < prod; i++) {
			for(int j = 0; j < Math.pow(2, b.length); j++) {
				Z += Math.exp(- energy( DecomporV(i), DecomporH(j)) );
			}
		}
		return Z;
	}
	
	//calculo da probabilidade de obervar um vetor v dado um h
	public double prob(double [] v, double[] h) throws Exception{
		return (1/constantZ())*(Math.exp(-energy(v,h)));
	}
	
	//probabilidade marginal de observar um vetor v (soma de prob para todos h) 
	public double probm(double[]v) throws Exception{
		double r=0;
		for (int i=0; i<Math.pow(2, b.length); i++) {
			double h[]=DecomporH(i);
			r=r+prob(v,h);
		}
		return r;
	}
	
	//dado um vetor sem classe devolve a classe que apresenta maior probabilidade (probm) para esse vetor
	public int classify(double[]v) throws Exception{
		double vaux []= new double [v.length+1];
		for (int i=0; i<v.length; i++) 
			vaux[i]=v[i];
		double p=0;
		int c=0;
		for (int j=0;j<d[d.length-1]; j++) {
			vaux[vaux.length-1]=j;
			double paux=probm(vaux);
			if (paux>p) {
				p=paux;
				c=j;
			}
		
		}
		return c;
	}
	
	//dados novos a, b, w faz o apdate da Bmachine
	public void Update(double [] Aa, double [] Bb, double [][] Ww) {
		setA(Aa);
		setB(Bb);
		setW(Ww);
	}
}