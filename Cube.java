import java.util.*;
class Cube{
    static int cube(int [] arr,int n){
        int a = 0;
        int ans =0;
        int count=0;
        int p =0;
        int b =0 ;
        for(int i=0;i<n;i++){
            p = arr[i];
            for(int j=1;j<p;j++){
                for(int z=1;z<p;z++){
                    ans = cubing(j)+cubing(z);
                    if(ans==p&&j!=b){
                        count++;
                        b=z;
                    }
                }
            }
        }
        return count;
    }
    static int cubing(int a){
        int ans =1;
        int b=3;
        while(b!=0){
            ans = ans * a;
            b--;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int [] arr = new int[v];
        for(int i=0;i<v;i++){
            arr[i] = sc.nextInt();
        }
        int n = arr.length;
        System.out.println(cube(arr,n));
    }
}