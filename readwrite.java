package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class readwrite {
	//Read write sample
	//Lê uma sample de um ficheiro e devolve para dentro do programa uma sample desse ficheiro
	public static Sample readS(String f){
		Sample Ar = new Sample();
		try {
			FileReader fileReader = new FileReader(f);
			Scanner sc=new Scanner(fileReader);
			while(sc.hasNext()){
				String line=sc.next();
				String[] linesplit = line.split(",");
				double a[]=new double[linesplit.length];
				for(int j=0; j < a.length; j++)
					a[j]=Integer.parseInt(linesplit[j]);
				Ar.add(a);}
			fileReader.close();
			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Ar;
	}
	//Constroi um ficheiro com a sample que recebe como input
	public static void writeS(Sample A, String f){
		try {
			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream oo;
			oo = new ObjectOutputStream(fo);
			oo.writeObject(A);

			fo.close();
			oo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//lê um ficheiro que contenha uma sample
	public static Sample readOS( String f){
		Sample B = new Sample();
		try {
			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			B = (Sample) oi.readObject();
			fi.close();
			oi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return B;
	}
	//read write gbmachine
	//Constroi um ficheiro com a gbmachine que recebe como input
		public static void writeGB(GBMachine A, String f){
			try {
				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream oo;
				oo = new ObjectOutputStream(fo);
				oo.writeObject(A);

				fo.close();
				oo.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//lê um ficheiro que contenha uma GBMachine
		public static GBMachine readOGB( String f){
			GBMachine GB = new GBMachine (null, null, null, null);
			try {
				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				GB = (GBMachine) oi.readObject();
				fi.close();
				oi.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return GB;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Sample At= new Sample();
		double [] a={1,2,3};
		At.add(a);
		At.add(a);
		System.out.println(At);
		writeS(At,"serAt.ser");
		Sample B=readOS("serAt.ser");
		System.out.println(B);*/
		Sample C=readS("hepatitis.csv");
		System.out.println(C);
		System.out.println(Arrays.toString(C.domain()));
		System.out.println(C.length());
		/*double[] aa = {1.0, 0.0};
		double[] b = {1.0, 1.0};
		int[]d= {2,2};
		double[][] w = {{1.0,0.0}, {0.0,1.0}};
		GBMachine Nova = new GBMachine( d, aa, b, w);
		writeGB(Nova,"Nova.ser");
		GBMachine dou=readOGB("Nova.ser");
		System.out.println( Arrays.toString( dou.getA() ) );
		System.out.println( Arrays.toString( dou.getB() ) );
		System.out.println( Arrays.toString( dou.getD() ) );
		System.out.println( Arrays.toString( dou.getW() ) );*/
	}

}
