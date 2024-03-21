import java.awt.*;
import java.awt.geom.*;
import javax.swing.Icon;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * ClockIcon class is responsible for drawing the clock
 */
public class ClockIcon implements Icon{
	
	//ClockIcon Fields
	private int width;
	private int radius;
	private Point2D.Double centerPoint;
	final double NUM = 0.92;
	final double HOUR = 0.50;
	final double MINUTE = 0.70;
	final double SECOND = 0.75;
	
	

	/**
	 * Constructor 
	 */
	public ClockIcon(int width){
		this.width = width;
		radius = width/2;
	}
	
	/**
	 * width getter
	 */
	@Override
	public int getIconWidth() {
		return width;
	}
	
	/**
	 * height getter
	 */
	@Override
	public int getIconHeight() {
		return width;
	}

	/*
	 * endingPoint to find the point with the given proportion and angle
	 * @param double proportion and  int angle
	 * @return Point2D.Double 
	 */
	public Point2D.Double endingPoint(double prop, int z) {
		
		double leng = prop * radius;
		double rad = z * 6 * Math.PI/180;

		double yCoordinate = centerPoint.y - leng * Math.cos(rad);
		double xCoordinate = centerPoint.x + leng * Math.sin(rad);
		return new Point2D.Double( xCoordinate, yCoordinate);
	}

	/*
	 * paint the clock
	 * 
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		centerPoint = new Point2D.Double(radius,radius);
		
		g2.setColor(Color.BLACK);
		g2.drawOval(x, y, width, width);
		
		g2.setColor(Color.BLACK);
		for(int i =0; i<60; i++){
			Point2D.Double point = endingPoint(NUM,i);
			if(i%5!=0)
				g2.drawString(".", (float) point.x, (float)point.y);
		}
		
		GregorianCalendar curentTime = new GregorianCalendar();
		int hours = curentTime.get(Calendar.HOUR);
		int minutes = curentTime.get(Calendar.MINUTE);
		int second = curentTime.get(Calendar.SECOND);
		hours = ((hours % 12) *5)+ (int) (5*minutes/60.0);
		
		g2.setColor(Color.GREEN);
		g2.drawLine((int)centerPoint.x, (int)centerPoint.y, (int)endingPoint(HOUR, hours).x, (int)endingPoint(HOUR, hours).y);
		g2.setColor(Color.RED);
		g2.drawLine((int)centerPoint.x, (int)centerPoint.y, (int)endingPoint(MINUTE,minutes).x, (int)endingPoint(MINUTE,minutes).y);
		g2.setColor(Color.BLUE);
		g2.drawLine((int)centerPoint.x, (int)centerPoint.y, (int)endingPoint(SECOND,second).x, (int)endingPoint(SECOND,second).y);
		
		g2.setColor(Color.BLACK);
		g2.drawString("XII",(float) endingPoint(NUM,0).x, (float)endingPoint(NUM,0).y); 
		g2.drawString("I", (float) endingPoint(NUM,5).x, (float)endingPoint(NUM,5).y); 
		g2.drawString("II", (float) endingPoint(NUM,10).x, (float)endingPoint(NUM,10).y);
		g2.drawString("III", (float) endingPoint(NUM,15).x, (float)endingPoint(NUM,15).y); 
		g2.drawString("IV", (float) endingPoint(NUM,20).x, (float)endingPoint(NUM,20).y);
		g2.drawString("V", (float) endingPoint(NUM,25).x, (float)endingPoint(NUM,25).y);
		g2.drawString("VI", (float) endingPoint(NUM,30).x, (float)endingPoint(NUM,30).y);
		g2.drawString("VII", (float) endingPoint(NUM,35).x, (float)endingPoint(NUM,35).y);
		g2.drawString("VIII", (float) endingPoint(NUM,40).x, (float)endingPoint(NUM,40).y);
		g2.drawString("IX", (float) endingPoint(NUM,45).x, (float)endingPoint(NUM,45).y); 
		g2.drawString("X", (float) endingPoint(NUM,50).x, (float)endingPoint(NUM,50).y); 
		g2.drawString("XI", (float) endingPoint(NUM,55).x, (float)endingPoint(NUM,55).y); 
		
		
	}
	
}
