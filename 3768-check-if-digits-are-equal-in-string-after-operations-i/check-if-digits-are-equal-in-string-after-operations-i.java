class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() != 2){
            String str = "";
            for(int i=1;i<s.length();i++){
                int sum = (s.charAt(i-1)-'0')+(s.charAt(i)-'0');
                int mod = sum%10;
                str += (mod+"");
            }
            s = new String(str);
        }
        if(s.charAt(0) == s.charAt(1)) return true;
        return false;
    }
}