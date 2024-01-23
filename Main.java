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
                String name = input.nextLine().toLowerCase();
                System.out.print("Enter a username for the new member:\n> ");
                String username = input.nextLine().toLowerCase();
                
                if (true) {
                    Member newMember = new Member(name, username);
                    statistics.addMember(newMember);
                }

                else if (true) {
                    
                }

                // method to check if username is taken

                System.out.println("Sorry this username is taken.");

                // print out the information
            }

            // Remove member
            else if (cmd.equals("rm") || cmd.equals("removemember")) {
                System.out.print("Enter the ID number of the member being removed:\n> ");
                int ID = Integer.parseInt(input.nextLine());
                
                // method to check if id is real
            }
            
            // View member
            else if (cmd.equals("vm") || cmd.equals("viewmember")) {
                System.out.print("Enter the ID number of the member being viewed:\n> ");
                int ID = Integer.parseInt(input.nextLine());

                // method to check if id is real
            }
            
            // TOURNAMENTS
            // Add tournament
            else if (cmd.equals("at") || cmd.equals("addtournament")) {
                System.out.print("Enter the name of the tournament:\n> ");
                String name = input.nextLine().toLowerCase();
                System.out.print("Choose the number of players participating in the tournament (use powers of two like 4, 8, 16, etc.)");
                int numOfPlayers = Integer.parseInt(input.nextLine());
            }
            
            // Add game (under tournament)
            else if (cmd.equals("atg") || cmd.equals("addtournamentgame")) {
                System.out.print("Please enter the game number for the tournament:\n> ");
                int gameNum = Integer.parseInt(input.nextLine());
                System.out.print("Enter the tournament game info:\nPlayer 1 ID:\n> ");
                int player1 = Integer.parseInt(input.nextLine());
                System.out.print("Player 2 ID:\n> ");
                int player2 = Integer.parseInt(input.nextLine());
                System.out.print("Player 3 ID:\n> ");
                int player3 = Integer.parseInt(input.nextLine());
                System.out.print("Player 4 ID:\n> ");
                int player4 = Integer.parseInt(input.nextLine());
                System.out.print("Offense points:\n> ");
                int offensePoints = Integer.parseInt(input.nextLine());
                System.out.print("Defense points:\n> ");
                int defensePoints = Integer.parseInt(input.nextLine());

                Game game = new Game(statistics.getMember(player1), statistics.getMember(player2), statistics.getMember(player3), statistics.getMember(player4));

                // print out the information
            }
            
            // GAME
            // Add game (not under tournament)
            else if (cmd.equals("ag") || cmd.equals("addgame")) {
                System.out.print("Enter the game info:\nPlayer 1 ID:\n> ");
                String player1 = input.nextLine().toLowerCase();
                System.out.print("Player 2 ID:\n> ");
                String player2 = input.nextLine().toLowerCase();
                System.out.print("Player 3 ID:\n> ");
                String player3 = input.nextLine().toLowerCase();
                System.out.print("Player 4 ID:\n> ");
                String player4 = input.nextLine().toLowerCase();
                System.out.print("Offense points:\n> ");
                String offensePoints = input.nextLine().toLowerCase();
                System.out.print("Defense points:\n> ");
                String defensePoints = input.nextLine().toLowerCase();

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
                            statistics.getPartnershipRanksByStat(0);
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