package com.baeldung.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect AccountAspect{
    private static final Logger logger = LoggerFactory.getLogger(AccountAspect.class);
    final int MIN_BALANCE = 10;

    pointcut callWithDraw(int amount,Account account):
            call(boolean com.baeldung.aspectj.Account.withdraw(int)) && args(amount) && target(account);

    before (int amount ,Account account) :callWithDraw(amount,account){
        logger.info(" Balance before withdrawal: {}", account.balance);
        logger.info(" Withdraw ammout: {}", amount);
    }
}