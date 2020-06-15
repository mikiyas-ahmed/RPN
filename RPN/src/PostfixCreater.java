import java.util.ArrayList;



public class PostfixCreater {


    /** enum **/
    private enum Precedence
    {
        lparen(0), rparen(1), plus(2), minus(3), divide(4), times(5), mod(6),pow(7), eos(8), operand(9);
 
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
    /** precedence stack **/
    private Precedence[] stack; 
    /** stack top pointer **/
    private int top;
 
    /** pop element from stack **/
    private Precedence pop()
    {
        return stack[top--];
    }
    /** push element onto stack **/
    private void push(Precedence ele)
    {
        stack[++top] = ele;
    }
    /** get precedence token for symbol **/
    public Precedence getToken(String symbol)
    {
        switch (symbol)
        {
        case "("  : return Precedence.lparen;
        case ")"  : return Precedence.rparen;
        case "+"  : return Precedence.plus;
        case "-"  : return Precedence.minus;
        case "/"  : return Precedence.divide;
        case "*"  : return Precedence.times;
        case "%"  : return Precedence.mod;
        case "^"  : return Precedence.pow;
        case " "  : return Precedence.eos;
        default   : return Precedence.operand;
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
 
    /** Function to convert infix to postfix **/
    public ArrayList<String> postfix(String infix)
    {
        ArrayList<String> postfix =new ArrayList<String>();
        //String postfix ="";
    	top = 0;
    	int operatatorCount=0,operandCount=0;
        stack = new Precedence[infix.length()];
        stack[0] = Precedence.eos;
        String[] t = infix.split("(?<=[-+^*/()])|(?=[-+^*/()])");
        Precedence token;
        for (int i = 0; i < t.length; i++)
        {
        	String c= t[i];
            token = getToken(c);
            //System.out.println(token);
            /** if token is operand append to postfix **/
            if (tryParseInt(t[i])) {
                postfix.add( t[i]);
                operandCount++;
                }
            /** if token is right parenthesis pop till matching left parenthesis **/
            else if (token == Precedence.rparen)
            {
                while (stack[top] != Precedence.lparen)
                    {postfix.add(operators[pop().getIndex()]);
                    operatatorCount++;
                    }
                /** discard left parenthesis **/
                pop();
            }
            /** else pop stack elements whose precedence is greater than that of token **/
            else
            {
                while (isp[stack[top].getIndex()] >= icp[token.getIndex()])
                    {postfix.add(operators[pop().getIndex()]);
                    operatatorCount++;
                    }
                push(token);
            }
        }
        /** pop any remaining elements in stack **/
        while ((token = pop()) != Precedence.eos) {
            postfix.add(operators[token.getIndex()]);
            operatatorCount++;}
 
        if(operatatorCount+1<operandCount) {
        	System.out.print("there is no enough operator to calculate ");
        	System.exit(0);
        }
        
        return postfix;
    }

}
