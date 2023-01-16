package org.example;

import java.util.Map;

public class Solution {
    // Tạo một map hằng số không thể thay đổi
    public static final Map<Character, Integer> ROMAN_NUMBERS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    // Tạo method tính tổng các thành phần số la mã sau chuyển đổi  sang số latin
    public int romanToInt(String s) {
        int sum = 0, i;

        for (i = 0; i < s.length() - 1; i++) {
            sum += checkNextChar(s.charAt(i), s.charAt(i + 1));
        }
        sum += Solution.ROMAN_NUMBERS.get(s.charAt(i)); // for loop bên trên sẽ bị sót giá trị cuối cùng nếu
        // nếu method được gọi ra return else statement
        return sum ;
    }
    // method tạo cấu trúc số âm khi phối hợp 1 sô la mã có giá trị 1/10 hoặc 1/5 giá trị số ngay sau nó
    // Nếu không có phối hợp trên return ra giá trị chính nó trên Static Final Map bên trên
    private int checkNextChar(Character currentRomanLetter, Character nextRomanLetter) {
        if (currentRomanLetter == 'I' && (nextRomanLetter == 'V' || nextRomanLetter == 'X')) {
            return -1;
        } else if (currentRomanLetter == 'X' && (nextRomanLetter == 'L' || nextRomanLetter == 'C')) {
            return -10;
        } else if (currentRomanLetter == 'C' && (nextRomanLetter == 'D' || nextRomanLetter == 'M')) {
            return -100;
        } else {
            return Solution.ROMAN_NUMBERS.get(currentRomanLetter);
        }
    }
}
