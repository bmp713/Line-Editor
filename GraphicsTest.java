// Brandon Piper
// cmps109 Winter 2005
// Program Project #3

/*  GraphicsTest.java:
 *      This class tests all of the Shape classes and
 *      drawing classes.  The program keeps track of
 *      various frames and Shapes within the frames
 *      Allows the user to add or remove different
 *      elements in the frames.
 *
 *  Note to grader:
 *      I have tested this code very thoroughly and it seems
 *      to work perfectly as long as the input is always valid.
 *      It will crash if any command is missing an argument.
 */

import tio.*;
import java.util.*;

/*  Frames.class:
 *      An instance of Frames keeps track of the number
 *      of frames and their content in the program.
 */
class Frames{
    int numFrames = 0;
    int currId = 0;
    
    // stores one FrameInfo object for each frame id.    
    HashMap<Integer,FrameInfo> frames = new HashMap<Integer,FrameInfo>();  
    FrameInfo currFrame;     // pointer to current FrameInfo object. 
}

/*  FrameInfo.class:
 *      An instance of FrameInfo keeps track of the content
 *      of one individual Frame object through the use of
 *      a HashMap structure.  The HashMap specifically
 *      stores references to all shapes stored in the Frame.
 */
class FrameInfo{
    int frameId;                     // frames id number.
    int numShapes = 0;               // number of shapes.
    TFrame frame;                    // the actual frame.
    HashMap<Integer,Shape> shapes;   // stores id and each shape.

    public FrameInfo(int id, int width, int length){
        frameId = id;
        frame = new Frame(width, length);
        shapes = new HashMap<Integer,Shape>();
   }
}

/*  GraphicsTest.class:
 *      The main method reads in commands lines one at
 *      a time and sends them to parseCommands() to be
 *      parsed into their individual operations.
 */
class GraphicsTest{    
    private Frames[] framesT = new Frames[5];

