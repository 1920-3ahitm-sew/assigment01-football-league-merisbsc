package at.htl.football;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Main {
    static League league = new League();
    public static void main(String[] args) {


        String fileName = "bundesliga-1819.csv";
        readFile(fileName);
        printTable(league.getTable());
    }

    private static void readFile(String fileName) {

        List<String> lines = new ArrayList<>();
        String[] data = new String[5];


        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        lines.remove(0);

        for (String line : lines) {
            data = line.split(";");
            Match match = new Match(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
            league.addMatchResult(match);
        }
    }

    private static void printTable(List<Team> teams) {
        System.out.format("%18s   %s   %s    %s    %s   %s   %s   %s\n","Team","Pts","W","D","L","GF","GA","GD");
        for (Team team : teams) {
            System.out.format("%18s   %2d   %2d   %2d   %2d   %2d   %2d   %2d\n", team.getName(), team.getPoints(),team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
        }
    }
}
