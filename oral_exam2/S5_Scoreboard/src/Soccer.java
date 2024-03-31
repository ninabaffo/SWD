public class Soccer extends TeamInfo {
    private int lengthOfPeriod, scoringMethod;
    private String periodName;

    /**
     * contructor to initialize home team and away team
     * @param homeTeamInput string with home team name
     * @param awayTeamInput string with away team name
     */
    public Soccer(String homeTeamInput, String awayTeamInput) {
        super(homeTeamInput, awayTeamInput);
    }

    /**
     * @param inputFromUser whatever game was selected
     * @return the method chosen by the user to be used to calculate the score
     */
    @Override // scoring methods
    public int getScoringMethods(int inputFromUser) {
        int goal = 1;
        int[] scoringMethodSoccer;
        scoringMethodSoccer = new int[3];
        scoringMethodSoccer[0] = goal;
        scoringMethodSoccer[1] = goal;
        scoringMethodSoccer[2] = 0;

        if (inputFromUser == 2) {
            endPeriod();
        }
        for (int i = 0; i <= scoringMethodSoccer.length; i++) {
            if (i == inputFromUser) {
                scoringMethod = scoringMethodSoccer[i - 1];
            }
        }
        return scoringMethod;
    }

    /**
     * @return the amount of periods in a Soccer game
     */
    @Override
    public int getPeriodLength() {
        lengthOfPeriod = 2;
        return lengthOfPeriod;
    }

    /**
     * @return the name of the period in a Soccer game
     */
    @Override
    public String getPeriodName() {
        periodName = "Half ";
        return periodName;
    }
}