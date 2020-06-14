import java.util.ArrayList;


public class PostfixCreater {

	private enum Precedence
    {
        lp(0), rp(1), add(2), minus(3), divide(4), mult(5), mod(6),pow(7), noth(8), number(9);
 
        private int index;
        Precedence(int index)
        {
        	
            this.index = index;
        }
        public int getIndex()
        {
            return index;
        }        
    } 
    /** in stack precedence **/
    private static final int[] isp = {0, 19, 12, 12, 13, 13, 13, 14, 0};
    /** incoming character precedence **/
    private static final int[] icp = {20, 19, 12, 12, 13, 13, 13, 14, 0};
    /** operators **/
    private static final String[] operators = {"{", "}", "+", "-", "/", "*", "%", "^", " "};

    public Precedence getToken(String symbol)
    {
        switch (symbol)
        {
        case "("  : return Precedence.lp;
        case ")"  : return Precedence.rp;
        case "+"  : return Precedence.add;
        case "-"  : return Precedence.minus;
        case "/"  : return Precedence.divide;
        case "*"  : return Precedence.mult;
        case "%"  : return Precedence.mod;
        case "^"  : return Precedence.pow;
        case " "  : return Precedence.noth;
        default   : return Precedence.number;
        }
    }
    
    public boolean tryParseInt(String s) {  
		try {  
			Double.parseDouble(s);  
			return true;  
		} catch (NumberFormatException e) {  
			return false;  
		}  
	}
public ArrayList<String> postfix(String infix)
{
	ArrayList<String> postfix =new ArrayList<String>();
	String[] t = infix.split("(?<=[-+*/()])|(?=[-+*/()])");
	Stack stack = new Stack();
	Precedence pretoken;
	for (int i = 0; i < t.length; i++)
	{

		String token =t[i]; 
        pretoken=getToken(t[i]);

		/** if token is operand append to postfix **/
		if (tryParseInt(token)){
			postfix.add(t[i]);
		}
		/** if token is right parenthesis pop till matching left parenthesis **/

		else if(pretoken==Precedence.rp) {
			while (stack.peek() != Precedence.lp)
				postfix.add(operators[stack.pop().getIndex()]);
			/** discard left parenthesis **/
			stack.pop();
		}
		 
		else {
			System.out.print(pretoken.getIndex());
			System.out.println();
			while (!stack.isEmpty() && isp[stack.peek().getIndex()] >= icp[pretoken.getIndex()])
				{
				postfix.add(operators[stack.pop().getIndex()]);
				}
			stack.push(pretoken);
		}
			

	}

	while(!stack.isEmpty())
		postfix.add(operators[stack.pop().getIndex()]);
	return postfix;
}


class Stack { 
	    static final int MAX = 10; 
	    int top; 
	    Precedence a[] = new Precedence[MAX]; // Maximum size of Stack 
	  
	    boolean isEmpty() 
	    { 
	        return (top < 0); 
	    } 
	    Stack() 
	    { 
	        top = -1; 
	    } 
	  
	    boolean push(Precedence x) 
	    { 
	        if (top >= (MAX - 1)) { 
	            System.out.println("Stack Overflow"); 
	            return false; 
	        } 
	        else { 
	            a[++top] = x; 
	            System.out.println(x + " pushed into stack"); 
	            return true; 
	        } 
	    } 
	  
	    Precedence pop() 
	    { 
//	        if (top < 0) { 
//	            System.out.println("Stack Underflow"); 
//	            return 0; 
//	        } 
//	        else { 
	        	Precedence x = a[top--]; 
	            return x; 
//	        } 
	    } 
	  
	    Precedence peek() 
	    { 
//	        if (top < 0) { 
//	            System.out.println("Stack Underflow"); 
//	            return 0; 
//	        } 
//	        else { 
	        	Precedence x = a[top]; 
	            return x; 
//	        } 
	    } 
} 



	
}
