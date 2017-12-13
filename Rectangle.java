// Brandon Piper
// cmps109 Winter 2005
// Program Project #3

/*  Rectangle.class:
 *      The Rectangle class implements the interface Shape.
 *      It keeps track of the dimensions of the rectangle.
 */

class Rectangle implements Shape{
   
    private int left;
    private int top;
    private int width;
    private int height;

    public Rectangle(int left, int top, int width, int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }   

    public void draw( TGraphics graphics ){
        graphics.drawVerticalLine(left,top,height);
        graphics.drawVerticalLine(left+width,top,height);
        graphics.drawHorizontalLine(left,top,width);
        graphics.drawHorizontalLine(left,top+height,width);
    }
}

