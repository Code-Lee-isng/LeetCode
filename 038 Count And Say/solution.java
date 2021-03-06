# 思路

1. 最原始，最笨的方法，就是三层for循环，但是太垃圾了了。
2. 对于String的加减，直接使用+来进行，太low了。


//n层for循环

public static String countAndSay(int n) {

  StringBuilder ini = new StringBuilder("1");

  StringBuilder results = ini;

  for(int k = 1; k < n; k++){
      int i, j, count;
      StringBuilder temp = new StringBuilder();
      for(i = 0; i < ini.length(); i = j){
          count = 1;
          for(j = i+1; j<ini.length(); j++, count++){
              if(ini.charAt(j) != ini.charAt(i)){
                  break;
              }
          }
          temp.append(count).append(ini.charAt(i));
          results = temp;
      }

      ini = results;
  }
  return results.toString();
}



//添加StringBuilder，同时套用recursion

套用递归，每一层都会用到下一层所得到的结果。
递归最重要的是，递归结束的条件。

class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        StringBuilder ini = new StringBuilder(countAndSay(n-1));
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i = 1; i < ini.length(); i++){
            if(ini.charAt(i) == ini.charAt(i-1)){
                count++;
                continue;
            }else{
                result.append(count).append(ini.charAt(i-1));
                count = 1;
            }
        }
        result.append(count).append(ini.charAt(ini.length() - 1));
        return result.toString();
    }
}
