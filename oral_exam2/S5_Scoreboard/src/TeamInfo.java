
/**
 * TeamInfo is an abstract superclass that implements the scorable interface.
 * Here is where all the methods are defined
 */
public abstract class TeamInfo implements Scoreable {
    public static String homeTeam, awayTeam, winner;
    public static int lengthOfPeriod, currentPeriod, homeScore, awayScore;

    /**
     * Constructor to initialize team names when a game is created
     * @param homeTeamInput name of home team
     * @param awayTeamInput name of away team
     */
    public TeamInfo(String homeTeamInput, String awayTeamInput){
        setHomeTeam(homeTeamInput);
        setAwayTeam(awayTeamInput);
    }

    /**
     * sets the home team to the input
     * @param homeTeamInput name of home team
     */
    public void setHomeTeam(String homeTeamInput){homeTeam = homeTeamInput;}

    /**
     * sets the away team to the input
     * @param awayTeamInput name of away team
     */
    public void setAwayTeam(String awayTeamInput){awayTeam = awayTeamInput;}

    /**
     * returns the home team
     * @return String with home team name
     */
    public String getHomeTeam(){return homeTeam;}

    /**
     * returns the away team
     * @return String with away team name
     */
    public String getAwayTeam(){return awayTeam;}

    /**
     * getScoringMethods takes the input from user and returns the scoring methods for the particular game selected \
     * @param inputFromUser is whatever game was selected
     * @return the methods that can be done to score int that game
     */
    public abstract int getScoringMethods(int inputFromUser);

    /**
     * takes the current period and sets it to current period + 1
     */
    public void endPeriod() {
        int period = getCurrentPeriod();
        setCurrentPeriod(period+1);
    }

    /**
     * sets the current period to 1, sets the home and away team scores to 0
     */
    public void startGame(){
        setCurrentPeriod(1);
        setHomeScore(0);
        setAwayScore(0);
    }

    /**
     * sets the period from endPeriod() to the current period
     * @param period is the input indicating that the period it over.
     */
    public void setCurrentPeriod(int period){currentPeriod = period;}

    /**
     * sets the home team score
     * @param newScore is what the score is after they scored
     */
    public void setHomeScore(int newScore){
        homeScore = newScore;
    }
    /**
     * sets the away team score
     * @param newScore is what the score is after they scored
     */
    public void setAwayScore(int newScore){
        awayScore = newScore;
    }

    /**
     * @return home team score
     */
    public int getHomeScore(){return homeScore;};

    /**
     * @return away team score
     */
    public int getAwayScore(){return awayScore;};

    /**
     * @return a string with both the home and away team scores to be printed so the user can see
     */
    public String getScore(){
        String scoreString = homeTeam +"-"+ getHomeScore()+" " + awayTeam +"-"+ getAwayScore();
        return scoreString;
    };

    /**
     * addScore takes the scoring method and whichever team that scored and sets the new score accordingly
     * @param scoringMethod is the way something was scored, i.e. touchdown, 3-pointer, etc
     * @param homeOrAwayTeam the team that scored whose score needs to be updated
     */
    public void addScore(int scoringMethod, String homeOrAwayTeam) {
        if (homeOrAwayTeam.equals(getHomeTeam())){
            int homeScore = getHomeScore();
            setHomeScore(scoringMethod+homeScore);
        }
        else if (homeOrAwayTeam.equals(getAwayTeam())){
             int awayScore = getAwayScore();
             setAwayScore(scoringMethod+awayScore);
        }
    };

    /**
     * @return true if the currentPeriod is greater than the amt of periods in a game which indicates
     * that the game is over or false if otherwise.
     */
    public boolean isGameOver(){
        if (getCurrentPeriod() > lengthOfPeriod){
            getWinningTeam();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return length of period of that particular game
     */
    public abstract int getPeriodLength();

    /**
     * @return the type of period a game has i.e. quarter, half, etc.
     */
    public abstract String getPeriodName();

    /**
     * @return the current period
     */
    public int getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * displays the winning team
     * @return which team one
     */
    public String getWinningTeam() {
        if (getHomeScore() > getAwayScore()){
            return "Congrats, Home Team Wins!";
        }
        else {
            return "Congrats, Away Team Wins!";
        }
    };

}
