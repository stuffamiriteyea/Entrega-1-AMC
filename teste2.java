package classes;
import java.util.Arrays;

public class teste2 {

	public static void main(String[] args) {
		double[] v = {1,2,3};
		Sample S = new Sample();
		
		for(int i=0; i<2; i++)
			S.add(v);
		double[] v1 = {0,2,3};
		S.add(v1);
		
		System.out.println(S.toString());
		
		GBMachine G = Inicializacao.init(S,5);
		
		System.out.println("d = " + Arrays.toString(G.getD()));
		System.out.println("a = " +Arrays.toString(G.getA()));
		System.out.println("b = " +Arrays.toString(G.getB()));
		for(int i = 0; i<G.getB().length; i++) {
			for(int j = 0; j<G.getB().length; j++)
				System.out.println(Arrays.toString(G.getW()[j]));
		}
		
		
		//System.out.println(Arrays.toString(I.novoA()));
		//System.out.println(Arrays.toString(I.novoB(-4)));
		//System.out.println(I.uniformW());
		//System.out.println(I.gaussW());
		/*for(int i = 0; i<I.sum; i++) {
			for(int j = 0; j<I.sum; j++)
				System.out.println(Arrays.toString(I.novoWu()[j]));
		}
		for(int i = 0; i<I.sum; i++) {
			for(int j = 0; j<I.sum; j++)
				System.out.println(Arrays.toString(I.novoWg()[j]));
		}*/
		
		
	}
	
	
}
