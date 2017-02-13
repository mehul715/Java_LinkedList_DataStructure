package Lab4;
import java.io.*;
import java.util.*;
public class readfile {
    public Scanner x;
	public void openFile(){
		
		try{
			 x = new Scanner(new File("gamescore.txt"));
			 
		}
		catch(Exception e){
			System.out.println("unable to find file");
		}
	}
  public void readFile(){
	   while(x.hasNext()){
		   String line = x.nextLine();
		   System.out.println(line);
	   }
  }
  public void closeFile(){
	  
	  x.close();
	  
  }
	

public static void main(String[] args){
	
	readfile r = new readfile();
	r.openFile();
	r.readFile();
	r.closeFile();
	
}
}
