package comp1721.cwk1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Game {
	 private int gameNumber;
	 private String target;
	 private String[] saver = new String[500];
  // TODO: Implement constructor with String parameter
	 public Game(String filename) throws IOException{
		 String stime= "2021-04-19";
		 LocalDate today = LocalDate.now();
		 String ntime = today.toString();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			Date date1 = format.parse(stime);
			Date date2 = format.parse(ntime);
			gameNumber=(int)((date2.getTime() -date1.getTime())/(1000*3600*24));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 WordList a = new WordList(filename);
		 target = a.getWord(gameNumber);
	 }
  // TODO: Implement constructor with int and String parameters
	 public Game(int num,String filename) throws IOException{
		 gameNumber = num;
		 WordList wordlist = new WordList(filename);
		 target = wordlist.getWord(gameNumber);
	 }
  // TODO: Implement play() method
	 public void play() {
		 int num = 1;
		 boolean f1 = false;
		 Guess g1 = new Guess(gameNumber, target);
		 Guess g2 = new Guess(num);
		 boolean flag = g1.matches(target);
		 System.out.print("WORDLE "+ gameNumber);
		 System.out.println();
		 System.out.println();
		 for(num = 1;num<=6;num++){
			 System.out.printf("Enter guess (%d/6): ",num);
			 String chosenWord = g1.getChosenWord();
			 saver[num-1] = chosenWord;
			 String result = g1.compareWith(target);
			 System.out.println(result);
			 if(flag == true && num ==1) {
				 System.out.println("Superb - Got it in one!");
				 break;
			 }else {
				 if(flag == true && (num>=2&&num<=5)) {
					 System.out.println("Well done!");
					 break;
				 }else {
					 if(flag == true && num ==6) {
						 System.out.println("That was a close call!");
						 break;
					 }else {
						 if(flag == false && num == 6) {
							 System.out.println(" Better luck next time!");
						 }
					 }
				 }
			 }
		 }
	 }
  // TODO: Implement save() method, with a String parameter
	 public void save(String filename) throws IOException {
		 String w1 = " ";
		 String path = filename;
		 boolean flag = false;
		 char[] b = target.toCharArray();
		 StringBuilder re = new StringBuilder();
		 StringBuffer w2 = new StringBuffer();
		 String result = " ";
		 for(int j = 0; j<6;j++) {
			w2.append(saver[j]);
			w1 = w2.toString();
			 char[] a = w1.toCharArray();
			 for(int i = 0;i<b.length;i++) {
				  if(a[i] == b[i]) {
					  re.append("\033[30;102m "+a[i]+" \033[0m");
				  }else {
					  for(int j1 =0;j1<b.length;j1++) {
						  if(a[i]==b[j1]) {
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
			 re.append("\n");
			 w2.setLength(0);
		 }
		 result = re.toString();
		 //for(int i=0; i<6;i++) {
		//	 System.out.println(saver[i]);
		// }
		 File file = new File(filename);
		 if(!file.exists()) {
			 file.createNewFile();
		 }else {
			 try {
				 Files.writeString(Paths.get(path), result);
			 }catch (IOException e) {
			     e.printStackTrace();
			 }
		 }
	}
}
	 

