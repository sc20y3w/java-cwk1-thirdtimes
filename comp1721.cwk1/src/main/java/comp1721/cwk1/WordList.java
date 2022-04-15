package comp1721.cwk1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class WordList {
	private  List<String> words = new ArrayList<String>();
  // TODO: Implement constructor with a String parameter
	public WordList(String filename) throws IOException{
		File file = new File(filename);
        InputStreamReader read = null;
        BufferedReader reader = null;
			read = new InputStreamReader(new FileInputStream(file),"utf-8");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
        }
    }
  // TODO: Implement size() method, returning an int
	public int size() {
		int count = 0;
		for(String s:words) {
			count++;
		}
		return count;
	}
	
  // TODO: Implement getWord() with an int parameter, returning a String
	public String getWord(int n) throws  GameException{
		if(n > size() || n<0){
			throw new GameException("Error");
		}
		String word = words.get(n);
		return word;
	}
}
