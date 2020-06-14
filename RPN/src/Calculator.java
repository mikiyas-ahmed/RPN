

import java.util.ArrayList;


public class Calculator{
 
	public double EvaluatePostfix(ArrayList<String> postfix) {

		Stack result = new Stack();
		for (int i = 0; i < postfix.size(); i++) {
			String token=postfix.get(i);
			if(tryParseInt(token)){
				result.push(Double.parseDouble(token));
			}
			else {
				double operand1=result.pop();
				
				double operand2=result.pop();
				
				System.out.println(operand2);
				System.out.println(operand1);
				System.out.println(token);
				
				double calc= calculate(operand1, operand2, token);
				System.out.println(calc);System.out.println();
				result.push(calc);
			}

		}
		return result.pop();
	}

	private static double  calculate(double operand1, double operand2, String token) {
		double result = 0.0;
		switch (token) 
		{
		case "+":
			result= operand2 + operand1;
			return result;
		case "-":
			result= operand2 - operand1;
			return result;
		case "/":
			result= operand2 / operand1;
			return result;
		case "*":
			result= operand2 * operand1;
			return result;
		case "^":
			result=operand1;
			for(int i=1; i<= operand2; i++) {
			result= result * operand1;}
			return result;
		}
		return result;
	}
	public boolean tryParseInt(String s) {  
		try {  
			Double.parseDouble(s);  
			return true;  
		} catch (NumberFormatException e) {  
			return false;  
		}  
	}
}

class Stack { 
	    static final int MAX = 10; 
	    int top; 
	    double a[] = new double[MAX]; // Maximum size of Stack 
	  
	    boolean isEmpty() 
	    { 
	        return (top < 0); 
	    } 
	    Stack() 
	    { 
	        top = -1; 
	    } 
	  
	    boolean push(double d) 
	    { 
	        if (top >= (MAX - 1)) { 
	            System.out.println("Stack Overflow"); 
	            return false; 
	        } 
	        else { 
	            a[++top] = d; 
	            System.out.println(d + " pushed into stack"); 
	            return true; 
	        } 
	    } 
	  
	    double pop() 
	    { 
	        if (top < 0) { 
	            System.out.println("Stack Underflow"); 
	            return 0; 
	        } 
	        else { 
	        	double x = a[top--]; 
	            return x; 
	        } 
	    } 
	  
	    double peek() 
	    { 
	        if (top < 0) { 
	            System.out.println("Stack Underflow"); 
	            return 0; 
	        } 
	        else { 
	        	double x = a[top]; 
	            return x; 
	        } 
	    } 
} 


