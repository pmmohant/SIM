package practice;

public  class Parentclass
{
   Parentclass(){
	System.out.println("Constructor of parent class");
   }
}

   class Subclass extends Parentclass
{
//   Subclass(){
//	/* Compile implicitly adds super() here as the
//	 *  first statement of this constructor.
//	 */
//	System.out.println("Constructor of child class");
//   }
   Subclass(int num){
	/* Even though it is a parameterized constructor.
	 * The compiler still adds the no-arg super() here
	 */
	System.out.println("arg constructor of child class");
   }
   void display(){
	System.out.println("Hello!");
   }
   
   public static void main(String args[]) throws InstantiationException, IllegalAccessException{
		/* Creating object using default constructor. This 
		 * will invoke child class constructor, which will 
		 * invoke parent class constructor
		 */
		//Subclass obj= new Subclass();
		//Calling sub class method 
		//obj.display();
		/* Creating second object using arg constructor
		 * it will invoke arg constructor of child class which will
		 * invoke no-arg constructor of parent class automatically 
		 */
		Subclass obj2= Subclass.class.newInstance();
		obj2.display();
	   }
}
