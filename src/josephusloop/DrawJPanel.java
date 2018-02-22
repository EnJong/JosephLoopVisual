package josephusloop;

public class DrawJPanel implements Runnable{
	int [] result = null;
    String modal = new String();
    Display josephLoopDisplay = null;

	public DrawJPanel(Display josephLoopDisplay, int[] result, String modal) {
		super();
		this.josephLoopDisplay = josephLoopDisplay;
		this.result = result;
		this.modal = modal;
	}

	@Override
	public void run() {
		if (modal == "Confirm") {
			for (int i = 0; i < result.length ; i++) {
				VisualJPanel starJPanel = new VisualJPanel(i+1,result.length, modal);
				josephLoopDisplay.add(starJPanel);
				starJPanel.setVisible(false);
				starJPanel.setVisible(true);
	    		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		if(i == result.length-1) { 
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					modal = "Draw";
					for (int j = 0; j < result.length ; j++) {
						VisualJPanel starJPanelvisual = new VisualJPanel(result[j], result.length, modal);
						josephLoopDisplay.add(starJPanelvisual);
						starJPanelvisual.setVisible(false);
						starJPanelvisual.setVisible(true);
						VisualJPanel drawLeaveNumber = new VisualJPanel(result[j], result.length, "LEAVE");
						josephLoopDisplay.add(drawLeaveNumber);
						starJPanelvisual.setVisible(false);
						starJPanelvisual.setVisible(true);
						try {
							Thread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						josephLoopDisplay.remove(drawLeaveNumber);
						starJPanelvisual.setVisible(false);
						starJPanelvisual.setVisible(true);
						if (j == result.length -1) {
							VisualJPanel drawLastLeaveNumber = new VisualJPanel(result[j], result.length, "LASTLEAVE");
							josephLoopDisplay.add(drawLastLeaveNumber);
							starJPanelvisual.setVisible(false);
							starJPanelvisual.setVisible(true);
						}
			        }
	    		}
	        }
		}
	}
}
