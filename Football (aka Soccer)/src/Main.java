import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) throws IOException{
        //Apparently default encoding is wrong
        //https://uva.onlinejudge.org/board/viewtopic.php?f=10&t=9336&hilit=10194&start=90#p141371
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));

        int caseNum = Integer.parseInt(input.readLine());
        for (int cases = 0; cases < caseNum; cases++) {

            String tournament = input.readLine().trim();
            int teamNum = Integer.parseInt(input.readLine());

            ArrayList<TeamStats> teamStats = new ArrayList<>();
            ArrayList<String> teamNames = new ArrayList<>();

            for (int i = 0; i < teamNum; i++) {
                String name = input.readLine().trim();
                teamStats.add(new TeamStats(name));
                teamNames.add(name);
            }
            int gameNums = Integer.parseInt(input.readLine());

            //Order of arraylist in teams
            //0 = Total points
            //1 = Number of games
            //2 = wins
            //3 = ties
            //4 = losses
            //5 = goal difference
            //6 = goals scores
            //7 = goals against
            for (int currentGame = 0; currentGame < gameNums; currentGame++) {
                String game = input.readLine();
                String[] teamsInvolved = game.split("#");
                String team1 = teamsInvolved[0];
                String team2 = teamsInvolved[2];
                String[] scores = teamsInvolved[1].split("@");
                int team1Score = Integer.parseInt(scores[0]);
                int team2Score = Integer.parseInt(scores[1]);

                //Update states
                TeamStats team1Stats = teamStats.get(teamNames.indexOf(team1));
                team1Stats.name = team1;
                TeamStats team2Stats = teamStats.get(teamNames.indexOf(team2));
                team2Stats.name = team2;
                //Both teams just played a game
                team1Stats.games++;
                team2Stats.games++;
                //Update points, wins, and losses
                if (team1Score > team2Score){
                    team1Stats.points += 3;
                    team1Stats.wins++;
                    team2Stats.losses++;
                } else if (team1Score < team2Score){
                    team2Stats.points += 3;
                    team2Stats.wins++;
                    team1Stats.losses++;
                } else {
                    team1Stats.points++;
                    team2Stats.points++;
                    team1Stats.ties++;
                    team2Stats.ties++;
                }
                //Difference in goals
                team1Stats.goalDifference += (team1Score - team2Score);
                team2Stats.goalDifference += (team2Score - team1Score);
                //Goals scored
                team1Stats.goalsScored += team1Score;
                team2Stats.goalsScored += team2Score;
                //Goals against
                team1Stats.goalsAgainst += team2Score;
                team2Stats.goalsAgainst += team1Score;

                teamStats.remove(teamNames.indexOf(team1));
                teamStats.add(teamNames.indexOf(team1), team1Stats);
                teamStats.remove(teamNames.indexOf(team2));
                teamStats.add(teamNames.indexOf(team2), team2Stats);
            }
            //Now to compare the teams...

            teamStats.sort(new Comparator<TeamStats>() {
                @Override
                public int compare(TeamStats o1, TeamStats o2) {
                    if (o1.points > o2.points){
                        return 1;
                    } else if (o2.points> o1.points){
                        return -1;
                    } else {
                        if (o1.wins > o2.wins){
                            return 1;
                        } else if (o2.wins > o1.wins){
                            return -1;
                        } else {
                            if (o1.goalDifference > o2.goalDifference){
                                return 1;
                            } else if (o2.goalDifference > o1.goalDifference){
                                return -1;
                            } else {
                                if (o1.goalsScored > o2.goalsScored){
                                    return 1;
                                } else if (o2.goalsScored > o1.goalsScored){
                                    return -1;
                                } else {
                                    if (o1.games < o2.games){
                                        return 1;
                                    } else if (o2.games < o1.games){
                                        return -1;
                                    } else {
                                        return o2.name.compareToIgnoreCase(o1.name);
                                    }
                                }
                            }
                        }
                    }
                }
            });

            output.write(tournament);
            output.newLine();
            int pos = 1;
            for (int i = teamStats.size()-1; i >= 0; i--, pos++) {
                TeamStats stat = teamStats.get(i);
                output.write(pos+") "+stat.name + " "+stat.points+"p, "+stat.games+"g ("+stat.wins+"-"+stat.ties+"-"+stat.losses+"), "+stat.goalDifference+"gd ("+stat.goalsScored+"-"+stat.goalsAgainst+")\n");
            }
            if (cases != caseNum-1)
            output.newLine();
        }
        output.flush();
    }
}

    class TeamStats {
        String name;
        int points = 0;
        int games = 0;
        int wins = 0;
        int ties = 0;
        int losses = 0;
        int goalDifference = 0;
        int goalsScored = 0;
        int goalsAgainst = 0;

        TeamStats(String name) {
            this.name = name;
        }
    }
