package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;


public class Sample implements Serializable{
	private static final long serialVersionUID = 1L;
	
	ArrayList<double[]> A = new ArrayList<double[]> ();
	
	
	private String toStringSample(ArrayList<double[]> sa) {
		String s="";
		for (int i = 0; i < sa.size(); i++) {
			s=s+Arrays.toString(sa.get(i));
		}
		return s;
	}

	@Override
	public String toString() {
		return "Sample [A=" + toStringSample(A) +"]";
	}
	
	//função que adiciona um novo vetor/paciente (input) á amostra
	public void add(double [] v) {
		A.add(v);
	}
	
	//tamanho da amostra, número de doentes
	public int length() {
		return A.size();
	}
	
	//retorna o vetor/paciente i
	public double[] element(int i) {
		return A.get(i);
	}
	
	
	//função de devolve o numero de vetores/doentes que para as variaveis em v[] apresentam os valores de e[]
	public int count(double []v, double [] e) {
		int r =0;
		for (int i=0;i<A.size(); i++) {
			int f=0;
			for (int j=0; j<v.length; j++){
				int b=(int)v[j];
				double c=e[j];
				double d=(A.get(i))[b];
				if (d==c) {
					f++;
				}
				if(f==v.length) {
					r++;
				}
			}
		}
		return r;
	}
	
	//função que devolve um vetor com o dominio de cada uma das variáveis, incluindo a classe	
	public int [] domain() {
		int [] r= new int [(A.get(0)).length];
		int max=0;
		for (int i=0; i<(A.get(0)).length; i++) {
			for(int j=0; j<A.size(); j++) {
				if ((A.get(j))[i]>max)
					max=(int)(A.get(j))[i];
			}
			r[i]=(max+1);
			max=0;
		}		
		return r;
					
	}
}