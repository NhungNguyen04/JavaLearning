package Bai11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class RotatingStarsFrame extends JFrame {
	
	public RotatingStarsFrame () {
		super( "Star circle" );
		
		setBackground( Color.white );
		setSize( 400, 400 );
		show();
	}
	
	public void paint( Graphics g ) {
		int xPoints[] = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
		int yPoints[] = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};
		
		Graphics2D g2d = (Graphics2D) g;
		
		GeneralPath star = new GeneralPath();
		star.moveTo (xPoints[0], yPoints[0]);
		
		for (int k = 1; k < xPoints.length; k++) 
			star.lineTo( xPoints[k], yPoints[k]); 
		
		star.closePath();
		g2d.translate( 200, 200 );
		
		for (int j = 1; j <= 20; j++) {
			g2d.rotate(Math.PI/10.0);
			g2d.setColor( 
				new Color(
					(int) (Math.random() * 256),
					(int) (Math.random() * 256),
					(int) (Math.random() * 256)
				)
			);
			g2d.fill(star);
		}
	}
	
	public static void main( String args[] ) {
		RotatingStarsFrame app = new RotatingStarsFrame();
		app.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
			}
		});
	}
}