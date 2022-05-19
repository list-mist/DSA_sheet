class Solution {
    public String intToRoman(int num) {
        String res = "";
        if(num >= 1000){
            while(num >= 1000){
                num -= 1000;
                res += "M";
            }
        }
        if(num >= 900){
            num -= 900;
            res += "CM";
        }
        if(num >= 500 && num < 1000){
            while(num >= 500){
                num -= 500;
                res += "D";
            }
        }
        if(num >= 400){
            num -= 400;
            res += "CD";
        }
        if(num >= 100 && num < 500){
            while(num >= 100){
                num -= 100;
                res += "C";
            }
        }
        if(num >= 90){
            num -= 90;
            res += "XC";
        }
        if(num >= 50 && num < 100){
            while(num >= 50){
                num -= 50;
                res += "L";
            }
        }
        if(num >= 40){
            num -= 40;
            res += "XL";
        }
        if(num >= 10 && num < 50){
            while(num >= 10){
                num -= 10;
                res += "X";
            }
        }
        if(num >= 9){
            num -= 9;
            res += "IX";
        }
        if(num >= 5 && num < 10){
            while(num >= 5){
                num -= 5;
                res += "V";
            }
        }
        if(num >= 4){
            num -= 4;
            res += "IV";
        }
        if(num >= 1 && num < 5){
            while(num >= 1){
                num -= 1;
                res += "I";
            }
        }
        return res;
    }
}
