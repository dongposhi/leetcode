public class Solution{

    /*
     I  : 1
     V  : 5
     X  : 10
     L  : 50
     C  : 100
     D  : 500
     M  : 1000
    */

    public static int romainToInt(String s){
        int n = 0;
        byte[] buf = s.getBytes();
        
        byte last = 0;
        byte cur  = 0;
        int count = 0;
        for(int i = 0;i<buf.length;i++){
            cur = buf[i];
            if(cur == 'I' || cur == 'X' || cur == 'C'){
                count++;
            }

            if( cur == 'V'){
                n = n + ((cur == 'V')?5:10);
                if(last == 'I'){
                    n = n - 1;
                    count = 0;
                }                 
            }

            if ( cur == 'L'){
                n = n + ((cur == 'L')?50:100);
                if(last == 'X'){
                    n = n -10;
                    count = 0;
                }                      
            }


            if(cur == 'D' || cur == 'M'){
                n = n + ((cur == 'D')?500:1000);
                if(last == 'C'){
                    n = n - 100;
                    count = 0;
                }                                  
            }

            last = cur;
        }
        if(last == 'I'){
            n = n + count *1;
            count = 0;
        }
        else if (last == 'X'){
            n = n + count * 10;
            count = 0;
        }
        else if(last == 'C'){
            n = n + count * 100;
            count = 0;
        }

        return n;
    }
    
    public static void main(String[] args){
        System.out.println(romainToInt(args[0]));
    }
}
