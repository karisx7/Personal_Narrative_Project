import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

 /*
* 2D array storing images related to my interests
*/
  private ImageFilter[][] secondImages;
  
 /*
* Precondition: the secondImages are initilized in the 2D array properly
* Postcondition: Instance variables are initialized for the scene
*/
  public SceneTwo(ImageFilter[][] secondImages) {
this.secondImages = secondImages;
  }
  
 /*
* Creates and returns the 2D array of caption text
* Each row creates a separate caption used to create a concatenated line of text
* Precondition: N/A
* Postcondition: Returns a 2D array of captions in the form of Strings
*/
  public String[][] setUpData() {
      String[][] captions = {
  {"Other than animes", " I like "}, //animes i like watching
  {"watching", " Percy Jackson"}, // other things i like to watch
  
};
    return captions;
  }

  /**
   * Draws the animaion in the order given using the other methods
   * Precondition: secondImages isn't null
   * Postcondition: The full SceneTwo is displayed
   */
  public void drawScene() {
    drawAnime();
    drawOtherShows();
  }

 /*
* Displays the images of my favorite animes
* Applies different filters for visual engagement
* Precondition: secondImages[0][0] and secondImages[0][1] aren't null
* Postcondition: The anime images are displayed properly
*/
  public void drawAnime() {
  clear("yellow");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    int fontSize = 40;
    setTextHeight(fontSize);
    setTextColor("black");
    drawText("My Interests", 30, 47);
    pause(1);
    fontSize = 20;
    setTextHeight(fontSize);
    drawText("I love watching anime!", 25, 97);
    pause(2);
    clear("yellow");
    drawImage(secondImages[0][0], 14, 40, 300); // before frieren image
    pause(1);
    secondImages[0][0].applyBlur();
    drawImage(secondImages[0][0], 14, 40, 300); // after frieren image
    pause(1);
    drawText("Frieren is my current fav", 30, 315);
    pause(3);
    clear("yellow");
    drawText("My all time favorite is", 50, 360);
    drawText("Jibaku Shonen Hanako Kun", 36, 380);
    pause(1);
    drawImage(secondImages[0][1], 40, 20, 300); // before jshk image
    pause(1);
    secondImages[0][1].colorize();
    drawImage(secondImages[0][1], 40, 20, 300);  // after jshk image   
    pause(2);
    
  }
  
/**
 * Goes through the captions 2D array and adds each element to one String called text
 * Precondition: captions isn't a null 2D array
 * Postcondition: Returns a single String containing all of the elements
*/
  public String setText(String[][] captions) {
    String text = "";
      for (int row = 0; row < captions.length; row++) {
        for (int col = 0; col < captions[0].length; col++) {
          text += captions[row][col];
        }
      }
return text;
    
  }
   /*
* Displays other shows that I enjoy watching
* It ends the animation with the "thank you" message
* Precondition: secondImages[1][0] is not null
* Postcondition: The other show image and captions are correctly displayed
*/
  public void drawOtherShows() {
    clear("yellow");
    int fontSize = 13;
    setTextHeight(fontSize);
    String[][] caption = setUpData();
    drawText(setText(caption), 10, 360);
    pause(2);
    drawImage(secondImages[1][0], 40, 10, 220); // percy jackson image
    pause(2);
    clear("green");
    fontSize = 40;
    setTextHeight(fontSize);
    setTextColor("white");
    drawText("Thank you!", 80, 220);
    pause(2);
  }

  
}