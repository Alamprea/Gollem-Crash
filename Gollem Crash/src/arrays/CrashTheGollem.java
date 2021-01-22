package arrays;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CrashTheGollem extends JPanel {
	
	// the width/height of the window - feel free to change these
	private final int W_WIDTH = 1200, W_HEIGHT = 800;
	
	// the number of enemies in the game - feel free to change
	
	//Head, Arms, Legs, and Heart (six parts of the same Gollem but still different entities)
	// a constant for the gravitational pull on our 'bird' - again, feel free to change
	private final double GRAVITY = .7;

	// hints...
	private int Health = 600;
	

	private boolean dead = false;
	
	private Image WinScreen;
	private Image GollemHandA;
	private Image GollemHandB;
	private Image GollemlegB;
	private Image GollemlegA;
	private Image GollemHeart;
	private Image GollemHead;
	private Image Blast;// example for using images - delete/replace this!

	// you'll need more instance variables - put them here.
	private int startX, startY;
	private int WinstartX = 2000 , WinstartY = 2000 ;
	private int LhandstartX = W_WIDTH * 2/3 + 200 , LhandstartY  = W_HEIGHT/2;
	private int RhandstartX = W_WIDTH * 2/3  , RhandstartY  = W_HEIGHT/2;
	private int PheadstartX = W_WIDTH * 2/3 + 100 , PheadstartY = W_HEIGHT/2 - 100;
	private int SheartstartX = W_WIDTH * 2/3 + 100, SheartstartY = W_HEIGHT/2;
	private int RfootstartX = W_WIDTH * 2/3 + 50, RfootstartY  = W_HEIGHT/2 + 100;
	private int LfootstartX = W_WIDTH * 2/3 + 150 , LfootstartY  = W_HEIGHT/2 + 100;
	private double speedX = 0;
	private double speedY = 0;
	private double blastX = 250, blastY = 300;
	private int DIAM = 50;
	
	private boolean GravActive = false;
	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		// example of loading an image file - edit to suit your project
		try {
			GollemHandA = ImageIO.read(new File("simple_cursors_12_550.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			GollemHandB = ImageIO.read(new File("Pixel Fist 2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Blast = ImageIO.read(new File("download.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			GollemHead = ImageIO.read(new File("Puwumpkin.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			GollemHeart = ImageIO.read(new File("Sheart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			GollemlegB = ImageIO.read(new File("Pixel Foot II.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			GollemlegA = ImageIO.read(new File("Pixel foot I.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			WinScreen = ImageIO.read(new File("background-scene---681e156ae971bd4--1-.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		
		
		blastX += speedX;
		blastY += speedY;
	if ( blastY >= W_HEIGHT) {
		
	blastX = 250;
	blastY = 300;
	GravActive = false;
	speedY = 0;
	speedX = 0;
		
	}
		
	if (GravActive)	
		speedY += GRAVITY;
	}
	
	public void Victory() {
	
	}
	public void checkHits() {
		
		double DistLH = Math.sqrt((LhandstartX - blastX) * (LhandstartX - blastX) + (LhandstartY - blastY) * (LhandstartY - blastY));
		if (DistLH <= DIAM/2 + 20) {
			LhandstartX += 1000000;
			Health -= 101;
			
		}
		double DistRH = Math.sqrt((RhandstartX - blastX) * (RhandstartX - blastX) + (RhandstartY - blastY) * (RhandstartY - blastY));
		if (DistRH <= DIAM/2 + 20) {
			RhandstartX += 1000000;
			Health -= 101;

		}
		double DistPH = Math.sqrt((PheadstartX - blastX) * (PheadstartX - blastX) + (PheadstartY - blastY) * (PheadstartY - blastY));
		if (DistPH <= DIAM/2 + 20) {
			PheadstartX += 1000000;
			Health -= 101;

		}
		double DistSH = Math.sqrt((SheartstartX - blastX) * (SheartstartX - blastX) + (SheartstartY - blastY) * (SheartstartY - blastY));
		if (DistSH <= DIAM/2 + 20) {
			SheartstartX += 1000000;
			Health -= 101;

		}
		double DistLF = Math.sqrt((LfootstartX - blastX) * (LfootstartX - blastX) + (LfootstartY - blastY) * (LfootstartY - blastY));
		if (DistLF <= DIAM/2 + 20) {
			LfootstartX += 1000000;
			Health -= 101;

		}
		double DistRF = Math.sqrt((RfootstartX - blastX) * (RfootstartX - blastX) + (RfootstartY - blastY) * (RfootstartY - blastY));
		if (DistRF <= DIAM/2 + 20) {
			RfootstartX += 1000000;
			Health -= 101;

		}
		if (Health < 0) {
			dead = true;
		}
		if (dead == true) {
		WinstartX = W_WIDTH/2;
		WinstartY = W_HEIGHT/2;
		}
		
	}
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	public void mousePressed(int mouseX, int mouseY) {
		
		startX = mouseX;
		startY = mouseY;
	
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		
		int distpulledbackX = mouseX - startX;
		int distpulledbackY = mouseY - startY;
		
		speedX = -distpulledbackX/10.0;
		speedY = -distpulledbackY/10.0;
	
		GravActive = true;
	}
	
	
	// draws everything in our project - the enemies, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		// draws a white background
		g.setColor(Color.black);
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		
		g.setColor(Color.red);
		g.fillRect(W_WIDTH/2 - 300, 100, Health, 30);
		
		// example of how to draw an image - draws at (100, 100) with width/height of 40/40
		g.drawImage(GollemHandB, RhandstartX ,RhandstartY, 40, 40, null);
		g.drawImage(GollemHandA, LhandstartX ,LhandstartY, 40, 40, null);
		g.drawImage(GollemHead, PheadstartX ,PheadstartY, 70, 70, null);
		g.drawImage(GollemHeart, SheartstartX ,SheartstartY, 60, 60, null);
		g.drawImage(GollemlegA, LfootstartX ,LfootstartY, 60, 60, null);
		g.drawImage(GollemlegB, RfootstartX ,RfootstartY, 60, 60, null);
		g.drawImage(WinScreen, WinstartX ,WinstartY, 140, 140, null);
		// your code here
		
		g.drawImage(Blast, (int) blastX,(int) blastY, DIAM, DIAM, null);
	}
	
	
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	public CrashTheGollem() {
		setup();
		
		JFrame frame = new JFrame();
		frame.setSize(W_WIDTH,W_HEIGHT);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				CrashTheGollem.this.mousePressed(e.getX(),e.getY());	
			}
			public void mouseReleased(MouseEvent e) {
				CrashTheGollem.this.mouseReleased(e.getX(),e.getY());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		run();
	}
	public static void main(String[] args) {
		new CrashTheGollem();
	}
}
