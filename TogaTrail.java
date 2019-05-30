import java.util.Scanner; 

public class TogaTrail
{
    private Scanner input;
    private int shopcount;
    private int dangercount;
    
    private String name;
    
    private int mins;
    private int meters;
    private int pace;
    private double money;
    private int falcons;
    private int tshirts;
    private int food;
    private int[] chariotRepair;
    private int supplies;
    private String weather;
    private String health; 
    private boolean knees;
    
    public TogaTrail(){
        input = new Scanner(System.in); 
        shopcount = 0;
        dangercount = 0;
        
        name = "";
        
        mins = 0;
        meters = 0;
        pace = 50;
        money = 0.0;
        falcons = 0;
        tshirts = 0;
        food = 0;
        chariotRepair = new int[3];
        supplies = 0;
        weather = "";
        health = "good";
        knees = true;
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
            System.out.println("You cannot type numbers, therefore you must be a freshman.");
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
        System.out.println("Welcome, " + this.name + "! You arrived at " + name + ".");
        int num = 0;
        
        double[] prices = {50.0,25.0,.50,20.0,20.0,20.0,5.00};
        for (int i = 0; i < prices.length; i++){
            prices[i] *= level;
        }
        
        while (num != 8){
            mins++;
            System.out.println("What would you like to buy?");
            System.out.println("1. falcons");
            System.out.println("You have " + falcons + " falcons.");
            System.out.println("2. class T-shirts");
            System.out.println("You have " + tshirts + " class T-shirts.");
            System.out.println("3. food");
            System.out.println("You have " + food + " food.");
            System.out.println("4. chariot wheels");
            System.out.println("You have " + chariotRepair[0] + " chariot wheels.");
            System.out.println("5. chariot axles");
            System.out.println("You have " + chariotRepair[1] + " chariot axles.");
            System.out.println("6. chariot tongues");
            System.out.println("You have " + chariotRepair[2] + " chariot tongues.");
            System.out.println("7. school supplies");
            System.out.println("You have " + supplies + " school supplies.");
            System.out.println("8. LEAVE " + name.toUpperCase());
            String[] names = {"falcons", "class T-shirts", "food", "chariot wheels", "chariot axles", "chariot tounges", "school supplies"};
            num = Integer.parseInt(input.nextLine());
            String[] personalizedMessages = {"You need falcons to fly your chariot to school. We suggest 2 falcons.",
            "You need class T-shirts to stay warm. We suggest 1.", "You need food to feed yourself and your falcons. We suggest 200 lbs per party member.",
            "You need wheels if your chariot breaks down. We suggest 1~2.", "You need axles if your chariot breaks down. We suggest 1~2.",
            "You need tongues if your chariot breaks down. We suggest 1~2.", "You need school supplies to graduate. We suggest 3."};
            if (num >=1 && num<=7){
                System.out.println(personalizedMessages[num-1]);
                System.out.println(names[num-1].substring(0, 1).toUpperCase() + names[num-1].substring(1) + " cost $" + prices[num-1] +". You have $" + money + ".");
                System.out.println("How many " + names[num-1] + " would you like?");
                int sum = Integer.parseInt(input.nextLine());
                if (money - sum * prices[num-1] >= 0){
                    money -= sum * prices[num-1];
                    if(num==1)falcons += sum;
                    if(num==2)tshirts += sum;
                    if(num==3)food += sum;
                    if(num==4)chariotRepair[0] += sum;
                    if(num==5)chariotRepair[1] += sum;
                    if(num==6)chariotRepair[2] += sum;
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
                    System.out.println("You have no money. We will give you a free falcon since you'll die soon anyways.");
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
    
    public boolean danger(String name, String description, double percent){
        dangercount++;
        
        System.out.println("Uh-oh! You reached the " + name + ". You are now in danger!");
        System.out.println(description);
        
        if(health.equals("good")){percent -= .05;}
        else if(health.equals("bad")){percent += .05;}
        else if(health.equals("verge of death")){percent += .10;}
        
        if (Math.random() < percent){
            System.out.println("Unfortunately, you died.\n");
            return true;
        }
        else {
            if (Math.random() < percent){
                chariot();
            }
            if (Math.random() < percent){
                if (falcons()){
                    return true;
                }
            }
            System.out.println("Congratulations! You managed to survive.\n");
            return false;
        }
    }
    
    public void move(){
        int Epace = 0;
        while(meters<=1000){
            if(meters>750 && shopcount==2){
                if (name.equals("Hermoine")){
                    System.out.println("You arrived at Hermione's House. Because you stole her name, she kills you.");
                    break;
                }
                else {
                    store("Hermione's House", 3);
                }
            }
            else if(meters>500 && shopcount==1)store("Neale and Sons Appraisers and Auctioneers", 2);
            else if(shopcount==0)store("Startoga (not Starbucks)", 1);
            
            if (meters > 900 && dangercount == 2){
                if (danger("SHS Parking Lot", "A busy parent dropping off their child swerves into you.", .65)){
                    break;
                }
            }
            else if (meters > 625 && dangercount == 1){
                if (danger("Saratoga Creek", "You must now cross the creek.", .45)){
                    break;
                }
            }
            else if (meters > 100 && dangercount == 0){
                if (danger("Saratoga Sunnyvale Road", "It's time to jaywalk across the road.", .25)){
                    break;
                }
            }
            
            if(pace==0)pace+=45;
            if(pace<50)pace++;
            
            if (knees){
                if (Math.random() > .96){
                    System.out.println("You broke your kneecaps. You move half as fast.\n");
                    pace /= 2;
                    knees = false;
                }
            }
            
            if (Math.random() > .97){
                chariot();
            }
            if (Math.random() > .97){
                if (falcons()){
                    break;
                }
            }
            
            changeHealth();
            weather = changeWeather();
            if(weather.equals("Hurricane")){
                int timeLoss = (int) Math.random() * 4 + 2;
                System.out.println("In a hurricane. Lose " + timeLoss + " minutes.");
                mins += timeLoss - 1;
                pace = 0;
            } else if(weather.equals("Foggy")){
                System.out.println("Foggy weather. Slow down.");
                pace = 0;
                Epace = pace - 10;
            } else if(weather.equals("Meatball")){
                System.out.println("Cloudy with a definite chance of meatballs. Free food but slow down.");
                pace = 0;
                food += 20;
                Epace = pace - 5;
            } else if(weather.equals("Lightning")){
                System.out.println("You stop to admire the picturesque view of wide arcs of light dashing across the sky. Part of the view is blocked by SHS.");
                if (Math.random()>.98){
                    System.out.println("You got thunderstruck. You die immediately.");
                    break;
                }
            }
            System.out.println();
            
            if(food==0){lowerHealth();}
            if(tshirts==0){lowerHealth();}
            
            if(health.equals("ded")){
                if(Math.random()>.5){System.out.println("You died of dysentery, brought on by your bad health.");}
                else if(Math.random()>.5){System.out.println("You died of typhoid, brought on by your bad health.");}
                else{System.out.println("You died of yellow fever, brought on by your bad health.");}
                break;
            }
            
            mins++;
            food-= 5 * (falcons + 1);
            if(food<0)food = 0;
            if(pace>0){meters+=pace;}
            else{meters+=Epace;}
            
            if(meters>=1000){
                if(supplies<=2){System.out.println("You do not have enough supplies to graduate.");}
                else if(mins>=60) {System.out.println("You arrived late to school and lost your legs.");}
                else{System.out.println("Congratulations " + name + "! You have successfully completed the TogaTrail with " + calcScore() + " points!");}
                
                break;
            }
            
            GUI();
            try {
                 Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (meters < 1000){
            System.out.println("Rest in peace " + name + ". Try again tomorrow!");
        }
    }
    
    public String changeWeather(){
        String[] weathers = {"Sunny", "Sunny", "Sunny", "Cloudy", "Cloudy", "Cloudy", "Rainy", "Lightning", "Meatball", "Foggy", "Hurricane"};
        return weathers[(int)(Math.random()*weathers.length)];
    }
    
    public void changeHealth(){
        double chance = Math.random()*10;
        if(health.equals("good")){
            if(chance>9.5){health = "decent";} 
        }
        else if(health.equals("decent")){
            if(chance>9.2){health = "good";} 
            else if(chance>8.4){health = "bad";}
        }
        else if(health.equals("bad")){
            if(chance>9.2){health = "fair";} 
            else if(chance>8.4){health = "verge of death";}
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
    
    public boolean falcons(){
        double percent = (double) food / (5 * (falcons + 1));
        if (health.equals("bad")){percent -= .10;}
        else if(health.equals("verge of death")){percent -= .20;}
        
        if (Math.random() * 100 > percent){
            System.out.println("Oh no! One of your falcons died.\n");
            falcons--;
            if (falcons <= 0){
                System.out.println("You have no more falcons and are no longer able to go to school.");
                return true;
            }
        }
        return false;
    }
    
    public void chariot(){
        String parts[] = {"chariot wheel", "chariot axle", "chariot tongue"};
        int ind = (int) (Math.random() * 3);
        System.out.println("Your " + parts[ind] + " broke down.");
        if (chariotRepair[ind] > 0){
            System.out.println("Luckily, you were prepared! You will use your spare " + parts[ind] + ".");
            chariotRepair[ind]--;
        }
        else {
            System.out.println("Sadly, you were not prepared. You move much more slowly now.");
            pace -= 20; 
        }
        System.out.println();
    }
    
    public void GUI(){
        System.out.println("\n\n----------------------");
        System.out.println("Minute: " + mins);
        System.out.println("Weather: " + weather );
        System.out.println("Health: " + health);
        System.out.println("Food: " + food);
        System.out.println("Meters to Travel: " + (1000-meters) + " m");
        System.out.println("----------------------\n\n");
    }
    
    public int calcScore(){
        int score = (int) money + (60 - mins) + falcons + tshirts + food + chariotRepair[0] + chariotRepair[1] + chariotRepair[2] + supplies;
        if(health.equals("good")){score += 40;}
        else if(health.equals("decent")){score += 30;}
        else if(health.equals("bad")){score += 20;}
        else if(health.equals("verge of death")){score += 10;}
        return score; 
    }
    
}
