import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        Statistics statistics = new Statistics();


        while (true) {    
            System.out.print("\nEUCHRE DATABASE\nType 'h' for a list of commands.\n> ");
            String cmd = input.nextLine().toLowerCase();
    
            // Help
            if (cmd.equals("h")) {
                System.out.print(   "\n--------------------------COMMANDS--------------------------\n" +
                                    "Member:\n" +
                                    "'am' OR 'addmember': Adds a member to the database\n" +
                                    "'rm' OR 'removemember': Removes a member from the database\n" +
                                    "'vm' OR 'viewmember': Searches for a member in the database\n" +
                                    "\nTournament:\n" +
                                    "'at' OR 'addtournament': Adds a tournament to the database\n" +
                                    "'atg' OR 'addtournamentgame': Adds game to the tournament\n" +
                                    "\nGame:\n" +
                                    "'ag' OR 'addgame': Adds a game to the database\n" +
                                    "'ar' OR 'addround': Adds a round to the game\n" +
                                    "\nStatistics:\n" +
                                    "'s' OR 'statistics': Go to the statistics commands\n" +
                                    "\nHelp:\n" +
                                    "'h' OR 'help': Brings up a commands list\n" +
                                    "\nExit:\n" +
                                    "'e' OR 'exit': Exits the database" +
                                    "\n------------------------------------------------------------\n");
            }

            // MEMBERS
            // Add member
            else if (cmd.equals("am") || cmd.equals("addmember")) {
                System.out.print("Enter the full name of the new member:\n> ");
                String name = input.nextLine();
                System.out.print("Enter a username for the new member:\n> ");
                String username = input.nextLine();
                
                System.out.print("Sorry this username is taken.");

            }

            // Remove member
            else if (cmd.equals("rm") || cmd.equals("removemember")) {
                System.out.print("Enter the ID number of the member being removed:\n> ");
                int ID = Integer.parseInt(input.nextLine());
                
            }
            
            // View member
            else if (cmd.equals("vm") || cmd.equals("viewmember")) {
                System.out.print("Enter the ID number of the member being viewed:\n> ");
                int ID = Integer.parseInt(input.nextLine());

            }
            
            // TOURNAMENTS
            // Add tournament
            else if (cmd.equals("at") || cmd.equals("addtournament")) {
                System.out.print("Enter the name of the tournament:\n> ");
                String name = input.nextLine();
                System.out.print("Choose the number of players participating in the tournament (use powers of two like 4, 8, 16, etc.)");
                int numOfPlayers = Integer.parseInt(input.nextLine());
            }
            
            // Add game (under tournament)
            else if (cmd.equals("atg") || cmd.equals("addtournamentgame")) {
                System.out.print("Please enter the game number for the tournament:\n> ");
                int gameNum = Integer.parseInt(input.nextLine());
                System.out.print("Enter the tournament game result:\nPlayer 1:\n> ");
                String player1 = input.nextLine();
                System.out.print("Player 2:\n> ");
                String player2 = input.nextLine();
                System.out.print("Player 3:\n> ");
                String player3 = input.nextLine();
                System.out.print("Player 4:\n> ");
                String player4 = input.nextLine();
                System.out.print("Offense points:\n> ");
                String offensePoints = input.nextLine();
                System.out.print("Defense points:\n> ");
                String defensePoints = input.nextLine();
            }
            
            // GAME
            // Add game (not under tournament)
            else if (cmd.equals("ag") || cmd.equals("addgame")) {
                System.out.print("Enter the game result:\nPlayer 1:\n> ");
                String player1 = input.nextLine();
                System.out.print("Player 2:\n> ");
                String player2 = input.nextLine();
                System.out.print("Player 3:\n> ");
                String player3 = input.nextLine();
                System.out.print("Player 4:\n> ");
                String player4 = input.nextLine();
                System.out.print("Offense points:\n> ");
                String offensePoints = input.nextLine();
                System.out.print("Defense points:\n> ");
                String defensePoints = input.nextLine();
            }   
            
            // Add round
            else if (cmd.equals("ar") || cmd.equals("addround")) {
                System.out.print("Please enter the ID number for the game:\n> ");
                int ID = Integer.parseInt(input.nextLine());

            }
            
            // STATISTICS
            // To statistics
            else if (cmd.equals("s") || cmd.equals("statistics")) {
                while (true) {
                    System.out.print(   "\n---------------------STATISTICS---------------------\n" +
                                        "'w' OR 'wins': Sorts by wins\n" +
                                        "'l' OR 'losses': Sorts by losses\n" +
                                        "'ow' OR 'offensivewins': Sorts by offensive wins\n" +
                                        "'dw' OR 'defensivewins': Sorts by defensive wins\n" +
                                        "'ol' OR 'offensivelosses': Sorts by offensive losses\n" +
                                        "'dl' OR 'defensivelosses': Sorts by defensive losses\n" +
                                        "'wlr' OR 'winlossrate': Sorts by the win/loss rate\n" +
                                        "'as' OR 'averagescore': Sorts by the average score\n" +
                                        "'e' OR 'exit': Exits statistics    " +
                                        "\n----------------------------------------------------\nPlease select which statistics you would like to view:\n> ");
                    String statscmd = input.nextLine().toLowerCase();
                }
            }
                
            else if (cmd.equals("e") || cmd.equals("exit")) {
                System.out.print("Exited database.");
            }

            // Invalid command
            else {
                System.out.println("Sorry that was an invalid command.");
            }
        }
    }
}