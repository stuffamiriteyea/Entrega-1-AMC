package classes;

import java.io.Serializable;

public class GBMachine extends Bmachine  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public GBMachine (int[] d, double [] a, double [] b, double [][] w) {
		super(d, a, b, w);
	}
	
	public double[] vTransform (double[] v) {
		int sum = 0;
		for(int i = 0; i < (getD()).length; i++)
			sum += getD()[i];
		
		double[] vt = new double[sum];
		int n = 0;
		
		for(int i=0; i<v.length; i++) {
			vt[(int)v[i] + n] = 1;
			n += getD()[i];
		}
		return vt;
	}
	 public double energy(double[] v, double[] h) {
		 return super.energy(vTransform(v), h);
	 }
	 
}	