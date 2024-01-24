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
    public int nextGame(Database database, int ID) {
        if (onGoing) {
            if (database.getGame(ID) == null) {
                Game game = new Game(players.get(index), players.get(index+1), players.get(index+2), players.get(index+3));
                game.setGameID(ID);
                database.addGame(game);
            }
            Game newGame = database.getGame(ID);
            if (newGame.getOnGoing()) {return newGame.getGameID();}
            games.add(newGame);
            if (newGame.getTeam1Win()) {players.remove(index); players.remove(index); index += 2;}
            else {index += 2; players.remove(index); players.remove(index);}
            if (index >= players.size()) {index = 0;}
            if (games.size() == numGames) {onGoing = false; return -2;} 
            newGame = new Game(players.get(index), players.get(index+1), players.get(index+2), players.get(index+3));
            database.addGame(newGame);
            return nextGame(database, ID+1);
        } 
        return -1;
    }

}
