import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;


public class Monopoly extends JApplet{

	Color board;
	Color brown;
	Color lightBlue;
	Color magenta;
	Color darkYellow;
	Color red;
	Color yellow;
	Color green;
	Color darkBlue;
	Color orange;
	Font font;
	Font fontTwo;
	Font goFont;
	Font jailFont;
	Font gotoJail;
	Font propertyName;
	Font bigCommChest;
	
	@Override
	public void init()
	{
		setLayout(new FlowLayout());
		board= new Color(178, 255, 178);
		brown= new Color(102, 51, 0);
		lightBlue= new Color(102, 178, 255);
		magenta= new Color(153, 0, 76);
		darkYellow= new Color(204, 204, 0);
		red= new Color(255,0, 0);
		yellow= new Color(255, 255, 0);
		green= new Color(0, 204, 0);
		darkBlue= new Color(0, 0, 204);
		orange= new Color(255, 153, 51);
		font= new Font("Serif", Font.BOLD, 60);
		fontTwo= new Font("Serif", Font.BOLD, 100);
		goFont= new Font("Serif", Font.BOLD, 30);
		jailFont= new Font("Serif", Font.BOLD, 20);
		gotoJail= new Font("Serif", Font.BOLD, 10);
		propertyName= new Font("Serif", Font.PLAIN, 9);
		bigCommChest = new Font("Serif",Font.BOLD,60);
	}
	
	@Override
	public void paint(Graphics g)									//Draws the gui
	{  
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform at= new AffineTransform();
		super.paint(g);
		
		drawBoard(g, g2d, at);					//draws the overall structure of the board
		
		
		
		
		tokenOne(g);
		tokenTwo(g);
		tokenThree(g);
		tokenFour(g);
		jail(g, g2d, at);							//draws the jail and go to jail corner
		badgeColor(g, g2d, at);					//draws color badges for properties
		house(g);
		hotel(g);
		bottomRow(g, g2d,at);					//text for bottom row
		topRow(g, g2d,at);						//text for top row
		rightSide(g, g2d, at);					//text for right row
		leftSide(g, g2d, at);					//text for left row
		middle(g, g2d,at);						//draws chance cards and monopoly logo
		

	}
	public void hotel(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(585, 603, 12, 15);
		g.setColor(Color.black);
		g.drawRect(585, 603, 12, 15);
		g.fillRect(589, 606, 2, 2);
		g.fillRect(593, 606, 2, 2);
		g.fillRect(589, 610, 2, 2);
		g.fillRect(593, 610, 2, 2);
		g.fillRect(589, 614, 2, 2);
		g.fillRect(593, 614, 2, 2);
	}
	
	public void house(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillArc(565, 605, 10, 10, 0, 180);
		g.fillRect(567, 610, 6, 6);
		g.setColor(Color.BLACK);
		g.drawArc(565, 605, 10, 10, 0, 180);
		g.drawRect(567, 610, 6, 6);
	}
	
	public void tokenFour(Graphics g)
	{
		g.setColor(yellow);
		g.fillOval(640, 602, 15, 15);
		g.setColor(Color.BLACK);
		g.fillRect(645, 607, 1, 1);
		g.fillRect(650, 607, 1, 1);
		g.drawArc(644, 608, 8, 4, 0, -180);
	}
	
	public void tokenThree(Graphics g)
	{
		g.setColor(red);
		g.fillRect(668, 602, 3, 12);
		g.setColor(Color.BLACK);
		g.fillRect(667, 614, 6, 6);
		g.drawRect(668, 603, 3, 12);
	}
	
	public void tokenTwo(Graphics g)
	{
		g.setColor(yellow);
		g.fillOval(650, 642, 7, 5);
		g.fillRect(650, 646, 7, 7);
		g.fillOval(647, 651, 13, 7);
		g.setColor(Color.BLACK);
		g.fillRect(652, 647, 1, 1);
		g.fillRect(654, 647, 1, 1);
	}
	public void tokenOne(Graphics g)
	{
		g.setColor(darkYellow);
		g.fillOval(668,648,11,11);
		g.setColor(Color.WHITE);
		g.fillOval(671, 651, 5, 5);
		g.setColor(lightBlue);
		g.fillOval(670, 643, 7, 7);
	}
	
