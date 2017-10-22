package com.yogi.common;

public class AbstratPages {

    protected void explicitWait(int timeInSecond){

        try {
            Thread.sleep(1000 * timeInSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
