import java.util.LinkedList;
public class Tournament {
    private int tournamentID;
    private static int tournamentIDGen = 0;
    private int numGames;
    private LinkedList<Game> games;
    private LinkedList<Member> players;
    private int index = 0;
    private boolean onGoing;

    // Overload constructor for onGoing and completed games 

    // Ongoing games
    public Tournament(LinkedList<Member> players, int numGames) {
        this.tournamentID = tournamentIDGen++;
        this.numGames = numGames;
        this.games = new LinkedList<Game>();
        this.onGoing = true;
        this.players = players;
    }

    // Completed Games
    public Tournament(LinkedList<Member> players, int numGames, LinkedList<Game> games) {
        this.tournamentID = tournamentIDGen++;
        this.numGames = numGames;
        this.games = games;
        this.onGoing = false;
        this.players = players;
    }

    public int getTournamentID() {return tournamentID;}
    public int getNumGames() {return numGames;}
    public LinkedList<Game> getGames() {return games;}
    public LinkedList<Member> getPlayers() {return players;}
    public boolean getOnGoing() {return onGoing;}

    public void setNumGames(int numGames) {this.numGames = numGames;} 
    public void nextGame(Game newGame) {
        if (onGoing) {
            games.add(newGame);
            if (newGame.getOnGoing()) {return;}
            if (newGame.getTeam1Win()) {players.remove(index); players.remove(index); index += 2;}
            else {index += 2; players.remove(index); players.remove(index);}
            if (index >= players.size()) {index = 0;}
            if (games.size() == numGames) {onGoing = false;} 
            nextGame(new Game(players.get(index), players.get(index+1), players.get(index+2), players.get(index+3)));
        } 
    }

}
