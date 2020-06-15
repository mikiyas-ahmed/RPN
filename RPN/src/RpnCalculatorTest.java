import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RpnCalculatorTest {

	@Test
	public void testWithoutParenthesis() {

		
		PostfixCreater sy = new PostfixCreater();

		String infix = "12^(5+2)+7";
		


		ArrayList<String> postfix = sy.postfix(infix);
		

		System.out.println("\n......................Calculation Started..............................\n");
		System.out.println("\nPostfix expression : " + postfix);
		Calculator cal= new Calculator();
		double result=  cal.EvaluatePostfix(postfix);
		System.out.println("\n\t\t\tresult = "+result);
		
	}
	
	@Test
	public void testWithParentesis() {
		
		PostfixCreater sy = new PostfixCreater();

		String infix = "7+((8-9)+5)+63*10";
		
		ArrayList<String> postfix = sy.postfix(infix);

		System.out.println("\n......................Calculation Started..............................\n");
		System.out.println("\nPostfix expression : " + postfix);
		Calculator cal= new Calculator();
		double result=  cal.EvaluatePostfix(postfix);
		System.out.println("\n\t\t\tresult = "+result);
		
				
	}
	
	@Test
	public void testMoreComplex() {
		
		PostfixCreater sy = new PostfixCreater();


		String infix = "7+6^2";

		ArrayList<String> postfix = sy.postfix(infix);

		System.out.println("\n......................Calculation Started..............................\n");
		System.out.println("\nPostfix expression : " + postfix);
		Calculator cal= new Calculator();
		double result=  cal.EvaluatePostfix(postfix);
		System.out.println("\n\t\t\tresult = "+result);
		
				
	}
	}