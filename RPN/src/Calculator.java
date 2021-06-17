?// this is me eyob

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
				
				double calc= calculate(operand1, operand2, token);
				result.push(calc);
			}

		}
		double final_result=result.pop();

		return final_result;
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
			result=Math.pow(operand2, operand1);
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
	            System.exit(0);
	            return false; 
	        } 
	        else { 
	            a[++top] = d; 
	            return true; 
	        } 
	    } 
	  
	    double pop() 
	    { 
	        if (top < 0) { 
	            System.out.println("Stack Underflow there is no enough operand to calocolate"); 
	            System.exit(0);
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
	            System.exit(0);
	            return 0; 
	        } 
	        else { 
	        	double x = a[top]; 
	            return x; 
	        } 
	    } 
} 


