package cn.tuyucheng.taketoday.l.advanced.refactored;

import java.math.BigDecimal;

public abstract class Account {
	protected abstract void deposit(BigDecimal amount);
}