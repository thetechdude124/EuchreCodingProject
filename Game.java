import java.util.HashMap;
public class Game {
    private int gameID;
    private static int gameIDGen = 0;
    private Member player1;
    private Member player2; 
    private Member player3;
    private Member player4;
    private Member[] players;
    private boolean partners;
    private Partnership team1;
    private Partnership team2;
    private int team1Points;
    private int team2Points;
    private boolean team1Win;
    private boolean onGoing;
    private HashMap<Integer, Round> rounds;
    private static int roundIDGen;
    private static Round tempRound;

    // Overload constructor for ongoing and completed games

    // Ongoing member games
    public Game(Member player1, Member player2, Member player3, Member player4) {
        this.gameID = gameIDGen++;
        this.partners = false;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.players = new Member[]{player1, player2, player3, player4};
        this.onGoing = true;
        this.rounds = new HashMap<Integer, Round>();
    }

    // Ongoing partner games
    public Game(Partnership team1, Partnership team2) {
        this.gameID = gameIDGen++;
        this.partners = true;
        this.team1 = team1;
        this.team2 = team2;
        this.player1 = team1.getMember1();
        this.player2 = team1.getMember2();
        this.player3 = team2.getMember1();
        this.player4 = team2.getMember2(); 
        this.players = new Member[]{player1, player2, player3, player4};
        this.onGoing = true;
        this.rounds = new HashMap<Integer, Round>();
    }

    // Completed member games
    public Game(Member player1, Member player2, Member player3, Member player4, int team1Points, int team2Points, HashMap<Integer, Round> rounds) {
        this.gameID = gameIDGen++;
        this.partners = false;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.players = new Member[]{player1, player2, player3, player4};
        this.team1Points = team1Points;
        this.team2Points = team2Points;
        this.team1Win = (team1Points > team2Points) ? true : false; 
        this.onGoing = false;
        this.rounds = rounds;
    }

    // Completed partner games
    public Game(Partnership team1, Partnership team2, int team1Points, int team2Points, HashMap<Integer, Round> rounds) {
        this.gameID = gameIDGen++;
        this.partners = true;
        this.team1 = team1;
        this.team2 = team2;
        this.player1 = team1.getMember1();
        this.player2 = team1.getMember2();
        this.player3 = team2.getMember1();
        this.player4 = team2.getMember2(); 
        this.players = new Member[]{player1, player2, player3, player4};
        this.team1Points = team1Points;
        this.team2Points = team2Points;
        this.team1Win = (team1Points > team2Points) ? true : false; 
        this.onGoing = false;
        this.rounds = rounds;
    }

    // Getters
    public int getGameID() {return gameID;}
    public boolean getIsPartners() {return partners;}
    public Member getPlayer1() {return player1;}
    public Member getPlayer2() {return player2;}
    public Member getPlayer3() {return player3;}
    public Member getPlayer4() {return player4;}
    public Member[] getPlayers() {return players;}
    public Partnership getTeam1() {return team1;}
    public Partnership getTeam2() {return team2;}
    public int getTeam1Points() {return team1Points;}
    public int getTeam2Points() {return team2Points;}
    public boolean getTeam1Win() {return team1Win;}
    public boolean getOnGoing() {return onGoing;}
    public HashMap<Integer, Round> getRounds() {return rounds;}
    public Round getRound(int roundID) {return rounds.get(roundID);}

    public void setGameID(int gameID) {this.gameID = gameID;}
    public void setTeam1Points(int team1Points) {this.team1Points = team1Points;}
    public void setTeam2Points(int team2Points) {this.team2Points = team2Points;}

    // Completed rounds
    public void addRound(boolean team1Offence, Member team1Player1, Member team1Player2, Member team2Player1, Member team2Player2, Member dealer, Member trumpEstablisher, boolean goingAlone, String trumpSuit, int team1Tricks, boolean team1Win) {
        if (team1Offence) {tempRound = new Round(roundIDGen++, team1Player1, team1Player2, team2Player1, team2Player2, dealer, trumpEstablisher, goingAlone, trumpSuit, team1Tricks, team1Win);}
        else {tempRound = new Round(roundIDGen++, team2Player1, team2Player2, team1Player1, team1Player2, dealer, trumpEstablisher, goingAlone, trumpSuit, 5-team1Tricks, !team1Win);}
        rounds.put(tempRound.getRoundID(), tempRound);
        if (team1Win) {this.team1Points += tempRound.getPointsAwarded();}
        else {this.team2Points += tempRound.getPointsAwarded();}
        if (team1Points >= 10) {endGame(true);}
        else if (team2Points >= 10) {endGame(false);}
    }

    public void endGame() {
        if (onGoing) {
            if (team1Points >= 10 || team2Points >= 10) {this.team1Win = (team1Points > team2Points) ? true : false;}
            if (partners) {
                team1.newGame(this, team1Win, gameID);
                team2.newGame(this, team1Win, gameID);
            }
            for (Member i : players) {i.newGame(this, team1Win, gameID);}
            onGoing = false;
        }
    }

    public void endGame(boolean team1Win) {
        if (onGoing) {
            this.team1Win = team1Win;
            if (partners) {
                team1.newGame(this, team1Win, gameID);
                team2.newGame(this, team1Win, gameID);
            }
            for (Member i : players) {i.newGame(this, team1Win, gameID);}
            onGoing = false;
        }
    }

}
