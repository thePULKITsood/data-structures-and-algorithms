public class linkedlist
{
  
private class Node{

  //  1 . data members 
    private int data = 0;
    private Node  next = null;
 
    Node (int data)   // constructor
    {
        this.data = data ;
    }
}

//  members or data of linked list 

 private  Node head = null;
 private  Node tail = null;
 private int NumberOfNodes = 0;

// functoins i need in the list 

//utility functions as i can not let them come in and access my private variables

// 1 . size
public int size ()
{
    return NumberOfNodes;
}

// 2 . isEmpty

public boolean isEmpty() {
    return size() == 0;
}


// ! helper fuctions for all the functions 
protected Node getNodeAt (int idx)
{Node temp = head;
  
    while (idx-- >0)
    {
temp = temp.next;
    }
    
    
    // can be written as 
    // * for (int i = 1 ;i<idx ; i++) 
    // tis is because the temp starts form head and after the first loop 
    // it reaches at 1 and after that i reaches at 1 means temp is leading i and 
    // not the other way around  so we start i from 1 so that i can lead 


    return temp;
}

 // ! additional functions for error handling and smooth sailing of the  add functions    

 protected  void  handleZeroAdd (Node node )
 {
     this.head = node ;
     this.tail = node ;
 }

 protected  void addNodeAtFirst ( Node node )
 {
     if (NumberOfNodes ==0)
     {
        //   call auzilary function to handle size zero add cases 
        handleZeroAdd(node);
     }
    else // size not zero  
     {
      node.next =  this .head;
      this .head = node ;
     }
     NumberOfNodes ++ ;
 }

 protected  void addNodeAtLast ( Node node )
 {
     if (NumberOfNodes ==0)
     {
        //   call auzilary function to handle size zero add cases 
        handleZeroAdd(node);
     }
    else // size not zero  
     {
      
      this .tail.next = node ;
      node.next = null;
     }
     NumberOfNodes ++ ;
 }


protected void  addNodeAtidx (Node node  ,int idx)
{
    if (idx == 0)
    addNodeAtFirst(node);
  else if (idx == size())
   addNodeAtLast(node);
else {
    Node nodeAt = getNodeAt(idx - 1);
    Node forw = nodeAt.next;

    //  ! here the order of the changing of pointers is very important
    // ! firtly change the node .next then change  noode at .next 
    //  nahi to if did in reverse order the results willbe devastating

    node.next = forw;    
    nodeAt.next = node;
    this.NumberOfNodes++;
}

}

// now adding functions    //* these functions will be public


//* =========================================================
// TODO -  add at first
// ? function for error handling and creating a node 

public void addAtFirst( int data)
{
    Node node = new Node (data);
    addNodeAtFirst(node);  // private func 
}



// TODO -  add at Last 
public void addAtLast( int data)
{
    Node node = new Node (data);
    addNodeAtLast(node);
}


// TODO -  add at Index

public void addAtidx( int data , int idx ) throws Exception
{
    // ! error checking 

    if (idx < 0 || idx > size() ) // here be care ful with the size what i am writing 
    
    {
     throw new Exception(" invalid index ");
    }
    Node node = new Node (data);
    addNodeAtidx(node ,idx);
}




// ! auxillary function for removal

protected  void EmptyException() throws Exception
{
    throw new Exception (" Linked list is empty ");
}
protected void handelSize1() {
    this.head = null;
    this.tail = null;
}
protected  Node removeFirstNode ()
{
    Node temp = head;
    if (size() == 1)
        handelSize1();
    else
        this.head = this.head.next;

    temp.next = null;
    this.NumberOfNodes--;
    return temp;
}
protected  Node removeLastNode()
{
    Node temp = tail;
    // ! this check is very important as i need ot check 
    // ! other wise the size - 2 will result in -1 and that will produce error ! 
    if (size() == 1)
        handelSize1();
    else {
        Node secondLastNode = getNodeAt(size() - 2);

        secondLastNode.next = null;
        this.tail = secondLastNode;
    }

    this.NumberOfNodes--;
    return temp;
}

protected Node removeNodeAtIdx (int idx)

{   if (idx == 0)
    return removeFirstNode();
else if (idx == size() - 1)
    return removeLastNode();
else {
    Node prevNode = getNodeAt(idx - 1);
    Node removeNode = prevNode.next;
    Node forwardNode = removeNode.next;

    prevNode.next = forwardNode;
    removeNode.next = null;

    this.NumberOfNodes--;
    return removeNode;
}
}
//  now removal functions - with error handling 

//  1 remove at first 
public int removeAtFirst( ) throws Exception
{ 

    if ( size() == 0)
    {
    //    throw new 
    EmptyException();
    }
    Node node = removeFirstNode ();
return node .data;

}


//  2 remove at last 
public int removeAtLast ( ) throws Exception
{ 

    if ( size() == 0)
    {
        
    }
    Node node = removeLastNode ();
return node .data;

}
//  3 remove at index
public int removeAtIdx( int idx ) throws Exception 
{
 if (size() == 0)
 {
     EmptyException();
 }   

 else if (idx <0 ||idx > size()-1 )  

//   * or i can type (idx <0 ||idx >=size() )
{
    throw new Exception ("Invalid syntax");
}

Node node = removeNodeAtIdx( idx);
return node.data;
}

// get data at first 

// get data at  last 
// get data at  index 


public int getFirst() throws Exception {
    if (size() == 0)
    EmptyException();

    return this.head.data;

}

public int getLast() throws Exception {
    if (size() == 0)
    EmptyException();

    return this.tail.data;
}

public int getAt(int idx) throws Exception {
    if (size() == 0)
    EmptyException();
    else if (idx < 0 || idx >= size())
        throw new Exception("Invalid Index");

    return getNodeAt(idx).data;
}

}