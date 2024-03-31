public class Hockey extends TeamInfo {
    private int lengthOfPeriod, scoringMethod;
    private String periodName;

    /**
     * contructor to initialize home team and away team
     * @param homeTeamInput string with home team name
     * @param awayTeamInput string with away team name
     */
    public Hockey(String homeTeamInput, String awayTeamInput) {
        super(homeTeamInput, awayTeamInput);
    }

    /**
     * @param inputFromUser whatever game was selected
     * @return the method chosen by the user to be used to calculate the score
     */
    @Override // scoring methods
    public int getScoringMethods(int inputFromUser){
        int goal = 1, assist = 1;
        int[] scoringMethodHockey;
        scoringMethodHockey = new int[11];
        scoringMethodHockey[0] = goal;
        scoringMethodHockey[1] = assist;
        scoringMethodHockey[2] = goal;
        scoringMethodHockey[3] = assist;
        scoringMethodHockey[4] = 0;

        if (inputFromUser == 4){
            endPeriod();
        }
        for (int i = 0; i <= scoringMethodHockey.length; i++ ){
            if (i == inputFromUser){
                scoringMethod = scoringMethodHockey[i-1];
            }
        }
        return scoringMethod;
    }

    /**
     * @return the amount of periods in a Hockey game
     */
    @Override
    public int getPeriodLength(){
        lengthOfPeriod = 3;
        return lengthOfPeriod;
    }

    /**
     * @return the name of the period in a Hockey game
     */
    @Override
    public String getPeriodName(){
        periodName = "Period";
        return periodName;
    }


}

