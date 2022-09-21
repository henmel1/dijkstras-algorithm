//HENRY MELLOR
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class graph {
	private int[][] matrix;
	private boolean[] spSet;
	private ArrayList<Point> arrPoints = new ArrayList<Point>();
	
	public graph(int[][] m, boolean[] pathSet) {
		matrix = m;
		spSet = pathSet;
		int x = 0;
		int y = 0;
		for(int j = 0; j<matrix.length; j++) {
			x = (int)(Math.random()*1000+50);
			y = (int)(Math.random()*800+50);
			arrPoints.add(new Point(x, y));
		}
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public void draw(Graphics g){
		for(int i = 0; i<matrix.length; i++) {
			for(int p = 0; p<arrPoints.size(); p++) {
				g.setColor(Color.RED);
				g.fillOval(arrPoints.get(p).x - 10, arrPoints.get(p).y - 10, 20, 20);
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(new Font("Serif", Font.BOLD, 12));
				g.drawString(""+p, arrPoints.get(p).x-6, arrPoints.get(p).y+6);
			}
			for(int k = 0; k<matrix.length; k++) {
				if(k == i) {
					k++;
				}
				if(matrix.length > i && matrix[i].length > k && matrix[i][k] > 0 && matrix[i][k] < Integer.MAX_VALUE) {
					g.setColor(Color.WHITE);
					if(spSet[i] && spSet[k]) {
						g.setColor(Color.BLUE);
					}
					if(arrPoints.size() > i && arrPoints.size() > k) {
						g.drawLine(arrPoints.get(i).x, arrPoints.get(i).y, arrPoints.get(k).x, arrPoints.get(k).y);
						g.setColor(Color.WHITE);
						g.drawString(""+matrix[i][k], (arrPoints.get(i).x+arrPoints.get(k).x)/2, ((arrPoints.get(i).y+arrPoints.get(k).y)/2)-15);
					}
				}
				
			}
			
			
		}
		
	}
		
}