/**
 * Pushes, Pops, and Prints state information onto a stack data structure
 * 
 *  @author <Steven Fernandez>  
 *  @version <2/18/2019>  
 */ 

class Stack
{
    private class Node {
        States state; //data type is of state
        Node previousNode; //node reference 
    }

    
    Node top;    
    
    public Stack()
    {
        top = null; //stack starts empty
    }
    
    public void push(States st){
        Node newtop = new Node(); //create node

        newtop.state = st;
        newtop.previousNode = top;
        top = newtop;
    }
    
    public States pop() //pops states 
    {
    	//if empty
        if (top == null){   //error catch if stack is empty
          System.out.println("List is empty");
          return null;   
        }
        else
        {
          States tempState = top.state;
          top = top.previousNode;
          return tempState;
        } 
    }
    
    public void printStack() //prints stack
    {
    		System.out.println();
    		System.out.println("Stack Contents:");
    		System.out.println();
    		System.out.printf("%-15s   %-12s  %-4s  %-17s  %-12s  %-6s\n","State Name","Capital","State Abbr","State Population","Region","US House Seats");
    		System.out.println("-------------------------------------------------------------------------------------------");
    		Node newtop = top;

        while(newtop != null)
        {
          States state = newtop.state;
          state.print();
          
          newtop = newtop.previousNode;
        }
    }	
    public boolean isEmpty()
    { 								//true if stack is empty
    	return (top == null);
    }
    
    public boolean isFull()
    {    
    	return false; //true if stack is full
    }
}