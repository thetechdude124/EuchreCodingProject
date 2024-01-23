import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//The main class
public class Main {

        //Set all terminal colours beforehand.
        //The scheme is as follows (also set a constant to revert to default terminal style when needed)
        private static String DEFAULT_COLOUR = "\u001B[0m";
        //GREEN - add an object.
        private static String GREEN_COLOUR = "\u001B[32m";
        //RED - remove an object.
        private static String RED_COLOUR = "\u001B[31m";
        //BLUE - view an object.
        private static String BLUE_COLOUR = "\u001B[34m";
        //PURPLE - all headers and command interfaces, as well as administrative examples.
        private static String PURPLE_COLOUR = "\u001B[35m";
        
        //Set bold and plain text markers
        private static String PLAIN_TEXT = "\033[0;0m";
        private static String BOLD_TEXT = "\033[0;1m";

        //IN DEVELOPMENT FLAG - this disables all animations for development acceleration purposes.
        private static boolean IN_DEVELOPMENT = true;


    //Function to render "All Commands" menu when necessary
    public static void renderAllCommands() {
        System.out.println(BOLD_TEXT + PURPLE_COLOUR + "\n------------------------- ALL COMMANDS -------------------------\n" +

                    DEFAULT_COLOUR + BOLD_TEXT + "\nMEMBER CLASS:\n\n" +
                    GREEN_COLOUR + "'am' OR 'addmember': Adds a member to the database.\n" +
                    RED_COLOUR + "'rm' OR 'removemember': Removes a member from the database.\n" +
                    BLUE_COLOUR + "'vm' OR 'viewmember': Searches for a member in the database.\n" +

                    DEFAULT_COLOUR + BOLD_TEXT + "\nTOURNAMENT CLASS:\n\n" +
                    GREEN_COLOUR + "'at' OR 'addtournament': Adds a tournament to the database.\n" +
                    GREEN_COLOUR + "'atg' OR 'addtournamentgame': Adds game to the tournament.\n" +

                    DEFAULT_COLOUR + BOLD_TEXT + "\nGAME CLASS:\n\n" +
                    GREEN_COLOUR + "'sg' OR 'startgame': Starts a game and adds it to the database.\n" +
                    GREEN_COLOUR + "'eg' OR 'endgame': Ends a game.\n" +
                    GREEN_COLOUR + "'ar' OR 'addround': Adds a round to the game.\n" +

                    DEFAULT_COLOUR + BOLD_TEXT + "\nSTATISTICS CLASS:\n\n" +
                    BLUE_COLOUR + "'s' OR 'statistics': Open the statistics menu.\n" +

                    DEFAULT_COLOUR + BOLD_TEXT + "\nHELP COMMAND:\n\n" +
                    BLUE_COLOUR + "'h' OR 'help': Brings up a commands list.\n" +

                    DEFAULT_COLOUR + BOLD_TEXT + "\nEXIT COMMAND:\n\n" +
                    RED_COLOUR + "'e' OR 'exit': Exits the database." +

                    PURPLE_COLOUR + "\n---------------------------------------------------------------\n");
    }

    //Functon to render "Statistics" menu when necessary
    public static void renderStatistics() {
        System.out.println(BOLD_TEXT + PURPLE_COLOUR + "\n------------------------- STATISTICS -------------------------\n" +

                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "\n'ng' OR 'numberofgames': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by number of games played.\n" +
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "'w' OR 'wins': "  + PLAIN_TEXT + GREEN_COLOUR + "Sorts by wins.\n" +
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "'l' OR 'losses': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by losses.\n" +
                            
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "\n'ow' OR 'offensivewins': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by offensive wins.\n" +
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "'dw' OR 'defensivewins': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by defensive wins.\n" +
                            
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "\n'ol' OR 'offensivelosses': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by offensive losses.\n" +
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "'dl' OR 'defensivelosses': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by defensive losses.\n" +

                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "\n'wlr' OR 'winlossrate': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by the win/loss rate.\n" +
                            DEFAULT_COLOUR + BOLD_TEXT + GREEN_COLOUR + "'as' OR 'averagescore': " + PLAIN_TEXT + GREEN_COLOUR + "Sorts by the average score.\n" +

                            DEFAULT_COLOUR + BOLD_TEXT + RED_COLOUR + "\n'e' OR 'exit': " + PLAIN_TEXT + RED_COLOUR + "Exits statistics.\n" +

                            DEFAULT_COLOUR + BOLD_TEXT + PURPLE_COLOUR + "\n--------------------------------------------------------------\n\n" + DEFAULT_COLOUR);
    }

