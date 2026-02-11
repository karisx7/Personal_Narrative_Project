import org.code.theater.*;
import org.code.media.*;

/*
 * Represents an image that can be modified with filters and effects
 */
public class ImagePlus extends Image {

  private Pixel[][] pixels;    // The 2D array of pixels

  /*
* Precondition: The filename exists
* The image from the filename is loaded
*/
  public ImagePlus(String filename) {
    super(filename);   // Calls the Image class constructor and uses the filename as the parameter

    pixels = getPixelsFromImage();
  }

  /*
   * Returns the 2D array of Pixel objects and allows other subclasses to access the pixel data
   * Precondition: The image is loaded from the constructor above
   */
  public Pixel[][] getImagePixels() {
    return pixels;
  }

  /*
   * Creates and returns a 2D array of Pixel[][] objects
   * It loops through each row and column to get every pixel from the image
   * Precondition: The is loaded from the constructor at the top
   * Postcondition: Each pixel has the correct RGB value and the image has the correct number of pixels
   */
  public Pixel[][] getPixelsFromImage() {
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];
    
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        tempPixels[row][col] = getPixel(col, row);
      }
    }

    return tempPixels;
  }

}