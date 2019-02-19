public class IntNode {
	
	//************************************************\\
	//               instance variables               \\
	//************************************************\\
	
	private int data;
	
	private IntNode link;
	
	
	//************************************************\\
	//                  constructors                  \\
	//************************************************\\
	
	public IntNode() {
		
		data = 0;
		
		link = null;
		
	}// end IntNode
	
	
	public IntNode( int _data , IntNode _node ) {
		
		data = _data;
		
		link = _node;
		
	}// end IntNode
	
	
	//************************************************\\
	//                    accessors                   \\
	//************************************************\\
	
	public int getData() {
		
		return data;
		
	}// end getData
	
	
	public IntNode getLink() {
		
		return link;
		
	}// end getLink
	
	
	//************************************************\\
	//                    mutators                    \\
	//************************************************\\
	
	public void setData( int _data ) {
		
		data = _data;
		
	}// end setData
	
	
	public void setLink ( IntNode _node ) {
		
		link = _node; 
		
	}// end setLink
	
	
	//************************************************\\
	//                    methods                     \\
	//************************************************\\

	public static int listLength ( IntNode head ) {
		
		// assuming head counts as a node in the list, there will always be at least 1.
		int count = 1;
		
		IntNode cursor = head;
		
		while ( cursor.getLink() != null ) {
			
			count ++;
			
			cursor = cursor.getLink();
			
		}//end while
		
		return count;
		
	}// end listLength
	
	
	public String toString() {
		
		String answer = "" + data;
		
		IntNode cursor = link;
		
		while ( cursor.getLink() != null ) {
			
			answer = answer + " -> " + cursor.getData();
			
			cursor = cursor.getLink();
			
		}//end while
		
		answer = answer + " -> " + cursor.getData();
		
		return answer;
		
	}//end toString
	

	public void addNodeAfterThis ( int newData ) {
		
		IntNode a = new IntNode ( newData , link );
		
		link = a;
		
	}//end addNodeAfterThis
	
	
	public static boolean search ( IntNode head , int data ) {
		
		IntNode cursor = head;
		
		// loop through the list starting from head and search for given data.
		// if it exists return true.
		while ( cursor != null ) {
			
			if ( cursor.data == data )
				
				return true;
			
			cursor = cursor.link;
			
		}//end while
		
		return false;
		
	}//end search
	
	
	public void removeNodeAfterThis() {
		
		if ( link == null ) return;
		
		link = link.link;
		
	}//end removeNodeAfterThis

	public static int listEvenNumber( IntNode head ) {	
		
		IntNode cursor = head;
		
		int count = 0;
		
		// loop through starting at the parameter node
		while (cursor != null ) {
			
			// check if this node is an even number and increment the count
			if ( ( cursor.getData() % 2 ) == 0 ) {
				
				count++;
				
			}//end if
			
			cursor = cursor.getLink();
			
		}//end while 
		
		return count;
		
	}//end listEvenNumber

	public void addToEnd ( int newdata ) {
		
		IntNode cursor = link;
		
		// loop through the while list to get to the end and keep cursor at the final node
		while ( cursor.getLink() != null ) {
			
			cursor = cursor.getLink();
			
		}//end while
		
		// create a new node linked to null and link cursor to the new node,
		// which effectively adds a new node to the end.
		IntNode a = new IntNode ( newdata, null );
		
		cursor.setLink( a );
		
	}//end addToEnd

	public static int sumLast( IntNode head, int num ) {
		
		int sum = 0;
		
		int count = 0;
		
		IntNode cursor = head;
		
		
		//count the amount of elements in the list.
		while ( cursor != null ) {
			
			count++;
			
			cursor = cursor.getLink();
			
		}//end while
		

		
		//create a variable to store the number of elements
		// that are not getting added into the summation.
		int skip = count - num;
		
		//reset cursor back to the start of the list
		cursor = head;
		
		//if num is larger the length of the list, 
		//it will return the sum of the entire list.
		if ( count <= num ) {
			
			while ( cursor != null ) {
				
				sum = sum + cursor.getData();
				
				cursor = cursor.getLink();
				
			}//end while
			
			return sum;
			
		}//end if
			
		
		//iterate through skip number of elements to skip the first elements
		//that aren't getting added in the list
		for ( int i = 0 ; i < skip ; i++) {
			
			cursor = cursor.getLink();
	
		}// end for
		
		
		//add the rest of the elements after skip until null
		//and return that value
		while ( cursor != null) {
			
			sum = sum + cursor.getData();
			
			cursor = cursor.getLink();
			
		}//end while
		
		return sum;
		
	}// end sumLast
	
	
	 
	public static IntNode copyOdd (IntNode head) {
		
		if ( head == null)
			return null;
		
		//create a new head
		IntNode answer = new IntNode( 0, null );
		
		IntNode answerCursor = answer;
		
		IntNode cursor = head;
		
		//loop through the entire list
		while ( cursor != null) {
			
			//add a new node after the head if it is an odd number
			if ( cursor.getData() % 2 != 0 ) {
			
				answerCursor.addNodeAfterThis( cursor.getData() ); 
				
				answerCursor = answerCursor.getLink();
				
			}//end if
			
			cursor = cursor.getLink();
			
		}//end while
		
		//remove the 0 at the start of the list
		answer = answer.getLink();
		
		return answer;
		
	}//end copyOdd


	public static IntNode removeAll( IntNode head, int e ) {
		
		IntNode preCursor = head;
		
		IntNode cursor = head.getLink();
		
		while ( preCursor.getData() == e ) {
			
			head = cursor;
			
			preCursor = head;
			
			cursor = cursor.getLink();
			
		}//end while
		
		//loop through all the elements
		while ( cursor != null ) {
			
			// check if data at cursor = e. if it does then change the link
			// of precursor to cursor.link and change cursor to precursor.link
			if ( cursor.getData() == e ) {
				
				preCursor.setLink ( cursor.getLink() );
				
				cursor = preCursor.getLink();
			
			}//end if
			
			//increment preCursor and cursor.
			preCursor = cursor;
			
			cursor = cursor.getLink();
			
		}//end while
		
		return head;
		
	}//end removeAll


	public static IntNode reverse ( IntNode head) {
		
		IntNode pre = head;
		
		IntNode cursor = head.getLink();
		
		IntNode next = cursor.getLink();
		
		//set the first node to null and cursor pointing to pre
		pre.setLink(null);
		
		cursor.setLink(pre);
		
		pre = cursor;
		
		cursor = next;
		
		next = next.getLink();
		
		// while next is not null ( the rest of the list ) 
		// link cursor to the previous and use next to get
		// to the next node.
		while ( next != null ) {
			
			cursor.setLink(pre);
			
			pre = cursor;
			
			cursor = next;
			
			next = next.getLink();
			
		}//end while
		
		//make the final node link to the previous
		cursor.setLink(pre);
		
		head = cursor;
		
		return head;
		
	}//end reverse

	
	public static boolean hasCycle(IntNode head) {
		
		IntNode cursor = head;
		
		cursor = head;
		
		//create an array with enough space to hold all the nodes of a list
		IntNode array[] = new IntNode[1000];
		
		//create count to count the amount of elements in the array
		int count = 0;
		
		//initialize the whole array to null
		for ( int i = 0 ; i < 1000 ; i++)
			array[i] = null;
		
		
		for ( int i = 0; i < 1000  && cursor != null ; i++) {
			
			array[i] = cursor;
			
			cursor = cursor.getLink();
			
		}//end for
		
		//count the elements in the array that arent null ( will have repetition)
		for ( int i = 0 ; i < 1000 ; i ++)
			
			if ( array[i] != null )
				
				count++;
		
		//check the address of each node against each other and find repetition
		for ( int i = 0 ; i < count ; i++ ) {
			
			for ( int z = i + 1 ; z < count; z++ )
				
				if ( array[i] == array[z] )
					return true;
				
		}
		return false;
		
	}//end hasCycle

	
	
	
	
	
}//end class