import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open"))                                                        //If "Open" is pressed open up file
         openFile();                                                                     
      else if (menuName.equals("Quit"))                                                   //If "Quit" is pressed close file
         System.exit(0);
   } //actionPerformed
   
   public void openFile() {                                    
		JFileChooser fileChooser = new JFileChooser();	
		fileChooser.showOpenDialog(null);					                             //opens menu to choose file
		File myFile = new File(fileChooser.getSelectedFile().getAbsolutePath());		 //save the file selected
		readFile(myFile);									                             //pass the file into the read

	}
   
   public void readFile(File chosenFile)  {
	   	TextFileInput textFileInput = new TextFileInput(chosenFile.toString());
	   	String fileName = chosenFile.getName();
		String dStorage = "";
		String argsline = chosenFile.toString();									
		String filelocation = argsline;

		File file = new File(filelocation);
		
		Scanner textF = null;
		try {
			textF = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

		
		while(textF.hasNextLine()) {                                   		              //While File has another line store it and go to the next one
			String line = textF.nextLine();
			dStorage += (line) + "\n";
		}
		//Tokenize info and store it as array of objects
		StringTokenizer dList = new StringTokenizer(dStorage,",\n");                      //Store string into Tokenzier
		
		UnsortedDate212List UnsortedL = new UnsortedDate212List();			              //Create an Unsorted list
		
		TreeMap<Date212, Integer> treeDates2 = new TreeMap(new dateComparator());		  //Sorted Treemap
		
		
		
		while(dList.hasMoreTokens()) {										//While it has more tokens store numbers into both sorted and unsorted node
			String token = dList.nextToken();
			try {
			Date212 su = new Date212(token);
			UnsortedL.addUnsorted(su);										//Append su into the Unsorted List. Append method should automatically turn Date212 object to Node
			
			treeDates2.put(su, null);										//As you loop through the dates, place the su into treeDate2
			}
			catch(IllegalDate212Exception e) {
				System.out.println(token + " Is Invalid Date");             //Will catch all "IllegalDate212Exceptions" thrown out from the try, in this case from Date212 objects
			}
			
		}
		
		

		
		
		
		//Store into data GUI and display
		DateGUI gui = new DateGUI();
		gui.createAndShowGUI(argsline, UnsortedL, treeDates2);                   //Call GUI and display Unsorted and Sorted Dates
		
   }
   
  
}

