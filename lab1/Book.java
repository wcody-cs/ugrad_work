import java.util.*;

public class Book {

    //*****************************************************//
    //                instance variables                   //
    //*****************************************************//
    
    private String title;
    
    private int numAuthors;
    
    private String authors[];
    
    private String isbn;
    
    
    //*****************************************************//
    //                     constructors                    //
    //*****************************************************//
    
    
    /**
     * 
     * No parameter constructor
     * 
     **/
    public Book(){
        
        title = null;
        
        isbn = null;
        
        numAuthors = 0;
        
        authors = new String[3];
        
        
    }//end constructor
    
    
    /**
     * 
     * @param1 String that contains the title of the book.
     * Constructor that creates a Book with only the Title.
     * 
     **/
    public Book (String _title){
        
        title = _title;
        
        isbn = null;
        
        numAuthors = 0;
        
        authors = new String[3];
        
    }//end constructor
    
    
    /**
     * 
     * @param1 An object.
     * @note Precondition: the parameter should not be null and should be an instance of Book.
     * Constructor that creates a Book with the same instance variables as the object used in the parameter.
     * 
     **/
    public Book( Object obj ) {
    	
    	if ( obj instanceof Book && obj != null ) {
    		
    		title = ( (Book) obj ).getTitle();
    		
    		numAuthors = ( (Book) obj ).getAuthorNumber();
    		
    		authors = (String[]) ( ( (Book) obj).getAuthors() ).clone();
    			
    		isbn = ( ( Book ) obj ).getISBN();
    	
    	}//end if
    	
    }//end constructor

    
    //*****************************************************//
    //                 Accessor methods                    //
    //*****************************************************//
    
    public String getTitle(){
    
        return title;
        
    } //end getTitle
    
    
    public int getAuthorNumber(){
        
        return numAuthors;
        
    }//end getAuthorNumber
    
    
    public String getISBN() {
        
        return isbn;
        
    } //end getISBN
    
    public String[] getAuthors() {
    	
    	return authors;
    	
    }//end getAuthors
    
    //*****************************************************//
    //                modification methods                 //
    //*****************************************************//
    
    public void setTitle ( String _title ) {
        
        title = _title;
        
        return;
        
    } //end setTitle
    
    
    public void setISBN( String _ISBN ) {
        
        isbn = _ISBN;
        
        return;
        
    } //end setTitle
    
    
    //*****************************************************//
    //                      methods                        //
    //*****************************************************//
    
    
    /**
     * 
     * @param1 First parameter is the author to be added. 
     * @return Returns true or false if an author was successfully added.
     * @note
     * Add an author into the array if there is enough space. Increases number of authors.
     * 
     **/
    public boolean addAuthor ( String _author ) {
        
        if ( numAuthors < 3 ) {
        
            authors[numAuthors] = _author;
            
            numAuthors ++;
            
            return true;
            
        } // end if
        
            return false;
        
    }//end addAuthor
    
    
    /**
     * 
     * @param1 General object 
     * @return Returns true or false
     * @note
     * Returns true or false if the two Books have the same ISBN.
     * 
     **/
    public boolean equals ( Object obj ) {
        
        if ( obj instanceof Book && obj != null ) {
        			
    		if ( ((Book) obj).getISBN() == isbn ) {
            
    			return true;
            
    		} //end if
    		
        }//end if
        
        return false;
        
    }// end equals
    
    
    /**
     * 
     * @param1 A book object. 
     * @param2 A book object.
     * @return An array with all of the unique authors from both books.
     * @note Precondition: Neither parameters are null. If
     * Static method to get all the distinct authors of two books.
     * 
     **/
    public static String[] getAllAuthors ( Book b1, Book b2 ) {
        
    	int i = 0;
    	
    	int count = 0;
    	
    	String hold[] = new String[6];
    	
    	
    	//initialize array to null
    	for(int f = 0 ; f < 6 ; f++ ) {
    		
    		hold[f] = null;
    		
    	}//end for
    	
    	
        if ( b1.getTitle() == null || b2.getTitle() == null ) {
            
            return null;
            
        } //end if
        
        	
        //for loop to first initialize the first 3 authors into the new array
        for ( int j = 0 ; j < 3 ; j++ ) {
       		
       		hold[i] = b1.authors[j];
        			
       		i++;
        			
       	}// end for j
        	
        	
       	//check how many authors are book 2 and add them based on the number of authors in b2
   		for ( int z = 0; z < 3 ; z++ ) {
        		
       		//check every single author in b1 against b2[z] for any duplicates. if no duplicates then add b2[z] to answer[i] and increment.
      		if(b1.authors[0] != b2.authors[z] && b1.authors[1] != b2.authors[z] && b1.authors[2] != b2.authors[z]) {
       				
       			hold[i] = b2.authors[z];
       				
       			i++;
       				
       		}//end if
        		
       	}//end for z
       		
       		
       	//count how many nulls are in the array
       	for ( int t = 5 ; t >= 0 ; t--) {
       			
       		if ( hold[t] == null ) {
       				
       			count++;
       			
       		}//end if
       			
       	}//end for
       		
        
      //create new array to put in all the distinct authors without the null
   		String[] answer = new String[hold.length - count];
   		
   		for ( int u = 0 ; u < ( hold.length - count ) ; u++ ) {
   			
   			answer[u] = hold[u];
   			
   		}//end for
        
		return answer;
        
    }//end getAllAuthors
    
    
    /**
     * 
     * @returnA String that will print all of the data in a Book.
     * @note
     * A toString method to print out a book object.
     * 
     **/
    public String toString() {
    	
    	String answer;

    	answer = "Title: " + title + "\n" + "Number of authors: " + String.valueOf(numAuthors) + "\n" + "Authors: ";
    	
    	answer = answer + authors[0] + ", " + authors[1] + ", " + authors[2];
    	
    	answer = answer + "\n" + "ISBN: " + isbn;
    	
    	return answer;
    	
    } //end toString
    
    
    
