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
	
<<<<<<< HEAD
	@Override
	public String toString() {
		return "[" + b + ", " + a + ", " + w + "]";
		}
	
		public double energy(double[] v, double[] h) {				
			return (-produto(a,v) - produto(b,h) - produto(ProdutoMatriz(w, v),h));			
		}
		
		//- Implementar um m�todo que calcule o produto interno de dois vetores dados:
		public static double produto( double [] vec1, double [] vec2 ) {
=======
	
		public double[] energy(double [] d, double [] b) {
			
			
			
			return ;
		}
		
		//- Implementar um m�todo que calcule o produto interno de dois vetores dados:
		public static double prduto( double [] vec1, double [] vec2 ) {
>>>>>>> 04ef041f2948996f59ad0e64fff246f0ce324029
		    int row = vec1.length;  
		    double r=0;
		    for(int i=0; i<=row; i++) 
		        r+=vec1[i]*vec2[i];
		    return r;    
		
		}
		
		//- Implementar um m�todo que calcule o produto interno de uma vetores dados:
		public static double[] ProdutoMatriz(double[][] matriz, double[] vetor) {
		    int linha = matriz.length;
		    int coluna= matriz[0].length;
<<<<<<< HEAD

		    double[] r = new double[linha];

=======

		    double[] r = new double[linha];

>>>>>>> 04ef041f2948996f59ad0e64fff246f0ce324029
		    for (int i = 0; i <= linha; i++) {
		        double sum = 0;
		        for (int j = 0; j <= coluna; j++) {
		            sum += matriz[i][j]* vetor[j];
		        }
		        r[i] = sum;
		    }
		    return r;
		}
<<<<<<< HEAD
		
=======

		//- Implementar um m�todo que calcule a matriz transposta de uma matriz dada:
		public int[][] matrizTransposta(int[][] matriz){
			for(int linha=0;linha<matriz.length;linha++){
				for(int coluna=0;coluna<matriz[linha].length;coluna++){
					if(coluna>linha)
						matriz[linha][coluna]=matriz[coluna][linha];
				}
			}
			return matriz;
		}
>>>>>>> 04ef041f2948996f59ad0e64fff246f0ce324029
}

