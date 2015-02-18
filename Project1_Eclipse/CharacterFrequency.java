//Author: Christopher Diehl
//CS 445
//Project 1
import java.io.*;

public class CharacterFrequency {

	public static void main(String[] args) {
		FrequencyBag<Character> cfb = new FrequencyBag<Character>();
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		char[] charArray=alphabet.toCharArray();	
		try{
			FileInputStream fis= new FileInputStream(new File("letter1.txt"));
			char inChar;
			Character lowerChar;
			while(fis.available()>0){
				inChar= (char) fis.read();
				lowerChar=Character.toLowerCase(inChar);
				cfb.add(lowerChar);
				}
			fis.close();
			System.out.println("Character: Frequency");
			System.out.println("====================");
			for(int i=0; i<charArray.length; i++){
				System.out.println(charArray[i]+": "+cfb.getFrequencyOf(charArray[i]));
			}
		}catch (FileNotFoundException FE) {
			System.out.println("File Not Found");
		}catch (IOException TE) {
			System.out.println("Something is broken");
		}
		
	}

}
