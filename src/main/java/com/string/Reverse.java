package com.string;

public class Reverse {

    public int reverse(int x) {
        int tmp = 0;
        while (x != 0){
            if ((tmp * 10) / 10 != tmp) {
                tmp = 0;
                break;
            }

            int pop = x % 10;
            x /=10;



            tmp = tmp * 10 + pop;
        }
        return tmp;
    }
}
