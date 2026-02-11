import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

 /*
* 2D array of ImageFilter objects for the scene
* Background sound file for the scene
*/
  private ImageFilter[][] images;
  private String soundFile;
/*
*Precondition: The soundfile is valid
* Postcondition: Instance variables are initilized properly
*/
  public SceneOne(ImageFilter[][] images, String soundFile) {
this.images = images;
this.soundFile = soundFile;
  }

  /**
   * Controls the animation order for Scene One using other methods
   * Precondition: The other methods exist
   * Postcondition: The full SceneOne is displayed correctly
   */
  public void drawScene() {
drawKoreanImages(87, 10, 400, 150);
drawFriendsImages();
  }

 /*
* Displays the images and text related to my Korean heritage
* Applies different filters to make the images more engaging
* Precondition: images[0][0] and images[0][1] aren't null
* Postcondition: The Korean images and text are displayed correctly
*/
  public void drawKoreanImages(int xPos, int yPos, int width, int height) {

    clear("pink");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    int fontSize = 40;
    setTextHeight(fontSize);
    setTextColor("black");
    int xLinePos = xPos;
    int yLinePos = yPos + fontSize;
    drawText("About Me", xLinePos, yLinePos);
    yLinePos += fontSize;
    pause(1);
    fontSize = 30;
    setTextHeight(fontSize);
    yLinePos = 115;
    drawText("I am Korean!", xLinePos, yLinePos - 30);
    pause(1);
    drawImage(images[0][0], 280, 100, 270, 90); // before hanbok image
    pause(1);
    images[0][0].colorShift(10);
    drawImage(images[0][0], 280, 100, 270, 90);  // after hanbok image
    pause(1);
    fontSize = 20;
    setTextHeight(fontSize);
    setTextColor("white");
    drawText("These are Korean cultural", 32, 318);
    drawText("dresses called Hanboks", 52, 350);
    pause(3);
    clear("pink");
    drawImage(images[0][1], 280, 100, 270, 90); // before janggu image
    pause(1);
    images[0][1].adjustContrast(2);
    drawImage(images[0][1], 280, 100, 270, 90); // after janggu image
    pause(1);
    fontSize = 20;
    setTextHeight(fontSize);
    drawText("I also play the Janggu", 44, 45);
    drawText("It's a Korean traditional drum", 15, 65);
    pause(3);
  }

 /*
* Displays the images of my friends
* Applies different filters for image engagement
* Precondition: images[1][0] and images[1][1] aren't null
* Postcondition: All of the images and text are displayed properly
*/

public void drawFriendsImages() {
    clear("pink");
    drawText("My friends are also a core", 34, 45);
    drawText("part of my life", 100, 65);
    pause(3);
    clear("pink");
    drawImage(images[1][0], 14, 13, 130);  // before dena image
    pause(1);
    images[1][0].glitchFilter();
    drawImage(images[1][0], 14, 13, 130); // after dena image
    pause(1);
    drawImage(images[1][1], 170, 50, 210);  // before bella/danica image
    pause(1);
    images[1][1].makeNegative();
    drawImage(images[1][1], 170, 50, 210); // after bella/danica image
    pause(1);
    drawText("This is Dena, Bella, and Danica!", 7, 342);
    pause(4);

}
  
}