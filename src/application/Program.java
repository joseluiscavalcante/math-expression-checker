package application;

import java.util.Locale;
import utilities.ExpressionChecker;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		ExpressionChecker checker = new ExpressionChecker();
		
		String expression = "x+y*(3+z)";
		
		boolean result = checker.checkExpression(expression);
		
		if(result == true) {
			System.out.println("A expressão: " + expression + " está correta!");
		}
		else {
			System.out.println("A expressão: " + expression + " está errada!");
		}
	}

}
