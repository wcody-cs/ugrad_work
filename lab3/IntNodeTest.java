
public class IntNodeTest extends IntNode {
	
	public static void main ( String args[] ) {
		
		//test default constructor
		IntNode a = new IntNode();
		
		
		IntNode e = new IntNode ( 8, null );
		
		IntNode d = new IntNode ( 6, e );
		
		IntNode c = new IntNode ( 4, d );
		
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
		
		
		
	}//end main
}
