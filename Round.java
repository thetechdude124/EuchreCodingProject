public class Round {
    private int roundID;
    private Member offencePlayer1;
    private Member offencePlayer2;
    private Member defencePlayer1;
    private Member defencePlayer2;
    private Member dealer;
    private Member trumpEstablisher;
    private boolean goingAlone; 
    private String trumpSuit;
    private int offenceTricks;
    private int defenceTricks;
    private boolean offenceWin;
    private int pointsAwarded;
    private boolean onGoing; 

    // Overload the constructors for ongoing and completed games

    // Ongoing games
    public Round(int roundID, Member offencePlayer1, Member offencePlayer2, Member defencePlayer1, Member defencePlayer2, Member dealer) {
        this.roundID = roundID;
        this.offencePlayer1 = offencePlayer1;
        this.offencePlayer2 = offencePlayer2;
        this.defencePlayer1 = defencePlayer1;
        this.defencePlayer2 = defencePlayer2;
        this.dealer = dealer;
        this.onGoing = true; 
    }

    // Completed games
    public Round(int roundID, Member offencePlayer1, Member offencePlayer2, Member defencePlayer1, Member defencePlayer2, Member dealer, Member trumpEstablisher, boolean goingAlone, String trumpSuit, int offenceTricks, int defenceTricks, boolean offenceWin, int pointsAwarded) {
        this.roundID = roundID;
        this.offencePlayer1 = offencePlayer1;
        this.offencePlayer2 = offencePlayer2;
        this.defencePlayer1 = defencePlayer1;
        this.defencePlayer2 = defencePlayer2;
        this.dealer = dealer;
        this.trumpEstablisher = trumpEstablisher;
        this.goingAlone = goingAlone;
        this.trumpSuit = trumpSuit;
        this.offenceTricks = offenceTricks;
        this.defenceTricks = defenceTricks;
        this.offenceWin = offenceWin;
        this.pointsAwarded = pointsAwarded;
        this.onGoing = false; 
    }

    // Getters
    public int getRoundID() {return roundID;}
    public Member getOffencePlayer1() {return offencePlayer1;}
    public Member getOffencePlayer2() {return offencePlayer2;}
    public Member getDefencePlayer1() {return defencePlayer1;}
    public Member getDefencePlayer2() {return defencePlayer2;}
    public Member getDealer() {return dealer;}
    public Member getTrumpEstablisher() {return trumpEstablisher;}
    public boolean getGoingAlone() {return goingAlone;}
    public String getTrumpSuit() {return trumpSuit;}
    public int getOffenceTricks() {return offenceTricks;}
    public int getDefenceTricks() {return defenceTricks;}
    public boolean getOffenceWin() {return offenceWin;}
    public int getPointsAwarded() {return pointsAwarded;}
    public boolean getOnGoing() {return onGoing;}

    // Methods
    public void establishTrump(Member trumpEstablisher, boolean goingAlone, String trumpSuit) {if(onGoing){this.trumpEstablisher = trumpEstablisher; this.goingAlone = goingAlone; this.trumpSuit = trumpSuit;}}
    public void addTrick(boolean offenceTrick) {
        if (offenceTrick) {offenceTricks++;} else {defenceTricks++;}
        if (offenceTricks + defenceTricks == 5) {endRound();}
    }
    public void endRound() {
        if (onGoing) {
            if (offenceTricks > defenceTricks) {
                offenceWin = true; 
                if (goingAlone) {
                    if (offenceTricks == 5) {pointsAwarded = 4;} else {pointsAwarded = 2;}
                } else {
                    if (offenceTricks == 5) {pointsAwarded = 2;} else {pointsAwarded = 1;}
                }
            } else {
                offenceWin = false;
                if (defenceTricks == 5) {pointsAwarded = 2;} else {pointsAwarded = 4;}
            } 
            onGoing = false;
        }
    }

}