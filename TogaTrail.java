import java.util.Scanner; 

public class TogaTrail
{
    private Scanner input;
    
    private int score;
    private String name;
    
    private int mins;
    private int miles;
    private double money;
    private int falcons;
    private int tshirts;
    private int food;
    private int wheels;
    private int axles;
    private int tongues;
    private int supplies;
    private String weather;
    private String health; 
    
    public TogaTrail(){
        input = new Scanner(System.in); 
        
        score = 0;
        name = "";
        
        mins = 0;
        miles = 0;
        money = 0.0;
        falcons = 0;
        tshirts = 0;
        food = 0;
        wheels = 0;
        axles = 0;
        tongues = 0;
        supplies = 0;
        weather = "";
        health = "good";
        startGame();
    }
    
    public void startGame(){
        System.out.println("The Toga Trail!");
        System.out.println();
        System.out.println("Many students have travelled this grueling journey to Saratoga High School. You are next. What grade are you in?");
        System.out.println("1. freshman");
        System.out.println("2. sophomore");
        System.out.println("3. junior");
        System.out.println("4. senior");
        int grade = Integer.parseInt(input.nextLine());
        if (grade >= 1 && grade <= 4){
            money = (grade + 8) * 100.0;
        }
        else {
            System.out.println("You cannot type numbers, therefore you become a freshman");
            grade=1;
            money = (grade + 8) * 100.0;
        }
        System.out.println();
        askName();
    }
    
    public void askName(){
        System.out.println("What is your name?");
        name = input.nextLine();
        if (name.equals("Hermione")){
            name = "Hermoine";
        }
        if (name.equals("Christina")){
            name = "Serena";
        }
        if (name.equals("Winston")){
            name = "Joekatrina";
        }
        System.out.println();
        store("Startoga (not Starbucks)", 1);
    }
    
    public void store(String name, int level){
        
        int num = 0;
        
        double[] prices = {50.0,25.0,.50,20.0,20.0,20.0,5.00};
        for (int i = 0; i < prices.length; i++){
            prices[i] *= level;
        }
        
        while (num != 8){
            mins++;
            System.out.println("You arrived at " + name + ". What would you like to buy?");
            System.out.println("1. falcons");
            System.out.println("You have " + falcons + " falcons.");
            System.out.println("2. class T-shirts");
            System.out.println("You have " + tshirts + " class T-shirts.");
            System.out.println("3. food");
            System.out.println("You have " + food + " food.");
            System.out.println("4. chariot wheels");
            System.out.println("You have " + wheels + " chariot wheels.");
            System.out.println("5. chariot axles");
            System.out.println("You have " + axles + " chariot axles.");
            System.out.println("6. chariot tongues");
            System.out.println("You have " + tongues + " chariot tongues.");
            System.out.println("7. school supplies");
            System.out.println("You have " + supplies + " school supplies.");
            System.out.println("8. LEAVE " + name.toUpperCase());
            String[] names = {"falcons", "class T-shirts", "food", "chariot wheels", "chariot axles", "chariot tounges", "school supplies"};
            num = Integer.parseInt(input.nextLine());
            String[] personalizedMessages = {"You need falcons to fly your chariot to school. We suggest 4 falcons.",
            "You need class T-shirts to stay warm. We suggest 2.", "You need food. We suggest 140 lbs",
            "You need wheels if your chariot breaks down. We suggest 1~2", "You need axles if your chariot breaks down. We suggest 1~2",
            "You need tongues if your chariot breaks down. We suggest 1~2", "You need school supplies to graduate. We suggest 3"};
            if (num >=1 && num<=7){
                System.out.println(personalizedMessages[num-1]);
                System.out.println(names[num-1] + " cost $" + prices[num-1] +". You have $" + money + ".");
                System.out.println("How many " + names[num-1] + " would you like?");
                int sum = Integer.parseInt(input.nextLine());
                if (money - sum * prices[num-1] >= 0){
                    money -= sum * prices[num-1];
                    if(num==1)falcons += sum;
                    if(num==2)tshirts += sum;
                    if(num==3)food += sum;
                    if(num==4)wheels += sum;
                    if(num==5)axles += sum;
                    if(num==6)tongues += sum;
                    if(num==7)supplies += sum;
                    System.out.println("Purchased! You have $" + money + " left.");
                }
                else {
                    System.out.println("Not enough money.");
                }
            }
            else if(num==8 && falcons == 0){ 
                System.out.println("You need falcons");
                if (money == 0){
                    System.out.println("You have no money. We will give you a free falcon because you'll die soon anyways.");
                    falcons++;
                }
                else {
                    num = 1;
                }
            }
            else {
                if(num!=8){System.out.println("Please reenter:");}
            }
            System.out.println();
        }
    }
    
    public String changeWeather(){
        String[] weathers = {"Sunny", "Sunny", "Sunny", "Cloudy", "Cloudy", "Cloudy", "Rainy", "Lightningstorm", "Meatball", "Foggy", "Hurricane"};
        int chance = (int)(Math.random()*weathers.length);
        return weathers[chance];
    }
    
    
}