	public void middle(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setColor(red);
		at.setToRotation(-Math.PI/4.5, 180, 430);
		g2d.setTransform(at);
		g2d.fillRect(180, 430, 420, 60);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g2d.drawString("MONOPOLY", 220, 480);
		
		g.setColor(lightBlue);
		at.setToRotation(-Math.PI/4.5, 120, 200);
		g2d.setTransform(at);
		g2d.fillRect(120, 200, 160, 100);
		g.setColor(Color.WHITE);
		g.setFont(jailFont);
		g2d.drawString("COMMUNITY", 140, 240);
		g2d.drawString("CHEST", 170, 270);
		
		g.setColor(orange);
		at.setToRotation(-Math.PI/4.5, 410, 500);
		g2d.setTransform(at);
		g2d.fillRect(410, 500, 160, 100);
		g.setColor(Color.WHITE);
		g.setFont(fontTwo);
		g2d.drawString("?", 465, 580);
	}
	
	public void leftSide(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setColor(Color.BLACK);
		g.setFont(propertyName);
		at.setToRotation(Math.PI/2.0, 50, 65);
		g2d.setTransform(at);
		g2d.drawString("NEW YORK", 50, 65);
		at.setToRotation(Math.PI/2.0, 40, 70);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 40, 70);
		at.setToRotation(Math.PI/2.0, 20, 80);
		g2d.setTransform(at);
		g2d.drawString("$200", 20, 80);
		
