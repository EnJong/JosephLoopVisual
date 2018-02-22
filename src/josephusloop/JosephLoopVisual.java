package josephusloop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JosephLoopVisual {
	Display josephLoopDisplay = new Display();
	boolean exit = true;
	public void buttonActionEvent() {
		josephLoopDisplay.confirmButton.addActionListener(new Monitor());
		josephLoopDisplay.exitButton.addActionListener(new Monitor());
		josephLoopDisplay.upPanel2.add(josephLoopDisplay.confirmButton);
		josephLoopDisplay.upPanel2.add(josephLoopDisplay.exitButton);
	}
	public static void main(String[] args) {
		JosephLoopVisual josephLoopVisual = new JosephLoopVisual();
		josephLoopVisual.buttonActionEvent();
		josephLoopVisual.josephLoopDisplay.launchJFrame();
	}
	class Monitor implements ActionListener{
	    Monitor() {
	    	super();
	    }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int number1 = Integer.parseInt(josephLoopDisplay.inputNumber1.getText());
			int number2 = Integer.parseInt(josephLoopDisplay.inputNumber2.getText());
			
			JosephLoop josephLoop = new JosephLoop(number1,number2);
			DrawJPanel drawJPanel = new DrawJPanel(josephLoopDisplay, josephLoop.joseph(number1, number2), arg0.getActionCommand());
			Thread drawThread1 = new Thread(drawJPanel);
	
			if(arg0.getActionCommand() == "Confirm") {
				josephLoopDisplay.outputNumber1.setText(String.valueOf(josephLoop.josephLoop()+1));
				drawThread1.start();	        
			} else if (arg0.getActionCommand() == "More") {
				JosephLoopVisual josephLoopVisual = new JosephLoopVisual();
				josephLoopVisual.buttonActionEvent();
				josephLoopVisual.josephLoopDisplay.launchJFrame();
			}
			
		}
		
	}
	
}
