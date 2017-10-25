import java.awt.Graphics;
/**
 * This parent class of Circle and Square
 * controls draws the shapes and controls the movements of the shapes.
 */
public abstract class Shape{
  private Point topLeft;
  private int size;

  /**
   * Constructor takes a point and a size.
   * @param topLeft A point in the window(x and y coordinates).
   * @param size The size of the shape in pixels.
   */
  public Shape(Point topLeft, int size)
  {
    this.topLeft = topLeft;
    this.size = size;
  }
/**
 * Moves the shape up.
 * @param amount The amount of pixels
 */
  public void moveUp(int amount)
  {
		topLeft.moveUp(amount);
	}
  /**
   * Moves the shape down.
   * @param amount The amount of pixels to move.
   */
  public void moveDown(int amount)
  {
    topLeft.moveDown(amount);
  }
  /**
   * Moves the shape left.
   * @param amount The amount of pixels to move.
   */
  public void moveLeft(int amount)
  {
		topLeft.moveLeft(amount);
	}
  /**
   * Moves the shape right.
   * @param amount The amount of pixels to move.
   */
  public void moveRight(int amount)
  {
		topLeft.moveRight(amount);
	}
/**
 * This method draws the shape.
 * @param g graphic object
 */
  public abstract void draw(Graphics g);

  public Point getTopLeftPoint()
  {
    return new Point(topLeft.getXCoord(),topLeft.getYCoord());
  }
/**
 * Getter Method for size, returns size.
 */
  public int getSize()
  {
    return new Integer(size);
  }






}
