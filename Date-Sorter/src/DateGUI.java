
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DateGUI extends JFrame{
	//String date, String day
	private static JMenuBar menuBar  = new JMenuBar();
	
	/**
	 * 
	 * 
	 * @param name Name of frame, this will appear on the top of the window
	 * @param listing Array of objects, this will supply the GUI with information that is fully sorted and converted to string 
	 * @param rawData String input, this will give the raw data from the file
	 * 
	 */
	 public void createAndShowGUI(String name, UnsortedDate212List unsorted, TreeMap sorted) {
		 
	        //Create and set up the window.
	        JFrame frame = new JFrame(name);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize( 100,100);//width, height);
	        frame.setLocation(200,200);//x, y);
	        frame.setLayout(new GridLayout(2,3));
	        


	        frame.getContentPane().add(new JLabel("Unsorted")); //Create Date and Day columns
	        frame.getContentPane().add(new JLabel("Sorted"));
	        
	        
	        JTextArea roomDate = new JTextArea(10, 40);  //Create Text space for Date and Day
	        JTextArea roomDay = new JTextArea(10, 40);
	        
	        roomDay.setEditable(false);					//Set Date and Day text boxes to uneditable
	        roomDate.setEditable(false);
	        
	        JScrollPane roomDateS = new JScrollPane(roomDate); //Allow scrolling for Text space of Date and Day
	        JScrollPane roomDayS = new JScrollPane(roomDay);
	        
	        frame.getContentPane().add(roomDateS);
	        frame.getContentPane().add(roomDayS);
	        
	        

//	        Date212Node sdHold = sorted.rNode();      //create nodes to set the start for both sorted and unsorted list at the bottom
	        Date212Node usdHold = unsorted.rNode();
	        
	      //print out unsorted in GUI
			for(int i = 0; i < unsorted.length; i++) {
				if(usdHold != null) {
					roomDate.append(usdHold.data.toString()+"\n");
				}
				usdHold = usdHold.next;
				
				
			} 
	        
			
			Iterator iter = sorted.keySet().iterator();			//Appends date into GUI
			while(iter.hasNext()) {
				roomDay.append(iter.next().toString() +"\n");
			}
			
	        
	        
	        
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        
	        
	    }
	 
	 public void createFileMenu() {
		 
		 JMenu filemenu = new JMenu("File");                          //Creates menu called "File"
		 JMenuItem item;
		 FileMenuHandler fileHandler = new FileMenuHandler(this);
		 
		 item = new JMenuItem("Open");                                //Creates menu Item called "Open", after add listener to open and put it in the menu "File"
		 item.addActionListener(fileHandler);
		 filemenu.add(item);
		 
		 filemenu.addSeparator();
		 
		 item = new JMenuItem("Quit");                                //Creates menu Item called "Quit", after add listener to open and put it in the menu "File"
		 item.addActionListener(fileHandler);
		 filemenu.add(item);
		 
	     setJMenuBar(menuBar);
	     menuBar.add(filemenu);
	     
	     pack();
	     setVisible(true);                                           //Make Visible
		 
		 
	 }


}
