import java.util.*;
public class Main
{
    static int ans(String str,int n){
        char c = ' ';
        int a = 0;
        int ans = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='1'||str.charAt(i)=='0'){
                c = str.charAt(i);
                a=Character.getNumericValue(c);
                if(count<1){
                    if(a==1||a==0){
                        ans = 1^a;
                        count++;
                    }
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    int n=str.length();
	    System.out.println(ans(str,n));
	}
}