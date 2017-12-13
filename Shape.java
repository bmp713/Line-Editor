/**
   This interface must be implemented by all 
   drawing shapes that will be added to a frame.
 */
interface Shape { 
  /**
     This method will be called when the shape needs to be drawn.
     @param graphics is the object upon which actual drawing 
     operations should be performed.
   */
  void draw(TGraphics graphics);
}
