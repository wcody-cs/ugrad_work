
public class StringSet {
	
	//*********************************************************\\
	//                  Instance variables                     \\
	//*********************************************************\\
	
	private int capacity;
	
	private String data[];
	
	private int size = 0;

	//*********************************************************\\
	//                      Constructors                       \\
	//*********************************************************\\


	/**
	 * No argument constructor which initializes a StringSet instance, sets its capacity to 2, and creates an array to store 2 String instances.
	 */
	public StringSet() {
		
		capacity = 2;
		
		data = new String[ capacity ];
		
		
	}//end StringSet(no-argument)
	
	
	/**
	 * This method initialized a StringSet instance and sets its capacity to the input parameter _capacity and creates an array to store _capacity string values.
	 * @param _capacity
	 * The initial capacity of the StringSet.
	 * @precondition
	 * _capacity must be a non-negative value.
	 * @postcondition
	 * creates an array to store _capacity of string values
	 */
	public StringSet( int _capacity) {
		
		if ( _capacity < 0 ) {
			
			throw new IllegalArgumentException ( "Capacity can not be less than 0.");
			
		}//end if
		
		capacity = _capacity;
		
		data = new String[ capacity ];
		
	}//end StringSet(int _capacity)
	
	
	/**
	 * A constructor that creates a new StringSet instance and copies the content of the given object to the new instance.
	 * @param obj
	 * The object to create the copy from.
	 * @precondition
	 * The obj should not be null and should be an instance of StringSet.
	 * @postcondition
	 * The constructor makes a new StringSet object with the same values in the instance variables as obj.
	 */
	public StringSet ( Object obj ) {
		
		if ( obj == null ) {
			
			throw new NullPointerException ("The object you entered is null.");
			
		}//end if
		
		if ( ! ( obj instanceof StringSet) ) {
			
			throw new IllegalArgumentException ("The object you entered is not an instance of StringSet");
			
		}//end if
		
		//once preconditions are met we can copy the instance variables of obj into a new StringSet.
		StringSet x = (StringSet) obj;
		
		capacity = x.capacity();
		
		size = x.size();
		
		for ( int i = 0 ; i < x.size(); i++ ) {
			
			data[i] =  new String ( x.data[i] );
			
		}//end for
		
	}//end copy constructor
	
	//*********************************************************\\
	//                        Accessors                        \\
	//*********************************************************\\
	
	/**
	 * A method to retrieve the value of size.
	 * @return int
	 * Returns the amount of elements in the set.
	 */
	public int size() {
		
		return size;
		
	}//end size
	
	/**
	 * A method to retrieve the value of capacity.
	 * @return int
	 * Returns the total capacity of the set.
	 */
	public int capacity() {
		
		return capacity;
		
	}//end capacity
	
	
	//*********************************************************\\
	//                        Mutators                         \\
	//*********************************************************\\
	
	/**
	 * A method which adds a given String value to the first available space of the String array in this StringSet instance.
	 * @precondition
	 * The String value should not be null.
	 * @postcondition
	 * The set will have a new unique character in the first available space in the String array.
	 * @param a
	 * The string to be added into the set.
	 */
	public void add ( String a ) {
		
		if ( a == null ) {
			
			throw new NullPointerException ("The string you entered is null.");
		
		}//end if
		
		if( size == capacity ) {
			
			ensureCapacity( ( size + 1 ) * 2 );
			
		}//end if
		
		if ( contains( a ) ) {
			
			return;
			
		}//end if
		
		data[size] = a;
		
		size++;
					
	}//end add
	
	/**
	 * A method to check whether this collection contains the input parameter.
	 * @param a
	 * The string to be found in the set.
	 * @return boolean
	 * Returns true or false if the set contains the given string.
	 */
	public boolean contains ( String a ) {
		
		if ( a == null ) return false;
		
		int i = 0;
		
		// check all instances of data[i] against the parameter. if found return true. 
		// if not then increment and check again until size has been reached.
		while ( i < size ) {
			
			if (data[i] == a) {
				
				return true;
				
			}//end if
			
			i++;
		}//end while
		
		return false;
		
	}//end contains
	
