package api.test.Learning;

import java.util.HashMap;
import java.util.Map;

public class Testt {
    public static void main(String[] args){
        String a = "vedant";
        String b =  "vedant";
        char[] a_arr = a.toCharArray();
        int a_size= a_arr.length;
        char[] b_arr = b.toCharArray();
        int b_size= b_arr.length;
        Map<Character, Integer> char_count = new HashMap<>();
        Map<Character, Integer> subchar_count = new HashMap<>();
        int count =0;
        for(int i=0;i<a_size;i++){
            for(int j=0;j<a_size;j++){
                if(a_arr[i]==a_arr[j]){
                    count++;
                }
            }
            char_count.put(a_arr[i],count);
            count =0;
        }

        for(int k=0;k<b_size;k++){
            for(int l=0;l<b_size;l++){
                if(b_arr[k]==b_arr[l]){
                    count++;
                }
            }
            subchar_count.put(b_arr[k],count);
            count =0;
        }

        boolean flag = false;
        for(int n=0;n<subchar_count.size();n++){
            if(subchar_count.get(b_arr[n]).equals(char_count.get(b_arr[n]))){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        if(flag== true){
            System.out.println("String is anagram");
        }
        else{
            System.out.println("String is not anagram");
        }

    }
    
}
