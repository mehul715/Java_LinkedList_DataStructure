package Lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/*
 * (1)	 Objective: Implement Link List
Write a class that maintains the scores for a game application.
Implement the addition and removal function to update the database.
 The gamescore.txt contains player’ name and score data record fields separated by comma.
  For Removal function, uses the name field to select record to remove the game score record.
Download – List.java, LList.java, Dlink.java, GameEntry.java and gamescore.txt from Moodle

(a)	Read gamescore.txt to initialize the Linked list in sorted order by score. (1 point)

(b)	Provide Remove and Add function for user to update the sorted linked list. (1 point)

(c)	Display “Name exist” when add an exist name to the list.

(d)	Display “Name does not exist” when remove a name not on the list.

 */
public class maintain{


	public static void main(String[] args) throws Exception
	{
		LList<GameEntry>list = new LList<GameEntry>();
		Scanner scan = new Scanner(System.in);
		int score ;
		String name ;
		//reading file from text
		FileReader file = new FileReader("C:\\Users\\alatar\\Desktop\\foldertoread\\gamescore.txt");
		BufferedReader reader = new BufferedReader(file);


		String text = "";
		String line = reader.readLine();

		while(line!= null)
		{
			text += line;
			String lineSplit[]=line.split(",");
			line=reader.readLine();

			name=lineSplit[0];
			score=Integer.parseInt(lineSplit[1]);
			GameEntry entry = new GameEntry(name, score);

			addFunction(list,entry);
		}
		System.out.println(text);
		System.out.println("Enter name to remove from list");

		String removeName = scan.next();
		removeFunction(list,removeName);


	}
	//add function
	public static void addFunction(LList<GameEntry> list, GameEntry entry){
		for(int i = 0; i < list.length(); i++) {
			if (list.getValue().getName().compareTo(entry.getName()) < 0){
				list.next();
			}
		}
	}
	//remove function
	public static void removeFunction(LList<GameEntry>list, String removeName){


		if(list.getValue().getName().equalsIgnoreCase(removeName)){
			list.remove();
		}


	}


}





