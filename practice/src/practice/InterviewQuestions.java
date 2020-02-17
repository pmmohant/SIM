package practice;

public class InterviewQuestions {

	public static void main(String[] args) {
		
		char ch = '5';
		
		Integer ss = new Integer(ch);
		
		int x = ss.intValue();
		
		System.out.println("Interger ="+ x);
		
		Character cc = new Character(ch);
		
		System.out.println("Char ="+ cc.charValue());
		
		if (ss.equals(cc)) System.out.println("euals");
			
		if (ss.intValue()==cc.charValue()) {
			System.out.println("EQ");
			}
		else System.out.println("Nothing");
		

	}

}
