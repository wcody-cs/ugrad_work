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
		
	}//end IntNode
	
	
	public IntNode( int _data , IntNode _node ) {
		
		data = _data;
		
		link = _node;
		
	}//end IntNode
	
	
	//************************************************\\
	//                    accessors                   \\
	//************************************************\\
	
	public int getData() {
		
		return data;
		
	}//end getData
	
	
	public IntNode getLink() {
		
		return link;
		
	}//end getLink
	
	
	//************************************************\\
	//                    mutators                    \\
	//************************************************\\
	
	public void setData( int _data ) {
		
		data = _data;
		
	}//end setData
	
	
	public void setLink ( IntNode _node ) {
		
		link = _node; 
		
	}//end setLink
	
	
	//************************************************\\
	//                    methods                     \\
	//************************************************\\

	public static int listLength ( IntNode head ) {
		
		//assuming head counts as a node in the list, there will always be at least 1.
		int count = 1;
		
		IntNode cursor = head;
		
		while ( cursor.getLink() != null ) {
			
			count ++;
			
			cursor = cursor.getLink();
			
		}//end while
		
		return count;
		
	}//end listLength
	
	
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
















}//end class