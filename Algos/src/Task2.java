package com.test.web3labs;
import java.util.*;


public class Task2 {
    public static int countMaximumTeams(List<Integer> skill, int teamSize, int maxDiff) {
        if(Objects.isNull(skill) || skill.isEmpty()) {
            return 0;
        }
        int teamCounts = 0;
        final Map<Integer, Integer> indexBySkills = new HashMap<>();
        for(int index=0; index< skill.size(); index++) {
            indexBySkills.put(index, skill.get(index));
        }
        Integer[] originalIndex = indexBySkills.keySet().toArray(new Integer[0]);
        Collections.sort(skill);
        for(int index=0; index <skill.size(); index++) {
            int[] teamIndexes = new int[teamSize];
            int []team = new int[teamSize];

            for(int teamIndex= index; teamIndex < skill.size() - teamSize; teamIndex++) {
                if (indexBySkills.containsKey(teamIndex)) {
                for(int i=0; i<teamSize; i++) {
                        teamIndexes[i] = originalIndex[teamIndex+i];
                        team[i] = skill.get(teamIndex+i);
                    }

                        if (isValidTeam(team, maxDiff)) {
                            teamCounts++;
                            Arrays.stream(teamIndexes).forEach(indexBySkills::remove);
                            break;
                        } else {
                            // non valid
                            teamIndexes = new int[teamSize];
                            team = new int[teamSize];
                        }

                    }
            }
        }

        return teamCounts;
    }

    private static boolean isValidTeam(int[] team, int maxDiff) {
        return team[team.length-1] - team[0] <= maxDiff;
    }

    public static void main(String[] args) {
        //1,3,3,4,6,5
        List<Integer> skills = Arrays.asList(3,4,3,1,6,5,7);
        int teamSize = 3;
        int maxDiff = 2;
        System.out.println(countMaximumTeams(skills, teamSize, maxDiff));
    }
}
