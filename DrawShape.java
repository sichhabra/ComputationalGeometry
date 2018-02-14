import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawShape {
	
	int L=600,W=600;
	int inY=570;

	class Line extends JComponent {
		
		int x1,x2,y1,y2;
		public Line(int x1,int y1,int x2,int y2) {
			this.x1=x1;
			this.y1=inY-y1;
			this.x2=x2;
			this.y2=inY-y2;
		}
		
		private static final long serialVersionUID = 4314400876148669943L;
		protected void paintComponent(Graphics g) {
			g.drawLine(x1, y1, x2, y2);
		}
	}

	public DrawShape() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(W, L));
		Line l1=new Line(1,1,100,100);
		frame.add(l1);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new DrawShape();
	}

}
