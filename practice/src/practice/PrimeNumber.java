package practice;

public class PrimeNumber {

	
	int n;
	
	public void primenumber(int i){
		for (i=2;i<n;i++){
			if(i%n==0){
				System.out.println("It is not a Prime number");
			}
		}
	}
	
	public static void main(String []args){
		
		PrimeNumber pm = new PrimeNumber();
		pm.primenumber(5);
		
	}
}
