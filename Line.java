// Brandon Piper
// cmps109 Winter 2005
// Program Project #3

/*  Line.class:
 *      The Line class implements the interface Shape.
 *      It keeps track of the points that form the line.
 */

class Line implements Shape{

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line( int x1, int y1, int x2, int y2 ){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    } 

    public void draw( TGraphics graphics ){
        graphics.drawLine( x1, y1, x2, y2 );
    }
}





