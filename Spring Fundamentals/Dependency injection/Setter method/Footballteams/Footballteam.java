package com.spring;

import java.util.List;

public class FootballTeam {
    private String teamName;
    private Stadium stadium;
    private List<Player> players;
    private TeamRank teamRank;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public TeamRank getTeamRank() {
        return teamRank;
    }

    public void setTeamRank(TeamRank teamRank) {
        this.teamRank = teamRank;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "teamName='" + teamName + '\'' +
                ", stadium=" + stadium +
                ", players=" + players +
                ", teamRank=" + teamRank +
                '}';
    }

    public static class Stadium {
        private String name;
        private int capacity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Stadium{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }

    public static class Player {
        private String name;
        private String position;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    '}';
        }
    }

    public static class TeamRank {
        private int rank;
        private int points;

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        @Override
        public String toString() {
            return "TeamRank{" +
                    "rank=" + rank +
                    ", points=" + points +
                    '}';
        }
    }
}
