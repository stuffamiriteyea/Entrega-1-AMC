package classes;

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
	
	public double energia(double[] v, double[] h) {				
		return (-produto(a,v) - produto(b,h) - produto(ProdutoMatriz(w, v),h));			
	}
		
	//- Implementar um m�todo que calcule o produto interno de dois vetores dados:
	public double produto( double [] vec1, double [] vec2 ) {
	    int linha = vec1.length;  
	    double r = 0;
	    for(int i = 0; i < linha; i++) 
	        r += vec1[i] * vec2[i];
	    return r;    	
		}
		
		//- Implementar um m�todo que calcule o produto interno de uma vetores dados:
	public double[] ProdutoMatriz(double[][] matriz, double[] vetor) {
	    int linha = matriz.length;
	    int coluna = matriz[0].length;

	    double[] r = new double[linha];

	    for (int i = 0; i <= linha; i++) {
	        double sum = 0;
	        for (int j = 0; j <= coluna; j++) {
	            sum += matriz[i][j]* vetor[j];
	        }
	        r[i] = sum;
	    }
	    return r;
	}


	public static int decompor(double [] x, double [] d) {
		x = 
		while (x != 0) {
			For (int j= 0; j < x.length; j++) {
				x[j]= x % d;			
			}
		}
	}

}

