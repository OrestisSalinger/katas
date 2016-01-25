package eu.salingers.katas.live.trifork;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {

	private Stack<BigDecimal> values = new Stack<>();

	public BigDecimal getAccumlator() {
		if (values.size() == 0)
			return BigDecimal.ZERO;
		return values.peek();
	}

	public void setAccumlator(BigDecimal value) {
		if (values.size() > 0)
			values.pop();
		values.push(value);
	}

	public void enter() {
		values.push(getAccumlator());
	}

	public void drop() {
		values.pop();
	}

}
