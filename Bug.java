import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 */
public class Bug implements Contract {

    String name;
    ArrayList<String> bag = new ArrayList<String>();
    int paramX;
    int paramY;
    Number size;
    ArrayList<Integer> position = new ArrayList<Integer>(2);


    /**
     * Bug constructor sets parameters and sets position to [0,0]
     * @param name name of the bug
     * @param x how far left/right the bug can move at a time
     * @param y how far up/down the bug can move at a time
     * @param size size of the bug
     */
    public Bug(String name, int x, int y, Number size){
        
        this.name = name;
        this.paramX = x;
        this.paramY = y;
        this.size = size;
        this.position.add(0);
        this.position.add(0);

        System.out.println("----------------------------");
        System.out.println("Let's create a bug friend :)");
        System.out.println("----------------------------\n");
        System.out.println("Your bug's name is " + this.name + " and they're " + this.size + " centimeters tall!");
        System.out.println("They can fly " + this.paramX + " centimeters to the side and " + this.paramY + " centimeters vertically at a time.");
        System.out.println("This little bug's postion in the air is: " + this.position + "\n");
    }

    /**
     * Default bug constructor that uses provided values
     * @param name name of the bug
     */
    public Bug(String name){
        
        this.name = name;
        this.paramX = 30;
        this.paramY = 20;
        this.size = 10;
        this.position.add(0);
        this.position.add(0);
        
        System.out.println("Your bug's name is " + this.name + " and they're " + this.size + " centimeters tall!");
        System.out.println("They can fly " + this.paramX + " centimeters to the side and " + this.paramY + " centimeters vertically at a time.");
        System.out.println("This little bug's postion in the air is: " + this.position + "\n");
    }

    /**
     * Allows user's bug to grab an item and adds it to ArrayList bag
     * @param item item the user wants to grab
     */
    public void grab(String item){

        System.out.println("You have now grabbed " + item + "\n");
        bag.add(item);
    }

    /**
     * Allows user's bug to drop an item if it's in ArrayList bag
     * @param item item the user wants to drop
     */
    public String drop(String item){

        if (bag.contains(item)) {

            bag.remove(item);
            String dropString = "You have now dropped " + item + "\n";

            System.out.println(dropString);
            return dropString;

        }else {

            String noDropString = "You can't drop " + item + " because it's not in the bag!\n";

            System.out.println(noDropString);
            return noDropString;
        }
    }
    
    /**
     * Asks the user what color the item is
     * @param item item the user wants to examine
     */
    public void examine(String item){

        System.out.println("Let's take a closer look at this " + item);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What color is the " + item + "?");

        String color = sc.nextLine();
        System.out.println("Ah, a " + color + " " + item + ". How interesting!\n");

        sc.close();
    }

    /**
     * Allows a user's bug to use an item
     * @param item item the user wants to use
     */
    public void use(String item){

        System.out.println("The " + item + " is in use. \n");
    }

    /**
     * Allows a user's bug to walk in set directions
     * @param direction which direction the bug will move in
     * @return boolean if the bug was able to move in a valid direction
     */
    public boolean walk(String direction){

        System.out.println("Your bug, " + this.name + ", can walk left, right, forward, and backward. Please choose one of those directions to walk in.");

        if (direction == "left" || direction == "right" || direction == "forward" || direction == "backward"){
            System.out.println(this.name + " is walking " + direction + ".\n");
            return true;
        }else{
            System.out.println(this.name + " can't walk like that! Choose a different direction.\n");
            return false;
        }  
    }

    /**
     * Allows a user's bug to fly along x y coordinates
     * @param x the amount left or right the user's bug will move
     * @param y the amount up or down the user's bug will move
     * @return boolean if the user's bug was able to fly within the set parameters
     */
    public boolean fly(int x, int y){

        if (x <= this.paramX && y <= this.paramY){

            int ogx = this.position.get(0);
            this.position.set(0, x+ogx);

            int ogy = this.position.get(1);
            this.position.set(1, y+ogy);
        
            System.out.println(this.name + " has flown " + x + " centimeters to the side and " + y + " centimeters vertically.");
            System.out.println("Their position in the air is now: " + this.position + "\n");
            
            return true;
        }else{

            System.out.println("Oops! That's outside of the set parameters! Try entering x and y less than " + paramX + " and " + paramY + "!\n");
            return false;
        }
    } 

    /**
     * Shrink the size of the user's bug
     * @return half the size the bug previously was
     */
    public Number shrink(){

        this.size = this.size.intValue()/2;

        System.out.println(this.name + " is now: " + this.size + " centimeters tall.\n");
        return this.size;
    }

    /**
     * Multiplies the size of the user's bug by two
     */
    public Number grow(){

        this.size = this.size.intValue()*2;

        System.out.println(this.name + " is now: " + this.size + " centimeters tall.\n");
        return this.size;
    }

    /**
     * Set's the user's bug's y-coordinate to 0 so that they're on the ground
     */
    public void rest(){

        this.position.set(1,0);

        System.out.println("Ahhhh... " + this.name + " is taking a rest...");
        System.out.println("Their position in the air is now: " + this.position + "\n");
        
    }

    /**
     * Resets the user's bug's coordinates to [0,0]
     */
    public void undo(){

        this.position.set(0,0);
        this.position.set(1,0);

        System.out.println("You've undone all the progress " + this.name + " has made!");
        System.out.println("Their position in the air is now back to: " + this.position + "\n");
    }

    public static void main(String[] args) {

        Bug myBug = new Bug("Pria", 20, 30, 5);
        myBug.grab("pear");
        myBug.grab("shoe");
        myBug.drop("pear");
        myBug.drop("apple");
        myBug.examine("pear");
        myBug.use("pear");
        myBug.walk("up");
        myBug.fly(9,30);
        myBug.fly(9,-15);
        myBug.rest();
        myBug.undo();
    }
}
