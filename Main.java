import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//The main class
public class Main {

    public static void main(String args[]) {

        // Test cases
        Member testMember = new Member("Jiapei Du", "J_D");

        //Set all terminal colours beforehand.
        //The scheme is as follows (also set a constant to revert to default terminal style when needed)
        String DEFAULT_COLOUR = "\u001B[0m";
        //GREEN - add an object.
        String GREEN_COLOUR = "\u001B[32m";
        //RED - remove an object.
        String RED_COLOUR = "\u001B[31m";
        //BLUE - view an object.
        String BLUE_COLOUR = "\u001B[34m";
        //WHITE - help and administrative commands.
        String WHITE_COLOUR = "\u001B[37m";
        //PURPLE - all headers and command interfaces.
        String PURPLE_COLOUR = "\u001B[35m";
        
        //Set bold and plain text markers
        String PLAIN_TEXT = "\033[0;0m";
        String BOLD_TEXT = "\033[0;1m";


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

        System.out.println("\n");
        // System.out.println( "-------------------------------------------------------------------------------------------------------\n");
        try {TimeUnit.SECONDS.sleep(2);}
        catch (Exception e) {}
        System.out.println(BOLD_TEXT + "👋 Hey there! Welcome to the EUCHRE CLUB MANAGER (ECM)," + " where you can manage your Euchre club with ease." + PLAIN_TEXT);
        
        try {TimeUnit.SECONDS.sleep(2);}
        catch (Exception e) {}
        System.out.println("\n💡 ECM acts as a repository for all your members, tournaments, games, and player statistics.");
        System.out.println("📝 Start by adding a few players. Enter your commands next to the 🔍 symbol.\n");
        try {TimeUnit.SECONDS.sleep(2);}
        catch (Exception e) {}
        // System.out.println("-------------------------------------------------------------------------------------------------------");


        System.out.println("Before we begin, here's a list of all the commands.");

        //Declare a new scanner and statistics object
        Scanner input = new Scanner(System.in);

        Database statistics = new Database();

        //Repeat ad nauseum unless the application is quit
        while (true) {    

            System.out.print("\nWhat would you like to do next? Press 'h' for help. \n\n🔍");
            String cmd = input.nextLine().toLowerCase();
    
            // Help
            if (cmd.equals("h")) {
                System.out.print(   "\n-------------------------- ALL COMMANDS --------------------------\n" +

                                    "\033[0;0m" + "\nMEMBER CLASS:\n\n" + "\033[0;1m" +
                                    GREEN_COLOUR + "'am' OR 'addmember': Adds a member to the database.\n" +
                                    RED_COLOUR + "'rm' OR 'removemember': Removes a member from the database.\n" +
                                    BLUE_COLOUR + "'vm' OR 'viewmember': Searches for a member in the database.\n" +

                                    DEFAULT_COLOUR + "\nTOURNAMENT CLASS:\n\n" +
                                    GREEN_COLOUR + "'at' OR 'addtournament': Adds a tournament to the database.\n" +
                                    GREEN_COLOUR + "'atg' OR 'addtournamentgame': Adds game to the tournament.\n" +

                                    DEFAULT_COLOUR + "\nGAME CLASS:\n\n" +
                                    GREEN_COLOUR + "'ag' OR 'addgame': Adds a game to the database.\n" +
                                    GREEN_COLOUR + "'ar' OR 'addround': Adds a round to the game.\n" +

                                    DEFAULT_COLOUR + "\nSTATISTICS CLASS:\n\n" +
                                    BLUE_COLOUR + "'s' OR 'statistics': Open the statistics menu to manage data regarding game performance.\n" +

                                    DEFAULT_COLOUR + "\nHELP COMMAND:\n\n" +
                                    BLUE_COLOUR + "'h' OR 'help': Brings up a commands list.\n" +

                                    DEFAULT_COLOUR + "\nEXIT COMMAND:\n\n" +
                                    RED_COLOUR + "'e' OR 'exit': Exits the database." +

                                    DEFAULT_COLOUR + "\n------------------------------------------------------------\n");
            }

            // MEMBERS
            // Add member
            else if (cmd.equals("am") || cmd.equals("addmember")) {

                System.out.print("Enter the full name of the new member:\n> ");
                String name = input.nextLine().toLowerCase();
                System.out.print("Enter a username for the new member:\n> ");
                String username = input.nextLine().toLowerCase();
                
                if (true) {
                    Member newMember = new Member(name, username);
                    statistics.addMember(newMember);
                }

                else if (true) {
                    System.out.println("Sorry this username is taken.");
                }

                // print out the information
            }

            // Remove member
            else if (cmd.equals("rm") || cmd.equals("removemember")) {
                System.out.print("Enter the ID number of the member being removed:\n> ");
                int ID = Integer.parseInt(input.nextLine());
                
                if (statistics.getMember(ID) == null) {
                    System.out.println("Invalid ID.");
                }

                else {
                    // remove member method
                }
            }
            
            // View member
            else if (cmd.equals("vm") || cmd.equals("viewmember")) {
                System.out.print("Enter the ID number of the member being viewed:\n> ");
                int ID = Integer.parseInt(input.nextLine());

                if (statistics.getMember(ID) == null) {
                    System.out.println("Invalid ID.");
                }

                else {
                    System.out.println( "MEMBER:\n" +
                                        "Name: " + statistics.getMember(ID).getName() +
                                        "\nID: " + statistics.getMember(ID).getUserID() +
                                        "\nNumber of Games: " + statistics.getMember(ID).getNumGames() +
                                        "\nTotal Wins: " + statistics.getMember(ID).getTotalWins() +
                                        "\nTotal Losses: " + statistics.getMember(ID).getTotalLosses() +
                                        "\nWins on Offence: " + statistics.getMember(ID).getWinsOnOffence() +
                                        "\nWins on Defence: " + statistics.getMember(ID).getWinsOnDefence() +
                                        "\nLosses on Offence: " + statistics.getMember(ID).getLossesOnOffence() +
                                        "\nLosses on Defence: " + statistics.getMember(ID).getLossesOnDefence() +
                                        "\nWin/Loss Rate: " + statistics.getMember(ID).getWinLossRate() +
                                        "\nAverage Score: " + statistics.getMember(ID).getAverageScore());
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
            
            // Add game (under tournament)
            else if (cmd.equals("atg") || cmd.equals("addtournamentgame")) {
                System.out.print("Please enter the game number for the tournament:\n> ");
                int gameNum = Integer.parseInt(input.nextLine());
                System.out.println("Enter the ID number for the game:\n> ");
                int ID = Integer.parseInt(input.nextLine());
                
                if (statistics.getMember(ID) == null) {
                    System.out.println("Invalid ID.");
                }

                else {
                    // remove member method
                }

                // print out the information
            }
            
            // GAME
            // Add game (not under tournament)
            else if (cmd.equals("ag") || cmd.equals("addgame")) {
                System.out.print("Please enter the game number for the tournament:\n> ");
                int gameNum = Integer.parseInt(input.nextLine());
                System.out.println("Enter the tournament game info:");
                int player1;
                int player2;
                int player3;
                int player4;
                int offensePoints;
                int defensePoints;

                while (true) {
                    System.out.print("Player 1 ID:\n> ");
                    player1 = Integer.parseInt(input.nextLine());
    
                    if (statistics.getMember(player1) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Player 2 ID:\n> ");
                    player2 = Integer.parseInt(input.nextLine());
                    
                    if (statistics.getMember(player2) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Player 3 ID:\n> ");
                    player3 = Integer.parseInt(input.nextLine());
                    
                    if (statistics.getMember(player2) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Player 4 ID:\n> ");
                    player4 = Integer.parseInt(input.nextLine());
                    
                    if (statistics.getMember(player2) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Offense points:\n> ");
                    offensePoints = Integer.parseInt(input.nextLine());
                    
                    if (statistics.getMember(player2) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Defense points:\n> ");
                    defensePoints = Integer.parseInt(input.nextLine());
                    
                    if (statistics.getMember(player2) == null) {
                        System.out.println("Invalid ID.");
                    }

                    else if (cmd.equals("e") || cmd.equals("exit")) {
                        System.out.print("Exited database.");
                        break;
                    }

                    else {
                        break;
                    }
                }

                Game game = new Game(statistics.getMember(player1), statistics.getMember(player2), statistics.getMember(player3), statistics.getMember(player4), offensePoints, defensePoints, null);

                // print out the information
            }   
            
            // Add round
            else if (cmd.equals("ar") || cmd.equals("addround")) {
                System.out.print("Please enter the ID number for the game:\n> ");
                int ID = Integer.parseInt(input.nextLine());

                // method to check if id is real
            }
            
            // STATISTICS
            // To statistics
            else if (cmd.equals("s") || cmd.equals("statistics")) {
                System.out.print("Would you like to check stats for members or partnerships? (type 'm' or 'p')\n> ");
                String choice = input.nextLine().toLowerCase();
                
                if (choice.equals("m") || choice.equals("members")) {
                    while (true) {
                        System.out.print(   "\n---------------------STATISTICS---------------------\n" +
                                            "'ng' OR 'numberofgames': Sorts by number of games played\n" +
                                            "'w' OR 'wins': Sorts by wins\n" +
                                            "'l' OR 'losses': Sorts by losses\n" +
                                            "'ow' OR 'offensivewins': Sorts by offensive wins\n" +
                                            "'dw' OR 'defensivewins': Sorts by defensive wins\n" +
                                            "'ol' OR 'offensivelosses': Sorts by offensive losses\n" +
                                            "'dl' OR 'defensivelosses': Sorts by defensive losses\n" +
                                            "'wlr' OR 'winlossrate': Sorts by the win/loss rate\n" +
                                            "'as' OR 'averagescore': Sorts by the average score\n" +
                                            "'e' OR 'exit': Exits statistics" +
                                            "\n----------------------------------------------------\n\nPlease select which statistics you would like to view:\n> ");
                        String statscmd = input.nextLine().toLowerCase();

                        // Number of games
                        if (statscmd.equals("ng") || statscmd.equals("numberofgames")) {
                            System.out.println(statistics.getMemberRanksByStat(0));
                        }

                        // Wins
                        if (statscmd.equals("w") || statscmd.equals("wins")) {
                            statistics.getMemberRanksByStat(1);
                        }

                        // Losses
                        if (statscmd.equals("l") || statscmd.equals("losses")) {
                            statistics.getMemberRanksByStat(2);
                        }

                        // Offensive wins
                        if (statscmd.equals("ow") || statscmd.equals("offensivewins")) {
                            statistics.getMemberRanksByStat(3);
                        }

                        // Defensive wins
                        if (statscmd.equals("dw") || statscmd.equals("defensivewins")) {
                            statistics.getMemberRanksByStat(4);
                        }
                        
                        // Offensive losses
                        if (statscmd.equals("ol") || statscmd.equals("offensivelosses")) {
                            statistics.getMemberRanksByStat(5);
                        }

                        // Defensive losses
                        if (statscmd.equals("dl") || statscmd.equals("defensivelosses")) {
                            statistics.getMemberRanksByStat(6);
                        }

                        // Win loss rate
                        if (statscmd.equals("wlr") || statscmd.equals("winlossrate")) {
                            statistics.getMemberRanksByStat(7);
                        }

                        // Average score
                        if (statscmd.equals("as") || statscmd.equals("averagescore")) {
                            statistics.getMemberRanksByStat(8);
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
                        System.out.print(   "\n---------------------STATISTICS---------------------\n" +
                                            "'n' OR 'wins': Sorts by number of games played\n" +
                                            "'w' OR 'wins': Sorts by wins\n" +
                                            "'l' OR 'losses': Sorts by losses\n" +
                                            "'ow' OR 'offensivewins': Sorts by offensive wins\n" +
                                            "'dw' OR 'defensivewins': Sorts by defensive wins\n" +
                                            "'ol' OR 'offensivelosses': Sorts by offensive losses\n" +
                                            "'dl' OR 'defensivelosses': Sorts by defensive losses\n" +
                                            "'wlr' OR 'winlossrate': Sorts by the win/loss rate\n" +
                                            "'as' OR 'averagescore': Sorts by the average score\n" +
                                            "'e' OR 'exit': Exits statistics" +
                                            "\n----------------------------------------------------\n\nPlease select which statistics you would like to view:\n> ");
                        
                        String statscmd = input.nextLine().toLowerCase();

                        // Number of games
                        if (statscmd.equals("ng") || statscmd.equals("numberofgames")) {
                            statistics.getMemberRanksByStat(0);
                        }

                        // Wins
                        if (statscmd.equals("w") || statscmd.equals("wins")) {
                            statistics.getPartnershipRanksByStat(1);
                        }

                        // Losses
                        if (statscmd.equals("l") || statscmd.equals("losses")) {
                            statistics.getPartnershipRanksByStat(2);
                        }

                        // Offensive wins
                        if (statscmd.equals("ow") || statscmd.equals("offensivewins")) {
                            statistics.getPartnershipRanksByStat(3);
                        }

                        // Defensive wins
                        if (statscmd.equals("dw") || statscmd.equals("defensivewins")) {
                            statistics.getPartnershipRanksByStat(4);
                        }
                        
                        // Offensive losses
                        if (statscmd.equals("ol") || statscmd.equals("offensivelosses")) {
                            statistics.getPartnershipRanksByStat(5);
                        }

                        // Defensive losses
                        if (statscmd.equals("dl") || statscmd.equals("defensivelosses")) {
                            statistics.getPartnershipRanksByStat(6);
                        }

                        // Win loss rate
                        if (statscmd.equals("wlr") || statscmd.equals("winlossrate")) {
                            statistics.getPartnershipRanksByStat(7);
                        }

                        // Average score
                        if (statscmd.equals("as") || statscmd.equals("averagescore")) {
                            statistics.getPartnershipRanksByStat(8);
                        }
                        
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
        input.close();
    }
}