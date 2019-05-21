package classes;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;

public class classificador {

	private JFrame frame;
	GBMachine G;
	private JTextField d1;
	private JTextField d2;
	private JTextField d3;
	private JTextField d4;
	private JTextField d5;
	private JTextField d6;
	private JTextField d7;
	private JTextField d8;
	private JTextField b1;
	private JTextField b2;
	private JTextField b3;
	private JTextField b4;
	private JTextField b5;
	private JTextField b6;
	private JTextField b7;
	private JTextField b8;
	private JTextField b9;
	private JTextField b10;
	private JTextField h1;
	private JTextField h2;
	private JTextField h3;
	private JTextField h4;
	private JTextField h5;
	private JTextField h6;
	private JTextField h7;
	private JTextField h8;
	private JTextField h9;
	private JTextField h10;
	private JTextField h11;
	private JTextField h12;
	private JTextField h13;
	private JTextField h14;
	private JTextField h15;
	private JTextField h16;
	private JTextField h17;
	private JTextField h18;
	private JTextField h19;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JTextField t10;
	private JTextField t11;
	private JTextField t12;
	private JTextField t13;
	private JTextField t14;
	private JTextField t15;
	private JTextField t16;
	private JTextField t17;
	private JTextField t18;
	private JTextField t19;
	private JTextField t20;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classificador window = new classificador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public classificador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Classifier");
		frame.setBounds(300, 300, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		
		JButton btnEscolherFicheiroGbm = new JButton("Escolher ficheiro GBM");
		btnEscolherFicheiroGbm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue=fileChooser.showOpenDialog((Component)e.getSource());
				if (returnValue==JFileChooser.APPROVE_OPTION){
					G = readwrite.readOGB(fileChooser.getSelectedFile().getAbsolutePath());
					System.out.println(G);
				}
			}
		});
		btnEscolherFicheiroGbm.setBounds(10, 11, 135, 46);
		frame.getContentPane().add(btnEscolherFicheiroGbm);
		
		JLabel classe = new JLabel("");
		classe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		classe.setBackground(Color.WHITE);
		classe.setForeground(Color.ORANGE);
		classe.setBounds(205, 45, 146, 35);
		frame.getContentPane().add(classe);
		
		JCheckBox chckbxBcancer = new JCheckBox("bcancer");
		chckbxBcancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxBcancer.isEnabled()) {
					double[] vd= new double[10];
					vd[0]=Double.parseDouble(b1.getText());
					vd[1]=Double.parseDouble(b2.getText());
					vd[2]=Double.parseDouble(b3.getText());
					vd[3]=Double.parseDouble(b4.getText());
					vd[4]=Double.parseDouble(b5.getText());
					vd[5]=Double.parseDouble(b6.getText());
					vd[6]=Double.parseDouble(b7.getText());
					vd[7]=Double.parseDouble(b8.getText());
					vd[8]=Double.parseDouble(b9.getText());
					vd[9]=Double.parseDouble(b10.getText());
					try {
						int c= G.classify(vd);
						classe.setText("O diagnostico e "+c+"");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		chckbxBcancer.setBounds(10, 76, 97, 23);
		frame.getContentPane().add(chckbxBcancer);
		
		JCheckBox chckbxDiabetes = new JCheckBox("diabetes");
		chckbxDiabetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxDiabetes.isEnabled() ) {
					double[] vd= new double[8];
					vd[0]=Double.parseDouble(d1.getText());
					vd[1]=Double.parseDouble(d2.getText());
					vd[2]=Double.parseDouble(d3.getText());
					vd[3]=Double.parseDouble(d4.getText());
					vd[4]=Double.parseDouble(d5.getText());
					vd[5]=Double.parseDouble(d6.getText());
					vd[6]=Double.parseDouble(d7.getText());
					vd[7]=Double.parseDouble(d8.getText());
					try {
						int c= G.classify(vd);
						classe.setText("O diagnostico e "+c+"");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		chckbxDiabetes.setBounds(10, 140, 97, 23);
		frame.getContentPane().add(chckbxDiabetes);
		
		JCheckBox chckbxHepatitis = new JCheckBox("hepatitis");
		chckbxHepatitis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxHepatitis.isEnabled()) {
					double[] vd= new double[19];
					vd[0]=Double.parseDouble(h1.getText());
					vd[1]=Double.parseDouble(h2.getText());
					vd[2]=Double.parseDouble(h3.getText());
					vd[3]=Double.parseDouble(h4.getText());
					vd[4]=Double.parseDouble(h5.getText());
					vd[5]=Double.parseDouble(h6.getText());
					vd[6]=Double.parseDouble(h7.getText());
					vd[7]=Double.parseDouble(h8.getText());
					vd[8]=Double.parseDouble(h9.getText());
					vd[9]=Double.parseDouble(h10.getText());
					vd[10]=Double.parseDouble(h11.getText());
					vd[11]=Double.parseDouble(h12.getText());
					vd[12]=Double.parseDouble(h13.getText());
					vd[13]=Double.parseDouble(h14.getText());
					vd[14]=Double.parseDouble(h15.getText());
					vd[15]=Double.parseDouble(h16.getText());
					vd[16]=Double.parseDouble(h17.getText());
					vd[17]=Double.parseDouble(h18.getText());
					vd[18]=Double.parseDouble(h19.getText());
					try {
						int c= G.classify(vd);
						classe.setText("O diagnostico e "+c+"");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		chckbxHepatitis.setBounds(10, 205, 97, 23);
		frame.getContentPane().add(chckbxHepatitis);
		
		JCheckBox chckbxThyroid = new JCheckBox("thyroid");
		chckbxThyroid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxThyroid.isEnabled()) {
					double[] vd= new double[20];
					vd[0]=Double.parseDouble(t1.getText());
					vd[1]=Double.parseDouble(t2.getText());
					vd[2]=Double.parseDouble(t3.getText());
					vd[3]=Double.parseDouble(t4.getText());
					vd[4]=Double.parseDouble(t5.getText());
					vd[5]=Double.parseDouble(t6.getText());
					vd[6]=Double.parseDouble(t7.getText());
					vd[7]=Double.parseDouble(t8.getText());
					vd[8]=Double.parseDouble(t9.getText());
					vd[9]=Double.parseDouble(t10.getText());
					vd[10]=Double.parseDouble(t11.getText());
					vd[11]=Double.parseDouble(t12.getText());
					vd[12]=Double.parseDouble(t13.getText());
					vd[13]=Double.parseDouble(t14.getText());
					vd[14]=Double.parseDouble(t15.getText());
					vd[15]=Double.parseDouble(t16.getText());
					vd[16]=Double.parseDouble(t17.getText());
					vd[17]=Double.parseDouble(t18.getText());
					vd[18]=Double.parseDouble(t19.getText());
					vd[19]=Double.parseDouble(t20.getText());
					try {
						int c= G.classify(vd);
						classe.setText("O diagnostico e "+c+"");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		chckbxThyroid.setBounds(10, 279, 97, 23);
		frame.getContentPane().add(chckbxThyroid);
		
		
		d1 = new JTextField();
		d1.setBounds(10, 170, 29, 20);
		frame.getContentPane().add(d1);
		d1.setColumns(10);
		
		d2 = new JTextField();
		d2.setBounds(49, 170, 29, 20);
		frame.getContentPane().add(d2);
		d2.setColumns(10);
		
		d3 = new JTextField();
		d3.setBounds(88, 170, 29, 20);
		frame.getContentPane().add(d3);
		d3.setColumns(10);
		
		d4 = new JTextField();
		d4.setBounds(127, 170, 29, 20);
		frame.getContentPane().add(d4);
		d4.setColumns(10);
		
		d5 = new JTextField();
		d5.setBounds(166, 170, 29, 20);
		frame.getContentPane().add(d5);
		d5.setColumns(10);
		
		d6 = new JTextField();
		d6.setBounds(205, 170, 29, 20);
		frame.getContentPane().add(d6);
		d6.setColumns(10);
		
		d7 = new JTextField();
		d7.setBounds(244, 170, 29, 20);
		frame.getContentPane().add(d7);
		d7.setColumns(10);
		
		d8 = new JTextField();
		d8.setBounds(283, 170, 29, 20);
		frame.getContentPane().add(d8);
		d8.setColumns(10);
		
		b1 = new JTextField();
		b1.setBounds(10, 106, 29, 20);
		frame.getContentPane().add(b1);
		b1.setColumns(10);
		
		b2 = new JTextField();
		b2.setBounds(49, 106, 29, 20);
		frame.getContentPane().add(b2);
		b2.setColumns(10);
		
		b3 = new JTextField();
		b3.setBounds(88, 106, 29, 20);
		frame.getContentPane().add(b3);
		b3.setColumns(10);
		
		b4 = new JTextField();
		b4.setBounds(127, 106, 29, 20);
		frame.getContentPane().add(b4);
		b4.setColumns(10);
				
		
		b5 = new JTextField();
		b5.setBounds(165, 106, 29, 20);
		frame.getContentPane().add(b5);
		b5.setColumns(10);
		
		b6 = new JTextField();
		b6.setBounds(205, 106, 29, 20);
		frame.getContentPane().add(b6);
		b6.setColumns(10);
		
		b7 = new JTextField();
		b7.setBounds(244, 106, 29, 20);
		frame.getContentPane().add(b7);
		b7.setColumns(10);
		
		b8 = new JTextField();
		b8.setBounds(283, 106, 29, 20);
		frame.getContentPane().add(b8);
		b8.setColumns(10);
		
		b9 = new JTextField();
		b9.setBounds(322, 106, 29, 20);
		frame.getContentPane().add(b9);
		b9.setColumns(10);
		
		b10 = new JTextField();
		b10.setBounds(361, 106, 29, 20);
		frame.getContentPane().add(b10);
		b10.setColumns(10);
		
		h1 = new JTextField();
		h1.setBounds(10, 235, 29, 20);
		frame.getContentPane().add(h1);
		h1.setColumns(10);
		
		h2 = new JTextField();
		h2.setBounds(49, 235, 29, 20);
		frame.getContentPane().add(h2);
		h2.setColumns(10);
		
		h3 = new JTextField();
		h3.setBounds(88, 235, 29, 20);
		frame.getContentPane().add(h3);
		h3.setColumns(10);
		
		h4 = new JTextField();
		h4.setBounds(127, 235, 29, 20);
		frame.getContentPane().add(h4);
		h4.setColumns(10);
		
		h5 = new JTextField();
		h5.setBounds(165, 235, 29, 20);
		frame.getContentPane().add(h5);
		h5.setColumns(10);
		
		h6 = new JTextField();
		h6.setBounds(205, 235, 29, 20);
		frame.getContentPane().add(h6);
		h6.setColumns(10);
		
		h7 = new JTextField();
		h7.setBounds(244, 235, 29, 20);
		frame.getContentPane().add(h7);
		h7.setColumns(10);
		
		h8 = new JTextField();
		h8.setBounds(283, 235, 29, 20);
		frame.getContentPane().add(h8);
		h8.setColumns(10);
		
		h9 = new JTextField();
		h9.setBounds(322, 235, 29, 20);
		frame.getContentPane().add(h9);
		h9.setColumns(10);
		
		h10 = new JTextField();
		h10.setBounds(361, 235, 29, 20);
		frame.getContentPane().add(h10);
		h10.setColumns(10);
		
		h11 = new JTextField();
		h11.setBounds(400, 235, 29, 20);
		frame.getContentPane().add(h11);
		h11.setColumns(10);
		
		h12 = new JTextField();
		h12.setBounds(439, 235, 29, 20);
		frame.getContentPane().add(h12);
		h12.setColumns(10);
		
		h13 = new JTextField();
		h13.setBounds(478, 235, 29, 20);
		frame.getContentPane().add(h13);
		h13.setColumns(10);
		
		h14 = new JTextField();
		h14.setBounds(517, 235, 29, 20);
		frame.getContentPane().add(h14);
		h14.setColumns(10);
		
		h15 = new JTextField();
		h15.setBounds(556, 235, 29, 20);
		frame.getContentPane().add(h15);
		h15.setColumns(10);
		
		h16 = new JTextField();
		h16.setBounds(595, 235, 29, 20);
		frame.getContentPane().add(h16);
		h16.setColumns(10);
		
		h17 = new JTextField();
		h17.setBounds(634, 235, 29, 20);
		frame.getContentPane().add(h17);
		h17.setColumns(10);
		
		h18 = new JTextField();
		h18.setBounds(673, 235, 29, 20);
		frame.getContentPane().add(h18);
		h18.setColumns(10);
		
		h19 = new JTextField();
		h19.setBounds(712, 235, 29, 20);
		frame.getContentPane().add(h19);
		h19.setColumns(10);
		
		t1 = new JTextField();
		t1.setBounds(10, 322, 29, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(49, 322, 29, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(88, 322, 29, 20);
		frame.getContentPane().add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(127, 322, 29, 20);
		frame.getContentPane().add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(166, 322, 29, 20);
		frame.getContentPane().add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(205, 322, 29, 20);
		frame.getContentPane().add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(244, 322, 29, 20);
		frame.getContentPane().add(t7);
		t7.setColumns(10);
		
		t8 = new JTextField();
		t8.setBounds(283, 322, 29, 20);
		frame.getContentPane().add(t8);
		t8.setColumns(10);
		
		t9 = new JTextField();
		t9.setBounds(322, 322, 29, 20);
		frame.getContentPane().add(t9);
		t9.setColumns(10);
		
		t10 = new JTextField();
		t10.setBounds(361, 322, 29, 20);
		frame.getContentPane().add(t10);
		t10.setColumns(10);
		
		t11 = new JTextField();
		t11.setBounds(400, 322, 29, 20);
		frame.getContentPane().add(t11);
		t11.setColumns(10);
		
		t12 = new JTextField();
		t12.setBounds(439, 322, 29, 20);
		frame.getContentPane().add(t12);
		t12.setColumns(10);
		
		t13 = new JTextField();
		t13.setBounds(478, 322, 29, 20);
		frame.getContentPane().add(t13);
		t13.setColumns(10);
		
		t14 = new JTextField();
		t14.setBounds(517, 322, 29, 20);
		frame.getContentPane().add(t14);
		t14.setColumns(10);
		
		t15 = new JTextField();
		t15.setBounds(556, 322, 29, 20);
		frame.getContentPane().add(t15);
		t15.setColumns(10);
		
		t16 = new JTextField();
		t16.setBounds(595, 322, 29, 20);
		frame.getContentPane().add(t16);
		t16.setColumns(10);
		
		t17 = new JTextField();
		t17.setBounds(634, 322, 29, 20);
		frame.getContentPane().add(t17);
		t17.setColumns(10);
		
		t18 = new JTextField();
		t18.setBounds(673, 322, 29, 20);
		frame.getContentPane().add(t18);
		t18.setColumns(10);
		
		t19 = new JTextField();
		t19.setBounds(712, 322, 29, 20);
		frame.getContentPane().add(t19);
		t19.setColumns(10);
		
		t20 = new JTextField();
		t20.setBounds(745, 322, 29, 20);
		frame.getContentPane().add(t20);
		t20.setColumns(10);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				classe.setText("");
				b1.setText("");
				b2.setText("");
				b3.setText("");
				b4.setText("");
				b5.setText("");
				b6.setText("");
				b7.setText("");
				b8.setText("");
				b9.setText("");
				b10.setText("");
				d1.setText("");
				d2.setText("");
				d3.setText("");
				d4.setText("");
				d5.setText("");
				d6.setText("");
				d7.setText("");
				d8.setText("");
				h1.setText("");
				h2.setText("");
				h3.setText("");
				h4.setText("");
				h5.setText("");
				h6.setText("");
				h7.setText("");
				h8.setText("");
				h9.setText("");
				h10.setText("");
				h11.setText("");
				h12.setText("");
				h13.setText("");
				h14.setText("");
				h15.setText("");
				h16.setText("");
				h17.setText("");
				h18.setText("");
				h19.setText("");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				t12.setText("");
				t13.setText("");
				t14.setText("");
				t15.setText("");
				t16.setText("");
				t17.setText("");
				t18.setText("");
				t19.setText("");
				t20.setText("");
			}
		});
		btnLimpar.setBounds(595, 23, 107, 35);
		frame.getContentPane().add(btnLimpar);
		
			
	}
}
