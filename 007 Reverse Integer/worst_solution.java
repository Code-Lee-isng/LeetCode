//using String, StringBuilder, Long
//complicated, many things to aware,

public static int reverse(int x) {
            long temp;
            if(x >= 0){
                temp = Long.valueOf(x);
            }else{
                temp = Long.valueOf(x) * -1; //
            }

            String str = String.valueOf(temp);

            StringBuilder sb = new StringBuilder();
            for(int i = str.length() - 1; i >= 0; i--){
                sb.append(str.charAt(i));
            }
            if(Long.valueOf(sb.toString()) > Long.valueOf(Integer.MAX_VALUE) ||
                    (Long.valueOf(sb.toString()) * -1) < Long.valueOf(Integer.MIN_VALUE)){
                return 0;
            }else if(x >= 0){
                return Integer.valueOf(sb.toString());
            }else{
                return -Integer.valueOf(sb.toString());
            }
}