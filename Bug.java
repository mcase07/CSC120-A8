import java.util.Scanner;
import java.util.ArrayList;


public class Bug { // will need to add "implements Contract"

    String name;
    ArrayList<String> bag = new ArrayList<String>();
    int x = 30;
    int y = 30;


    public Bug(String name){
        
        this.name = name;
        System.out.println("Your bug's name is " + this.name + "\n");

        // Scanner sc = new Scanner(System.in);
        // System.out.println("What would you like your bug's name to be?");

        // this.name = sc.nextLine();
        // System.out.println("Perfect! Your bug's name is " + name);

        // sc.close();
    }

    public void grab(String item){

        System.out.println("You have now grabbed " + item + "\n");
        bag.add(item);

        // Scanner sc2 = new Scanner(System.in);
        // System.out.println("What would you like to grab?");

        // item = sc2.nextLine();
        // System.out.println("You have grabbed " + item);
    
        // sc2.close();

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

    public void setParameters(int x, int y){

        this.x = x;
        this.y = y;

        System.out.println("You've set the max that " + this.name + " can fly around \n");
    }

    public boolean fly(int x, int y){

        if (x <= this.x && y <= this.y){
            
            System.out.println(this.name + " has moved " + x + " to the side and " + y + " up/down.\n");
            return true;
        }else{
            System.out.println("Oops! That's outside of the set paramters!");
            return false;
        }
    } 

    // public Number shrink();
    // public Number grow();
    // public void rest();
    // public void undo();

    public static void main(String[] args) {
        Bug myBug = new Bug("Pria");
        myBug.grab("pear");
        myBug.drop("pear");
        // myBug.examine("pear");
        myBug.use("pear");
        myBug.walk("up");

   
    }
}
