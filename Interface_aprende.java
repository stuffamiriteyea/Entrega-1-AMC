package classes;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Interface_aprende {

	private JFrame frame;
	Sample S;
	GBMachine G;
	private JTextField textName;
	private JTextField textBL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_aprende window = new Interface_aprende();
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
	public Interface_aprende() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Learner");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JFileChooser fileChooser = new JFileChooser();
		JButton btnBrowseCsvFile = new JButton("Browse csv file");
		btnBrowseCsvFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue=fileChooser.showOpenDialog((Component)e.getSource());
				if (returnValue==JFileChooser.APPROVE_OPTION){
					S = readwrite.readS(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		frame.getContentPane().setLayout(null);
		btnBrowseCsvFile.setBounds(10, 11, 116, 55);
		frame.getContentPane().add(btnBrowseCsvFile);
		
		JLabel Value = new JLabel("Value");
		Value.setBounds(148, 100, 106, 24);
		frame.getContentPane().add(Value);
		
		textBL = new JTextField();
		textBL.setBounds(20, 102, 86, 20);
		frame.getContentPane().add(textBL);
		textBL.setColumns(10);
		
		JButton btnLearn = new JButton("Learn");
		btnLearn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double BL=Double.parseDouble(textBL.getText());
				G=Inicializacao.init(S,BL);
				Sample A=new Sample();
				int RC=(S.length()/20);
				for(int i=RC; i<S.length()-RC; i++)
					A.add(S.element(i));
				ContrastiveDivergence cd=new ContrastiveDivergence(G,A);
				cd.aprende();
				double p=0;
				for (int c=0; c<6; c++){
					double[] va= new double[S.element(0).length-1];
					for (int v=0; v<S.element(0).length-1; v++)
						va[v]=S.element(c)[v];
					double aux;
					try {
						aux = G.classify(va);
						if (S.element(c)[S.element(0).length-1]==aux)
							p++;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				for(int l=S.length()-1; l>S.length()-RC-1; l--) {
					double[] vb= new double[S.element(0).length-1];
					for (int v=0; v<S.element(0).length-1; v++)
						vb[v]=S.element(l)[v];
					double au;
					try {
						au = G.classify(vb);
						if (S.element(l)[S.element(0).length-1]==au)
							p++;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				double prec=(p/(RC*2))*100;
					Value.setText(""+prec+"%");
			}
		});
		btnLearn.setBounds(149, 11, 116, 55);
		frame.getContentPane().add(btnLearn);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textName.getText();
				readwrite.writeGB(G,""+name+".ser");
			}
		});
		btnSave.setBounds(296, 11, 116, 55);
		frame.getContentPane().add(btnSave);
		
		textName = new JTextField();
		textName.setBounds(296, 102, 116, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblNameTheFile = new JLabel("Name the file to save");
		lblNameTheFile.setBounds(296, 77, 116, 14);
		frame.getContentPane().add(lblNameTheFile);
		
		JLabel Percentage = new JLabel("Percentage");
		Percentage.setBounds(149, 77, 116, 14);
		frame.getContentPane().add(Percentage);
		
		JLabel lblChooseBlength = new JLabel("Choose b.length");
		lblChooseBlength.setBounds(20, 77, 86, 14);
		frame.getContentPane().add(lblChooseBlength);
		
		
	}
}
