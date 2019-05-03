
public class Bmachine {
	private int[]d;
	private double []a;
	private double[]b;
	private double[][]W;
	
	public Bmachine(int[]d,double []a,double []b,double [][]W) {
		this.d = d;
		this.a = a;
		this.b = b;
		this.W = W;
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

	public double[][] getW() {
		return W;
	}

	public void setW(double[][] w) {
		W = w;
	}
	
	
	

}
