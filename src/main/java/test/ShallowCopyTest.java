package test;

import java.util.LinkedList;

public class ShallowCopyTest {

    public static void main(String[] args) {
        LinkedList<Player> players1 = new LinkedList<>();
        Player p1 = new Player();
        p1.setBettingAverage(64.7f);
        p1.setWordRank(4);

        Player p2 = new Player();
        p2.setBettingAverage(56.9f);
        p2.setWordRank(1);

        players1.add(p1);
        players1.add(p2);

        LinkedList<Player> players2 = new LinkedList<>();
        for (Player p : players1){
            Player tempPlayer = new Player();
            tempPlayer.setWordRank(p.getWordRank());
            tempPlayer.setBettingAverage(p.getBettingAverage());
            players2.add(tempPlayer);
        }

        players2.get(0).setWordRank(5);


        System.out.println(players1);
        System.out.println(players2);
    }
}


class Player {
    private double bettingAverage;
    private int wordRank;

    public double getBettingAverage() {
        return bettingAverage;
    }

    public void setBettingAverage(double bettingAverage) {
        this.bettingAverage = bettingAverage;
    }

    public int getWordRank() {
        return wordRank;
    }

    public void setWordRank(int wordRank) {
        this.wordRank = wordRank;
    }
}
