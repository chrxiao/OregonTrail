import java.util.Scanner; 

public class TogaTrail
{
    private Scanner input;
    private int shopcount;
    
    private int score;
    private String name;
    
    private int mins;
    private int meters;
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
        shopcount = 0;
        
        score = 0;
        name = "";
        
        mins = 0;
        meters = 0;
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
        move();
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
        shopcount++;
    }
    
    public void move(){
        int pace = 50;
        int Epace = 0;
        while(meters<2000){
            if(meters>1500 && shopcount==2)store("Hermione's House", 3);
            else if(meters>1000 && shopcount==1)store("Neale and Sons Appraisers and Auctioneers", 2);
            else if(shopcount==0)store("Startoga (not Starbucks)", 1);
            
            if(pace==0)pace+=45;
            if(pace<50)pace++;
            if((Math.random()*100)>98.0){
                System.out.println("You broke your kneecaps. You move half as fast.");
                pace /= 2;
            }
            changeHealth();
            weather = changeWeather();
            if(weather.equals("Hurricane")){
                System.out.println("In a hurricane, lose a day.");
                pace = 0;
            } else if(weather.equals("Foggy")){
                System.out.println("Foggy Weather, slow down.");
                pace = 0;
                Epace = pace - 10;
            } else if(weather.equals("Meatball")){
                System.out.println("Cloudy with a definite chance of meatballs, free food but slow down.");
                pace = 0;
                food += 20;
                Epace = pace - 5;
            } else if(weather.equals("Lightningstorm")){
                System.out.println("You stop to admire the picturesque view of wide arcs of light \n dash across the sky. Part of the view is blocked by SHS.");
            }
            if(food==0){lowerHealth();}
            if(tshirts==0){lowerHealth();}
            
            if(health.equals("ded")){
                if(Math.random()>.5){System.out.println("You died of dysentery, brought on by your bad health.");}
                else if(Math.random()>.5){System.out.println("You died of typhoid, brought on by your bad health.");}
                else{System.out.println("You died of yellow fever, brought on by your bad health.");}
                break;
            }
            
            mins++;
            food-=10;
            if(food<0)food = 0;
            if(pace>0){meters+=pace;}
            else{meters+=Epace;}
            GUI();
        }
        if(meters>2000){
            if(supplies<=2){System.out.println("You do not have enough supplies to graduate");}
            else{System.out.println("Congrats! You have succeeded on the organ trail with " + score + " points!");}
        }
    }
    
    public String changeWeather(){
        String[] weathers = {"Sunny", "Sunny", "Sunny", "Cloudy", "Cloudy", "Cloudy", "Rainy", "Lightningstorm", "Meatball", "Foggy", "Hurricane"};
        int chance = (int)(Math.random()*weathers.length);
        return weathers[chance];
    }
    
    public void changeHealth(){
        double chance = Math.random()*10;
        if(health.equals("good")){
            if(chance>9.2){health = "decent";} 
        }
        else if(health.equals("decent")){
            if(chance>9.2){health = "good";} 
            else if(chance>8.0){health = "bad";}
        }
        else if(health.equals("bad")){
            if(chance>9.2){health = "fair";} 
            else if(chance>8.0){health = "verge of death";}
        } else{
            if(chance>7.5){health = "ded";}
        }
    }
    
    public void lowerHealth(){
        if(health.equals("good")){health="decent";}
        else if(health.equals("decent")){health="bad";}
        else if(health.equals("bad")){health="verge of death";}
        else if(health.equals("verge of death")){health="ded";}
    }
    
    public void GUI(){
        System.out.println("\n\n----------------------");
        System.out.println("Minute: " + mins);
        System.out.println("Weather: " + weather );
        System.out.println("Health: " + health);
        System.out.println("Food: " + food);
        System.out.println("Meters to Travel: " + (2000-meters) + " m");
        System.out.println("----------------------\n\n");
    }
    
}
