import java.awt.Graphics;
import java.awt.Rectangle;

public class Circle extends Shape{

	public Circle(Point topLeft, int size)
	{
		super(topLeft,size);
	}

	public void draw(Graphics g){
		g.drawOval(getTopLeftPoint().getXCoord(), getTopLeftPoint().getYCoord(),
				super.getSize() * 2,
				super.getSize() * 2);
	}

}
