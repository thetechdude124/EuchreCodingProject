import java.util.LinkedList;
public class Tournament {
    private int tournamentID;
    private static int tournamentIDGen = 0;
    private String style;
    private int numGames;
    private LinkedList<Game> games;
    private LinkedList<Member> players;
    private boolean onGoing;

    // Overload constructor for onGoing and completed games 

    // Ongoing games
    public Tournament(String style, LinkedList<Member> players, int numGames) {
        this.tournamentID = tournamentIDGen++;
        this.style = style;
        this.numGames = numGames;
        this.games = new LinkedList<Game>();
        this.onGoing = true;
        this.players = players;
    }

    // Completed Games
    public Tournament(String style, Member[] players, int numGames, LinkedList<Game> games) {
        this.tournamentID = tournamentIDGen++;
        this.style = style;
        this.numGames = numGames;
        this.games = games;
        this.onGoing = false;
        this.players = players;
    }

    public int getTournamentID() {return tournamentID;}
    public String getStyle() {return style;}
    public int getNumGames() {return numGames;}
    public LinkedList<Game> getGames() {return games;}
    public boolean getOnGoing() {return onGoing;}

    public void setStyle(String style) {this.style  = style;}
    public void setNumGames(int numGames) {this.numGames = numGames;}
    public void setGames(LinkedList<Game> games) {this.games = games;}
    public void nextGame(Game newGame) {
        if (onGoing) {
            games.add(newGame);
            if (games.size() == numGames) {onGoing = false;}
        } 
    }

}
