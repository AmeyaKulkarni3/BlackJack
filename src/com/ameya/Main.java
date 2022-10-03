package com.ameya;

import com.ameya.model.Card;
import com.ameya.model.Game;
import com.ameya.model.Hand;
import com.ameya.model.Player;
import com.ameya.utils.Rank;
import com.ameya.utils.Suit;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Card> deck = new ArrayList<>();
    static Game game = new Game();
    static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {

        List<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING));
        List<Suit> suits = new ArrayList<>(Arrays.asList(Suit.HEART, Suit.DIAMOND, Suit.CLUB, Suit.SPADE));

        for (int i = 1; i <= 6; i++) {
            for(Suit s : suits){
                for(Rank r : ranks){
                    Card c = new Card();
                    c.setRank(r);
                    c.setSuit(s);
                    deck.add(c);
                }
            }
        }

        Player dealer = new Player();
        dealer.setPlaying(true);
        dealer.setName("Dealer");
        dealer.setDealer(true);
        dealer.setBalance(1000000);

        players.add(dealer);

        boolean askPlayers = true;

        while (askPlayers){
            System.out.println("Dealer : Hello Sir!, Would you like to test your luck in classic game of BlackJack?");
            System.out.println("Press Y to join");
            String input = scanner.next();
            if(input.toLowerCase().equals("y")){
                Player player = new Player();
                System.out.println("Please enter your name");
                player.setName(scanner.next());
                System.out.println("Enter amount you would like to play with");
                player.setBalance(scanner.nextDouble());
                while(player.getBalance() < 1000){
                    System.out.println("You can't play with no money! Go and get some Money");
                    System.out.println("Enter the amount again!");
                    player.setBalance(scanner.nextDouble());
                }
                player.setDealer(false);
                player.setPlaying(true);
                players.add(player);
                System.out.println("Welcome " + player.getName() + "!");
            } else {
                askPlayers = false;
            }
        }

        game.setPlayers(players);
        game.setActive(players.size() > 1);
        while (game.isActive()){
            playGame();
        }
    }

    private static void playGame() {
        System.out.println("Let's Start!! Your bets please. Minimum bet is 1000!!");
        for(Player player : players){
            if(!player.isDealer()){
                System.out.println("Your bet " + player.getName() + "?");
                double bet = scanner.nextDouble();
                while(bet > player.getBalance()){
                    System.out.println("You don't have enough balance. Add more money");
                    double added = scanner.nextDouble();
                    player.setBalance(added + player.getBalance());
                }
                System.out.println(player.getName() + " has bet " + bet);
                player.setBalance(player.getBalance() - bet);
            }
        }
        Player d = players.get(0);
        players.remove(0);
        players.add(d);
        Random r = new Random();
        for(int i = 1 ; i <= 2; i++){
            for(Player p : players){
                Card c = deck.get(r.nextInt(deck.size()));
                Hand h = p.getHand();
                if(h == null){
                    h = new Hand();
                }
                List<Card> cardInHand = h.getCards();
                if(cardInHand == null){
                    cardInHand = new ArrayList<>();
                }
                cardInHand.add(c);
                h.setCards(cardInHand);
                p.setHand(h);
            }
        }
        for(Player p : players){
            Hand h = p.getHand();
            List<Card> cards = h.getCards();
            int count = 0;
            if(!p.isDealer()){
                System.out.println(p.getName() + "'s cards : ");
                for(Card c : cards){
                    System.out.println(c.toString());
                    count = count + c.getValue();
                }
                h.setCount(count);
                System.out.println("The count is " + count);
                System.out.println("----------------------------------");
            } else {
                System.out.println("Dealer's Card:");
                System.out.println(p.getHand().getCards().get(0).toString());
                for(Card c : cards){
                    count = count + c.getValue();
                }
                h.setCount(count);
                System.out.println("The Dealer count is " + p.getHand().getCards().get(0).getValue());
                System.out.println("----------------------------------");
            }
        }
        for(Player p : players){
            if(!p.isDealer()){
                System.out.println(p.getName() + " hit or stand? Press H for hit and S for Stand");
                String input = scanner.next();
                switch (input.toLowerCase()){
                    case "h":
                        Card c = deck.get(r.nextInt(deck.size()));
                        Hand h = p.getHand();
                        int count = h.getCount();
                        count = count + c.getValue();
                        if(count > 21){
                            for(Card card : h.getCards()){
                                
                            }
                        }
                }
            }
        }
    }
}
