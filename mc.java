import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Arrays;
public abstract class mc implements Contract{
    public String name;
    public static int attack = 5;
    public static int speed = 5;
    public static int hp = 5;
    public static int iq = 5;
    public int west;
    public int east;
    public int north;
    public int south;
    public boolean canFly;
    public String itemType;
    public ArrayList<String> directionalcmd =new ArrayList<String>(Arrays.asList("North", "East", "Sout", "West"));
    public ArrayList<String> helpfulitems = new ArrayList<String>(Arrays.asList("Health Potion", "Strength Potion", "Insight Potion", "Speed Potion"));
    public int helpfulSize = 1;
    public ArrayList<String> ehitems = new ArrayList<String>(Arrays.asList("Water of the Fountain of Youth","Elixir of Demonic Strength", "Knowledge Beyond Mankind", "Angel Wings"));
    public ArrayList<String> ehdes = new ArrayList<String>(Arrays.asList("increases HP by 5 and decreases attack by 3", "increases attack 5 and decreases speed by 7", "increases IQ 5 and decreases attack by 3", "increases speed 5 and decreases attack by 5"));
    public int ehSize = 5;
    public ArrayList<String> correspondingAbility = new ArrayList<String>(Arrays.asList("HP", "attack", "IQ", "speed"));
    public ArrayList<String> inventory =  new ArrayList<String>();
    public int invSize = 20;
    /**
     * grabs item
     * @param item stuff you put in your inventory 
     */
    public void grab(String item){
        if (helpfulitems.contains(item) || ehitems.contains(item)){
            if (helpfulSize< invSize || ehSize< invSize){
                inventory.add(item);
                if (helpfulitems.contains(item)){
                invSize-=helpfulSize;
                }if (ehitems.contains(item)){
                    invSize-=ehSize;
                }else{         
                throw new RuntimeException("You don't have enough space for this item.");
                }
            }else{         
            throw new RuntimeException("There does not exist such item.");
            }
        }
    }
    /**
     * drops item
     * @param item stuff you drop from your inventory 
     */
    public String drop(String item){
        if (inventory.contains(item)){
            inventory.remove(item);
            System.out.println( item + " has been removed from" + this.name + "'s inventory");
        }
        else{ 
            throw new RuntimeException("Item does not exist in inventory");
            
        }

        return item; 
    } 
    /** 
     * to pick up and examin object
     * @param item stuff you find
     */
    public void examine(String item){
        System.out.println(this.name + " picked up and examined " + item);
        String itemname = " ";
        String ability = " ";
        String printedString = "it is a " + itemname + " that would increase your "+ ability + " by 1!";
        if (item == helpfulitems.get(0)){
            itemname = helpfulitems.get(0);
            ability = correspondingAbility.get(10);
            System.out.println(printedString);
        }else if (item == helpfulitems.get(1)){
            itemname = helpfulitems.get(1);
            ability = correspondingAbility.get(1);
            System.out.println(printedString);
        }else if (item == helpfulitems.get(2)){
            itemname = helpfulitems.get(2);
            ability = correspondingAbility.get(2);
            System.out.println(printedString);
        }else if (item == helpfulitems.get(3)){
            itemname = helpfulitems.get(3);
            ability = correspondingAbility.get(3);
            System.out.println(printedString);
        }else if (item == ehitems.get(0)){
            System.out.println(ehitems.get(0) + " " + ehdes.get(0));
        }else if (item == helpfulitems.get(1)){
            System.out.println(ehitems.get(1) + " " + ehdes.get(1));
            System.out.println(printedString);
        }else if (item == helpfulitems.get(2)){
            System.out.println(ehitems.get(2) + " " + ehdes.get(2));
            System.out.println(printedString);
        }else if (item == helpfulitems.get(3)){
            System.out.println(ehitems.get(3) + " " + ehdes.get(3));
        }
    }
    /** 
     * to use stuff from inventory 
     * @param item stuff you  use from your inventory 
     */
    public void use(String item){
        System.out.println(this.name + " used " + item);
        String ability = " ";
        String ability2 = " ";
        int number = 0;
        int number2 = 0;
        if (inventory.contains(item) && helpfulitems.contains(item)){
            if (item == helpfulitems.get(0)){
                ability = correspondingAbility.get(0);
                // System.out.println(printedString);
                this.hp+= 1;
            }else if (item == helpfulitems.get(1)){
                ability = correspondingAbility.get(1);
                this.attack+= 1;
                // System.out.println(printedString);
            }else if (item == helpfulitems.get(2)){
                ability = correspondingAbility.get(2);
                // System.out.println(printedString);
                this.iq+= 1;
            }else if (item == helpfulitems.get(3)){
                ability = correspondingAbility.get(3);
                // System.out.println(printedString);
                this.speed+= 1;
            }String printedString = ability + " increases by 1.";
            System.out.println(printedString);
        }
        if (inventory.contains(item) && ehitems.contains(item)){
            if (item == ehitems.get(0)){
                ability = "HP";
                ability2 = "attack";
                number = 5;
                number2 = 3;
                this.hp+= 5;
                this.attack -= 3;
                // System.out.println(printedString2);
            }else if (item == helpfulitems.get(1)){
                ability = "attack";
                ability2 = "speed";
                number = 5;
                number2 = 7;
                this.attack+= 5;
                this.speed -= 7;
                // System.out.println(printedString2);
            }else if (item == helpfulitems.get(2)){
                ability = "IQ";
                ability2 = "attack";
                number = 5;
                number2 = 3;
                this.iq+= 5;
                this.attack-=3;
                // System.out.println(printedString2);
            }else if (item == helpfulitems.get(3)){
                ability = "speed";
                ability2 = "attack";
                number = 5;
                number2 = 5;
                this.speed+= 5;
                this.attack-= 5;
                // System.out.println(printedString2);
            }String s = Integer.toString(number);
            String s2 = Integer.toString(number2);
            String printedString2 = ability + " increases by " + s + " and " + ability2 + " decreases by " + s2;
            System.out.println(printedString2);
        }      
    }
    /** 
     * to move to different directions
     * @param direction the direction that you want to walk in in North, East, South, West 
     */
    public boolean walk(String direction){
        this.north = 0;
        this.east = 0;
        this.south = 0;
        this.west = 0;
        if (this.speed > 0){
            if (direction ==directionalcmd.get(0)){
                this.north += 1;    
            }else if (direction ==directionalcmd.get(1)){
                this.east += 1;
            }else if (direction ==directionalcmd.get(2)){
                this.south += 1;
            }else if (direction ==directionalcmd.get(3)){
            this.west += 1;
            }else{
            throw new RuntimeException("I don't understand where to go...");
            }
            return true;
        }else{
            System.out.println("You don't have enough speed.");
            return false;
        }
    }
    /** 
     * to move quickly across multiple steps
     * @param direction the direction in terms of x and y direction
     */
    public boolean fly(int x, int y){
        if (this.speed > 20){
            this.canFly = true;
            this.speed -= 20;
            if (y > 0){
                this.north += y;
            }if(y < 0){
                this.south += y;
            }if (x > 0){
                this.east += x;
            }if(x < 0){
                this.west += x;
            }if (x == 0 && y ==0){
                throw new RuntimeException("ummm you are not moving...");
            }
            return true;
        } else{
            System.out.println("You cannot fly :/");
            return false;
        }

        }
     /** 
     * decrease hit points to increase attack
     */
    public Number shrink(){
        hp -= 1;
        attack += 1;
        return hp;
        }
    /** 
     * decrease attack to increase hit point
     */
    public Number grow(){
        attack -= 1;
        hp += 1;
        return hp;
    }
    /** 
     * decrease attack to increase hit point
     */
    public void rest(){
        if (this.speed == 0 && this.speed < 20){
            speed += 1;
        }else{
            throw new RuntimeException("You... don't need to rest");
        }
    }
    /** 
     * No, you can't undo 
     */
    public void undo(){
        throw new RuntimeException("Are you trying to hack the game?????");
    }
}