		at.setToRotation(Math.PI/2.0, 50, 125);
		g2d.setTransform(at);
		g2d.drawString("TENNESSEE", 50, 125);
		at.setToRotation(Math.PI/2.0, 40, 130);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 40, 130);
		at.setToRotation(Math.PI/2.0, 20, 140);
		g2d.setTransform(at);
		g2d.drawString("$180", 20, 140);
		
		at.setToRotation(Math.PI/2.0, 50, 250);
		g2d.setTransform(at);
		g2d.drawString("ST. JAMES", 50, 250);
		at.setToRotation(Math.PI/2.0, 40, 255);
		g2d.setTransform(at);
		g2d.drawString("PLACE", 40, 255);
		at.setToRotation(Math.PI/2.0, 20, 260);
		g2d.setTransform(at);
		g2d.drawString("$180", 20, 260);
		
		at.setToRotation(Math.PI/2.0, 50, 370);
		g2d.setTransform(at);
		g2d.drawString("VIRGINIA", 50, 370);
		at.setToRotation(Math.PI/2.0, 40, 370);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 40, 370);
		at.setToRotation(Math.PI/2.0, 20, 380);
		g2d.setTransform(at);
		g2d.drawString("$160", 20, 380);
		
		at.setToRotation(Math.PI/2.0, 50, 435);
		g2d.setTransform(at);
		g2d.drawString("STATES", 50, 435);
		at.setToRotation(Math.PI/2.0, 40, 430);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 40, 430);
		at.setToRotation(Math.PI/2.0, 20, 440);
		g2d.setTransform(at);
		g2d.drawString("$140", 20, 440);
		
		at.setToRotation(Math.PI/2.0, 50, 543);
		g2d.setTransform(at);
		g2d.drawString("ST. CHARLES", 50, 543);
		at.setToRotation(Math.PI/2.0, 40, 555);
		g2d.setTransform(at);
		g2d.drawString("PLACE", 40, 555);
		at.setToRotation(Math.PI/2.0, 20, 560);
		g2d.setTransform(at);
		g2d.drawString("$140", 20, 560);
		
		at.setToRotation(Math.PI/2.0, 50, 182);
		g2d.setTransform(at);
		g2d.drawString("COMMUNITY", 50, 182);
		at.setToRotation(Math.PI/2.0, 40, 195);
		g2d.setTransform(at);
		g2d.drawString("CHEST", 40, 195);
		
		g.setFont(gotoJail);
		at.setToRotation(Math.PI/2.0, 50, 307);
		g2d.setTransform(at);
		g2d.drawString("PENNSYL-", 50, 307);
		at.setToRotation(Math.PI/2.0, 40, 312);
		g2d.setTransform(at);
		g2d.drawString("VANIA", 40, 312);
		at.setToRotation(Math.PI/2.0, 30, 305);
		g2d.setTransform(at);		
		g2d.drawString("RAILROAD", 30, 305);
		at.setToRotation(Math.PI/2.0, 20, 320);
		g2d.setTransform(at);
		g2d.drawString("$200", 20, 320);
		
		at.setToRotation(Math.PI/2.0, 50, 485);
		g2d.setTransform(at);
		g2d.drawString("ELECTRIC", 50, 485);
		at.setToRotation(Math.PI/2.0, 40, 485);
		g2d.setTransform(at);
		g2d.drawString("COMPANY", 40, 485);
	}
	public void rightSide(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setColor(darkYellow);
		g.setFont(font);
		at.setToRotation(-Math.PI/2.0, 670, 405);
		g2d.setTransform(at);
		g2d.drawString("?", 670, 405);
		
		g.setColor(Color.BLACK);
		g.setFont(propertyName);
		at.setToRotation(-Math.PI/2.0, 650, 110);
		g2d.setTransform(at);
		g2d.drawString("PACIFIC", 650, 110);
		at.setToRotation(-Math.PI/2.0, 660, 112);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 660, 112);
		at.setToRotation(-Math.PI/2.0, 680, 100);
		g2d.setTransform(at);
		g2d.drawString("$300", 680, 100);
		
		at.setToRotation(-Math.PI/2.0, 650, 170);
		g2d.setTransform(at);
		g2d.drawString("NORTH", 650, 170);
		at.setToRotation(-Math.PI/2.0, 660, 175);
		g2d.setTransform(at);
		g2d.drawString("CAROLINA", 660, 175);
		at.setToRotation(-Math.PI/2.0, 670, 172);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 670, 172);
		at.setToRotation(-Math.PI/2.0, 680, 160);
		g2d.setTransform(at);
		g2d.drawString("$300", 680, 160);
		
		at.setToRotation(-Math.PI/2.0, 650, 293);
		g2d.setTransform(at);
		g2d.drawString("PENNSYL-", 650, 293);
		at.setToRotation(-Math.PI/2.0, 660, 285);
		g2d.setTransform(at);
		g2d.drawString("VANIA", 660, 285);
		at.setToRotation(-Math.PI/2.0, 670, 292);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 670, 292);
		at.setToRotation(-Math.PI/2.0, 680, 280);
		g2d.setTransform(at);
		g2d.drawString("$320", 680, 280);
		
		at.setToRotation(-Math.PI/2.0, 650, 463);
		g2d.setTransform(at);
		g2d.drawString("PARK", 650, 463);
		at.setToRotation(-Math.PI/2.0, 660, 465);
		g2d.setTransform(at);
		g2d.drawString("PLACE", 660, 465);
		at.setToRotation(-Math.PI/2.0, 680, 460);
		g2d.setTransform(at);
		g2d.drawString("$350", 680, 460);
		
		at.setToRotation(-Math.PI/2.0, 650, 585);
		g2d.setTransform(at);
		g2d.drawString("BOARD-", 650, 585);
		at.setToRotation(-Math.PI/2.0, 660, 585);
		g2d.setTransform(at);
		g2d.drawString("WALK", 660, 585);
		at.setToRotation(-Math.PI/2.0, 680, 580);
		g2d.setTransform(at);
		g2d.drawString("$400", 680, 580);
		
		at.setToRotation(-Math.PI/2.0, 650, 240);
		g2d.setTransform(at);
		g2d.drawString("COMMUNITY", 650, 240);
		at.setToRotation(-Math.PI/2.0, 660, 230);
		g2d.setTransform(at);
		g2d.drawString("CHEST", 660, 230);
		
		g.setFont(gotoJail);
		at.setToRotation(-Math.PI/2.0, 650, 350);
		g2d.setTransform(at);
		g2d.drawString("SHORT", 650, 350);
		at.setToRotation(-Math.PI/2.0, 660, 345);
		g2d.setTransform(at);
		g2d.drawString("LINE", 660, 345);
		at.setToRotation(-Math.PI/2.0, 680, 340);
		g2d.setTransform(at);
		g2d.drawString("$200", 680, 340);
		
		at.setToRotation(-Math.PI/2.0, 650, 530);
		g2d.setTransform(at);
		g2d.drawString("LUXURY", 650, 530);
		at.setToRotation(-Math.PI/2.0, 660, 525);
		g2d.setTransform(at);
		g2d.drawString("TAX", 660, 525);
	}
	
	public void bottomRow(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setFont(propertyName);
		g.setColor(Color.BLACK);
		g.drawString("CONNECTI-", 87, 630);
		g.drawString("CUT", 100, 640);
		g.drawString("AVENUE", 90, 650);
		g.drawString("$120", 100, 660);
		
		g.drawString("VERMONT", 147, 630);
		g.drawString("AVENUE", 150, 640);
		g.drawString("$100", 160, 660);
		
		g.drawString("ORIENTAL", 267, 630);
		g.drawString("AVENUE", 270, 640);
		g.drawString("$100", 280, 660);
		
		
		g.drawString("BALTIC", 455, 630);
		g.drawString("AVENUE", 450, 640);
		g.drawString("$60", 460, 660);
		
		g.drawString("MEDITER-", 570, 630);
		g.drawString("RANEAN", 570, 640);
		g.drawString("AVENUE", 570, 650);
		g.drawString("$60", 580, 660);

		g.setFont(gotoJail);
		g.drawString("READING", 329, 630);
		g.drawString("RAILROAD", 325, 640);
		g.drawString("$200", 340, 660);
		
		g.drawString("INCOME", 390, 635);
		g.drawString("TAX", 400, 645);
		
		g.setFont(propertyName);
		g.drawString("COMMUNITY", 501, 635);
		g.drawString("CHEST", 515, 645);
	}
	
	public void topRow(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setColor(magenta);
		g.setFont(font);
		g.drawString("?", 215, 650);
		//
		//
		
		
		g.setColor(lightBlue);
		g.setFont(font);
		at.setToRotation(-Math.PI/1.0, 185, 10);
		g2d.setTransform(at);
		g2d.drawString("?", 185, 10);
		
		g.setColor(Color.BLACK);
		g.setFont(propertyName);
		at.setToRotation(-Math.PI/1.0, 136, 30);
		g2d.setTransform(at);
		g2d.drawString("KENTUCKY", 136, 30);
		at.setToRotation(-Math.PI/1.0, 130, 20);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 130, 20);
		at.setToRotation(-Math.PI/1.0, 120, 0);
		g2d.setTransform(at);
		g2d.drawString("$220", 120, 0);
		
		at.setToRotation(-Math.PI/1.0, 253, 30);
		g2d.setTransform(at);
		g2d.drawString("INDIANA", 256, 30);
		at.setToRotation(-Math.PI/1.0, 250, 20);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 250, 20);
		at.setToRotation(-Math.PI/1.0, 240, 0);
		g2d.setTransform(at);
		g2d.drawString("$220", 240, 0);
		
		at.setToRotation(-Math.PI/1.0, 313, 30);
		g2d.setTransform(at);
		g2d.drawString("ILLINOIS", 316, 30);
		at.setToRotation(-Math.PI/1.0, 310, 20);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 310, 20);
		at.setToRotation(-Math.PI/1.0, 300, 0);
		g2d.setTransform(at);
		g2d.drawString("$240", 300, 0);
		
		at.setToRotation(-Math.PI/1.0, 434, 30);
		g2d.setTransform(at);
		g2d.drawString("ATLANTIC", 434, 30);
		at.setToRotation(-Math.PI/1.0, 430, 20);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 430, 20);
		at.setToRotation(-Math.PI/1.0, 420, 0);
		g2d.setTransform(at);
		g2d.drawString("$260", 420, 0);
		
		at.setToRotation(-Math.PI/1.0, 494, 30);
		g2d.setTransform(at);
		g2d.drawString("VENTNOR", 494, 30);
		at.setToRotation(-Math.PI/1.0, 490, 20);
		g2d.setTransform(at);
		g2d.drawString("AVENUE", 490, 20);
		at.setToRotation(-Math.PI/1.0, 480, 0);
		g2d.setTransform(at);
		g2d.drawString("$260", 480, 0);

		at.setToRotation(-Math.PI/1.0, 610, 30);
		g2d.setTransform(at);
		g2d.drawString("MARVIN", 610, 30);
		at.setToRotation(-Math.PI/1.0, 614, 20);
		g2d.setTransform(at);
		g2d.drawString("GARDENS", 614, 20);
		at.setToRotation(-Math.PI/1.0, 600, 0);
		g2d.setTransform(at);
		g2d.drawString("$280", 600, 0);
		
		g.setFont(gotoJail);
		at.setToRotation(-Math.PI/1.0, 363, 30);
		g2d.setTransform(at);
		g2d.drawString("B & 0", 363, 30);
		at.setToRotation(-Math.PI/1.0, 377, 20);
		g2d.setTransform(at);
		g2d.drawString("RAILROAD", 377, 20);
		at.setToRotation(-Math.PI/1.0, 360, 0);
		g2d.setTransform(at);
		g2d.drawString("$200", 360, 0);
		
		at.setToRotation(-Math.PI/1.0, 550, 30);
		g2d.setTransform(at);
		g2d.drawString("WATER", 550, 30);
		at.setToRotation(-Math.PI/1.0, 550, 20);
		g2d.setTransform(at);
		g2d.drawString("WORKS", 550, 20);
		at.setToRotation(-Math.PI/1.0, 540, 0);
		g2d.setTransform(at);
		g2d.drawString("$150", 540, 0);
		
	}
	
	public void badgeColor(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setColor(brown);
		g.fillRect(560, 600, 60, 20);
		g.fillRect(440, 600, 60, 20);
		g.setColor(Color.BLACK);
		g.drawRect(560, 600, 60, 20);
		g.drawRect(440, 600, 60, 20);
		
		g.setColor(lightBlue);
		g.fillRect(80, 600, 60, 20);
		g.fillRect(140, 600, 60, 20);
		g.fillRect(260, 600, 60, 20);
		g.setColor(Color.BLACK);
		g.drawRect(80, 600, 60, 20);
		g.drawRect(140, 600, 60, 20);
		g.drawRect(260, 600, 60, 20);
		
		g.setColor(red);
		g.fillRect(80, 40, 60, 20);
		g.fillRect(200, 40, 60, 20);
		g.fillRect(260, 40, 60, 20);
		g.setColor(Color.BLACK);
		g.drawRect(80, 40, 60, 20);
		g.drawRect(200, 40, 60, 20);
		g.drawRect(260, 40, 60, 20);
		
		g.setColor(yellow);
		g.fillRect(380, 40, 60, 20);
		g.fillRect(440, 40, 60, 20);
		g.fillRect(560, 40, 60, 20);
		g.setColor(Color.BLACK);
		g.drawRect(380, 40, 60, 20);
		g.drawRect(440, 40, 60, 20);
		g.drawRect(560, 40, 60, 20);
		
		g.setColor(darkYellow);
		g.fillRect(60, 60, 20, 60);
		g.fillRect(60, 120, 20, 60);
		g.fillRect(60, 240, 20, 60);
		g.setColor(Color.BLACK);
		g.drawRect(60, 60, 20, 60);
		g.drawRect(60, 120, 20, 60);
		g.drawRect(60, 240, 20, 60);
		
		g.setColor(magenta);
		g.fillRect(60, 360, 20, 60);
		g.fillRect(60, 420, 20, 60);
		g.fillRect(60, 540, 20, 60);
		g.setColor(Color.BLACK);
		g.drawRect(60, 360, 20, 60);
		g.drawRect(60, 420, 20, 60);
		g.drawRect(60, 540, 20, 60);
		
		g.setColor(green);
		g.fillRect(620, 60, 20, 60);
		g.fillRect(620, 120, 20, 60);
		g.fillRect(620, 240, 20, 60);
		g.setColor(Color.BLACK);
		g.drawRect(620, 60, 20, 60);
		g.drawRect(620, 120, 20, 60);
		g.drawRect(620, 240, 20, 60);
		
		g.setColor(darkBlue);
		g.fillRect(620, 420, 20, 60);
		g.fillRect(620, 540, 20, 60);
		g.setColor(Color.BLACK);
		g.drawRect(620, 420, 20, 60);
		g.drawRect(620, 540, 20, 60);
	}
	
	public void drawBoard(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		g.setColor(board);
		g.fillRect(20, 0, 660, 660);
		g.setColor(Color.BLACK);
		g.drawRect(20, 0, 660, 660);
		
		g.setColor(Color.BLACK);
		g.drawLine(80, 0, 80, 660);
		g.drawLine(140, 0, 140, 660);
		g.drawLine(200, 0, 200, 660);
		g.drawLine(260, 0, 260, 660);
		g.drawLine(320, 0, 320, 660);
		g.drawLine(380, 0, 380, 660);
		g.drawLine(440, 0, 440, 660);
		g.drawLine(500, 0, 500, 660);
		g.drawLine(560, 0, 560, 660);
		g.drawLine(620, 0, 620, 660);
		g.drawLine( 20, 60, 680, 60);
		g.drawLine( 20,120, 680,120);
		g.drawLine( 20,180, 680,180);
		g.drawLine( 20,240, 680,240);
		g.drawLine( 20,300, 680,300);
		g.drawLine( 20,360, 680,360);
		g.drawLine( 20,420, 680,420);
		g.drawLine( 20,480, 680,480);
		g.drawLine( 20,540, 680,540);
		g.drawLine( 20,600, 680,600);
		
		g.setColor(board);
		g.fillRect(80, 60, 540, 540);
		g.setColor(Color.BLACK);
		g.drawRect(80, 60, 540, 540);
	}
	public void jail(Graphics g, Graphics2D g2d, AffineTransform at)
	{
		//jail
		g.setColor(darkYellow);
		g.fillRect(20, 620, 60, 40);
		g.setColor(Color.BLACK);
		g.drawRect(20, 620, 60, 40);
		g.fillRect(29, 620, 5, 40);
		g.fillRect(47, 620, 5, 40);
		g.fillRect(67, 620, 5, 40);
		g.setFont(jailFont);
		g.drawString("JAIL", 27, 617);
		
		//goto jail
		g.setColor(darkYellow);
		g.fillRect(620, 20, 60, 40);
		g.setColor(Color.BLACK);
		g.drawRect(620, 20, 60, 40);
		g.fillRect(629, 20, 5, 40);
		g.fillRect(647, 20, 5, 40);
		g.fillRect(667, 20, 5, 40);
		g.setFont(gotoJail);
		g.drawString("GO-TO JAIL", 621, 15);
		
		//free parking
		g.setColor(Color.BLACK);
		g.setFont(gotoJail);
		g.drawString("FREE", 35, 25);
		g.drawString("PARKING", 27, 37);
		
		//go
		g.setColor(Color.BLACK);
		g.setFont(goFont);
		g.drawString("GO", 630, 640);
	}
}
