package classes;

import java.util.Random;

public class ContrastiveDivergence {
	GBMachine gbm;
	Sample samp;
	
 	public ContrastiveDivergence (GBMachine G, Sample S) {
		this.gbm = G;
		this.samp = S;
	}
	
	public double unif() {
		Random unif = new Random();
		double u = unif.nextDouble();
			return u;
	}
			
	public double probh(int j, double[]v) {
		
		double s = 0;
		double[] vb = gbm.vTransform(v);
		
		for (int i=0; i<vb.length; i++)
			s += (gbm.getW()[i][j] * vb[i]);
		
		double x = (gbm.getB()[j] + s);
		
		return (Math.exp(x)) / (1+Math.exp(x)) ;
	}
	
	public double[] alg1(double[]v) {
		double[] h= new double[gbm.getB().length];
		for (int j=0; j<h.length; j++) {
			double p = probh(j,v);
			double u = unif();
			if (u < p)
				h[j]=1;
			else
				h[j]=0;
		}
		return h;
	}
		
	public double[][] grad(double []v, double []h) {
		double[]vb=gbm.vTransform(v);
		
		double [][] r = new double [vb.length][h.length];
		
		for (int i=0; i<vb.length; i++) {
			for(int j=0; j<h.length; j++)
				r[i][j] = vb[i]*h[j];
		}
		return r;
	}
	
	public double pesquisaa (double[] a, int j, int i) {
		int d=0;
		for (int k=0; k<i; k++)
			d=d+(gbm.getD())[k];
		return a[(j+d)];
	}
	
	public double pesquisaw (double [][]w, int k, int i, int j ) {
		int d=0;
		for (int g=0; g<i; g++) 
			d = (d + gbm.getD()[g]);
		return w[(k+d)][j];
	}
	
	public double probv(double[]h, int k, int i) {
		double nsum=0;
		
		for (int j=0; j<h.length; j++) {
			nsum += (pesquisaw ((gbm.getW()), k, i, j ) * h[j]);
		}
		
		double num = Math.exp( pesquisaa(gbm.getA(), k, i) + nsum);
		
		double den=0;
		
		for (int t=0; t<(gbm.getD())[i]; t++) {
			double dsum=0;
			
			for (int j=0; j<h.length; j++) {
				dsum += (pesquisaw ((gbm.getW()), t, i, j )*h[j]);
			}
			
			den += Math.exp(pesquisaa ((gbm.getA()), t, i)+dsum);
		}
		
		return (num/den);
	}
	
	public double[] alg2(double[]h) {
		double []v = new double[(gbm.getD()).length];
		
		for (int i=0; i<gbm.getD().length; i++) {
			
			double [] prob = new double[ (gbm.getD())[i] ];
			
			for (int k=0; k < gbm.getD()[i]; k++) {
				if (k==0)
					prob[k]=probv(h,k,i);
				else
					prob[k] = (prob[k-1] + probv(h,k,i));
			}
			
			double u = unif();
			
			int j = 0;
			
			while(j < prob.length) {
				if (prob[j]>u) {
					v[i] = j;
					j = prob.length;
			}
				else
					j++;
			}
		}
		return v;
	}
	
	
	public double [] sumvector(double A[], double B[]) {
		double r[]= new double [A.length];
		for (int i=0; i<A.length; i++) {
			r[i]=A[i]+B[i];
		}
		return r;
	}
	
// Soma entre duas matrizes
	public double [][] summatriz(double A[][], double B[][]) {
		double r[][]= new double [A.length][A[0].length];
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A[0].length;j++) {
				r[i][j]=A[i][j]+B[i][j];
			}
			
		}
		return r;
	}
		
// Diferenca entre dois vetores e multiplicacao por epsilon

	public double [] difvector_e(double A[], double B[], double e) {
		double r[]= new double [A.length];
		for (int i=0; i<A.length; i++) {
			r[i]=e*(A[i]-B[i]);
		}
		return r;
	}
		
		
// Diferenca entre duas matrizes e multiplicacao por epsilon
	
	public double [][] difmatriz_e(double A[][], double B[][], double e) {
		double r[][]= new double [A.length][A[0].length];
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A[0].length;j++) {
				r[i][j]=e*(A[i][j]-B[i][j]);
			}
			
		}
		return r;
	}
	
	public void aprende() {
		for(int l=0; l<(samp.length());l++) {
			double[] v=samp.element(l);
			double[] h=alg1(v);
			double vl[]=alg2(h);
			double hl[]=alg1(vl);
			double [][]gradpos=grad((samp.element(l)),h);
			double [][]gradneg=grad(vl,hl);
			double e=0.01;
			double [][]W=((summatriz(gbm.getW(),difmatriz_e(gradpos,gradneg,e))));
			double []A=((sumvector(gbm.getA(),difvector_e(gbm.vTransform(v), gbm.vTransform(vl), e))));
			double []B=((sumvector(gbm.getB(),difvector_e(h, hl, e))));
			gbm.Update(A, B, W);
			
			
		}
	}
	
}