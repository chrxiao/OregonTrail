import java.util.Scanner; 

/**
 * Write a description of class TogaTrail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TogaTrail
{
    private int score;
    private int money;
    
    public TogaTrail(){
        score = 0;
        money = 0;
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
        Scanner input = new Scanner(System.in); 
        int grade = Integer.parseInt(input.nextLine());
        if (grade >= 1 && grade <= 4){
            money = (grade + 8) * 100;
        }
        else {
            System.out.println("Please reenter:");
            startGame();
        }
    }
}
