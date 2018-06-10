package twitter;
import java.util.*;
import java.io.*;

public class Twitter {
	//260762008 Tianze Lin
	
	//attributes
	private ArrayList<Tweet> tweets;
	
	//methods
	public Twitter() {
		this.tweets = new ArrayList<Tweet>();
	}
	
	public void loadDB(String name) {
		FileReader fr;
		BufferedReader br;
		String currentLine;
		try {
			fr = new FileReader(name);
			br = new BufferedReader(fr);
			currentLine = br.readLine();
			while(currentLine != null) {
				String[] parts = currentLine.split("\t");
				String userAccount = parts[0];
				String date = parts[1];
				String time = parts[2];
				String message = parts[3];
				Tweet test = new Tweet(userAccount, date, time, message);
				if(test.checkMessage(test.getMessage())) {
					tweets.add(test);
				}
				currentLine = br.readLine();
			}
			br.close();
			fr.close();
			sortTwitter();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			System.out.println("Error checking the stopWords database: The file of stopWords has not been loaded yet");
		}
	}
	
	public void sortTwitter() {
		ArrayList <Tweet> arrList = new ArrayList<Tweet> (tweets.size());
		Tweet[] arr = new Tweet[tweets.size()];
		for(int i=0; i<tweets.size();i++) {
			arr[i]=tweets.get(i);
		}
		for(int i=0; i<arr.length-1; i++) {
			for(int j =0; j<arr.length-1-i;j++) {
				if(arr[j+1].isBefore(arr[j])) {
					Tweet temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0; i<arr.length;i++) {
			arrList.add(arr[i]);
		}
		tweets = arrList;
	}
	
	public int getSizeTwitter() {
		return this.tweets.size();
	}
	
	public Tweet getTweet(int i) {
		return tweets.get(i);
	}
	
	public String printDB() {
		String a = "";
		for(int i = 0; i<tweets.size(); i++) {
			a += tweets.get(i).toString();
			if(i != tweets.size()-1) {
				a+="\n";
			}
		}
		return a;
	}
	
	public ArrayList<Tweet> rangeTweets(Tweet a, Tweet b) {
		ArrayList <Tweet> newTweets = new ArrayList<Tweet>();
		if(a.isBefore(b)) {
			newTweets.add(a);
			for(int i = 0; i<tweets.size(); i++) {
				if(a.isBefore(tweets.get(i)) && tweets.get(i).isBefore(b)) {
					newTweets.add(tweets.get(i));
				}
			}
			newTweets.add(b);
			return newTweets;
		}else {
			newTweets.add(b);
			for(int i = 0; i<tweets.size(); i++) {
				if(b.isBefore(tweets.get(i)) && tweets.get(i).isBefore(a)) {
					newTweets.add(tweets.get(i));
				}
			}
			newTweets.add(a);
			return newTweets;
		}
	}
	
	public void saveDB(String nameOfFile) {
		try {
			String message = printDB();
			FileWriter fw = new FileWriter(nameOfFile);
			BufferedWriter bw = new BufferedWriter(fw);
			String[] parts = message.split("\n");
			for(int j=0; j<parts.length; j++) {
				System.out.println(parts[j]);
				bw.write(parts[j]);
				bw.newLine();
			}
			bw.close();
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String trendingTopic() {
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		String s = "";
		for(int i = 0; i<tweets.size(); i++) {
			String message = tweets.get(i).getMessage();
			//store all the words in an array
			String[] parts = message.split(" ");
			//change the words end with ",""."":"";" into original forms
			for(int j=0; j<parts.length; j++) {
				if(parts[j].charAt(parts[j].length()-1) == ',') {
					parts[j] = parts[j].replace(parts[j].substring(parts[j].length()-1), "");
				}else if(parts[j].charAt(parts[j].length()-1) == ';') {
					parts[j] = parts[j].replace(parts[j].substring(parts[j].length()-1), "");
				}else if(parts[j].charAt(parts[j].length()-1) == ':') {
					parts[j] = parts[j].replace(parts[j].substring(parts[j].length()-1), "");
				}else if(parts[j].charAt(parts[j].length()-1) == '.') {
					parts[j] = parts[j].replace(parts[j].substring(parts[j].length()-1), "");
				}
			}
			//remove all the repetitive words in a message by using hashSet
			HashSet<String> buffer = new HashSet<String>();
			for(int j=0; j<parts.length;j++) {
				buffer.add(parts[j]);
			}
			//create an arrayList to store all the "good" words in a message
			ArrayList<String> listOfWords = new ArrayList<String>();
			for(String a: buffer) {
				listOfWords.add(a);
			}
			//build connections between words and numbers by hashMap
			for(int j=0; j<listOfWords.size(); j++) {
				if(tweets.get(i).checkWord(listOfWords.get(j))) {
				    Integer k = words.get(listOfWords.get(j));
					if(k == null) {
						k = 1;
						words.put(listOfWords.get(j), k);
					}else {
						k++;
						words.put(listOfWords.get(j), k);
					}
					s = listOfWords.get(j);
				}	
			}
		}
		for(String c : words.keySet()) {
			if(words.get(c)>words.get(s)) {
				s=c;
			}
		}
		System.out.println(words.get(s));
		return s;
	}
	
	public static void main(String[] args) {
		Twitter example = new Twitter();
		Tweet.loadStopWords("D:\\ѧϰ\\McGill\\U0\\Comp 202\\assignment\\stopWords.txt");
		example.loadDB("D:\\ѧϰ\\McGill\\U0\\Comp 202\\assignment\\tweets.txt");
		example.saveDB("D:\\ѧϰ\\McGill\\U0\\Comp 202\\assignment\\1.txt");
		System.out.print(example.trendingTopic());
	}
}
