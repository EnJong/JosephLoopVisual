package josephusloop;

import java.awt.*;
import javax.swing.JFrame;

public class Display extends JFrame {
	private static final long serialVersionUID = 1;
	TextField inputNumber1,inputNumber2,outputNumber1,outputNumber2;
	Label star = new Label("*");
	
	Panel upPanel1 = new Panel(new FlowLayout(10,0,10));
	Panel upPanel2 = new Panel(new GridLayout(2,1));
	Label totalNumber = new Label("总人数：");
	Label targetNumber = new Label(" 需要除去的位置：");
	Label resultNumber = new Label(" 最后还剩下：");
	Button confirmButton = new Button("Confirm");
	Button exitButton = new Button("More");

	public Display(){
		super();
        setLayout(null);
        setSize(502, 552);
        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//匿名类
//		this.addWindowListener(
//				new WindowAdapter(){
//				public void windowClosing(WindowEvent e) {
//					setVisible(false);
//					System.exit(-1);
//				}
//			});
		inputNumber1 = new TextField(8);
		inputNumber2 = new TextField(8);
		outputNumber1 = new TextField(8);
		outputNumber2 = new TextField(8);
		
		upPanel1.setBounds(2, 1, 433, 50);
		upPanel2.setBounds(436, 1, 64, 50);
		upPanel1.setBackground(Color.gray);
		upPanel2.setBackground(Color.gray);

		upPanel1.add(totalNumber);
		upPanel1.add(inputNumber1);
		upPanel1.add(targetNumber);
		upPanel1.add(inputNumber2);
		upPanel1.add(resultNumber);
		upPanel1.add(outputNumber1);
		
		upPanel2.add(confirmButton);
		upPanel2.add(exitButton);
		add(upPanel1);
		add(upPanel2);
        setTitle("约瑟夫环");
	}

	public void launchJFrame() {
        setVisible(true);
	}
	
	public static void main(String[] args) {
		Display josephLoopVisual = new Display();
		josephLoopVisual.launchJFrame();
	}
}