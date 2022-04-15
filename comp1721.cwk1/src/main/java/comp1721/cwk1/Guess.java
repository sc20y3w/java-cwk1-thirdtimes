package comp1721.cwk1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class Guess {
	private int guessNumber;
	private String chosenWord;
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  // TODO: Implement constructor with int parameter
  public Guess(int num)throws GameException {
	  if(num >= 1 && num <= 6) {
		  guessNumber = num;
	  }else {
		  throw new GameException("Num should be an integer greater than zero and less than seven.");
	  }
  }
  // TODO: Implement constructor with int and String parameters
  public Guess(int num,String word) {
//	  if(num >= 1 && num <= 6) {
//		  guessNumber = num;
//	  }else {
//		  throw new GameException("Num should be an integer greater than zero and less than seven.");
//	  }
//	  int size = word.length();
//	  if(size == 5) {
//		  chosenWord = word;
//	  }else {
//		  throw new GameException("Word length should be greater than zero and less than seven.");
//	  }
  }
  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber() {
	  
	  return guessNumber;
  }
  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord() {
	  readFromPlayer();
	  return chosenWord;
  }
  // TODO: Implement readFromPlayer()
  public void readFromPlayer() {
	  String str = INPUT.nextLine();
	  chosenWord = str.toUpperCase();
  }
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target) {
	  StringBuilder re = new StringBuilder();
	  String result = " ";
	  boolean flag = false;
	  char[] a = chosenWord.toCharArray();
	  char[] b = target.toCharArray();
	  for(int i = 0;i<b.length;i++) {
		  if(a[i] == b[i]) {
			  re.append("\033[30;102m "+a[i]+" \033[0m");
		  }else {
			  for(int j =0;j<a.length;j++) {
				  if(a[i]==b[j]) {
					  flag = true;
					  break;
				  }else {
					  flag = false;
				  }
			  }
			  if(flag==false) {
				  re.append("\033[30;107m "+a[i]+" \033[0m");
				  
			  }else {
				  re.append("\033[30;103m "+a[i]+" \033[0m");
				  
			  }
		  }
	  }
	  result = re.toString();
	  return result;
  }
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target) {
	  if (target.equals(chosenWord)) {
		  return true;
	  }else {
		  return false;
	  }
  }
}