    public static void main(String args[]) {
    	
    	Book book1 = new Book();
    	
    	Book book2 = new Book( "stringConstructorTEST ");
    	
    	Book book3 = new Book("book3TITLE");
    	
    	
    	book1.setTitle( "book1SET_TITLE_TEST");
    	
    	book1.setISBN( "123abc");
    	
    	book1.addAuthor("author1");
    	
    	book1.addAuthor("author2");
    	
    	book1.addAuthor("author3");
    	
    	book3.addAuthor("author4");
    	
    	book3.addAuthor("author5");
    	
    	book3.addAuthor("Author6");
    	
    	
    	System.out.println ( "Testing book1 with getTitle(), getISBN(), and toString()" );
    	System.out.println();
    	
    	System.out.println ( book1.getTitle() );
    	
    	System.out.println ( book1.getISBN() );
    	
    	System.out.println ( book1 );
    	System.out.println();
    	System.out.println("-----------------------------------------------------------------------------");
    	System.out.println();
    	
    	System.out.println( "Testing book2 with String constructor" );
    	
    	System.out.println ( book2.getTitle() );
    	System.out.println();
    	System.out.println("-----------------------------------------------------------------------------");
    	System.out.println();
    	
    	System.out.println ( "Testing book3 with getAllAuthors(book1,book2)" );
    	
    	String allAuthorTEST[] = getAllAuthors(book1,book3);
    	
    	System.out.println(allAuthorTEST[0]+ " " + allAuthorTEST[1]+ " " + allAuthorTEST[2]+ " " + allAuthorTEST[3]+ " " + allAuthorTEST[4]+ " " + allAuthorTEST[5]);
    	System.out.println();
    	System.out.println("-----------------------------------------------------------------------------");
    	System.out.println();
    	
    	System.out.println( "Testing if changing author4 to author3 will still add it to the array.");
    	
    	Book book4 = new Book ( "book4TEST ");
    	
    	book4.addAuthor("author3");
    	
    	book4.addAuthor("author5");
    	
    	book4.addAuthor("Author6");
    	
    	String b[] = getAllAuthors(book1,book4);
    	
    	for ( int i = 0 ; i < b.length ; i++) {
    		
    		System.out.println(b[i] + " ");
    	}//end for
    	
    	
    	System.out.println();
    	System.out.println("-----------------------------------------------------------------------------");
    	System.out.println();
    	
    	System.out.println ( "Testing book5 with copy constructor.");
    	Book book5 = new Book ( book1 );
    	
    	System.out.println( book5 );
    	
    	System.out.println();
    	System.out.println("-----------------------------------------------------------------------------");
    	System.out.println();
    	
    	System.out.println( "Testing equals method with book5 and book1 (should be true)" );
    	System.out.println ( book5.equals( book1 ) );
    	
    	System.out.println ( "Testing equals method with book5 and book2 (should be false)");
    	System.out.println ( book5.equals( book2 ) );
    	
    	
    	
    	
    	//System.out.println ( book3 );
    	
    	
    }//end main
    
}//end class    