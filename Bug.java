import java.util.Scanner;
import java.util.ArrayList;


public class Bug { // will need to add "implements Contract"

    String name;
    ArrayList<String> bag = new ArrayList<String>();
    int paramX = 30;
    int paramY = 30;
    Number size = 10;


    public Bug(String name, int x, int y, Number size){
        
        this.name = name;
        this.paramX = x;
        this.paramY = y;
        this.size = size;
        
        System.out.println("Your bug's name is " + this.name + " and they're " + this.size + " centimeters tall!");
        System.out.println("They can fly " + this.paramX + " centimeters to the side and " + this.paramY + " centimeters vertically at a time.\n");
    }

    public Bug(String name){
        
        this.name = name;
        
        System.out.println("Your bug's name is " + this.name + " and they're " + this.size + " centimeters tall!");
        System.out.println("They can fly " + this.paramX + " centimeters to the side and " + this.paramY + " centimeters vertically at a time.\n");
    }

    public void grab(String item){

        System.out.println("You have now grabbed " + item + "\n");
        bag.add(item);
    }

    public String drop(String item){

        String dropString = "You have now dropped " + item + "\n";
        System.out.println(dropString);

        return dropString;
    }

    
    public void examine(String item){

        System.out.println("Let's take a closer look at this " + item);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What color is the " + item + "?");

        String color = sc.nextLine();
        System.out.println("Ah, a " + color + " " + item + ". How interesting!\n");

        sc.close();
    }

    public void use(String item){

        System.out.println("The " + item + " is in use. \n");
    }


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

    public boolean fly(int x, int y){

        if (x <= this.paramX && y <= this.paramY){
        
            System.out.println(this.name + " has flown " + x + " centimeters to the side and " + y + " centimeters vertically.\n");
            return true;
        }else{

            System.out.println("Oops! That's outside of the set paramters! Try entering x and y less than " + paramX + " and " + paramY + "!\n");
            return false;
        }
    } 

    public Number shrink(){

        this.size = this.size.intValue()/2;

        System.out.println(this.name + " is now " + this.size + " centimeters tall.\n");
        return this.size;
    }

    public Number grow(){

        this.size = this.size.intValue()*2;

        System.out.println(this.name + " is now " + this.size + " centimeters tall.\n");
        return this.size;
    }

    public void rest(){

        System.out.println("Ahhhh... " + this.name + " is taking a rest...");
    }

    public void undo(){


        // make the position be 0,0
    }

    public static void main(String[] args) {

        Bug myBug = new Bug("Pria", 20, 30, 5);
        myBug.grab("pear");
        myBug.grab("shoe");
        // myBug.drop("pear");
        // myBug.examine("pear");
        myBug.use("pear");
        myBug.walk("up");
        myBug.fly(9,30);
        myBug.rest();
    }
}