	/**
	 * A method to remove from the collection the String which has the same vaule as the given parameter.
	 * @param a
	 * The value of the string to remove
	 * @return
	 * return false if a is NULL.
	 * return false if a was successfully removed from the collection.
	 */
	public boolean remove( String a ) {
		
		if ( a == null ) return false;
		
		int index;
		
		for ( index = 0; index < size && a != data[index] ; index++) {
			
			//target was not found
			if ( index == size ) {
				
				return false;
				
			}//end if
			
		}//end for
		
		while ( index < size ) {
			
			//take the data at index and place the data in front of it into its spot
			data[index] = data [ index + 1 ];
			
			index++;
				
		}//end while
		
		size--;
		
		return true;
			
		
	}//end remove
	
	
	private void ensureCapacity(int minimumCapacity) {
		
		if ( minimumCapacity < 0 ) { 
			
			throw new IllegalArgumentException ("The minimumCapacity can not be negative.");
			
		}//end if 
		
		String newData[] = new String[minimumCapacity];
		
		System.arraycopy( data, 0, newData, 0, size );
		
		data = newData;
		
		capacity = data.length;
	
	}//end ensureCapacity
	
	
	/**
	 * 
	 * @precondition 
	 * String value should not be null
	 * The values in the array are already ordered ascendingly
	 * @postcondition
	 * Takes a value from input and adds it into the alphabetical place in the array.
	 * @param a
	 * The string to be added
	 **/
	public void addOrdered( String a ) {
		
		if ( a == null ) 
			
			throw new NullPointerException ( "The String you entered is null.");
		
		if ( contains( a ) ) 
			
			return;
			
		if ( size == capacity )
			
			ensureCapacity ( ( size + 1 )* 2 );
		
		int index = 0;
		
		//loop to find which index is smaller than the given letter starting from 0
		for ( int i = 0 ; i < size ; i++ ) {
			
			if ( data[i].compareTo( a ) < 0 )
				
				index++;
			
			else
				
				break;
			
		}//end for
			
		String temp[] = new String [capacity];
		
		int i = 0;
		
		//loop to assign all values from 0 to the spot a goes into in the new array.
		while ( i < index ) {
			
			temp[i] = data[i];
			
			i++;
			
		}//end while
		
		temp[i] = a;
		
		//loop to add all the values after the spot a goes into in the new array.
		while ( i < size ) {
			
			temp[ i + 1 ] = data[ i ];
			
			i++;
			
		}//end while
		
		data = temp;
		
		size++;
		
	}//end addOrdered
	
	
	public static void main ( String args []) {
		
		//test no param constructor
		StringSet a = new StringSet();
		
		//test constructor with initial capacity
		StringSet b = new StringSet(10);
		System.out.println( b.capacity() );
		
		
		//test copy constructor
		StringSet bCopy = new StringSet ( b );
		System.out.println( bCopy.capacity() );
		
		//test all accessors on a
		a.addOrdered("z");
		
		System.out.print("Size of collection A: ");
		System.out.println( a.size()  );
		System.out.print("Capacity of collection A: ");
		System.out.println( a.capacity() );
		
		a.addOrdered("f");
		
		System.out.print("Size of collection A: ");
		System.out.println( a.size() );
		
		a.addOrdered( "a" );
		
		System.out.print("Size of collection A: ");
		System.out.println( a.size() );
		System.out.print("Capacity of collection A: ");
		System.out.println( a.capacity() );
		
		System.out.print("The strings in collection a are: ");
		
		System.out.println( a.data[0] + " " + a.data[1] + " " + a.data[2] + " ");
		
		System.out.println( "Does collection a contain p? " + a.contains("p") );
		System.out.println( "Does collection a contain z? " + a.contains("z") );
		
		System.out.println( "Was z successfully removed from collection a? " + a.remove("z") );
		System.out.println( "Does collection a contain z? " + a.contains("z"));
		
		b.add("b");
		
		System.out.println( b.size() );
		b.add("c");
		b.add("d");
		System.out.println( b.size() );
		b.add("b");
		System.out.println( b.size() );
		
	}//end main
	
	
}//end class
