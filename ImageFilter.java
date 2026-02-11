import org.code.theater.*;
import org.code.media.*;
/*
 * Represents an image that can be modified with filters and effects
 */
public class ImageFilter extends ImagePlus {
  /*
   * Calls the superclass constructor to initialize pixels
   */
  public ImageFilter(String filename) {
    super(filename);
  }
  
 /*
* Applies a "glitch" effect by slightly altering the values of the
* red, green, and blue pixels randomly
* Assigns random values between -50 and 50 as to create a change not too overwhelming or slight
* Precondition: The image has been loaded properly
* Postcondition: the image appears moderately glitched
*/
 public void glitchFilter() {
    
Pixel[][] pixels = getImagePixels();
for (int r = 0; r < pixels.length; r++) {
  for (int c = 0; c < pixels[0].length; c++) {
    Pixel currentPixel = pixels[r][c];

    int newRed = (int)(Math.random() * 101) - 50;
    int newGreen = (int)(Math.random() * 101) - 50;
    int newBlue = (int)(Math.random() * 101) - 50;

    int finalRed = currentPixel.getRed() + newRed;
    int finalGreen = currentPixel.getGreen() + newGreen;
    int finalBlue =  currentPixel.getBlue() + newBlue;

    if (finalRed > 255) {
      finalRed = 255;
    } else if (finalRed < 0) {
      finalRed = 0;
    }

     if (finalBlue > 255) {
      finalBlue = 255;
    } else if (finalBlue < 0) {
      finalBlue = 0;
    }

     if (finalGreen > 255) {
      finalGreen = 255;
    } else if (finalGreen < 0) {
      finalGreen = 0;
    }
        currentPixel.setRed(finalRed);
    currentPixel.setGreen(finalGreen);
    currentPixel.setBlue(finalBlue);
  }
}
  }

    /*
   * Shifts the color of each Pixel object by a fixed amount
   * Precondition: The image has been loaded properly
   * Postcondition: The image appears brighter or tinted with light
   */
  public void colorShift(int value) {
 Pixel[][] pixels = getImagePixels();
for (int r = 0; r < pixels.length; r++) {
  for (int c = 0; c < pixels[0].length; c++) {
    Pixel currentPixel = pixels[r][c];
    int currentRed = currentPixel.getRed();
    int currentGreen = currentPixel.getGreen();
    int currentBlue = currentPixel.getBlue();

    int finalRed = currentRed + value;
    int finalGreen = currentGreen + value;
    int finalBlue = currentBlue + value;

    if (finalRed > 255) {
      finalRed = 255;
    }
     if (finalGreen > 255) {
      finalGreen = 255;
    }
     if (finalBlue > 255) {
      finalBlue = 255;
    }

    currentPixel.setRed(finalRed);
    currentPixel.setGreen(finalGreen);
    currentPixel.setBlue(finalBlue);


    
  }
  
}
  }

  /*
   * Adjusts the contrast of the image by multiplying the
   * red, green, and blue values by the multiplier
   * Precondition: The image has been loaded properly
   * Postcondition: The image constrast increases
   */
  public void adjustContrast(int multiplier) {
  Pixel[][] pixels = getImagePixels();
for (int r = 0; r < pixels.length; r++) {
  for (int c = 0; c < pixels[0].length; c++) {
    Pixel currentPixel = pixels[r][c];
    int currentRed = currentPixel.getRed();
    int currentGreen = currentPixel.getGreen();
    int currentBlue = currentPixel.getBlue();

    int finalRed = currentRed * multiplier;
    int finalGreen = currentGreen * multiplier;
    int finalBlue = currentBlue * multiplier;

    currentPixel.setRed(finalRed);
    currentPixel.setGreen(finalGreen);
    currentPixel.setBlue(finalBlue);
  }
}
  }

    /*
   * Applies a Gaussian blur by finding the average of the red,
   * green, and blue color values of the current Pixel object and
   * its top-left neighboring Pixel object using a weighted average
   * Precondition: The image has been loaded properly
   * Postcondition: The image appears blurred
   */
  public void applyBlur() {
Pixel[][] pixels = getPixelsFromImage();
    for (int row = 1; row < pixels.length -1; row++) {
      for (int col = 1; col < pixels[0].length -1; col++) {
        Pixel currentPixel = pixels[row][col];
        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

    int finalRed = calcWeightedRed(pixels, row, col);
    int finalGreen = calcWeightedGreen(pixels, row, col);
    int finalBlue = calcWeightedBlue(pixels, row, col);

    currentPixel.setRed(finalRed);
    currentPixel.setGreen(finalGreen);
    currentPixel.setBlue(finalBlue);
        
      }
    }
  }

  /*
   * Returns a weighted red average of the pixels around the specified row and col
   * Precondition: pixels are a valid 2D array
   * Postcondition: Returns the average red value of the pixels
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   * Precondition: pixels are a valid 2D array
   * Postcondition: Returns the average green value of the pixels
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   * Precondition: pixels are a valid 2D array
   * Postcondition: Returns the average blue value of the pixels
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }

    /*
   * Applies a colorize filter by converting each Pixel to grayscale and applying
   * a color to it based on its grayscale value
   * Precondition: The image has been loaded properly
   * Postcondition: The image becomes converted to either red, green, or blue based on brightness
   */
  public void colorize() {

Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        
        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int grayScale = (currentRed + currentGreen + currentBlue) / 3;

    if (grayScale < 85) {
    currentPixel.setRed(255);
    currentPixel.setGreen(0);
    currentPixel.setBlue(0);
    } else if (grayScale < 170) {
    currentPixel.setRed(0);
    currentPixel.setGreen(255);
    currentPixel.setBlue(0);
    } else {
    currentPixel.setRed(0);
    currentPixel.setGreen(0);
    currentPixel.setBlue(255);     
    }

    
  }
  
}
  }

    /*
   * Applies a threshold filter to an image
   * Precondition: The image has been loaded properly
   * Postcondition: Each pixel becomes black or white based on the grayscale value
   */
  public void threshold(int value) {
 Pixel[][] pixels = getImagePixels();
for (int r = 0; r < pixels.length; r++) {
  for (int c = 0; c < pixels[0].length; c++) {
    Pixel currentPixel = pixels[r][c];
    int currentRed = currentPixel.getRed();
    int currentGreen = currentPixel.getGreen();
    int currentBlue = currentPixel.getBlue();

    int grayScale = (currentRed + currentGreen + currentBlue) / 3;

   if(grayScale < value) {
     currentPixel.setColor(Color.BLACK);
   }
    else {
      currentPixel.setColor(Color.WHITE);
    }
  }
}
}
  
    /*
   * Applies a threshold filter to an image
   * Precondition: The image has been loaded properly
   * Postcondition: Each pixel's RGB values are inverted
   */
    public void makeNegative() {
 Pixel[][] pixels = getImagePixels();
for (int r = 0; r < pixels.length; r++) {
  for (int c = 0; c < pixels[0].length; c++) {
    Pixel currentPixel = pixels[r][c];
    int currentRed = currentPixel.getRed();
    int currentGreen = currentPixel.getGreen();
    int currentBlue = currentPixel.getBlue();

    int finalRed = 255 - currentRed;
    int finalGreen = 255 - currentGreen;
    int finalBlue = 255 - currentBlue;

    currentPixel.setRed(finalRed);
    currentPixel.setGreen(finalGreen);
    currentPixel.setBlue(finalBlue);


    
  }
  
}
  }
  

}