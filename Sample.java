
import java.util.ArrayList;
import java.util.Arrays;


public class Sample {
	ArrayList<int[]> A = new ArrayList<int[]> ();
	int [] domains=null;
	
	private String toStringSample(ArrayList<int[]> sa) {
		String s="";
		for (int i = 0; i < sa.size(); i++) {
			s=s+Arrays.toString(sa.get(i));
		}
		return s;
	}

	@Override
	public String toString() {
		return "Sample [A=" + toStringSample(A) + ", domains=" + Arrays.toString(domains) + "]";
	}
	
	
	public void add(int [] v) {
		A.add(v);
		if (A.size()==1) {
			domains=new int[v.length];
			
		}
	}
	
	public int length() {
		return A.size();
	}
	
	public int[] element(int i) {
		return A.get(i);
	}
	/*primeira versão vetor
	public int [] count(int [] v, int[] e){
		int r [] = new int[v.length];
		int b =0;
		int c=0;
		int i=0;
		while( i<v.length)
			b=v[i];
			c=e[i];
			int aux1[] = new int[(A.get(0)).length];
			int aux2=0;
			int d=0;
			int j=0;
			while( j<A.size())
				aux1=A.get(j);
				aux2=aux1[b];
				if (aux2==c)
					d++;
				j++;
			r[i]=d;
			i++;			
		return r;
	}*/
	
	//fazer com a versão de número
		
	public int count(int []v, int [] e) {
		int r =0;
		for (int i=0;i<A.size(); i++) {
			int f=0;
			for (int j=0; j<v.length; j++){
				int b=v[j];
				int c=e[j];
				int d=(A.get(i))[b];
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
	
	public int [] domain() {
		int [] r= new int [(A.get(0)).length];
		int max=0;
		for (int i=0; i<(A.get(0)).length; i++) {
			for(int j=0; j<A.size(); j++) {
				if ((A.get(j))[i]>max)
					max=(A.get(j))[i];
			}
			r[i]=(max+1);
			max=0;
		}		
		return r;
					
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample B = new Sample();
		int a[]= {1 , 2, 3, 0, 5};
		int b[]= {0 , 2, 1, 0, 4};
		int c[]= {1 , 0, 3, 1, 3};
		int d[]= {0,2,4};
		int g[]= {1,3,3};
		int h[]= {1,3,2};
		B.add(a);
		B.add(b);
		B.add(c);
		System.out.println(B);
		//System.out.println(Arrays.toString(B.element(1)));
		//System.out.println(Arrays.toString(B.domain()));
		System.out.println(B.count(d, g));
		System.out.println(B.count(d, h));
	}
	
}