import java.util.Scanner;

/**
 * GameTypeInterfaceTest is the main program that runs the game
 */
public class GameTypeInterfaceTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        /**
         * ask the user what sport they want to play and then get home and away team names
         */
        System.out.println("Select the type of game: \n 1: Football \n 2: Basketball \n 3: Hockey \n 4: Soccer \n Enter choice: ");
        int gameTypeInput = input.nextInt();

        System.out.println("Enter Home team: ");
        String homeTeam = input2.nextLine();

        System.out.println("Enter Away team: ");
        String awayTeam = input2.nextLine();

        /**
         * based on the gameTypeInput, create an instance of that class (whichever sport chosen)
         * with the home and away team names. Start the game and which the current period indicates that
         * the game is not over, keep looping through the menu of scoring methods
         */
        if (gameTypeInput == 1) { // "1" = Football
            // create an instance of the Football class
            Football fballGame = new Football(homeTeam, awayTeam);
            fballGame.startGame();
            while (fballGame.getCurrentPeriod() <= fballGame.getPeriodLength()) {
                System.out.println("Menu: \n 1: " + homeTeam + " touchdown \n 2: " + homeTeam + " field goal \n 3: " + homeTeam +
                        " extra-point \n 4: " + homeTeam + " two-point conversion \n 5: " + homeTeam + " safety \n 6: " + awayTeam + " touchdown \n 7: " +
                        awayTeam + " field goal \n 8: " + awayTeam + " extra-point \n 9: " + awayTeam + " two-point conversion \n 10: " +
                        awayTeam + " safety \n 11: End " + fballGame.getPeriodName());
                int menuInput = input.nextInt(); // record user input
                // get the scoring method chosen by user
                int scoringMethodChosen = fballGame.getScoringMethods(menuInput);
                if (menuInput < 6) {
                    fballGame.addScore(scoringMethodChosen, homeTeam);
                } else {
                    fballGame.addScore(scoringMethodChosen, awayTeam);
                }
                System.out.println("Current " + fballGame.getPeriodName() + ": " + fballGame.getCurrentPeriod());
                System.out.println(fballGame.getScore());
            }
            if (fballGame.isGameOver() == true) {
                System.out.print(fballGame.getScore() + "\n");
                System.out.println(fballGame.getWinningTeam());
            }
        } else if (gameTypeInput == 2) { // "2" = Basketball
            Basketball bballGame = new Basketball(homeTeam, awayTeam);
            bballGame.startGame();
            while (bballGame.getCurrentPeriod() <= bballGame.getPeriodLength()) {
                System.out.println("Menu: \n 1: " + homeTeam + "3-point shot \n 2: " + homeTeam + " 2-point shot \n 3: " + homeTeam +
                        " free throw \n 4: " + awayTeam + " 3-point shot \n 5: " + awayTeam + " 2-point shot \n 6: " + awayTeam + " free throw \n 7: End " + bballGame.getPeriodName());
                int newInput = input.nextInt();
                int scoringMethodChosen = bballGame.getScoringMethods(newInput);
                if (newInput < 4) {
                    bballGame.addScore(scoringMethodChosen, homeTeam);
                } else {
                    bballGame.addScore(scoringMethodChosen, awayTeam);
                }
                System.out.println("Current " + bballGame.getPeriodName() + ": " + bballGame.getCurrentPeriod());
                System.out.println(bballGame.getScore());
            }
            if (bballGame.isGameOver() == true) {
                System.out.print(bballGame.getScore() + "\n");
                System.out.println(bballGame.getWinningTeam());
            }
        } else if (gameTypeInput == 3) { // "3" = Hockey
            Hockey hockeyGame = new Hockey(homeTeam, awayTeam);
            hockeyGame.startGame();
            while (hockeyGame.getCurrentPeriod() <= hockeyGame.getPeriodLength()) {
                System.out.println("Menu: \n 1: " + homeTeam + "goal \n 2: " + homeTeam + " assist \n 3: " + awayTeam +
                        " goal \n 4: " + awayTeam + " assist \n 5: End " + hockeyGame.getPeriodName());
                int newerInput = input.nextInt();
                int scoringMethodChosen = hockeyGame.getScoringMethods(newerInput);
                if (newerInput <= 2) {
                    hockeyGame.addScore(scoringMethodChosen, homeTeam);
                } else {
                    hockeyGame.addScore(scoringMethodChosen, awayTeam);
                }
                System.out.println("Current " + hockeyGame.getPeriodName() + ": " + hockeyGame.getCurrentPeriod());
                System.out.println(hockeyGame.getScore());
            }
            if (hockeyGame.isGameOver() == true) {
                System.out.print(hockeyGame.getScore() + "\n");
                System.out.println(hockeyGame.getWinningTeam());
            }
        } else if (gameTypeInput == 4) { // "4" = Soccer
            Soccer sGame = new Soccer(homeTeam, awayTeam);
            sGame.startGame();
            while (sGame.getCurrentPeriod() <= sGame.getPeriodLength()) {
                System.out.println("Menu: \n 1: " + homeTeam + " goal \n 2: " + awayTeam + " goal \n 3: End " + sGame.getPeriodName());
                int newestInput = input.nextInt();
                int scoringMethodChosen = sGame.getScoringMethods(newestInput);
                if (newestInput <= 1) {
                    sGame.addScore(scoringMethodChosen, homeTeam);
                } else {
                    sGame.addScore(scoringMethodChosen, awayTeam);
                }
                System.out.println("Current " + sGame.getPeriodName() + ": " + sGame.getCurrentPeriod());
                System.out.println(sGame.getScore());
            }
            if (sGame.isGameOver() == true) {
                System.out.print(sGame.getScore() + "\n");
                System.out.println(sGame.getWinningTeam());
            }
        }
    }
}