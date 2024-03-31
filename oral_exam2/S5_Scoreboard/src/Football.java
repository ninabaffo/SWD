public class Football extends TeamInfo {
    private int lengthOfPeriod, scoringMethod;
    private String periodName;

    /**
     * contructor to initialize home team and away team
     * @param homeTeamInput string with home team name
     * @param awayTeamInput string with away team name
     */
    public Football(String homeTeamInput, String awayTeamInput){
        super(homeTeamInput, awayTeamInput);
    }

    /**
     * @param inputFromUser whatever game was selected
     * @return the method chosen by the user to be used to calculate the score
     */
    @Override // scoring methods
    public int getScoringMethods(int inputFromUser){
        int touchdown = 6, fieldGoal = 3, extraPoint = 1, safety = 2, twoPointConversion = 2;
        int[] scoringMethodFball;
        scoringMethodFball = new int[11];
        scoringMethodFball[0] = touchdown;
        scoringMethodFball[1] = fieldGoal;
        scoringMethodFball[2] = extraPoint;
        scoringMethodFball[3] = safety;
        scoringMethodFball[4] = twoPointConversion;
        scoringMethodFball[5] = touchdown;
        scoringMethodFball[6] = fieldGoal;
        scoringMethodFball[7] = extraPoint;
        scoringMethodFball[8] = safety;
        scoringMethodFball[9] = twoPointConversion;
        scoringMethodFball[10] = 0;

        if (inputFromUser == 11){
            endPeriod();
        }
        for (int i = 0; i <= scoringMethodFball.length; i++ ){
            if (i == inputFromUser){
                scoringMethod = scoringMethodFball[i-1];
            }
        }
        return scoringMethod;
    }

    /**
     * @return the amount of periods in a Football game
     */
    @Override
    public int getPeriodLength(){
        lengthOfPeriod = 4;
        return lengthOfPeriod;
    }

    /**
     * @return the name of the period in a football game
     */
    @Override
    public String getPeriodName(){
        periodName = "Quarter";
        return periodName;
    }


}
