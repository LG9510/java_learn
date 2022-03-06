package com.baeldung.numberofdigits;

public class NumberOfDigits {
    /**
     * 这可能是一种次优解,因为此语句涉及为每个评估分配字符串内存
     * jvm必须解析我们的数字并将数字复制到单独的字符串中,并执行其它不同的操作(例如临时保存副本,处理Unicode转换等)
     *
     * @param number 数字
     * @return 返回数字的长度
     */
    public int stringBasedSolution(int number) {
        return String.valueOf(number).length();
    }

    /**
     * Math.log10()所选值返回以10为底的对数
     *
     * @param number 數字
     * @return integer长度
     */
    public int logarithmicApproach(int number) {
        return (int) Math.log10(number) + 1;
    }

    /**
     * 在此方法中，我们将采用一个临时变量（初始化为 1）并连续将其乘以 10，直到它大于我们的数字。
     * 在此过程中，我们还将使用长度变量，该变量将跟踪数字的长度
     *
     * @param number
     * @return
     */
    public int repeatedMultiplication(int number) {
        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
        }
        return length;
    }

    public int shiftOperators(int number) {
        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp = (temp << 3) + (temp << 1);
        }
        return length;
    }

    public int dividingWithPowersOf2(int number) {
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 100;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number > 10) {
            length += 1;
        }
        return length;
    }

    /**
     * 暴力解法,理论上最快,需要提前知道最大位数
     *
     * @param number
     * @return
     */
    public int divideAndConquer(int number) {
        if (number < 1000000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            // 6 digits or more
            if (number < 10000000) {
                // 6 or 7 digits
                if (number < 1000000)
                    return 6;
                else
                    return 7;
            } else {
                // 8 to 10 digits
                if (number < 100000000)
                    return 8;
                else {
                    // 9 or 10 digits
                    if (number < 1000000000)
                        return 9;
                    else
                        return 10;
                }
            }
        }
    }


























}