    //Custom "Delay" function for rendering objects to the terminal in an aesthetically pleasing manner
    //If in development, do not institute a delay.
    public static void delay(int seconds) {
        if (!IN_DEVELOPMENT) {
            try {TimeUnit.SECONDS.sleep(seconds);}
            catch (Exception e) {}
        }
    }

    public static void main(String args[]) {

        //Display application header.
        System.out.println();
        System.out.println(PURPLE_COLOUR + "==============================================================================================================================================================");
        System.out.println(
            """
                 _______   ___  ___  ________  ___  ___  ________  _______           _____ ______   ________  ________   ________  ________  _______   ________         
                |\\  ___ \\ |\\  \\|\\  \\|\\   ____\\|\\  \\|\\  \\|\\   __  \\|\\  ___ \\         |\\   _ \\  _   \\|\\   __  \\|\\   ___  \\|\\   __  \\|\\   ____\\|\\  ___ \\ |\\   __  \\        
                \\ \\   __/|\\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\   __/|        \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\  \\|\\  \\ \\  \\___|\\ \\   __/|\\ \\  \\|\\  \\       
                 \\ \\  \\_|/_\\ \\  \\\\\\  \\ \\  \\    \\ \\   __  \\ \\   _  _\\ \\  \\_|/__       \\ \\  \\\\|__| \\  \\ \\   __  \\ \\  \\\\ \\  \\ \\   __  \\ \\  \\  __\\ \\  \\_|/_\\ \\   _  _\\      
                  \\ \\  \\_|\\ \\ \\  \\\\\\  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\_|\\ \\       \\ \\  \\    \\ \\  \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  \\\\  \\| ___ 
                   \\ \\_______\\ \\_______\\ \\_______\\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\_______\\       \\ \\__\\    \\ \\__\\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\__\\\\ _\\|\\__\\
                    \\|_______|\\|_______|\\|_______|\\|__|\\|__|\\|__|\\|__|\\|_______|        \\|__|     \\|__|\\|__|\\|__|\\|__| \\|__|\\|__|\\|__|\\|_______|\\|_______|\\|__|\\|__\\|__|
            """
        );
        System.out.println("==============================================================================================================================================================" + DEFAULT_COLOUR);

        //Display initial instructions with a 2 second delay for animation purposes.
        System.out.println("\n");
        delay(2);
        System.out.println(BOLD_TEXT + "👋 Hey there! Welcome to the EUCHRE CLUB MANAGER (ECM)," + " where you can manage your Euchre club with ease." + PLAIN_TEXT);
        
        //Describe the ECM after a 3 second delay.
        delay(3);
        System.out.println("\n💡 ECM acts as a repository for all your members, tournaments, games, and player statistics.");
        System.out.println("📝 Start by adding a few players. Enter your commands next to the 🔍 symbol.\n");
        delay(3);

        //On startup, display the help menu for user friendliness. Set to bold.
        System.out.print(BOLD_TEXT);
        System.out.println(PURPLE_COLOUR + "Before we begin, here's a list of all the command colours you'll need to know.\n" + DEFAULT_COLOUR);
        delay(2);

        //Prior to displaying the help menu, quickly walk through what each of the colours mean.
        System.out.println(BOLD_TEXT + GREEN_COLOUR + "GREEN" + DEFAULT_COLOUR + " - this is for commands that add and/or sort items.");
        delay(2);
        System.out.println(BOLD_TEXT + RED_COLOUR + "RED" + DEFAULT_COLOUR + " - this is for commands that remove items (as well as the exit command).");
        delay(2);
        System.out.println(BOLD_TEXT + BLUE_COLOUR + "BLUE" + DEFAULT_COLOUR + " - this is for commands that view/display items or statistics.");
        delay(2);
        System.out.println(BOLD_TEXT + PURPLE_COLOUR + "PURPLE" + DEFAULT_COLOUR + " - this is for general application headers and instructions.");
        delay(3);

        //Display the menu
        System.out.println("\nThat being said... here's the menu:");
        delay(3);
        renderAllCommands();

        //Final message before allowing the user to enter commands
        delay(3);
        System.out.println("\n" + DEFAULT_COLOUR + "You're ready to begin! Thanks for choosing ECM. Let's get started!\n");
        delay(3);

        //Declare a new scanner and Database object
        Scanner input = new Scanner(System.in);

        Database database = new Database();

        //Repeat ad nauseum unless the application is quit
        while (true) {    
            try {
                 
                System.out.print(DEFAULT_COLOUR + PURPLE_COLOUR + "\n---------------------------------------------------");
                System.out.print(BOLD_TEXT + "\nWhat would you like to do next? Press 'h' for help." + DEFAULT_COLOUR + "\n🔍 ");
                String cmd = input.nextLine().toLowerCase();
                System.out.println(PURPLE_COLOUR + "---------------------------------------------------\n" + DEFAULT_COLOUR);
        
                //For the help command
                if (cmd.equals("h")) {renderAllCommands();}

                // MEMBERS
                // Add member
                else if (cmd.equals("am") || cmd.equals("addmember")) {

                    System.out.print("Enter the full name of the new member:\n> ");
                    String name = input.nextLine();
                    System.out.print("Enter a username for the new member:\n> ");
                    String username = input.nextLine();
                    
                    if (database.checkUsername(username)) {
                        Member newMember = new Member(name, username);
                        database.addMember(newMember);
                        System.out.println("Member successfully added.\nThe member ID is: " + newMember.getUserID());
                    }

                    else {
                        System.out.println("Sorry this username is taken.");
                    }

                    // print out the information
                }

                // Remove member
                else if (cmd.equals("rm") || cmd.equals("removemember")) {
                    System.out.print("Enter the ID number of the member being removed:\n> ");
                    int ID = Integer.parseInt(input.nextLine());
                    
                    if (database.getMember(ID) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else {
                        System.out.println("Successfully removed member.");
                        database.removeMember(ID);
                    }
                }
                
                // View member
                else if (cmd.equals("vm") || cmd.equals("viewmember")) {
                    System.out.print("Enter the ID number of the member being viewed:\n> ");
                    int ID = Integer.parseInt(input.nextLine());

                    if (database.getMember(ID) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else {
                        System.out.println( "MEMBER:\n" +
                                            "Name: " + database.getMember(ID).getName() +
                                            "\nID: " + database.getMember(ID).getUserID() +
                                            "\nNumber of Games: " + database.getMember(ID).getNumGames() +
                                            "\nTotal Wins: " + database.getMember(ID).getTotalWins() +
                                            "\nTotal Losses: " + database.getMember(ID).getTotalLosses() +
                                            "\nWins on Offence: " + database.getMember(ID).getWinsOnOffence() +
                                            "\nWins on Defence: " + database.getMember(ID).getWinsOnDefence() +
                                            "\nLosses on Offence: " + database.getMember(ID).getLossesOnOffence() +
                                            "\nLosses on Defence: " + database.getMember(ID).getLossesOnDefence() +
                                            "\nWin/Loss Rate: " + database.getMember(ID).getWinLossRate() +
                                            "\nAverage Score: " + database.getMember(ID).getAverageScore());
                    }
                }
                
                // TOURNAMENTS
                // Add tournament
                else if (cmd.equals("at") || cmd.equals("addtournament")) {
                    System.out.print("Enter the name of the tournament:\n> ");
                    String name = input.nextLine().toLowerCase();
                    System.out.print("Choose the number of players participating in the tournament (use powers of two like 4, 8, 16, etc.)\n> ");
                    int numOfPlayers = Integer.parseInt(input.nextLine());

                    // NEEDS FINISHING
                }
                
                // Adds a completed game to the tournament
                else if (cmd.equals("atg") || cmd.equals("addtournamentgame")) {
                    System.out.println("Enter the ID number for the completed game:\n> ");
                    int ID = Integer.parseInt(input.nextLine());
                    
                    if (database.getMember(ID) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else {
                        System.out.println("Game successfully added.");
                    }

                    // print out the information
                }
                
                // GAME
                // Starts a game
                else if (cmd.equals("sg") || cmd.equals("startgame")) {
                    System.out.println("Enter the game info (any key to exit):");
                    int player1;
                    int player2;
                    int player3;
                    int player4;

                    while (true) {
                        System.out.print("Player 1 ID:\n> ");
                        player1 = Integer.parseInt(input.nextLine());
        
                        if (database.getMember(player1) == null) {
                            System.out.println("Invalid ID.");
                        }

                        else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Player 2 ID:\n> ");
                        player2 = Integer.parseInt(input.nextLine());
                        
                        if (database.getMember(player2) == null) {
                            System.out.println("Invalid ID.");
                        }

                        else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Player 3 ID:\n> ");
                        player3 = Integer.parseInt(input.nextLine());
                        
                        if (database.getMember(player2) == null) {
                            System.out.println("Invalid ID.");
                        }

                        else {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Player 4 ID:\n> ");
                        player4 = Integer.parseInt(input.nextLine());
                        
                        if (database.getMember(player2) == null) {
                            System.out.println("Invalid ID.");
                        }

                        else {
                            break;
                        }
                    }

                    Game newGame = new Game(database.getMember(player1), database.getMember(player2), database.getMember(player3), database.getMember(player4));
                    System.out.println("Game successfully created.\nThe game ID is: " + newGame.getGameID());

                    // print out the information
                }

                else if (cmd.equals("eg") || cmd.equals("endgame")) {
                    System.out.print("Please enter the ID number for the game:\n> ");
                    int ID = Integer.parseInt(input.nextLine());

                    if (database.getGame(ID) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else {

                    }
                }
                
                // Add round
                else if (cmd.equals("ar") || cmd.equals("addround")) {
                    System.out.print("Please enter the ID number for the game:\n> ");
                    int ID = Integer.parseInt(input.nextLine());

                    if (database.getGame(ID) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else {
                        
                    }
                }
                
                // STATISTICS
                // To statistics
                else if (cmd.equals("s") || cmd.equals("statistics")) {
                    System.out.print("Would you like to check stats for members or partnerships? (type 'm' or 'p')\n> ");
                    String choice = input.nextLine().toLowerCase();
                    
                    if (choice.equals("m") || choice.equals("members")) {
                        while (true) {

                            //Render statistics menu
                            renderStatistics();

                            System.out.print("Please select which statistics you would like to view:\n> ");
                            String statscmd = input.nextLine().toLowerCase();

                            // Number of games
                            if (statscmd.equals("ng") || statscmd.equals("numberofgames")) {
                                database.printMemberTop5(0);
                            }

                            // Wins
                            if (statscmd.equals("w") || statscmd.equals("wins")) {
                                database.printMemberTop5(1);
                            }

                            // Losses
                            if (statscmd.equals("l") || statscmd.equals("losses")) {
                                database.printMemberTop5(2);
                            }

                            // Offensive wins
                            if (statscmd.equals("ow") || statscmd.equals("offensivewins")) {
                                database.printMemberTop5(3);
                            }

                            // Defensive wins
                            if (statscmd.equals("dw") || statscmd.equals("defensivewins")) {
                                database.printMemberTop5(4);
                            }
                            
                            // Offensive losses
                            if (statscmd.equals("ol") || statscmd.equals("offensivelosses")) {
                                database.printMemberTop5(5);
                            }

                            // Defensive losses
                            if (statscmd.equals("dl") || statscmd.equals("defensivelosses")) {
                                database.printMemberTop5(6);
                            }

                            // Win loss rate
                            if (statscmd.equals("wlr") || statscmd.equals("winlossrate")) {
                                database.printMemberTop5(7);
                            }

                            // Average score
                            if (statscmd.equals("as") || statscmd.equals("averagescore")) {
                                database.printMemberTop5(8);
                            }
                            
                            // Exit
                            if (statscmd.equals("e") || statscmd.equals("exit")) {
                                System.out.println("Exited statistics.");
                                break;
                            }
                        }
                    }
                    
                    else if (choice.equals("p") || choice.equals("partnerships")) {
                        while (true) {

                            //Render statistics menu
                            renderStatistics();
                            System.out.print("Please select which statistics you would like to view:\n> ");
                            
                            String statscmd = input.nextLine().toLowerCase();

                            // Number of games
                            if (statscmd.equals("ng") || statscmd.equals("numberofgames")) {
                                database.printPartnershipTop5(0);
                            }

                            // Wins
                            if (statscmd.equals("w") || statscmd.equals("wins")) {
                                database.printPartnershipTop5(1);
                            }

                            // Losses
                            if (statscmd.equals("l") || statscmd.equals("losses")) {
                                database.printPartnershipTop5(2);                            }

                            // Offensive wins
                            if (statscmd.equals("ow") || statscmd.equals("offensivewins")) {
                                database.printPartnershipTop5(3);                            }

                            // Defensive wins
                            if (statscmd.equals("dw") || statscmd.equals("defensivewins")) {
                                database.printPartnershipTop5(4);                            }
                            
                            // Offensive losses
                            if (statscmd.equals("ol") || statscmd.equals("offensivelosses")) {
                                database.printPartnershipTop5(5);                            }

                            // Defensive losses
                            if (statscmd.equals("dl") || statscmd.equals("defensivelosses")) {
                                database.printPartnershipTop5(6);                            }

                            // Win loss rate
                            if (statscmd.equals("wlr") || statscmd.equals("winlossrate")) {
                                database.printPartnershipTop5(7);                            }

                            // Average score
                            if (statscmd.equals("as") || statscmd.equals("averagescore")) {
                                database.printPartnershipTop5(8);                            }
                            
                            // Exit
                            if (statscmd.equals("e") || statscmd.equals("exit")) {
                                System.out.println("Exited statistics.");
                                break;
                            }
                        }
                    }

                        else {
                            System.out.println("Invalid input.");
                        }
                    }

                    // EXIT
                    // Exits the program    
                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    // Invalid command
                    else {
                        System.out.println("Invalid command.");
                    }
            }
            
            //Handle exceptions
            catch (Exception e) {e.printStackTrace();}
        }
        
        System.out.println("Goodbye!");
        input.close();
    }
}