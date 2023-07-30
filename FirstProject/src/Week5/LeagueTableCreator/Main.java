package Week5.LeagueTableCreator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //-------------------------
        Scanner sc = new Scanner(System.in);
        List<String> teams = new ArrayList<>();

        System.out.print("How many team will be in the tournament? ");
        int teamCount = sc.nextInt();
        for (int i = 1; i <= teamCount; i++) {
            System.out.print("Enter the " + i + ". team's name: ");
            String name = sc.next();
            teams.add(name);
        }

        System.out.println();
        System.out.println("Teams: ");
        for (String t : teams) {
            System.out.println("- " + t);
        }
        //--------------------------

        //creating all possibilities
        List<String> allPossibilities = createAllPossibilities(teams, teamCount);
        //creating league table
        List<String> finalMatches = createTable(allPossibilities, teams, teamCount);
        //printing league table
        for (String s : finalMatches) {
            System.out.println(s);
        }
    }

    static List<String> createAllPossibilities(List<String> teams, int teamCount) {

        List<String> allPossibilities = new ArrayList<>();

        //add a dummy team  if there is no even teams to indicate passing a team in that week
        if (teamCount % 2 == 1)
            teams.add("Bay");

        //create all possibilities which means every team will be played with all other teams
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size(); j++) {
                if (i == j) continue;
                String match = teams.get(i) + " vs " + teams.get(j);
                allPossibilities.add(match);
            }
        }

        return allPossibilities;
    }

    static List<String> createTable(List<String> allPossibilities, List<String> teams, int teamCount) {

        //week count is always (team-size - 1) * 2
        int weekCount = (teams.size() - 1) * 2;

        //creating copy to keep all possibilities safe in case we restarted the league table
        List<String> allPossibilitiesCopy = new ArrayList<>(allPossibilities);

        //to print only the final result
        List<String> finalMatches = new ArrayList<>();

        //if all possibilities is not used restart the creation of league table
        while (!allPossibilities.isEmpty()) {

            allPossibilities = new ArrayList<>(allPossibilitiesCopy);
            finalMatches = new ArrayList<>();

            //week's for-loop
            for (int i = 1; i <= weekCount; i++) {
                List<String> weeklyMatches = new ArrayList<>();

                //getting first possibility randomly and taking team names to not use them again
                Random rnd = new Random();
                String firstMatch = allPossibilities.get(rnd.nextInt(allPossibilities.size()));
                String t1 = firstMatch.split(" vs ")[0];
                String t2 = firstMatch.split(" vs ")[1];

                //actually our first match selected too
                weeklyMatches.add(firstMatch);
                allPossibilities.remove(firstMatch);

                //to check team's repetition
                List<String> playedTeams = new ArrayList<>();
                playedTeams.add(t1);
                playedTeams.add(t2);

                //to try to add new matches
                for (int j = 0; j < allPossibilities.size(); j++) {

                    //checking if we got already used teams
                    String t3 = allPossibilities.get(j).split(" vs ")[0];
                    String t4 = allPossibilities.get(j).split(" vs ")[1];
                    if (playedTeams.contains(t3) || playedTeams.contains(t4))
                        continue;

                    //if we not then affect everything
                    playedTeams.add(t3);
                    playedTeams.add(t4);
                    weeklyMatches.add(allPossibilities.get(j));
                    allPossibilities.remove(j);
                    j--;

                    //if we use all teams, break
                    if (playedTeams.size() >= teamCount) break;
                }

                //creating a string to represent a week
                String weeksMatches = "\nWEEK " + i + "\n";
                for (String s : weeklyMatches) {
                    weeksMatches += "\n" + s;
                }

                finalMatches.add(weeksMatches);
            }
        }

        return finalMatches;
    }
}