package practice;

public class PrimeNumberFinally {

	public boolean isPrime(int num){
		
		if (num<=1){
			return false;
		}
		
		for(int i=2;i<num;i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public void numPrint(int st,int end){
		for (int i=st;i<=end;i++){
			 if(isPrime(i)){
				 System.out.println(i);
			 }
		}
			
	}
	
	public static void main(String[] args) {
		PrimeNumberFinally obj = new PrimeNumberFinally();
		System.out.println("No. is "+obj.isPrime(101));
		obj.numPrint(0,20);
	}
}
		
	
	
	
