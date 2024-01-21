import java.util.LinkedList;
public class Tournament {
    private int tournamentID;
    private int tournamentIDGen = 0;
    private String style;
    private int numGames;
    private LinkedList<Game> games;
    private int gameIDGen = 0;
    private boolean onGoing;

    // Overload constructor for onGoing and completed games 

    // onGoing games
    public Tournament(String style) {
        this.tournamentID = tournamentIDGen++;
        this.style = style;
        this.numGames = 0;
        this.games = new LinkedList<Game>();
        this.onGoing = true;
    }

    // Completed Games
    public Tournament(String style, int numGames, LinkedList<Game> games) {
        this.tournamentID = tournamentIDGen++;
        this.style = style;
        this.numGames = numGames;
        this.games = games;
        this.onGoing = false;
    }

    public int getTournamentID() {return tournamentID;}
    public String getStyle() {return style;}
    public int getNumGames() {return numGames;}
    public LinkedList<Game> getGames() {return games;}
    public boolean getOnGoing() {return onGoing;}

    public void setStyle(String style) {this.style  = style;}
    public void setNumGames(int numGames) {this.numGames = numGames;}
    public void setGames(LinkedList<Game> games) {this.games = games;}
    public void addGame(Game newGame, boolean lastGame) {
        if (onGoing) {
            newGame.setGameID(gameIDGen++);
            games.add(newGame);
            numGames++;
            if (lastGame) {onGoing = false;}
        } 
    }

}
