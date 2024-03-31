public class Basketball extends TeamInfo {
    private int lengthOfPeriod, scoringMethod, newScore;
    private String periodName;

    /**
     * contructor to initialize home team and away team
     * @param homeTeamInput string with home team name
     * @param awayTeamInput string with away team name
     */
    public Basketball(String homeTeamInput, String awayTeamInput){
        super(homeTeamInput, awayTeamInput);
    }

    /**
     * @param inputFromUser whatever game was selected
     * @return the method chosen by the user to be used to calculate the score
     */
    @Override // scoring methods
    public int getScoringMethods(int inputFromUser){
        int threePtShot = 3, twoPtShot = 2, freethrow = 1;
        int scoringMethodBball[];
        scoringMethodBball = new int[7];
        scoringMethodBball[0] = threePtShot;
        scoringMethodBball[1] = twoPtShot;
        scoringMethodBball[2] = freethrow;
        scoringMethodBball[3] = threePtShot;
        scoringMethodBball[4] = twoPtShot;
        scoringMethodBball[5] = freethrow;
        scoringMethodBball[6] = 0;

        if (inputFromUser == 7){
            endPeriod();
        }
        for (int i = 0; i <= scoringMethodBball.length; i++ ){
            if (i == inputFromUser){
                scoringMethod = scoringMethodBball[i-1];
            }
        }
        return scoringMethod;
    }

    /**
     * @return the amount of periods in a Basketball game
     */
    @Override
    public int getPeriodLength(){
        lengthOfPeriod = 4;
        return lengthOfPeriod;
    }

    /**
     * @return the name of the period in a Basketball game
     */
    @Override
    public String getPeriodName(){
        periodName = "Quarter";
        return periodName;
    }

}
