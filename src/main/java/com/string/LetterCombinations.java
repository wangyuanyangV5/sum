package com.string;

import java.util.*;


/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        Map<Character,List<String>> numMap = new HashMap<>();
        numMap.put('2', Arrays.asList("a","b","c"));
        numMap.put('3',Arrays.asList("d","e","f"));
        numMap.put('4',Arrays.asList("g","h","i"));
        numMap.put('5',Arrays.asList("j","k","l"));
        numMap.put('6',Arrays.asList("m","n","o"));
        numMap.put('7',Arrays.asList("p","q","r","s"));
        numMap.put('8',Arrays.asList("t","u","v"));
        numMap.put('9',Arrays.asList("w","x","y","z"));

        List<StringBuilder> builders = null;

        char[] nums = digits.toCharArray();

        for(int i = 0;i < nums.length;i++){
            List<String> chars = numMap.get(nums[i]);
            List<StringBuilder> stringBuilders = new ArrayList<>();
            if(builders == null){
                for(String c : chars){
                    StringBuilder newBuilder = new StringBuilder();
                    newBuilder.append(c);
                    stringBuilders.add(newBuilder);
                }
            }else {
                for(StringBuilder builder : builders){
                   for(String c : chars){
                        String build = builder.toString();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(build);
                        stringBuilder.append(c);
                        stringBuilders.add(stringBuilder);
                    }
                }
            }



            builders = stringBuilders;
        }

        List<String> result = new ArrayList<>();
        if(builders == null){
            return result;
        }
        for(StringBuilder builder : builders){
             result.add(builder.toString());
        }

        return result;
    }

    public List<String> staticLetterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
