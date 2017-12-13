// Brandon Piper
// cmps109 Winter 2005
// Program Project #3

/*  Polygon.class:
 *      The polygon class implements the interface Shape.
 *      It keeps track of all the points in a polygon.
 *      Also provides a method that allows points to be
 *      added to a specific polygon.
 */

class Polygon implements Shape{

    private int maxPoints = 0;
    private int numPoints = 0;
    private int[] xValues; 
    private int[] yValues;

    public Polygon( int maxPoints ){
        this.maxPoints = maxPoints;
        this.xValues = new int[maxPoints];
        this.yValues = new int[maxPoints];
        for( int i = 0; i < maxPoints; i++ ){
            this.xValues[i] = -1;
            this.yValues[i] = -1;
        }
    }

    public void add( int x, int y ){
        xValues[numPoints] = x;
        yValues[numPoints] = y;
        numPoints ++;
    }

    public void draw( TGraphics graphics ){
        int i = 0;
        for(; i < numPoints - 1; i++ ){
            graphics.drawLine(xValues[i],yValues[i],
                              xValues[i+1],yValues[i+1]);
        }
        graphics.drawLine(xValues[i],yValues[i],
                          xValues[0],yValues[0]);
    }
}

