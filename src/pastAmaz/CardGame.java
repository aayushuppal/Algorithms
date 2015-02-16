package pastAmaz;

import java.util.ArrayList;
import java.util.Random;

import pastAmaz.Card.Suit;

public class CardGame {
	 
	
	public static void main(String[] args) {
		Deck newDeck = new Deck();
		ArrayList<ArrayList<Card>> deck1 = newDeck.deck;
		
		System.out.println(deck1.get(0));
		
	}

}

class Card{
	public enum Suit {Club, Spade, Diamond, Heart};
	int value;
	Suit suitVal;
	
	Card(Suit suit, int val){
		this.suitVal = suit;
		if (val <=13 && val >= 1 ){	this.value = val;	}
		else {	System.out.println("wrong assignment");	}
	}
	
	public String toString(){
		return ""+this.value +"-"+ this.suitVal; 
	}
}

class Deck  {

	ArrayList<ArrayList<Card>> deck = new ArrayList<ArrayList<Card>>();
	
	Deck(){
		ArrayList<Card> Spd = new ArrayList<Card>();
		for (int i=1; i<=13; i++){
			Spd.add(new Card(Suit.Spade, i));
		}
		deck.add(Spd);
		ArrayList<Card> Clb = new ArrayList<Card>();
		for (int i=1; i<=13; i++){
			Clb.add(new Card(Suit.Club, i));
		}
		deck.add(Clb);
		ArrayList<Card> Dmd = new ArrayList<Card>();
		for (int i=1; i<=13; i++){
			Dmd.add(new Card(Suit.Diamond, i));
		}
		deck.add(Dmd);
		ArrayList<Card> Hrt = new ArrayList<Card>();
		for (int i=1; i<=13; i++){
			Hrt.add(new Card(Suit.Heart, i));
		}
		deck.add(Hrt);
	}
	
	
	int nextRnd() { // use hashset to store prev values and then shuffle accordingly
		Random rd = new Random();
		return rd.nextInt(13)+1;
		}
	
}