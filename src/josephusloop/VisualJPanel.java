package josephusloop;

import java.awt.Color;
import java.awt.Graphics;
import java.math.*;

import javax.swing.JPanel;

public class VisualJPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	/**
	 * 500*500的Panel用来画约瑟夫环
	 */
	double result = 0;
	int resultLength = 0;
	String modal = null;
	
	public VisualJPanel(int result, int length, String modal) {
		super();
		this.modal = modal;
		this.result = result;
		this.resultLength = length;
		setSize(500,500);
		setBackground(Color.black);
		setBounds(1,50,500,500);
	}

	public void paintComponent(Graphics g){
//		public void paintComponent(){
		//设置圆心和半径：
		final int defaultX = 250;
		final int defaultY = 250;
		final double defaultRadius = 200;
		int placeX;
	    int placeY;
	    double Angle;
	    // 画圆周上的点
	    if(result == -1) {
	    	g.setColor(Color.black);
	    	g.fillRect(0, 0, 500, 500);
	    } else {
	    	Angle = ((double)(360.0/resultLength)) * result;
//	    	System.out.println((double)Angle);
//	        System.out.println(Math.cos(Angle*Math.PI/180));
//	        System.out.println(defaultRadius*Math.cos(Angle*Math.PI/180));
//	        System.out.println(defaultX + defaultRadius*Math.cos(Angle*Math.PI/180));
		    BigDecimal bigDecimalX = new BigDecimal((defaultX + defaultRadius*Math.cos(Angle*Math.PI/180)));
		    BigDecimal bigDecimalY = new BigDecimal((defaultY + defaultRadius*Math.sin(Angle*Math.PI/180)));
		    placeX = bigDecimalX.setScale(0, RoundingMode.HALF_EVEN).intValue();
		    placeY = bigDecimalY.setScale(0, RoundingMode.HALF_EVEN).intValue();
//    		System.out.println(placeX);
//    		System.out.println(placeY);
//    		System.out.println((defaultY + defaultRadius*Math.sin(Angle*Math.PI/180)));
//	        
	        
	        if (modal == "Confirm") {
	        	g.setColor(Color.black);
	        	g.drawString(result<10 ? ("0" + Integer.toString((int)result)):Integer.toString((int)result), (int) placeX, placeY);//在X,Y的位置处画上特定的符号*
	        } else if (modal == "Draw") {
	        	g.setColor(Color.black);
	        	g.fillOval(placeX-6, placeY-16,22,22);//在X,Y的位置处画上特定的符号*
	        } else if (modal == "LEAVE") {
	        	g.drawString("去除的数字是： ", 200, 250);
        		g.setColor(Color.black);
	        	g.fillOval(288, 234,22,22);//在X,Y的位置处画上特定的符号*
	        	g.setColor(Color.yellow);
	        	g.drawString(result<10 ? ("0" + Integer.toString((int)result)):Integer.toString((int)result), 294, 250);
	        } else if (modal == "LASTLEAVE") {
		    	g.setColor(Color.black);
		    	g.fillRect(200, 234, 110, 22);
		    	g.setColor(Color.yellow);
		    	g.drawString("最后的数字是：" + (result<10 ? ("0" + Integer.toString((int)result)):Integer.toString((int)result)), 208, 250);
	        }
	    }		
	}
	public static void main(String[] args) {
//		VisualJPanel visualJPanel = new VisualJPanel(3, 110 , "Confirm");
//		visualJPanel.paintComponent();
	}
}
