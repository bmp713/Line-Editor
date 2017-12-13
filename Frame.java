// Brandon Piper
// cmps109 Winter 2005
// Program Project #3

/*  Frame.class:
 *     The Frame class implements the interface TFrame.
 *     An arraylist keeps track of all shapes that are  
 *     in the shape at any one time.
 */

import java.util.*;

class Frame implements TFrame{
    private int xDim = 0; 
    private int yDim = 0;
    TGraphics display;    // the display

    //Structure to keep track of each shape
    ArrayList<Shape> shapes;
    
    public Frame( int xDim, int yDim ){
        this.xDim = xDim;
        this.yDim = yDim;
        display = new ConsoleGraphics( xDim, yDim );
        shapes = new ArrayList<Shape>();
    }
    
    public void add(Shape shape){
        shapes.add( shape );
    }
    
    public boolean remove(Shape shape){
        if( shapes.contains(shape) ){
            shapes.remove( shape );
            return true;
        }
        return false;
    }
    
    public void clear(){
        while( !shapes.isEmpty() )
            remove( shapes.get(0) );
    }
    
    //iterate over each shape and insert them in
    //the display then show the display.  only
    //insert in the display to show it.
    public void show(){
        for( int i = 0; i < shapes.size(); i++ ){
            Shape curr = shapes.get(i);
            curr.draw( display );
        }
        display.render();
    }
}




