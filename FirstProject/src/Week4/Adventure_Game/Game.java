package Week4.Adventure_Game;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        Scanner inp = new Scanner(System.in);

        System.out.println("Welcome to the game!");

        while(!gm.isGameFinished())
        {
            System.out.print("You are lost in island. To escape the island you must collect all items found in different places." +
                    " But be careful when you go to these places because of some kind of monsters." +
                    " Now you are at your base where you heal. Let's start to collect necessary items.");
            gm.selectPlace(inp);
        }
    }
}
