
/**
 * The Scorable interface defines all the behaviors that can be implemented by any of the classes in the
 * hierarchy.
 */
public interface Scoreable {
    /**
     * takes the method that was done to score and the team that scored and adds the points to it
     * @param scoringMethod is the way something was scored, i.e. touchdown, 3-pointer, etc
     * @param homeOrAwayTeam the team that scored whose score needs to be updated
     */
    void addScore(int scoringMethod, String homeOrAwayTeam);

    /**
     * getScoringMethods returns the scoring methods for the particular game selected by the user
     * @param userInput is whatever game was selected
     * @return scoring methods for that particular game
     */
    int getScoringMethods(int userInput);

    /**
     * getPeriodLength
     * @return the length of the period of the particular game selected so we can keep tracking while they are playing
     */
    int getPeriodLength();

    /**
     * setCurrentPeriod is used to start the period at 0 and increment it when the user inputs that the period it over.
     * @param period is the input indicating that the period it over.
     */
    void setCurrentPeriod(int period);

    /**
     * getPeriodName
     * @return the type of period for that particular game
     */
    String getPeriodName();

    /**
     * getCurrentPeriod
     * @return the current period to be outputted to the user
     */
    int getCurrentPeriod();

    /**
     * endPeriod is used when the user indicates they want to go to the next period
     */
    void endPeriod();

    /**
     * startGame is used to set the period and team names
     */
    void startGame();

    /**
     * @return the home team score
     */
    int getHomeScore();

    /**
     * @return the away team score
     */
    int getAwayScore();

    /**
     * terminates the game if the current period is greater than the amount of periods in a game
     * @return true or false
     */
    boolean isGameOver();

    /**
     * after the game is over getWinningTeam
     * @return the winning team
     */
    String getWinningTeam();

}
