package Lab4;
import java.io.File;
import java.util.Scanner;

public class test{

	public static void main(String args[]) throws Exception

	{

		GameEntry ge = null;

		LList<GameEntry> llge = new LList<GameEntry>();

		Scanner input = new Scanner(new File("gamescore.txt"));

		String line = "";

		String name;

		int score;

		// read till end of the file

		while (input.hasNextLine())

		{

			// read the line from the file

			line = input.nextLine();
			// split the string at ","
			String data[] = line.split(",");
			//System.out.println(data);
			// set the values

			name = data[0];
			score = Integer.parseInt(data[1]);
			// create an object of GameEntry
			ge = new GameEntry(name, score);
			// call the addRecord function

			// to add the data in sorted order

			addRecord(llge, ge);

		}

		input.close();



		//print the current list

		System.out.println("Current list: ");

		System.out.println(llge.toString());

		// call the method removeRecord() that removes

		// the name from the list by looking into the

		// name

		removeRecord(llge, "Mike");



		// print the list

		System.out.println("\nMike is removed from the list. The updated list is: ");

		System.out.println(llge.toString());



		//call the reverseList() method of LList

		System.out.println("\nReverse of list: ");

		// llge.reverseList();



		// print the list

		System.out.println(llge.toString());

	}

	// addRecord() that takes a LList object and GameEntry object

	// and adds the ge to the llge in sorted order

	public static void addRecord(LList<GameEntry> llge, GameEntry ge)

	{

		// get the length
		int length = llge.length();
		// move the pointer to the begining of the list
		llge.moveToStart();
		int i = 0;
		// condition to check whether getValue() is null or not
		// if null, append ge to the empty list
		if (llge.getValue() == null)
		{
			llge.append(ge);
		}
		// else insert ge at appropriate location
		else
		{
			//loop through find the greater value
			while (i != length)
			{
				// condition to compare by name
				if (llge.getValue().getName().compareTo(ge.getName()) < 0)
				{
					// move the pointer
					llge.next();
				}
				else
				{
					break;
				}
				i++;
			}// insert the ge to the llge at appropriate position
			llge.insert(ge); }

	}

	// removeRecord() that takes a LList object and String object

	// and removes the name from the llge. This method removes all the

	// records that matches the name

	public static void removeRecord(LList<GameEntry> llge, String name)

	{
		// get the length
		int length = llge.length(); // move the pointer to the begining of the list
		llge.moveToStart();
		int i = 0;
		// condition to check whether getValue() is matches the

		// name, then remove the record from the list

		if (llge.getValue().getName().equalsIgnoreCase(name))

		{

			llge.remove();

		}



		// else move to the appropriate record

		else

		{

			// loop till the value is found

			while (i != length)

			{

				// if found, remove the record.

				if (llge.getValue().getName().equalsIgnoreCase(name))

				{

					llge.remove();

				}

				else

				{

					llge.next();

				}

				i++;

			}

		}

	}

}
