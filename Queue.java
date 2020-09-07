/**
 * Places state information into a Queue using a doubly Linked list
 * 
 *  @author <Steven Fernandez>  
 *  @version <2/18/2019>  
 */ 
class Queue 
{
	 private class Node{
     States state;
     Node previousNode, nextNode;
   }
   
   Node front, end;
   
	 public Queue() //constructor that starts the Queue with nothing
	 {
     front = null;
     end = null;
	 }

	 public void insertEnd(States item) //inserts Data nodes at the end of the Queue
	 {
		 Node newEnd = new Node(); //create node
    
		 newEnd.state = item; //Assigns state to node
     	if(isEmpty()) //if empty list
     	{
     		front = newEnd;
     	}
     	else
     	{
     		end.nextNode = newEnd; 
     		newEnd.previousNode = end; 
     		
     	}
     	end = newEnd;
	 }
	 public void insertFront(States item) //inserts data nodes at the front of Queue
	 {   
		 //reference to node
		 Node newFront = new Node();

     newFront.state = item;
     	if(isEmpty())
     	{
     		end = newFront;
     	}
     	
     	else
     	{
  		front.previousNode = newFront;
  		newFront.nextNode = front; 
  		
     	}
  
     	front = newFront;
	 }
	 public States findDelete(String st) //finds the state name and deletes it
	 {   
		 //points to beginning
		 Node current = front; 
		 
		 while(!current.state.getName().equals(st)) //obtains state name from state class
		 {
			 if(current.nextNode == null)
			 {
				 return null;
			 }
			 else
			 {
				 current = current.nextNode;
			 }
		 }
		 
		 if(current == front)
		 {
			 front = front.nextNode;
			
			 return removeFront();
		 }
		 else if(current == end)
		 {
			 end = end.previousNode;
	
			 return removeEnd();
		 }
		 
		 else
		 {
			 current.previousNode.nextNode = current.nextNode;
			 current.nextNode.previousNode = current.previousNode;
			 return current.state;
		 }
	 }

	 public States removeEnd() //removes nodes from the end of Queue
	 {
		 if (end == null) 
		 {
			 System.out.println("List is empty");
			 return null;
		 }
		 else
		 {
			 States tempState = end.state;
			 end = end.previousNode;
			
			 if(end != null)
			 {
				 
			 
    		 end.nextNode = null; 
			 }
    		 return tempState;
		 } 
	 }

   public States removeFront() //removes nodes from the front of the Queue
   {
     if (front == null){
         System.out.println("List is empty");
         return null;
        }
     else
     {
    	 States tempState = front.state;
         front = front.nextNode; //changes current front node
    	 
    	 
    	 if(front != null)
    	 {
         front.previousNode = null;
    	 }
         return tempState;
     } 
   }
   

	 
	 public void printQueue() //prints Queue contents
	 {
        System.out.println();
    		System.out.println("Queue Contents:");
    		System.out.println();
    		System.out.printf("%-15s   %-12s  %-4s  %-17s  %-12s  %-6s\n","State Name","Capital","State Abbr","State Population","Region","US House Seats");
    		System.out.println("-------------------------------------------------------------------------------------------");
        Node temp = front;

        while(temp != null){
          States state = temp.state;
          state.print();
          
          temp = temp.nextNode;
         }
	 }
	
	 public boolean isEmpty() //true if no links
	 {
		 if (end == null)
	     {
	       return true;
	     }
		 else 
		 {
		   return false;
		 }
	 }
	 
	 public boolean isFull() //never true because its a linked list
	 {
		 return false;
	 }
	 
}