/**
   This interface represents a simple graphics device. You must assume
   that the device will only remember what has been drawn on it up
   until the next render() command. A subsequent render() without any
   intervening drawXXX() commands will just draw a blank display.
 */
interface TGraphics {
    /**
       Draw a line from (x1, y1) to (x2, y2).
       @param x1 - x coordinate of first point.
       @param y1 - y coordinate of first point.
       @param x2 - x coordinate of second point.
       @param y2 - y coordinate of second point.
     */
    void drawLine(int x1, int y1, int x2, int y2);

    /**
       Draw a horizontal line of the specified length, with (x1, y1) 
       as the left end.
       @param x1 - x coordinate of left end of the line.
       @param y1 - y coordinate of left end of the line.
       @param length - the length of the line.
     */
    void drawHorizontalLine(int x1, int y1, int length);

    /**
       Draw a vertical line of the specified length, with (x1, y1) 
       as the upper end.
       @param x1 - x coordinate of upper end of the line.
       @param y1 - y coordinate of upper end of the line.
       @param length - the length of the line.
     */
    void drawVerticalLine(int x1, int y1, int length);

    /**
       Force the display to actually appear.
     */
    void render();

    /**
       Clear the display.
     */
    void clear();
}




