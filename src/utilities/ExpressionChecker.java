package utilities;


public class ExpressionChecker {
	boolean r1;
	boolean r2;
	boolean r3;
	private MyStack<Character> stack;

    public ExpressionChecker() {
    	stack = new MyStack<>();
    }
    
    public boolean getR1() {
		return r1;
	}
	
	public boolean getR2() {
		return r2;
	}
	
	public boolean getR3() {
		return r3;
	}

	public boolean checkExpression(String expression) {
    	this.r1 = checkOperators(expression);
    	this.r2 = checkParentheses(expression);
    	this.r3 = checkOperationsParentheses(expression);
    	
    	if(this.r1 == false || this.r2 == false || this.r3 == false) {
    		return false;
    	}
    	
    	return true;
    }
    
    public boolean checkOperators(String expression) {
    	int appeared = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '*') {
            	appeared++;
                if (i == 0 || i == expression.length() - 1) {
                    return false;
                }

                char previousCharacter = expression.charAt(i - 1);
                char nextCharacter = expression.charAt(i + 1);

                if (Character.isDigit(previousCharacter) && nextCharacter == ')') {
                    return false;
                }
                if(previousCharacter == '(' && Character.isDigit(nextCharacter)) {
                	return false;
                }
                if(previousCharacter == '(' && nextCharacter == ')') {
                	return false;
                }
                if(previousCharacter == '(' && nextCharacter == '(') {
                	return false;
                }
            }
        }
        if(appeared == 0) {
        	return false;
        }

        return true;
    }
    
    public boolean checkParentheses(String expression) {
    	Boolean result = null;
    	for(int i = 0; i < expression.length(); i++) {
    		char c = expression.charAt(i);
    		if(c == '(') {
    			stack.push('(');
    		}
    		else if(c == ')'){
    			if(stack.size() == 0) {
    				stack.push(')');
    				break;
    			}
    			else {
    				stack.pop();
    			}
    		}
    	}
    	
    	if(stack.size() > 0) {
    		result =  false;
    	}
    	else if(stack.size() == 0) {
    		result = true;
    	}
  
    	return result;
    }
    
    public boolean checkOperationsParentheses(String expression) {
    	for(int i = 0; i < expression.length(); i++) {
    		char c = expression.charAt(i);
    		if(c == '(' && i != 0) {
    			char previousCharacter = expression.charAt(i - 1);
    			if(Character.isDigit(previousCharacter)) {
    				return false;
    			}
    		}
    		if(c == ')' && i != expression.length() - 1) {
    			char nextCharacter = expression.charAt(i + 1);
    			if(Character.isDigit(nextCharacter)) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    
    
    
    
    
}
