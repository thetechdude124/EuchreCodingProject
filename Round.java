package EuchreCodingProject;
public class Round {
    private Member offencePlayer1;
    private Member offencePlayer2;
    private Member defencePlayer1;
    private Member defencePlayer2;
    private Member dealer;
    private Member trumpEstablisher;
    private String trumpSuit;
    private int offenceTricks;
    private int defenceTricks;
    private boolean offenceWin;
    private int pointsAwarded;
    private boolean onGoing; 

    // Overload the constructors for ongoing and completed games

    // Ongoing games
    public Round(Member offencePlayer1, Member offencePlayer2, Member defencePlayer1, Member defencePlayer2, Member dealer) {
        this.offencePlayer1 = offencePlayer1;
        this.offencePlayer2 = offencePlayer2;
        this.defencePlayer1 = defencePlayer1;
        this.defencePlayer2 = defencePlayer2;
        this.dealer = dealer;
        this.onGoing = true; 
    }

    // Completed games
    public Round(Member offencePlayer1, Member offencePlayer2, Member defencePlayer1, Member defencePlayer2, Member dealer, Member trumpEstablisher, String trumpSuit, int offenceTricks, int defenceTricks, boolean offenceWin, int pointsAwarded) {
        this.offencePlayer1 = offencePlayer1;
        this.offencePlayer2 = offencePlayer2;
        this.defencePlayer1 = defencePlayer1;
        this.defencePlayer2 = defencePlayer2;
        this.dealer = dealer;
        this.trumpEstablisher = trumpEstablisher;
        this.trumpSuit = trumpSuit;
        this.offenceTricks = offenceTricks;
        this.defenceTricks = defenceTricks;
        this.offenceWin = offenceWin;
        this.pointsAwarded = pointsAwarded;
        this.onGoing = false; 
    }

    public Member getOffencePlayer1() {return offencePlayer1;}
    public Member getOffencePlayer2() {return offencePlayer2;}
    public Member getDefencePlayer1() {return defencePlayer1;}
    public Member getDefencePlayer2() {return defencePlayer2;}
    public Member getDealer() {return dealer;}
    public Member getTrumpEstablisher() {return trumpEstablisher;}
    public String getTrumpSuit() {return trumpSuit;}
    public int getOffenceTricks() {return offenceTricks;}
    public int getDefenceTricks() {return defenceTricks;}
    public boolean getOffenceWin() {return offenceWin;}
    public int getPointsAwarded() {return pointsAwarded;}
    public boolean getOnGoing() {return onGoing;}

    

}