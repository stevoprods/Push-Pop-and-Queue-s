import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * COP 3538: Project 3 - Linked lists
 * <P>
 * The program reads a file of states, pushes them onto a stack then pops them one by one.
 * inserting them into a priority queue that is based on population and region 
 * in the following order: South, West, Midwest, then removes those states from the Queue
 * and pushes them back onto a stack.
 * <P>
 *  @author <Steven Fernandez>  
 *  @version <2/18/2019>  
 */ 
public class Project3
{   
	
	static Stack stack = new Stack();
	static States states;
	static States[] stateArray;
	static Queue stateQueue = new Queue();
	int size;
	/**   
	 *  Reads file States2.csv and pushes the states onto a stack 
	 *  as they are read and counts lines. Pops each state individually and inserts them into the front and back
	 *  of the Queue, then removes them individually from the front and back while pushing them back onto a stack.
	 *  
	 * @param  String file name
	 * @return line count
	 */
	public int read(String filename) //read file method
	  {
	     String csvFile = filename;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	       int cnt=0;
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                //String[] data= line.split(cvsSplitBy);

	               cnt++;

	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	         }
	       
	         stateArray=new States[cnt-1];
	       int scnt=0;
	          try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {
	                if(scnt==0)
	                 {
	                   scnt++;
	                   continue;
	                }
	                // use comma as separator
	                String[] data= line.split(cvsSplitBy);
	                
	                //reads only south, middle Atlantic, and new england regions
	               if((data[4].equals("South")) || (data[4].equals("Middle Atlantic")) || (data[4].equals("New England")))
	               {
	               stack.push(new States(data[0],data[1],data[2],Long.parseLong(data[3]),data[4],Integer.parseInt(data[5])));
	               scnt++;
	               }
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	      return scnt;
	       	  
	  }
	
	/**main method
    *
    */
	public static void main (String[] args)
	{
		
		Project3 p3=new Project3();
	    System.out.println("COP3538 Project 1");
	    System.out.println("Instructor: Xudong Liu");
	    System.out.println();
	    System.out.println("Stacks and Priority Queues");
	    System.out.println("Enter the filename: ");
	    Scanner in=new Scanner(System.in);
	    String fname=in.nextLine();
	    int nr=p3.read("States2.csv");
	    System.out.println();
	    System.out.println("There were "+(nr-1)+ " states put on the stack");
	    System.out.println();
	    int count = 1; //declare counter for odd/even
	    
	    stack.printStack(); //prints stack
	    
	    while (!stack.isEmpty()) //until stack is empty
	    {
	    	
	    	States temp = stack.pop();
	  		if(count%2 == 1) // if its odd insert states at front
	  		{
	  			stateQueue.insertFront(temp);
	  		}
	  		else if(count%2 == 0) //if its even insert state at end
	  		{
	  			stateQueue.insertEnd(temp);
	  		}
	  		count++;
	    }
	    
	    stateQueue.printQueue(); //prints Queue
	    
	    //delete states from Queue
	    stateQueue.findDelete("Massachusetts"); 
	    stateQueue.findDelete("New Hampshire");
	    stateQueue.findDelete("Rhode Island");
	    stateQueue.findDelete("Maryland");
	    stateQueue.findDelete("New Jersey");
	    stateQueue.findDelete("Pennsylvania");
	    stateQueue.findDelete("Alabama");
	    stateQueue.findDelete("Kentucky");
	    stateQueue.findDelete("North Carolina");
	    stateQueue.printQueue();
	    
	    while(!stateQueue.isEmpty()) //until the Queue is empty
	    {
	    	
	    	
	    	if(count%2 == 1) // if its odd
	  		{
	    		States temp = stateQueue.removeFront(); //remove state from front of Queue if its odd
	  			stack.push(temp);
	  			
	  		}
	  		else if(count%2 == 0)
	  		{
	  			States temp2 = stateQueue.removeEnd(); //remove state from end of Queue if its even
	  			stack.push(temp2);
	  		}
	  		count++;
	    }
	    
	    stack.printStack(); //prints stack
	    
	}
}