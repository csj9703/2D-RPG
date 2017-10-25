import java.awt.Graphics;

public class Square extends Shape{

	public Square(Point topLeft, int size) 
	{
		super(topLeft, size);
	}

	public void draw(Graphics g) {
		g.drawRect(getTopLeftPoint().getXCoord(), getTopLeftPoint().getYCoord(), 
				super.getSize(), super.getSize());
	}
	
	
	
}
