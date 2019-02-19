
public class IntNodeAdvancedTest extends IntNode {
	
	public static void main ( String args[] ) {
		
		//test default constructor
		IntNode a = new IntNode();
		
		
		IntNode e = new IntNode ( 7, null );
		
		IntNode d = new IntNode ( 6, e );
		
		IntNode c = new IntNode ( 7, d );
		
		IntNode b = new IntNode( 2, c );
		
		//test toString
		System.out.println ("Testing toString(b) :");
		System.out.println ( b + "\n--------------------------------------------------------------------");
		
		//test list length
		System.out.println ("Testing listLength(b) :");
		System.out.println ( listLength( b ) + "\n--------------------------------------------------------------------" );
		
		//test addNodeAfterThis & print
		c.addNodeAfterThis(10);
		System.out.println ("Testing c.addNodeAfterThis(10) :");
		System.out.println ( b + "\n--------------------------------------------------------------------");
		
		//test list length
		System.out.println ("Testing listLength(b) :");
		System.out.println ( listLength( b ) + "\n--------------------------------------------------------------------" );
		
		//test search
		System.out.println ("Testing search(7) :\n" + search( b, 7) + "\n");
		System.out.println ("Testing search(6) :");
		System.out.println (search ( b , 6 ) + "\n--------------------------------------------------------------------");
		
		//test remove addNodeAfterThis & print
		c.removeNodeAfterThis();
		System.out.println ("Testing c.removeNodeAfterThis() :");
		System.out.println ( b + "\n--------------------------------------------------------------------");
		
		//test listEvenNumber
		System.out.println ("Testing listEvenNumber() :");
		System.out.println ( listEvenNumber( b ) + "\n--------------------------------------------------------------------");
		
		//test addToEnd
		b.addToEnd( 10 );
		System.out.println ( "Testing addToEnd() " );
		System.out.println ( b + "\n--------------------------------------------------------------------");

		//test sumLast
		System.out.println ( "Testing sumLast " );
		System.out.println ( sumLast(b, 3) + "\n--------------------------------------------------------------------");
		
		//test copyOdd
		System.out.println ( "Testing copyOdd " );
		System.out.println (  copyOdd(b) + "\n--------------------------------------------------------------------");
		
		//test removeAll(7)
		System.out.println ( "Testing removeAll(7) " );
		System.out.println (  removeAll( b, 7) + "\n--------------------------------------------------------------------");
				
		
		//test reverse(b)
		System.out.println ( "Testing reverse(b) " );
		System.out.println (  reverse(b) + "\n--------------------------------------------------------------------");
		

	    IntNode h = new IntNode ( 25, null);
		
		h.addNodeAfterThis(10);
		h.addNodeAfterThis(90);
		h.addNodeAfterThis(34);
		
		//test hasCycle
		System.out.println ( "Testing hasCycle(h) " );
		System.out.println (  hasCycle(h)  + "\n--------------------------------------------------------------------");
				
		//create a list with a cycle
		IntNode z = new IntNode ( 10, null );
		IntNode x = new IntNode ( 20, null);
		IntNode y = new IntNode ( 30, null); 

		x.setLink(y);
		y.setLink(z);
		z.setLink(x);
		
		//test hasCycle
		System.out.println ( "Testing hasCycle(x) " );
		System.out.println (  hasCycle(x)  + "\n--------------------------------------------------------------------");
						

		
	}//end main
}
