import org.code.theater.*;
import org.code.media.*;
 /*
* The class used to run the actual scenes
*/
public class TheaterRunner {
  public static void main(String[] args) {

 /*
* 2D arrays storing images related to my culture and my friends
* Each row represents a category of a core part of me while the column represents an example
*/
ImageFilter[][] images = {
  {new ImageFilter("IMG_8569.jpeg"), new ImageFilter("IMG_2620.jpeg") }, // Korean culture
  {new ImageFilter("IMG_5170.png"), new ImageFilter("IMG_5564.jpeg")}, // friends
};

 /*
* 2D array storing images of my interests, which are animes and shows
*/ 
ImageFilter[][] secondImages = {
  {new ImageFilter("IMG_5783.jpeg"), new ImageFilter("IMG_5796.jpeg")}, //animes i like watching
  {new ImageFilter("MV5BMTI3YmIzNzYtOTcwNy00ZTZiLTg5NmQtMTUyNGY1ZWVmZDJiXkEyXkFqcGc-._V1_QL75_UY281_CR18-0-190-281_.jpg"), null}, // shows I like to watch
  
};
    
 /*
* Creates the SceneOne and SceneTwo objects and passes in the images and background music
*/
    SceneOne scene1 = new SceneOne(images, "youtube-intro-music-2-447241.wav");
    SceneTwo scene2 = new SceneTwo(secondImages);
    
  /*
* Calls each scene's drawScene() method to display the animation
*/ 
    scene1.drawScene();
    scene2.drawScene();
    
 /*
* Plays the scenes in order inside the theater
*/
    Theater.playScenes(scene1, scene2);


    

    
    
  }
}