package twitter;
import java.util.*;
import java.io.*;

public class Tweet {
	//260762008 Tianze Lin
	
	//attributes
	private String userAccount;
	private String date;
	private String time;
	private String message;
	private static HashSet<String> stopWords = new HashSet<String> ();
	
	//methods
	public Tweet(String userAccount, String date, String time, String message) {
		this.userAccount = userAccount;
		this.date = date;
		this.time = time;
		this.message = message;
	}
	
	public boolean checkMessage(String tweetMessage) {
		if (stopWords == null) {
			throw new NullPointerException();
		}
		String[] parts = tweetMessage.split(" ");
		int counter = parts.length;
		//remove the count of stopWords
		for(int i=0; i<parts.length;i++) {
			for(String a: stopWords) {
				String b = a + ',';
				String c = a + '.';
				String d = a + ';';
				String e = a + ':';
				if(a.equalsIgnoreCase(parts[i])) {
					counter--;
				}else if(b.equalsIgnoreCase(parts[i])) {
					counter--;
				}else if(c.equalsIgnoreCase(parts[i])) {
					counter--;
				}else if(d.equalsIgnoreCase(parts[i])) {
					counter--;
				}else if(e.equalsIgnoreCase(parts[i])) {
					counter--;
				}
			}
		}
		if(counter<16 && counter>0) {
			return true;
		}
		return false;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getUserAccount() {
		return this.userAccount;
	}
	
	public String toString() {
		String a = "";
		a += this.userAccount;
		a += "\t";
		a += this.date;
		a += "\t";
		a += this.time;
		a += "\t";
		a += this.message;
		return a;
	}
	
	public boolean isBefore(Tweet a) {
		String aDate = a.getDate();
		String aTime = a.getTime();
		int j = aDate.length();
		//check the date
		for(int i = 0; i < j; i++) {
			if(aDate.charAt(i)>this.date.charAt(i)) {
				return true;
			}else if(aDate.charAt(i)<this.date.charAt(i)){
				return false;
			}else {
				continue;
			}
		}
		int k = aTime.length();
		//check the time
		for (int i = 0;i < k;i++) {
			if(aTime.charAt(i)>this.time.charAt(i)) {
				return true;
			}else if(aTime.charAt(i)<this.time.charAt(i)) {
				return false;
			}else {
				continue;
			}
		}
		return false;
	}
	
	public static void loadStopWords(String name) {
		FileReader fr;
		BufferedReader br;
		String currentLine;
		try {
			fr = new FileReader(name);
			br = new BufferedReader(fr);
			currentLine = br.readLine();
			while(currentLine != null) {
				stopWords.add(currentLine);
				currentLine = br.readLine();
			}
			br.close();
			fr.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkWord(String word) {
		for(String a: stopWords) {
			if(a.equalsIgnoreCase(word)) {
				return false;
			}
		}
		return true;
	}
}