    public static void main( String[] args ){
        boolean quiet = false;
	
        Frames theFrames = new Frames(); // Stores info for all the frames.   
        
        if( args.length > 0 )
            if( args[0].equals("-q") ) 
                quiet = true;  
        
        if( !quiet ) System.out.print("enter command>"); 
        String commands = Console.in.readLine(); 
        while( !commands.equals("q") ){ 
            theFrames = parseCommands( commands, theFrames ); 
            
            if( !quiet ) System.out.print("enter command>"); 
            commands = Console.in.readLine(); 
        } 
    }

/*  parseCommands() takes in a command line and an instance of Frames.
 *  It then uses StringTokenizer to break the line into individual
 *  operations and calls appropriate methods to process those commands.
 */
    static Frames  parseCommands( String commands, Frames theFrames ){ 
        StringTokenizer line = new StringTokenizer(commands); 
         
        while( line.hasMoreTokens() ){ 
            String token = line.nextToken(); 
             
            if( token.equals("f") ){ 
                theFrames = createFrame(line, theFrames);
            } 
            else if( token.equals("r") ){ 
                theFrames = createRectangle(line, theFrames);
            }
            else if( token.equals("l") ){ 
                theFrames = createLine(line, theFrames);
            } 
            else if( token.equals("p") ){ 
                theFrames = createPolygon(line, theFrames);
            } 
            else if( token.equals("d") ){ 
                theFrames.currFrame.frame.show();
            } 
            else if( token.equals("s") ){ 
                int id = Integer.parseInt( line.nextToken() ); 
                Integer key = new Integer( id );
                if(theFrames.frames.containsKey( key ) ){
                    theFrames.currFrame = (FrameInfo)theFrames.frames.get(key);
                    theFrames.currFrame.frame.show();
                }
                else System.out.println("No frame with id "+id);
            } 
            else if( token.equals("c") ){ 
                theFrames.currFrame.frame.clear();
                theFrames.currFrame.shapes.clear();
            } 
            else if( token.equals("x") ){ 
                int id = Integer.parseInt( line.nextToken() ); 
                Integer key = new Integer( id );
                Shape value = (Shape)theFrames.currFrame.shapes.remove(key); 
                
                theFrames.currFrame.frame.remove( value );
                theFrames.currFrame.numShapes --;
            } 
        }
        return theFrames;
    }
    
/*  createFrame() takes in a specific command and the Frames object.
 *  It then parses the command into each token and creates a new
 *  frame based on those tokens.  It then returns the updated Frames.
 */
    static Frames createFrame( StringTokenizer line, Frames theFrames ){
        int id     = Integer.parseInt( line.nextToken() ); 
        int width  = Integer.parseInt( line.nextToken() ); 
        int height = Integer.parseInt( line.nextToken() ); 
        
        Integer key = new Integer( id );
        FrameInfo value = new FrameInfo(key, width, height);
        
        value.frameId = id;
        theFrames.frames.put(key, value);
        theFrames.currFrame = value;
        theFrames.numFrames ++;
        theFrames.currId = id;
        
        return theFrames;
    }

/*  createLine() takes in a specific command and the Frames object.
 *  It then parses the command into each token and creates a new
 *  line based on those tokens.  It then returns the updated Frames.
 */
    static Frames createLine(StringTokenizer line, Frames theFrames){
        int id = Integer.parseInt( line.nextToken() ); 
        int x1 = Integer.parseInt( line.nextToken() ); 
        int y1 = Integer.parseInt( line.nextToken() ); 
        int x2 = Integer.parseInt( line.nextToken() ); 
        int y2 = Integer.parseInt( line.nextToken() ); 
        
        Integer key = new Integer( id ); 
        Line value = new Line(x1, y1, x2, y2); 
        
        if(theFrames.currFrame.shapes.containsKey(key)){
            System.out.print("Warning: replacing existing object ");
            System.out.println("with id: "+id);
            Shape temp = (Shape)theFrames.currFrame.shapes.remove(key);
            theFrames.currFrame.frame.remove(temp);
        }
        
        theFrames.currFrame.shapes.put( key, value ); 
        theFrames.currFrame.frame.add( value ); 
        theFrames.currFrame.numShapes ++; 
        
        return theFrames;
    }

/*  createRectangle() takes in a specific command and the Frames object.
 *  It then parses the command into each token and creates a new
 *  rectangle based on those tokens.  It then returns the updated Frames.
 */
    static Frames createRectangle(StringTokenizer line, Frames theFrames){
        int id     = Integer.parseInt( line.nextToken() ); 
        int left   = Integer.parseInt( line.nextToken() ); 
        int top    = Integer.parseInt( line.nextToken() ); 
        int width  = Integer.parseInt( line.nextToken() ); 
        int height = Integer.parseInt( line.nextToken() ); 
        
        Integer key = new Integer( id );
        Rectangle value = new Rectangle(left,top,width,height);
        
        if(theFrames.currFrame.shapes.containsKey(key)){
            System.out.print("Warning: replacing existing object ");
            System.out.println("with id: "+id);
            Shape temp = (Shape)theFrames.currFrame.shapes.remove(key);
            theFrames.currFrame.frame.remove(temp);
        }
        theFrames.currFrame.shapes.put( key, value );
        theFrames.currFrame.frame.add( value );
        theFrames.currFrame.numShapes ++;
        
        return theFrames;
    }

/*  createPolygon() takes in a specific command and the Frames object.
 *  It then parses the command into each token and creates a new
 *  polygon based on those tokens.  It then returns the updated Frames.
 */
    static Frames createPolygon(StringTokenizer line, Frames theFrames){
        int id = Integer.parseInt( line.nextToken() ); 
        int n  = Integer.parseInt( line.nextToken() ); 
        
        Integer key = new Integer( id );
        Polygon value = new Polygon( n );
        
        if(theFrames.currFrame.shapes.containsKey(key)){
            System.out.print("Warning: replacing existing object ");
            System.out.println("with id: "+id);
            Shape temp = (Shape)theFrames.currFrame.shapes.remove(key);
            theFrames.currFrame.frame.remove(temp);
        }
        
        for(int i = 0; i < n; i++ ){ 
            int x = Integer.parseInt( line.nextToken() ); 
            int y = Integer.parseInt( line.nextToken() ); 
            value.add(x, y);
        } 
        theFrames.currFrame.shapes.put( key, value );
        theFrames.currFrame.frame.add( value );
        theFrames.currFrame.numShapes ++;
        
        return theFrames;
    }
}








