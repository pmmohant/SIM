package practice;

public class Test extends UpcastingDowncasting {

	void Sample() {
	      System.out.println("method of sub class");
	      super.Sample();
	   }
	
	public static void main(String args[]) {
		   UpcastingDowncasting obj =(UpcastingDowncasting) new Test(); 
		   obj.Sample();
		   
}
}