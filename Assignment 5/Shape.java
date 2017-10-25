import java.awt.Graphics;

public abstract class Shape{
  private Point topLeft;
  private int size;

  public Shape(Point topLeft, int size)
  {
    this.topLeft = topLeft;
    this.size = size;
  }

  public void moveUp(int amount)
  {
		topLeft.moveUp(amount);
	}

  public void moveDown(int amount)
  {
    topLeft.moveDown(amount);
  }

  public void moveLeft(int amount)
  {
		topLeft.moveLeft(amount);
	}

  public void moveRight(int amount)
  {
		topLeft.moveRight(amount);
	}

  public abstract void draw(Graphics g);

  public Point getTopLeftPoint()
  {
    return topLeft;
  }

  public int getSize()
  {
    return size;
  }






}
