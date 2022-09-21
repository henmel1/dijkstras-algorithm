//HENRY MELLOR 
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DijkstraTest extends JPanel{
	public int totalV;
	public static boolean[] pathSet;
	public graph graph0;
	
	public DijkstraTest() {
		Timer t = new Timer(20, new Listener());
		t.start();
		
		int[][] matrix =
			{
			{-1,  2,  6, -1, -1, -1, -1},
			{ 2, -1, -1,  5, -1, -1, -1},
			{ 6, -1, -1,  8, -1, -1, -1},
			{-1,  5,  8, -1, 10, 15, -1},
			{-1, -1, -1, 10, -1,  6,  2},
			{-1, -1, -1, 15,  6, -1,  6},
			{-1, -1, -1, -1,  2,  6, -1}
			};

		dijkstra(matrix, 0);
		graph grph = new graph(matrix, pathSet);
		graph0 = grph;
		
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		graph0.draw(g);
	}
	
	public int minimumDistance(int distance[], boolean spSet[]) {
		int minimum = Integer.MAX_VALUE;
		int minimumIndex = -1;
		for(int i = 0; i<totalV; i++) {
			if(spSet[i] == false && distance[i] <= minimum) {
				minimum = distance[i];
				minimumIndex = i;
			}
		}
		
		return minimumIndex;
	}
	
	public void printSol(int distance[], int n){
		System.out.println("Shortest distance from source (0) node to all other nodes in graph 1 is: ");
		for(int i = 0; i<n; i++) {
			System.out.println("To " + i + ": " + distance[i]);
		}
	}
	
	public void dijkstra(int[][] graph, int n) {
		totalV = graph.length;
		int distance[] = new int[totalV];
		boolean spSet[] = new boolean[totalV];
		
		for(int i = 0; i< totalV; i++) {
			distance[i] = Integer.MAX_VALUE;
			spSet[i] = false;
		}
		
		distance[n] = 0;
		
		for(int r = 0; r<totalV-1; r++) {
			int minUnvisited = minimumDistance(distance, spSet);
			
			spSet[minUnvisited] = true;
			
			for(int c = 0; c<totalV; c++) {
				if(!spSet[c] && graph[r][c] != -1 && distance[r] != Integer.MAX_VALUE && distance[r]+graph[r][c] < distance[c]) {
					distance[c] = distance[r] + graph[r][c];
				}
			}
		}
		pathSet = spSet;
		printSol(distance, totalV);
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Dijkstras");
		frame.setSize(1100, 900);
		frame.setLocation(800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DijkstraTest());
		frame.setVisible(true);
	}
	
}

