package com.example.demo.test;

public class MyTest {
    public static void main(String[] args) {
        double v = totalPrice(2, 3,4,1,0);
        System.out.println("所购买商品的总价为：" + v + "元");
    }

    /**
     * 求总价格
     * @param apple 苹果斤数
     * @param strawberry 草莓斤数
     * @param mango 芒果斤数
     * @param state 草莓是否打8折，1：是，0：否
     * @param status 是否购物满100减10块，1：是，0：否
     * @return 总价格
     */
    public static double totalPrice(double apple,double strawberry,double mango,int state,int status){
        double applePrice = 8;
        double strawberryPrice = 13;
        if (state == 1) {
            strawberryPrice = 13 * 0.8;
        }
        double mangoPrice = 20;
        double all = apple + strawberry + mango;
        double totalPrice = 0;
        if (apple < 0 || strawberry <0 || mango < 0) {
            throw new RuntimeException("水果斤数应当为大于等于0的整数");
        } else if(all == 0) {
            return totalPrice;
        } else {
            if (Math.round(all) == all) {
                totalPrice = applePrice * apple + strawberryPrice * strawberry + mangoPrice * mango;
                if (status == 1) {
                    if (totalPrice >= 100) {
                        double floor = Math.floor(totalPrice);
                        return totalPrice - Math.floor(floor / 100) * 10;
                    }
                }
                return totalPrice;
            } else {
                throw new RuntimeException("水果斤数应当为大于等于0的整数");
            }
        }
    }
}
