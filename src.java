/*
MANG
xep hang
import java.util.*;

class Pair implements Comparable<Pair> {
    public Integer first;
    public Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first != o.first)
            return this.first.compareTo(o.first);
        return this.second.compareTo(o.second);
    }

    @Override
    public String toString() {
        return String.format("%d %d", this.first, this.second);
    }
}

public class J02009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; ++i)
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        Arrays.sort(a);
        int ans=0;
        for(Pair x:a)
            if (x.first<=ans) ans+=x.second;
            else ans=x.first+x.second;
        System.out.println(ans);
        sc.close();
    }
}
bo 3 so pytago
import java.util.*;

public class J02016 {
    public static boolean res(int n,long[] a){
        for(int i=1;i<n-1;++i){
            int l=0;
            int r=n-1;
            while(l<r){
                if (a[l]+a[r]<a[i]) l++;
                else if (a[l]+a[r]>a[i]) r--;
                else return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a=new long[n];
            for(int i=0;i<n;++i){
                long x=sc.nextLong();
                a[i]=x*x;
            }
            Arrays.sort(a);
            System.out.println(res(n,a)?"YES":"NO");
        }
        sc.close();
    }
}
lua chon tham lam 
import java.util.*;

public class J02023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        if (n==1&&s==0) System.out.println("0 0");
        else if (9*n<s||s==0) System.out.println("-1 -1");
        else{
            int s1=s;
            int[] a=new int[n];
            for(int i=n-1;i>=0;--i){
                for(int j=9;j>=0;--j)
                    if (s1-j>=0){
                        a[i]=j;
                        s1-=j;
                        break;
                    }
                if (a[i]==0) break;
            }
            if (a[0]==0){
                a[0]=1;
                for(int i=1;i<n;++i)
                    if (a[i]>0){
                        a[i]--;
                        break;
                    }
            }
            for(int i=0;i<n;++i){
                System.out.print(a[i]);
                a[i]=0;
            }
            System.out.print(" ");
            s1=s;
            for(int i=0;i<n;++i){
                for(int j=9;j>=0;--j)
                    if (s1-j>=0){
                        a[i]=j;
                        s1-=j;
                        break;
                    }
                if (a[i]==0) break;
            }
            for(int i=0;i<n;++i) System.out.print(a[i]);
        }
        sc.close();
    }
}
day con co tong le
import java.util.*;

public class J02024 {
    public static void Try(int i,int[] a,int sum,String s){
        if (sum%2==1) System.out.println(s);
        for(int j=0;j<i;++j) Try(j,a,sum+a[j],s+a[j]+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Arrays.sort(a);
            Try(n,a,0,"");
        }
        sc.close();
    }
}
day con co tong nguyen to
import java.util.*;

public class J02025 {
    public static boolean nto(int n){
        for(int i=2;i*i<=n;++i)
            if (n%i==0) return false;
        return n>1;
    }

    public static void Try(int i,int[] a,int sum,String s){
        if (nto(sum)) System.out.println(s);
        for(int j=0;j<i;++j) Try(j,a,sum+a[j],s+a[j]+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Arrays.sort(a);
            Try(n,a,0,"");
        }
        sc.close();
    }
}
day con co k phan tu tang dan
import java.util.*;

public class J02025 {
    public static boolean nto(int n){
        for(int i=2;i*i<=n;++i)
            if (n%i==0) return false;
        return n>1;
    }

    public static void Try(int i,int[] a,int sum,String s){
        if (nto(sum)) System.out.println(s);
        for(int j=0;j<i;++j) Try(j,a,sum+a[j],s+a[j]+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Arrays.sort(a);
            Try(n,a,0,"");
        }
        sc.close();
    }
}
khoang cach nho hon k 
import java.util.*;

public class J02027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Arrays.sort(a);
            int l=0;
            long ans=0;
            for(int i=1;i<n;++i){
                while(l<i&&a[l]+k<=a[i]) l++;
                ans+=(i-l);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
day con lien tiep tong bang k
import java.util.*;

public class J02028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            long[] a=new long[n];
            for(int i=0;i<n;++i) a[i]=sc.nextLong();
            long s=0;
            int l=0;
            boolean kt=false;
            for(int i=0;i<n;++i){
                s+=a[i];
                while(s>k&&l<i) s-=a[l++];
                if (s==k){
                    kt=true;
                    break;
                }
            }
            System.out.println(kt?"YES":"NO");
        }
        sc.close();
    }
}
quay phai 
import java.util.*;

public class J02035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a=new long[n];
            for(int i=0;i<n;++i) a[i]=sc.nextLong();
            int cnt=1;
            for(int i=0;i<n-1;++i)
                if (a[i]<a[i+1]) cnt++;
                else break;
            System.out.println(cnt==n?0:cnt);
        }
        sc.close();
    }
}
uoc so chung lon nhat 
import java.util.*;

public class J02036 {
    public static int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            int[] b=new int[n+1];
            b[0]=a[0];
            for(int i=1;i<n;++i) b[i]=lcm(a[i],a[i-1]);
            b[n]=a[n-1];
            for(int i=0;i<=n;++i) System.out.printf("%d ",b[i]);
            System.out.println();
        }
        sc.close();
    }
}
ma tran xoan oc tang dan
import java.util.*;

public class J02102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n*n];
        for(int i=0;i<n*n;++i) a[i]=sc.nextInt();
        Arrays.sort(a);
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int x=1;
        int y=1;
        int dir=0;
        int[][] b=new int[n+2][n+2];
        for(int i=0;i<=n+1;++i){
            b[0][i]=-1;
            b[n+1][i]=-1;
            b[i][0]=-1;
            b[i][n+1]=-1;
        }
        for(int i=0;i<n*n;++i){
            b[x][y]=a[i];
            x+=dx[dir];
            y+=dy[dir];
            if (b[x][y]!=0){
                x-=dx[dir];
                y-=dy[dir];
                dir=(dir+1)%4;
                x+=dx[dir];
                y+=dy[dir];
            }
        }
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j) System.out.printf("%d ",b[i][j]);
            System.out.println();
        }
        sc.close();
    }
}
tong uoc so - 2
import java.util.*;

public class J02019 {
    public static final int N=(int)1e6+5;
    public static int[] a=new int[N];

    public static void sieve(){
        for(int i=1;i<=N-5;++i)
            for(int j=i*2;j<=N-5;j+=i) a[j]+=i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sieve();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int ans=0;
        for(int i=l;i<=r;++i)
            if (a[i]>i) ans++;
        System.out.println(ans);
        sc.close();
    }
}
dao dau
import java.util.*;

public class J02033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        boolean kt=false;
        long s=0;
        for(int i=0;i<n;++i){
            int x=sc.nextInt();
            s+=x;
            if (x>0) a.add(x);
            else if (x<0) b.add(x);
            else kt=true;
        }
        Collections.sort(a);
        Collections.sort(b);
        for(int i=0;i<b.size()&&k>0;++i,--k) s+=(-b.get(i))*2;
        if (k%2==1&&!kt){
            if (a.isEmpty()){
                if (!b.isEmpty()) s-=Math.abs(b.get(b.size()-1))*2;
            }
            else if (b.isEmpty()) s-=a.get(0)*2;
            else s-=Math.min(a.get(0),Math.abs(b.get(b.size()-1)))*2;
        }
        System.out.println(s);
        sc.close();
    }
}
XAU KI TU
day uu the
import java.util.*;

public class J02037 {
    public static boolean res(String[] a){
        int odd=0;
        int even=0;
        for(String x:a)
            if ((x.charAt(x.length()-1)-'0')%2==1) odd++;
            else even++;
        return ((a.length&1)+(odd>even?1:0))%2==0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] a=sc.nextLine().split("\\s+");
            System.out.println(res(a)?"YES":"NO");
        }
        sc.close();
    }
}
tong so nguyen lon - 1
import java.math.BigInteger;
import java.util.*;

public class J03012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            BigInteger a=new BigInteger(sc.next());
            BigInteger b=new BigInteger(sc.next());
            System.out.println(a.add(b));
        }
        sc.close();
    }
}
tong so nguyen lon - 2
import java.math.BigInteger;
import java.util.*;

public class J03014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a=new BigInteger(sc.next());
        BigInteger b=new BigInteger(sc.next());
        System.out.println(a.add(b));
        sc.close();
    }
}
chia het cho 11
import java.math.BigInteger;
import java.util.*;

public class J03016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        BigInteger b=new BigInteger("11");
        BigInteger c=new BigInteger("0");
        while(t-->0){
            BigInteger a=new BigInteger(sc.next());
            System.out.println(a.mod(b).equals(c)?1:0);
        }
        sc.close();
    }
}
xau con lon nhat
import java.util.*;

public class J03019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        String ans="";
        int i=0;
        while (i<s.length()){
            char a=s.charAt(i);
            int b=i;
            for(int j=i+1;j<s.length();++j)
                if (a<s.charAt(j)){
                    a=s.charAt(j);
                    b=j;
                }
            for(int j=i;j<s.length();++j)
                if (a==s.charAt(j)){
                    ans+=a;
                    b=j;
                }
            i=b+1;
        }
        System.out.println(ans);
        sc.close();
    }
}
tim tu thuan nghich dai nhat
import java.util.*;

public class J03020 {
    public static boolean res(String s){
        for(int i=0;i<s.length()/2;++i)
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> a=new LinkedHashMap<>();
        while(sc.hasNextLine()){
            String[] b=sc.nextLine().split("\\s+");
            for(String x:b)
                if (res(x)){
                    if (a.containsKey(x)) a.put(x,a.get(x)+1);
                    else a.put(x,1);
                }
            }
        int cnt=0;
        for(String x:a.keySet()) cnt=Math.max(cnt,x.length());
        for(String x:a.keySet())
            if (cnt==x.length()) System.out.printf("%s %d\n",x,a.get(x));
        sc.close();
    }
}
xu li van ban
import java.util.*;

public class J03022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> a=new ArrayList<>();
        while(sc.hasNext()){
            a.add(sc.next().toLowerCase());
        }
        boolean kt=true;
        for(int i=0;i<a.size();++i){
            char x=a.get(i).charAt(a.get(i).length()-1);
            if (x=='.'||x=='?'||x=='!'){
                if (a.get(i).length()>1){
                    if (kt) System.out.printf("%s ",a.get(i).substring(0,1).toUpperCase()+a.get(i).substring(1,a.get(i).length()-1));
                    else System.out.printf("%s ",a.get(i).substring(0,a.get(i).length()-1));
                }
                kt=true;
                System.out.println();
            }
            else{
                if (kt) System.out.printf("%s ",a.get(i).substring(0,1).toUpperCase()+a.get(i).substring(1));
                else System.out.printf("%s ",a.get(i));
                kt=false;
            }
        }
        sc.close();
    }
}
so la ma
import java.util.*;

public class J03023 {
    public static int get(char x){
        if (x=='I') return 1;
        if (x=='V') return 5;
        if (x=='X') return 10;
        if (x=='L') return 50;
        if (x=='C') return 100;
        if (x=='D') return 500;
        return 1000;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int ans=0;
            for(int i=0;i<s.length();++i){
                if (i<s.length()-1){
                    char a=s.charAt(i);
                    char b=s.charAt(i+1);
                    i++;
                    if (a=='I'&&b=='V') ans+=4;
                    else if (a=='I'&&b=='X') ans+=9;
                    else if (a=='X'&&b=='L') ans+=40;
                    else if (a=='X'&&b=='C') ans+=90;
                    else if (a=='C'&&b=='D') ans+=400;
                    else if (a=='C'&&b=='M') ans+=900;
                    else{
                        ans+=get(a);
                        i--;
                    }
                }
                else ans+=get(s.charAt(i));
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
ma hoa drm
import java.util.*;

public class J03028 {
    public static int getInt(char x){
        return x-'A';
    }

    public static char getChar(int x){
        return (char)(x+'A');
    }

    public static String rotate(String s){
        int cnt=0;
        for(int i=0;i<s.length();++i) cnt+=getInt(s.charAt(i));
        String ans="";
        for(int i=0;i<s.length();++i) ans+=getChar((getInt(s.charAt(i))+cnt)%26);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String a=rotate(s.substring(0,s.length()/2));
            String b=rotate(s.substring(s.length()/2));
            String ans="";
            for(int i=0;i<a.length();++i) ans+=getChar((getInt(a.charAt(i))+getInt(b.charAt(i)))%26);
            System.out.println(ans);
        }
        sc.close();
    }
}
xau day du
import java.util.*;

public class J03031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int k=sc.nextInt();
            int[] a=new int[26];
            for(int i=0;i<s.length();++i) a[s.charAt(i)-'a']++;
            int cnt1=0;
            int cnt2=0;
            for(int i=0;i<26;++i)
                if (a[i]>1) cnt1+=(a[i]-1);
                else if (a[i]==0) cnt2++;
            System.out.println(cnt1>=cnt2&&cnt2<=k?"YES":"NO");
        }
        sc.close();
    }
}
vong tron 
import java.util.*;

public class J03037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int[] a=new int[26];
        Arrays.fill(a,-1);
        int[] b=new int[26];
        for(int i=0;i<s.length();++i)
            if (a[s.charAt(i)-'A']==-1) a[s.charAt(i)-'A']=i;
            else b[s.charAt(i)-'A']=i;
        int ans=0;
        for(int i=0;i<26;++i)
            for(int j=0;j<26;++j)
                if (a[i]<a[j]&&a[j]<b[i]&&b[i]<b[j]) ans++;
        System.out.println(ans);
        sc.close();
    }
}
day du cac chu so
import java.util.*;

public class J01020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            if (n==0){
                System.out.println("Impossible");
                continue;
            }
            int i=1;
            boolean[] a=new boolean[10];
            while(true){
                long m=n*i;
                while(m>0){
                    a[(int)m%10]=true;
                    m/=10;
                }
                boolean kt=true;
                for(int j=0;j<10;++j)
                    if (!a[j]){
                        kt=false;
                        break;
                    }
                if (kt) break;
                i++;
            }
            System.out.println(n*i);
        }
        sc.close();
    }
}
loai bo 100
import java.util.*;

class Pair{
    public char first;
    public int second;

    public Pair(char first,int second){
        this.first=first;
        this.second=second;
    }
}

public class J03017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int ans=0;
            ArrayList<Pair> a=new ArrayList<>();
            int end=0;
            int cnt=0;
            for(int i=0;i<s.length();++i){
                a.add(new Pair(s.charAt(i),i));
                if (a.size()>=3){
                    String tmp="";
                    for(int j=a.size()-3;j<a.size();++j) tmp+=a.get(j).first;
                    if (tmp.equals("100")){
                        if (end+1!=a.get(a.size()-3).second) cnt=0;
                        cnt+=a.get(a.size()-1).second-a.get(a.size()-3).second+1;
                        end=a.get(a.size()-1).second;
                        ans=Math.max(ans,cnt);
                        for(int j=0;j<3;++j) a.remove(a.size()-1);
                    }
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
tim so du
import java.util.*;

public class J03018 {
    public static int[] a={1,2,4,3};
    public static int[] b={1,3,4,2};
    public static int[] c={1,4};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int n;
            if (s.length()<=2) n=Integer.parseInt(s);
            else n=Integer.parseInt(s.substring(s.length()-2));
            System.out.println((1+a[n%4]+b[n%4]+c[n%2])%5);
        }
        sc.close();
    }
}
chuan hoa cau
import java.util.*;

public class J03029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] a=sc.nextLine().toLowerCase().split("\\s+");
            String b="";
            for(int i=0;i<a.length;++i){
                if (a[i].equals(".")||a[i].equals("!")||a[i].equals("?")){
                    b=b.substring(0,b.length()-1)+a[i];
                    System.out.println(b);
                    b="";
                }
                else{
                    if (b.isEmpty()) a[i]=a[i].substring(0,1).toUpperCase()+a[i].substring(1);
                    b+=(a[i]+" ");
                    char x=a[i].charAt(a[i].length()-1);
                    if (x=='.'||x=='!'||x=='?'){
                        System.out.println(b);
                        b="";
                    }
                }
            }
            if (!b.isEmpty()) System.out.println(b.substring(0,b.length()-1)+".");
        }
        sc.close();
    }
}
xoay vong ki tu
import java.util.*;

public class J03036 {
    public static String rotate(String s){
        return s.substring(1)+s.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;++i) a[i]=sc.next();
        int m=a[0].length();
        int ans=(int)1e9;
        for(int i=0;i<n;++i){
            int cnt1=0;
            for(int j=0;j<n;++j){
                String tmp=a[j];
                int cnt2=0;
                while(!tmp.equals(a[i])&&cnt2<m){
                    tmp=rotate(tmp);
                    cnt2++;
                }
                if (!tmp.equals(a[i])){
                    ans=-1;
                    break;
                }
                cnt1+=cnt2;
            }
            if (ans==-1) break;
            ans=Math.min(ans,cnt1);
        }
        System.out.println(ans);
        sc.close();
    }
}
bien doi a-b
import java.util.*;

public class J03030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        s=" "+s;
        int[] a=new int[n+1];
        int[] b=new int[n+1];
        for(int i=1;i<=n;++i)
            if (s.charAt(i)=='A'){
                a[i]=Math.min(a[i-1],b[i-1]+1);
                b[i]=Math.min(b[i-1],a[i-1])+1;
            }
            else{
                a[i]=Math.min(a[i-1],b[i-1])+1;
                b[i]=Math.min(b[i-1],a[i-1]+1);
            }
        System.out.println(a[n]);
        sc.close();
    }
}
VAO RA FILE
hop va giao cua 2 file van ban
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> set;

    public WordSet(String file) throws IOException {
        set = new TreeSet<>();
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) set.add(sc.next().toLowerCase());
    }

    public WordSet(TreeSet<String> set) {
        this.set = set;
    }

    public WordSet union(WordSet o) {
        TreeSet<String> tmp = new TreeSet<>();
        tmp.addAll(set);
        tmp.addAll(o.set);
        return new WordSet(tmp);
    }

    public WordSet intersection(WordSet o) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String x : set)
            if (o.set.contains(x)) tmp.add(x);
        return new WordSet(tmp);
    }

    @Override
    public String toString() {
        String s = "";
        for (String x : set) s += (x + " ");
        return s;
    }
}

public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
so nguyen to trong 2 file nhi phan
import java.io.*;
import java.util.*;

public class J07016 {
    public static int[] b = new int[10000];

    public static void sieve() {
        Arrays.fill(b, 1);
        b[0] = b[1] = 0;
        for (int i = 2; i <= 100; i++)
            if (b[i] == 1)
                for (int j = i * i; j < 10000; j += i)
                    b[j] = 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ot1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ot2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> a1 = (List<Integer>) ot1.readObject();
        List<Integer> a2 = (List<Integer>) ot2.readObject();
        int[] c = new int[10000];
        for (Integer i : a1)
            c[i] += b[i];
        int[] d = new int[10000];
        for (Integer i : a2)
            d[i] += b[i];
        for (int i = 2; i < 10000; i++)
            if (c[i] > 0 && d[i] > 0)
                System.out.println(i + " " + c[i] + " " + d[i]);
        ot1.close();
        ot2.close();
    }
}
chuan hoa danh sach sinh vien
import java.io.File;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class SinhVien {
    private static int ID = 0;
    private static final String KEY = "B20DCCN";
    private String id;
    private String name;
    private String grade;
    private String dob;
    private float gpa;

    public SinhVien(String name, String grade, String dob, float gpa) {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.grade = grade;
        String[] tmpDob = dob.split("/");
        this.dob = String.format("%02d/%02d/%d", Integer.parseInt(tmpDob[0]), Integer.parseInt(tmpDob[1]), Integer.parseInt(tmpDob[2]));
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, name, grade, dob, gpa);
    }
}

public class J07018 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SINHVIEN.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.next(), sc.next(), sc.nextFloat()));
        }
        for (SinhVien x : a) System.out.println(x);
    }
}
nguyen to va thuan nghich
import java.io.*;
import java.util.*;

public class J07023 {
    public static int[] b = new int[10000];

    public static void sieve() {
        Arrays.fill(b, 1);
        b[0] = b[1] = 0;
        for (int i = 2; i <= 100; i++)
            if (b[i] == 1)
                for (int j = i * i; j < 10000; j += i)
                    b[j] = 0;
    }

    public static boolean palin(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < s.length() / 2; ++i)
            if (s.charAt(i) != s.charAt(s.length() - i -1)) return false;
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ot1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ot2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) ot1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) ot2.readObject();
        int[] c = new int[10000];
        for (Integer i : a1)
            if (palin(i)) c[i] += b[i];
        int[] d = new int[10000];
        for (Integer i : a2)
            if (palin(i)) d[i] += b[i];
        for (int i = 2; i < 10000; i++)
            if (c[i] > 0 && d[i] > 0)
                System.out.println(i + " " + c[i] + " " + d[i]);
        ot1.close();
        ot2.close();
    }
}
hieu cua 2 tap tu
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> set;

    public WordSet(String file) throws IOException {
        set = new TreeSet<>();
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) set.add(sc.next().toLowerCase());
    }

    public WordSet(TreeSet<String> set) {
        this.set = set;
    }

    public WordSet difference(WordSet o) {
        TreeSet<String> tmp = new TreeSet<>();
        tmp.addAll(set);
        for (String x : o.set) tmp.remove(x);
        return new WordSet(tmp);
    }

    @Override
    public String toString() {
        String s = "";
        for (String x : set) s += (x + " ");
        return s;
    }
}

public class J07024 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
danh sach khach hang trong file
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String gender;
    private Date dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) throws ParseException {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.gender = gender;
        String[] tmpDob = dob.split("/");
        dob = String.format("%02d/%02d/%d", Integer.parseInt(tmpDob[0]), Integer.parseInt(tmpDob[1]), Integer.parseInt(tmpDob[2]));
        this.dob = formatter.parse(dob);
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id, name, gender, address, formatter.format(dob));
    }

    @Override
    public int compareTo(KhachHang o) {
        return Long.compare(this.dob.getTime(), o.dob.getTime());
    }
}

public class J07025 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
    }
}
lich giang day theo mon hoc
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;
    private int credits;

    public MonHoc(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class HocPhan implements Comparable<HocPhan> {
    private static int ID = 0;
    private static final String KEY = "HP";
    private String id;
    private MonHoc monHoc;
    private int day;
    private int time;
    private String teacherName;
    private String room;

    public HocPhan(int day, int time, String teacherName, String room) {
        this.id = String.format("%s%03d", KEY, ++ID);
        this.day = day;
        this.time = time;
        this.teacherName = teacherName;
        this.room = room;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    @Override
    public int compareTo(HocPhan o) {
        if (day != o.day) return Integer.compare(day, o.day);
        if (time != o.time) return Integer.compare(time, o.time);
        return teacherName.compareTo(o.teacherName);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %s %s", id, day, time, teacherName, room);
    }
}

public class J07074 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        int n = sc1.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            int credits = sc1.nextInt();
            a.add(new MonHoc(id, name, credits));
        }
        int m = sc2.nextInt();
        ArrayList<HocPhan> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String monHocId = sc2.next();
            int day = sc2.nextInt();
            int time = sc2.nextInt();
            sc2.nextLine();
            String teacherName = sc2.nextLine();
            String room = sc2.next();
            HocPhan c = new HocPhan(day, time, teacherName, room);
            for (MonHoc x : a)
                if (x.getId().equals(monHocId)) {
                    c.setMonHoc(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        String id = sc2.next();
        String name = "";
        for (MonHoc x : a)
            if (x.getId().equals(id)) {
                name = x.getName();
                break;
            }
        System.out.printf("LICH GIANG DAY MON %s:\n", name);
        for (HocPhan x : b)
            if (x.getMonHoc().getId().equals(id)) System.out.println(x);
        sc1.close();
        sc2.close();
    }
}
lich giang day theo giang vien
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;
    private int credits;

    public MonHoc(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class HocPhan implements Comparable<HocPhan> {
    private static int ID = 0;
    private static final String KEY = "HP";
    private String id;
    private MonHoc monHoc;
    private int day;
    private int time;
    private String teacherName;
    private String room;

    public HocPhan(int day, int time, String teacherName, String room) {
        this.id = String.format("%s%03d", KEY, ++ID);
        this.day = day;
        this.time = time;
        this.teacherName = teacherName;
        this.room = room;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public int compareTo(HocPhan o) {
        if (day != o.day) return Integer.compare(day, o.day);
        if (time != o.time) return Integer.compare(time, o.time);
        return teacherName.compareTo(o.teacherName);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", id, monHoc.getName(), day, time, room);
    }
}

public class J07075 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        int n = sc1.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            int credits = sc1.nextInt();
            a.add(new MonHoc(id, name, credits));
        }
        int m = sc2.nextInt();
        ArrayList<HocPhan> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String monHocId = sc2.next();
            int day = sc2.nextInt();
            int time = sc2.nextInt();
            sc2.nextLine();
            String teacherName = sc2.nextLine();
            String room = sc2.next();
            HocPhan c = new HocPhan(day, time, teacherName, room);
            for (MonHoc x : a)
                if (x.getId().equals(monHocId)) {
                    c.setMonHoc(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        sc2.nextLine();
        String name = sc2.nextLine();
        System.out.printf("LICH GIANG DAY GIANG VIEN %s:\n", name);
        for (HocPhan x : b)
            if (x.getTeacherName().equals(name)) System.out.println(x);
        sc1.close();
        sc2.close();
    }
}
tim vi tri xau con 
import java.util.*;
import java.io.*;

public class J07078 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t=sc.nextInt();
        while(t-->0){
            String s1=sc.next();
            String s2=sc.next();
            int n1=s1.length();
            int n2=s2.length();
            for(int i=0;i<=n1-n2;++i) {
                int j=0;
                while(j<n2&&s1.charAt(i+j)==s2.charAt(j)) j++;
                if (j==n2) System.out.printf("%d ",i+1);
            }
            System.out.println();
        }
        sc.close();
    }
}
thong ke tu khac nhau trong file van ban
import java.io.File;
import java.util.*;

class Pair<X extends Comparable, Y extends Comparable> implements Comparable<Pair> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (!second.equals(o.second)) return -second.compareTo(o.second);
        return first.compareTo(o.first);
    }

    @Override
    public String toString() {
        return String.format("%s %s", first.toString(), second.toString());
    }
}

public class J07011 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        HashMap<String, Integer> b = new HashMap<>();
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] a = sc.nextLine().toLowerCase().split("[^a-z0-9]+");
            for (String x : a)
                if (!x.isEmpty()) b.put(x, b.getOrDefault(x, 0) + 1);
        }
        ArrayList<Pair<String, Integer>> c = new ArrayList<>();
        for (Map.Entry<String, Integer> x : b.entrySet()) c.add(new Pair<>(x.getKey(), x.getValue()));
        Collections.sort(c);
        for (Pair<String, Integer> x : c) System.out.println(x);
        sc.close();
    }
}
thong ke tu khac nhau trong file nhi phan
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

class Pair<X extends Comparable, Y extends Comparable> implements Comparable<Pair> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (!second.equals(o.second)) return -second.compareTo(o.second);
        return first.compareTo(o.first);
    }

    @Override
    public String toString() {
        return String.format("%s %s", first.toString(), second.toString());
    }
}

public class J07012 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ot = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) ot.readObject();
        HashMap<String, Integer> b = new HashMap<>();
        for (String x : a) {
            String[] tmp = x.toLowerCase().split("[^a-z0-9]+");
            for(String y : tmp)
                if (!y.isEmpty()) b.put(y, b.getOrDefault(y, 0) + 1);
        }
        ArrayList<Pair<String, Integer>> c = new ArrayList<>();
        for (Map.Entry<String, Integer> x : b.entrySet()) c.add(new Pair<>(x.getKey(), x.getValue()));
        Collections.sort(c);
        for (Pair<String, Integer> x : c) System.out.println(x);
        ot.close();
    }
}
hoa don-1
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    private String id;
    private String name;
    private int type1Price;
    private int type2Price;

    public SanPham(String id, String name, int type1Price, int type2Price) {
        this.id = id;
        this.name = name;
        this.type1Price = type1Price;
        this.type2Price = type2Price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType1Price() {
        return type1Price;
    }

    public int getType2Price() {
        return type2Price;
    }
}

class HoaDon {
    private static int ID = 0;
    private String id;
    private int amount;
    private SanPham sanPham;
    private int discount;
    private int finalPrice;

    public HoaDon(String id, int amount) {
        this.id = String.format("%s-%03d", id, ++ID);
        this.amount = amount;
        discount = 0;
    }

    public String getId() {
        return id;
    }

    public void setSanPham(SanPham sanPham, char type) {
        this.sanPham = sanPham;
        int unitPrice = 0;
        if (type == '1') unitPrice = sanPham.getType1Price();
        else unitPrice = sanPham.getType2Price();
        int price = unitPrice * amount;
        if (amount >= 150) discount = (int) (price * 0.5);
        else if (amount >= 100) discount = (int) (price * 0.3);
        else if (amount >= 50) discount = (int) (price * 0.15);
        finalPrice = price - discount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, sanPham.getName(), discount, finalPrice);
    }
}

public class J07019 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("DATA1.in"));
        Scanner sc2 = new Scanner(new File("DATA2.in"));
        int n = sc1.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            int type1Price = sc1.nextInt();
            int type2Price = sc1.nextInt();
            a.add(new SanPham(id, name, type1Price, type2Price));
        }
        int m = sc2.nextInt();
        ArrayList<HoaDon> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            HoaDon c = new HoaDon(sc2.next(), sc2.nextInt());
            for (SanPham x : a)
                if (x.getId().equals(c.getId().substring(0, 2))) {
                    c.setSanPham(x, c.getId().charAt(2));
                    break;
                }
            b.add(c);
        }
        for (HoaDon x : b) System.out.println(x);
        sc1.close();
        sc2.close();
    }
}
hoa don-2 
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class KhachHang {
    private static int ID = 0;
    private static final String KEY = "KH";
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

class MatHang {
    private static int ID = 0;
    private static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int buyPrice;
    private int sellPrice;

    public MatHang(String name, String unit, int buyPrice, int sellPrice) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}

class HoaDon {
    private static int ID = 0;
    private static final String KEY = "HD";
    private String id;
    private KhachHang khachHang;
    private MatHang matHang;
    private int amount;

    public HoaDon(int amount) {
        id = String.format("%s%03d", KEY, ++ID);
        this.amount = amount;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d %d %d %d", id, khachHang.getName(), khachHang.getAddress(), matHang.getName(), matHang.getUnit(), matHang.getBuyPrice(), matHang.getSellPrice(), amount, amount * matHang.getSellPrice());
    }
}

public class J07020 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("KH.in"));
        Scanner sc2 = new Scanner(new File("MH.in"));
        Scanner sc3 = new Scanner(new File("HD.in"));
        int n = sc1.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        sc1.nextLine();
        for (int i = 0; i < n; ++i) {
            String name = sc1.nextLine();
            String gender = sc1.next();
            String dob = sc1.next();
            sc1.nextLine();
            String address = sc1.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        int m = sc2.nextInt();
        ArrayList<MatHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc2.nextLine();
            b.add(new MatHang(sc2.nextLine(), sc2.next(), sc2.nextInt(), sc2.nextInt()));
        }
        int k = sc3.nextInt();
        ArrayList<HoaDon> c = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            String khachHangId = sc3.next();
            String matHangId = sc3.next();
            int amount = sc3.nextInt();
            HoaDon d = new HoaDon(amount);
            for (KhachHang x : a)
                if (x.getId().equals(khachHangId)) {
                    d.setKhachHang(x);
                    break;
                }
            for (MatHang x : b)
                if (x.getId().equals(matHangId)) {
                    d.setMatHang(x);
                    break;
                }
            c.add(d);
        }
        for (HoaDon x : c) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
quan li bai tap nhom
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String phone;
    private Nhom nhom;

    public SinhVien(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setNhom(Nhom nhom) {
        this.nhom = nhom;
    }

    @Override
    public int compareTo(SinhVien o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", id, name, phone, nhom.getId(), nhom.getHomeWork());
    }
}

class Nhom {
    private int id;
    private String homeWork;

    public Nhom(int id, String homeWork) {
        this.id = id;
        this.homeWork = homeWork;
    }

    public int getId() {
        return id;
    }

    public String getHomeWork() {
        return homeWork;
    }
}

public class J07027 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("BAITAP.in"));
        Scanner sc3 = new Scanner(new File("NHOM.in"));
        int n = sc1.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String phone = sc1.next();
            a.add(new SinhVien(id, name, phone));
        }
        int m = sc2.nextInt();
        sc2.nextLine();
        ArrayList<Nhom> b = new ArrayList<>();
        for (int i = 1; i <= m; ++i) b.add(new Nhom(i, sc2.nextLine()));
        for (int i = 0; i < n; ++i) {
            String sinhVienId = sc3.next();
            int groupId = sc3.nextInt();
            for (SinhVien x : a)
                if (x.getId().equals(sinhVienId)) {
                    for (Nhom y : b)
                        if (y.getId() == groupId) {
                            x.setNhom(y);
                            break;
                        }
                    break;
                }
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
tinh gio chuan 
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;

    public MonHoc(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class GiangVien {
    private String id;
    private String name;
    private double numOfHours;

    public GiangVien(String id, String name) {
        this.id = id;
        this.name = name;
        numOfHours = 0;
    }

    public String getId() {
        return id;
    }

    public void addHour(double hour) {
        numOfHours += hour;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, numOfHours);
    }
}

public class J07028 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("GIANGVIEN.in"));
        Scanner sc3 = new Scanner(new File("GIOCHUAN.in")).useLocale(Locale.getDefault());
        int n = sc1.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new MonHoc(sc1.next(), sc1.nextLine().trim()));
        int m = sc2.nextInt();
        ArrayList<GiangVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new GiangVien(sc2.next(), sc2.nextLine().trim()));
        int k = sc3.nextInt();
        while (k-- > 0) {
            String giaoVienId = sc3.next();
            String monHocId = sc3.next();
            double hour = sc3.nextDouble();
            for (GiangVien x : b)
                if (x.getId().equals(giaoVienId)) {
                    x.addHour(hour);
                    break;
                }
        }
        for (GiangVien x : b) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
bang diem theo mon hoc
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;
    private int numOfCredits;

    public MonHoc(String id, String name, int numOfCredits) {
        this.id = id;
        this.name = name;
        this.numOfCredits = numOfCredits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String mail;

    public SinhVien(String id, String name, String grade, String mail) {
        this.id = id;
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.grade = grade;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

class BangDiem implements Comparable<BangDiem> {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private double mark;

    public BangDiem(double mark) {
        this.mark = mark;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    @Override
    public int compareTo(BangDiem o) {
        if (mark != o.mark) return -Double.compare(mark, o.mark);
        return sinhVien.getId().compareTo(o.sinhVien.getId());
    }

    @Override
    public String toString() {
        String s = String.format("%s %s %s ", sinhVien.getId(), sinhVien.getName(), sinhVien.getGrade());
        if (mark == (int) mark) s += String.format("%d", (int) mark);
        else s += String.format("%s", mark);
        return s;
    }
}

public class J07035 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        Scanner sc3 = new Scanner(new File("BANGDIEM.in")).useLocale(Locale.getDefault());
        int n = sc1.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String grade = sc1.next();
            String mail = sc1.next();
            a.add(new SinhVien(id, name, grade, mail));
        }
        int m = sc2.nextInt();
        sc2.nextLine();
        ArrayList<MonHoc> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc2.next();
            sc2.nextLine();
            String name = sc2.nextLine();
            int numOfCredits = sc2.nextInt();
            b.add(new MonHoc(id, name, numOfCredits));
        }
        int k = sc3.nextInt();
        ArrayList<BangDiem> c = new ArrayList<>();
        while (k-- > 0) {
            String sinhVienId = sc3.next();
            String monHocId = sc3.next();
            double mark = sc3.nextDouble();
            BangDiem d = new BangDiem(mark);
            for (SinhVien x : a)
                if (x.getId().equals(sinhVienId)) {
                    d.setSinhVien(x);
                    break;
                }
            for (MonHoc x : b)
                if (x.getId().equals(monHocId)) {
                    d.setMonHoc(x);
                    break;
                }
            c.add(d);
        }
        Collections.sort(c);
        k = sc3.nextInt();
        while (k-- > 0) {
            String id = sc3.next();
            String name = "";
            for (MonHoc x : b)
                if (x.getId().equals(id)) {
                    name = x.getName();
                    break;
                }
            System.out.printf("BANG DIEM MON %s:\n", name);
            for (BangDiem x : c)
                if (x.getMonHoc().getId().equals(id)) System.out.println(x);
        }
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
bang diem theo lop
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;
    private int numOfCredits;

    public MonHoc(String id, String name, int numOfCredits) {
        this.id = id;
        this.name = name;
        this.numOfCredits = numOfCredits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String mail;

    public SinhVien(String id, String name, String grade, String mail) {
        this.id = id;
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.grade = grade;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

class BangDiem implements Comparable<BangDiem> {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private double mark;

    public BangDiem(double mark) {
        this.mark = mark;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    @Override
    public int compareTo(BangDiem o) {
        if (!monHoc.getId().equals(o.monHoc.getId())) return monHoc.getId().compareTo(o.monHoc.getId());
        return sinhVien.getId().compareTo(o.sinhVien.getId());
    }

    @Override
    public String toString() {
        String s = String.format("%s %s %s %s ", sinhVien.getId(), sinhVien.getName(), monHoc.getId(), monHoc.getName());
        if (mark == (int) mark) s += String.format("%d", (int) mark);
        else s += String.format("%s", mark);
        return s;
    }
}

public class J07036 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        Scanner sc3 = new Scanner(new File("BANGDIEM.in")).useLocale(Locale.getDefault());
        int n = sc1.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String grade = sc1.next();
            String mail = sc1.next();
            a.add(new SinhVien(id, name, grade, mail));
        }
        int m = sc2.nextInt();
        sc2.nextLine();
        ArrayList<MonHoc> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc2.next();
            sc2.nextLine();
            String name = sc2.nextLine();
            int numOfCredits = sc2.nextInt();
            b.add(new MonHoc(id, name, numOfCredits));
        }
        int k = sc3.nextInt();
        ArrayList<BangDiem> c = new ArrayList<>();
        while (k-- > 0) {
            String sinhVienId = sc3.next();
            String monHocId = sc3.next();
            double mark = sc3.nextDouble();
            BangDiem d = new BangDiem(mark);
            for (SinhVien x : a)
                if (x.getId().equals(sinhVienId)) {
                    d.setSinhVien(x);
                    break;
                }
            for (MonHoc x : b)
                if (x.getId().equals(monHocId)) {
                    d.setMonHoc(x);
                    break;
                }
            c.add(d);
        }
        Collections.sort(c);
        k = sc3.nextInt();
        while (k-- > 0) {
            String grade = sc3.next();
            System.out.printf("BANG DIEM lop %s:\n", grade);
            for (BangDiem x : c)
                if (x.getSinhVien().getGrade().equals(grade)) System.out.println(x);
        }
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
quan li khach san
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Phong {
    private String symbol;
    private String type;
    private int unitPrice;
    private double service;

    public Phong(String symbol, String type, int unitPrice, double service) {
        this.symbol = symbol;
        this.type = type;
        this.unitPrice = unitPrice;
        this.service = service;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public double getService() {
        return service;
    }
}

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String phongId;
    private int numOfDays;
    private double discount;
    private Phong phong;

    public KhachHang(String name, String phongId, String start, String end) throws ParseException {
        id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.phongId = phongId;
        Date startDate = formatter.parse(start);
        Date endDate = formatter.parse(end);
        numOfDays = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
        if (numOfDays > 30) discount = 0.06;
        else if (numOfDays >= 20) discount = 0.04;
        else if (numOfDays >= 10) discount = 0.02;
        else discount = 0;
    }

    public String getPhongId() {
        return phongId;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public double getPrice() {
        double price = numOfDays * phong.getUnitPrice();
        if (numOfDays == 0) price = phong.getUnitPrice();
        return price * (1 - discount) * (1 + phong.getService());
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(numOfDays, o.numOfDays);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %.2f", id, name, phongId, numOfDays, getPrice());
    }
}

public class J07047 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Phong> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new Phong(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble()));
        int m = sc.nextInt();
        ArrayList<KhachHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            KhachHang c = new KhachHang(sc.nextLine(), sc.next(), sc.next(), sc.next());
            for (Phong x : a)
                if (x.getSymbol().equals(c.getPhongId().substring(2, 3))) {
                    c.setPhong(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        for (KhachHang x : b) System.out.println(x);
        sc.close();
    }
}
tinh ngay het han bao hanh
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class SanPham {
    private String id;
    private String name;
    private int unitPrice;
    private int guarantee;

    public SanPham(String id, String name, int unitPrice, int guarantee) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getGuarantee() {
        return guarantee;
    }
}

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String address;
    private SanPham sanPham;
    private int amount;
    private Date buyDate;
    private Date overDueDate;

    public KhachHang(String name, String address, int amount, String buy) throws ParseException {
        id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.address = address;
        this.amount = amount;
        buyDate = formatter.parse(buy);
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(buyDate);
        calendar.add(Calendar.MONTH, sanPham.getGuarantee());
        overDueDate = calendar.getTime();
    }

    public int getPrice() {
        return amount * sanPham.getUnitPrice();
    }

    @Override
    public int compareTo(KhachHang o) {
        if (overDueDate.getTime() != o.overDueDate.getTime())
            return Long.compare(overDueDate.getTime(), o.overDueDate.getTime());
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %s", id, name, address, sanPham.getId(), getPrice(), formatter.format(overDueDate));
    }
}

public class J07049 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitPrice = sc.nextInt();
            int guarantee = sc.nextInt();
            a.add(new SanPham(id, name, unitPrice, guarantee));
        }
        int m = sc.nextInt();
        ArrayList<KhachHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            String address = sc.nextLine();
            String sanPhamId = sc.next();
            int amount = sc.nextInt();
            String buy = sc.next();
            KhachHang c = new KhachHang(name, address, amount, buy);
            for (SanPham x : a)
                if (x.getId().equals(sanPhamId)) {
                    c.setSanPham(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        for (KhachHang x : b) System.out.println(x);
        sc.close();
    }
}
sap xep lich thi
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class MonThi {
    private String id;
    private String name;
    private String type;

    public MonThi(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class CaThi {
    private static int ID = 0;
    private static final String KEY = "C";
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private String id;
    private Date date;
    private String phongId;

    public CaThi(String date, String time, String phongId) throws ParseException {
        id = String.format("%s%03d", KEY, ++ID);
        this.date = formatter.parse(date + " " + time);
        this.phongId = phongId;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getPhongId() {
        return phongId;
    }
}

class LichThi implements Comparable<LichThi> {
    private CaThi caThi;
    private MonThi monThi;
    private String groupId;
    private int numOfSinhViens;

    public LichThi(String groupId, int numOfSinhViens) {
        this.groupId = groupId;
        this.numOfSinhViens = numOfSinhViens;
    }

    public void setCaThi(CaThi caThi) {
        this.caThi = caThi;
    }

    public void setMonThi(MonThi monThi) {
        this.monThi = monThi;
    }

    @Override
    public int compareTo(LichThi o) {
        if (caThi.getDate().getTime() != o.caThi.getDate().getTime())
            return Long.compare(caThi.getDate().getTime(), o.caThi.getDate().getTime());
        return caThi.getId().compareTo(o.caThi.getId());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d", CaThi.formatter.format(caThi.getDate()), caThi.getPhongId(), monThi.getName(), groupId, numOfSinhViens);
    }
}

public class J07060 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        int n = sc1.nextInt();
        ArrayList<MonThi> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String type = sc1.nextLine();
            a.add(new MonThi(id, name, type));
        }
        int m = sc2.nextInt();
        ArrayList<CaThi> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new CaThi(sc2.next(), sc2.next(), sc2.next()));
        int k = sc3.nextInt();
        ArrayList<LichThi> c = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            String caThiId = sc3.next();
            String monThiId = sc3.next();
            String groupId = sc3.next();
            int numOfSinhViens = sc3.nextInt();
            LichThi d = new LichThi(groupId, numOfSinhViens);
            for (CaThi x : b)
                if (x.getId().equals(caThiId)) {
                    d.setCaThi(x);
                    break;
                }
            for (MonThi x : a)
                if (x.getId().equals(monThiId)) {
                    d.setMonThi(x);
                    break;
                }
            c.add(d);
        }
        Collections.sort(c);
        for (LichThi x : c) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
tinh gia tri bieu thuc 
import java.util.*;
import java.io.*;

public class J07077 {
    public static boolean isDigit(char x){
        return x>='0'&&x<='9';
    }

    public static int res(String s){
        if (s.equals("*")||s.equals("/")) return 2;
        if (s.equals("+")||s.equals("-")) return 1;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BIEUTHUC.in"));
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            Stack<String> a=new Stack<>();
            Stack<String> b=new Stack<>();
            String s1="";
            for(int i=0;i<s.length();++i)
                if (isDigit(s.charAt(i))) s1+=s.charAt(i);
                else{
                    String x=Character.toString(s.charAt(i));
                    if (s1!=""){
                        a.push(s1);
                        s1="";
                    }
                    if (x.equals("(")) b.add(x);
                    else if (x.equals(")")){
                        while(!b.isEmpty()&&!b.peek().equals("(")) a.push(b.pop());
                        b.pop();
                    }
                    else{
                        if (res(x)>0){
                            while(!b.isEmpty()&&res(b.peek())>=res(x)) a.push(b.pop());
                            b.push(x);
                        }
                    }
                }
            if (s1!="") a.push(s1);
            while(!b.isEmpty()) a.push(b.pop());
            Stack<String> c=new Stack<>();
            for(String x:a)
                if (res(x)==0) c.push(x);
                else{
                    long p=Long.parseLong(c.pop());
                    long q=Long.parseLong(c.pop());
                    if (x.equals("+")) c.push(Long.toString(q+p));
                    else if (x.equals("-")) c.push(Long.toString(q-p));
                    else if (x.equals("*")) c.push(Long.toString(q*p));
                    else if (x.equals("/")) c.push(Long.toString(q/p));
                }
            System.out.println(c.peek());
        }
        sc.close();
    }
}
QUAN HE GIUA CAC LOP(KHO)
quan li bai tap nhom-1
import java.util.ArrayList;
import java.util.Scanner;

class SinhVien {
    private String id;
    private String name;
    private String phone;
    private int groupId;

    public SinhVien(String id, String name, String phone, int groupId) {
        this.id = id;
        this.name = name.trim();
        this.phone = phone;
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, name, phone);
    }
}

class Nhom {
    private static int ID = 0;
    private int id;
    private String deTai;
    private ArrayList<SinhVien> sinhViens;

    public Nhom(String deTai) {
        id = ++ID;
        this.deTai = deTai;
        sinhViens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<SinhVien> getSinhViens() {
        return sinhViens;
    }

    @Override
    public String toString() {
        String s = String.format("DANH SACH NHOM %d:\n", id);
        for (SinhVien x : sinhViens) s += (x.toString() + "\n");
        s += String.format("Bai tap dang ky: %s", deTai);
        return s;
    }
}

public class J06003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.next();
            int groupId = sc.nextInt();
            a.add(new SinhVien(id, name, phone, groupId));
        }
        ArrayList<Nhom> b = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < m; ++i) b.add(new Nhom(sc.nextLine()));
        for (SinhVien x : a)
            for (Nhom y : b)
                if (x.getGroupId() == y.getId()) y.getSinhViens().add(x);
        int q = sc.nextInt();
        while (q-- > 0) {
            int id = sc.nextInt();
            for (Nhom x : b)
                if (x.getId() == id) System.out.println(x);
        }
        sc.close();
    }
}
quan li bai tap nhom-2
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String phone;
    private int groupId;
    private Nhom group;

    public SinhVien(String id, String name, String phone, int groupId) {
        this.id = id;
        this.name = name.trim();
        this.phone = phone;
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroup(Nhom group) {
        this.group = group;
    }

    @Override
    public int compareTo(SinhVien o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", id, name, phone, groupId, group.getDeTai());
    }
}

class Nhom {
    private static int ID = 0;
    private int id;
    private String deTai;

    public Nhom(String deTai) {
        id = ++ID;
        this.deTai = deTai;
    }

    public int getId() {
        return id;
    }

    public String getDeTai() {
        return deTai;
    }
}

public class J06004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.next();
            int groupId = sc.nextInt();
            a.add(new SinhVien(id, name, phone, groupId));
        }
        Collections.sort(a);
        ArrayList<Nhom> b = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < m; ++i) b.add(new Nhom(sc.nextLine()));
        for (SinhVien x : a)
            for (Nhom y : b)
                if (x.getGroupId() == y.getId()) x.setGroup(y);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
tinh toan hoa don ban quan ao
import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    private String id;
    private String name;
    private int type1Price;
    private int type2Price;

    public SanPham(String id, String name, int type1Price, int type2Price) {
        this.id = id;
        this.name = name;
        this.type1Price = type1Price;
        this.type2Price = type2Price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType1Price() {
        return type1Price;
    }

    public int getType2Price() {
        return type2Price;
    }
}

class HoaDon {
    private static int ID = 0;
    private String id;
    private int amount;
    private SanPham sanPham;
    private int discount;
    private int finalPrice;

    public HoaDon(String id, int amount) {
        this.id = String.format("%s-%03d", id, ++ID);
        this.amount = amount;
        discount = 0;
    }

    public String getId() {
        return id;
    }

    public void setSanPham(SanPham sanPham, char type) {
        this.sanPham = sanPham;
        int unitPrice = 0;
        if (type == '1') unitPrice = sanPham.getType1Price();
        else unitPrice = sanPham.getType2Price();
        int price = unitPrice * amount;
        if (amount >= 150) discount = (int) (price * 0.5);
        else if (amount >= 100) discount = (int) (price * 0.3);
        else if (amount >= 50) discount = (int) (price * 0.15);
        finalPrice = price - discount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, sanPham.getName(), discount, finalPrice);
    }
}

public class J06001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int type1Price = sc.nextInt();
            int type2Price = sc.nextInt();
            a.add(new SanPham(id, name, type1Price, type2Price));
        }
        int m = sc.nextInt();
        ArrayList<HoaDon> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            HoaDon c = new HoaDon(sc.next(), sc.nextInt());
            for (SanPham x : a)
                if (x.getId().equals(c.getId().substring(0, 2))) {
                    c.setSanPham(x, c.getId().charAt(2));
                    break;
                }
            b.add(c);
        }
        for (HoaDon x : b) System.out.println(x);
        sc.close();
    }
}
sap xep hoa don ban quan ao
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SanPham {
    private String id;
    private String name;
    private int type1Price;
    private int type2Price;

    public SanPham(String id, String name, int type1Price, int type2Price) {
        this.id = id;
        this.name = name;
        this.type1Price = type1Price;
        this.type2Price = type2Price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType1Price() {
        return type1Price;
    }

    public int getType2Price() {
        return type2Price;
    }
}

class HoaDon implements Comparable<HoaDon> {
    private static int ID = 0;
    private String id;
    private int amount;
    private SanPham sanPham;
    private int discount;
    private int finalPrice;

    public HoaDon(String id, int amount) {
        this.id = String.format("%s-%03d", id, ++ID);
        this.amount = amount;
        discount = 0;
    }

    public String getId() {
        return id;
    }

    public void setSanPham(SanPham sanPham, char type) {
        this.sanPham = sanPham;
        int unitPrice = 0;
        if (type == '1') unitPrice = sanPham.getType1Price();
        else unitPrice = sanPham.getType2Price();
        int price = unitPrice * amount;
        if (amount >= 150) discount = (int) (price * 0.5);
        else if (amount >= 100) discount = (int) (price * 0.3);
        else if (amount >= 50) discount = (int) (price * 0.15);
        finalPrice = price - discount;
    }

    @Override
    public int compareTo(HoaDon o) {
        return -Integer.compare(finalPrice, o.finalPrice);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, sanPham.getName(), discount, finalPrice);
    }
}

public class J06002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int type1Price = sc.nextInt();
            int type2Price = sc.nextInt();
            a.add(new SanPham(id, name, type1Price, type2Price));
        }
        int m = sc.nextInt();
        ArrayList<HoaDon> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            HoaDon c = new HoaDon(sc.next(), sc.nextInt());
            for (SanPham x : a)
                if (x.getId().equals(c.getId().substring(0, 2))) {
                    c.setSanPham(x, c.getId().charAt(2));
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        for (HoaDon x : b) System.out.println(x);
        sc.close();
    }
}
quan li ban hang-1
import java.util.ArrayList;
import java.util.Scanner;

class KhachHang {
    private static int ID = 0;
    private static final String KEY = "KH";
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

class MatHang {
    private static int ID = 0;
    private static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int buyPrice;
    private int sellPrice;

    public MatHang(String name, String unit, int buyPrice, int sellPrice) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}

class HoaDon {
    private static int ID = 0;
    private static final String KEY = "HD";
    private String id;
    private KhachHang khachHang;
    private MatHang matHang;
    private int amount;

    public HoaDon(int amount) {
        id = String.format("%s%03d", KEY, ++ID);
        this.amount = amount;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d %d %d %d", id, khachHang.getName(), khachHang.getAddress(), matHang.getName(), matHang.getUnit(), matHang.getBuyPrice(), matHang.getSellPrice(), amount, amount * matHang.getSellPrice());
    }
}

public class J06005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        int m = sc.nextInt();
        ArrayList<MatHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            b.add(new MatHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        int k = sc.nextInt();
        ArrayList<HoaDon> c = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            String khachHangId = sc.next();
            String matHangId = sc.next();
            int amount = sc.nextInt();
            HoaDon d = new HoaDon(amount);
            for (KhachHang x : a)
                if (x.getId().equals(khachHangId)) {
                    d.setKhachHang(x);
                    break;
                }
            for (MatHang x : b)
                if (x.getId().equals(matHangId)) {
                    d.setMatHang(x);
                    break;
                }
            c.add(d);
        }
        for (HoaDon x : c) System.out.println(x);
        sc.close();
    }
}
quan li ban hang-2 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class KhachHang {
    private static int ID = 0;
    private static final String KEY = "KH";
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

class MatHang {
    private static int ID = 0;
    private static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int buyPrice;
    private int sellPrice;

    public MatHang(String name, String unit, int buyPrice, int sellPrice) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}

class HoaDon implements Comparable<HoaDon> {
    private static int ID = 0;
    private static final String KEY = "HD";
    private String id;
    private KhachHang khachHang;
    private MatHang matHang;
    private int amount;

    public HoaDon(int amount) {
        id = String.format("%s%03d", KEY, ++ID);
        this.amount = amount;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public int getProfit() {
        return amount * (matHang.getSellPrice() - matHang.getBuyPrice());
    }

    @Override
    public int compareTo(HoaDon o) {
        return -Integer.compare(getProfit(), o.getProfit());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %d %d", id, khachHang.getName(), khachHang.getAddress(), matHang.getName(), amount, amount * matHang.getSellPrice(), getProfit());
    }
}

public class J06006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        int m = sc.nextInt();
        ArrayList<MatHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            b.add(new MatHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        int k = sc.nextInt();
        ArrayList<HoaDon> c = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            String khachHangId = sc.next();
            String matHangId = sc.next();
            int amount = sc.nextInt();
            HoaDon d = new HoaDon(amount);
            for (KhachHang x : a)
                if (x.getId().equals(khachHangId)) {
                    d.setKhachHang(x);
                    break;
                }
            for (MatHang x : b)
                if (x.getId().equals(matHangId)) {
                    d.setMatHang(x);
                    break;
                }
            c.add(d);
        }
        Collections.sort(c);
        for (HoaDon x : c) System.out.println(x);
        sc.close();
    }
}
bang tinh gio chuan
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;

    public MonHoc(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class GiangVien {
    private String id;
    private String name;
    private double numOfHours;

    public GiangVien(String id, String name) {
        this.id = id;
        this.name = name;
        numOfHours = 0;
    }

    public String getId() {
        return id;
    }

    public void addHour(double hour) {
        numOfHours += hour;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, numOfHours);
    }
}

public class J06007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new MonHoc(sc.next(), sc.nextLine().trim()));
        int m = sc.nextInt();
        ArrayList<GiangVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new GiangVien(sc.next(), sc.nextLine().trim()));
        int k = sc.nextInt();
        while (k-- > 0) {
            String giaoVienId = sc.next();
            String monHocId = sc.next();
            double hour = sc.nextDouble();
            for (GiangVien x : b)
                if (x.getId().equals(giaoVienId)) {
                    x.addHour(hour);
                    break;
                }
        }
        for (GiangVien x : b) System.out.println(x);
        sc.close();
    }
}
tinh gio chuan cho tung giang vien
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Pair<X, Y> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }
}

class MonHoc {
    private String id;
    private String name;

    public MonHoc(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class GiangVien {
    private String id;
    private String name;
    private double numOfHours;
    private ArrayList<Pair<MonHoc, Double>> monHocList;

    public GiangVien(String id, String name) {
        this.id = id;
        this.name = name;
        numOfHours = 0;
        monHocList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public ArrayList<Pair<MonHoc, Double>> getMonHocList() {
        return monHocList;
    }

    public void addHour(double hour) {
        numOfHours += hour;
    }

    @Override
    public String toString() {
        String s = String.format("Giang vien: %s\n", name);
        for (Pair<MonHoc, Double> x : monHocList)
            s += String.format("%s %s\n", x.getFirst().getName(), x.getSecond());
        s += String.format("Tong: %.2f", numOfHours);
        return s;
    }
}

public class J06008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new MonHoc(sc.next(), sc.nextLine().trim()));
        int m = sc.nextInt();
        ArrayList<GiangVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new GiangVien(sc.next(), sc.nextLine().trim()));
        int k = sc.nextInt();
        while (k-- > 0) {
            String giaoVienId = sc.next();
            String monHocId = sc.next();
            double hour = sc.nextDouble();
            for (GiangVien x : b)
                if (x.getId().equals(giaoVienId)) {
                    for (MonHoc y : a)
                        if (y.getId().equals(monHocId)) {
                            x.getMonHocList().add(new Pair<>(y, hour));
                            x.addHour(hour);
                            break;
                        }
                    break;
                }
        }
        String id = sc.next();
        for (GiangVien x : b)
            if (x.getId().equals(id)) {
                System.out.println(x);
                break;
            }
        sc.close();
    }
}
MANG DOI TUONG
danh sach doi tuong sinh vien-1
import java.util.*;

class SinhVien {
    public static final String KEY = "B20DCCN";
    public static int ID = 0;
    private String id;
    private String name;
    private String grade;
    private String dob;
    private double gpa;

    public SinhVien(String name, String grade, String dob, double gpa) {
        this.id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.grade = grade;
        String[] tmp = dob.split("/");
        this.dob = String.format("%02d/%02d/%s", Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]);
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.name, this.grade, this.dob, this.gpa);
    }
}

public class J05003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int t=sc.nextInt();
        while(t-->0) {
            sc.nextLine();
            SinhVien a = new SinhVien(sc.nextLine(), sc.next(), sc.next(), sc.nextDouble());
            System.out.println(a);
        }
        sc.close();
    }
}
danh sach doi tuong sinh vien-2
import java.util.*;

class SinhVien {
    public static final String KEY = "B20DCCN";
    public static int ID = 0;
    private String id;
    private String name;
    private String grade;
    private String dob;
    private double gpa;

    public SinhVien(String name, String grade, String dob, double gpa) {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] x = name.trim().toLowerCase().split("\\s+");
        this.name = x[0].substring(0, 1).toUpperCase() + x[0].substring(1);
        for (int i = 1; i < x.length; ++i) this.name += (" " + x[i].substring(0, 1).toUpperCase() + x[i].substring(1));
        this.grade = grade;
        String[] tmp = dob.split("/");
        this.dob = String.format("%02d/%02d/%s", Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]);
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.name, this.grade, this.dob, this.gpa);
    }
}

public class J05004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int t=sc.nextInt();
        while(t-->0) {
            sc.nextLine();
            SinhVien a = new SinhVien(sc.nextLine(), sc.next(), sc.next(), sc.nextDouble());
            System.out.println(a);
        }
        sc.close();
    }
}
danh sach doi tuong sinh vien-3
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    public static final String KEY = "B20DCCN";
    public static int ID = 0;
    private String id;
    private String name;
    private String grade;
    private String dob;
    private double gpa;

    public SinhVien(String name, String grade, String dob, double gpa) {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] x = name.trim().toLowerCase().split("\\s+");
        this.name = x[0].substring(0, 1).toUpperCase() + x[0].substring(1);
        for (int i = 1; i < x.length; ++i) this.name += (" " + x[i].substring(0, 1).toUpperCase() + x[i].substring(1));
        this.grade = grade;
        String[] tmp = dob.split("/");
        this.dob = String.format("%02d/%02d/%s", Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]);
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.name, this.grade, this.dob, this.gpa);
    }

    @Override
    public int compareTo(SinhVien o) {
        return -Double.compare(this.gpa, o.gpa);
    }
}

public class J05005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.next(), sc.next(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
danh sach doi tuong nhan vien
import java.util.*;

class NhanVien {
    public static int ID = 0;
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;
    private String taxCode;
    private String signDate;

    public NhanVien(String name, String gender, String dob, String address, String taxCode, String signDate) {
        this.id = String.format("%05d", ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.taxCode = taxCode;
        this.signDate = signDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s", this.id, this.name, this.gender, this.dob, this.address, this.taxCode, this.signDate);
    }
}

public class J05006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            String taxCode = sc.next();
            String signDate = sc.next();
            NhanVien a = new NhanVien(name, gender, dob, address, taxCode, signDate);
            System.out.println(a);
        }
        sc.close();
    }
}
sap xep danh sach doi tuong nhan vien
import java.util.*;

class NhanVien implements Comparable<NhanVien> {
    public static int ID = 0;
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;
    private String taxCode;
    private String signDate;

    public NhanVien(String name, String gender, String dob, String address, String taxCode, String signDate) {
        this.id = String.format("%05d", ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.taxCode = taxCode;
        this.signDate = signDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public static String reverseFormat(String date) {
        String[] tmp = date.split("/");
        return tmp[2] + tmp[1] + tmp[0];
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s", this.id, this.name, this.gender, this.dob, this.address, this.taxCode, this.signDate);
    }

    @Override
    public int compareTo(NhanVien o) {
        String x=NhanVien.reverseFormat(this.dob);
        String y=NhanVien.reverseFormat(o.dob);
        return x.compareTo(y);
    }
}

public class J05007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            String taxCode = sc.next();
            String signDate = sc.next();
            a.add(new NhanVien(name, gender, dob, address, taxCode, signDate));
        }
        Collections.sort(a);
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
tim thu khoa cua ki thi
import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    public static int ID = 0;
    private int id;
    private String name;
    private String dob;
    private double mark1;
    private double mark2;
    private double mark3;

    public ThiSinh(String name, String dob, double mark1, double mark2, double mark3) {
        this.id = ++ID;
        this.name = name;
        this.dob = dob;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    public double getTotalMark() {
        return this.mark1 + this.mark2 + this.mark3;
    }

    @Override
    public int compareTo(ThiSinh o) {
        if (this.getTotalMark() != o.getTotalMark()) return -Double.compare(this.getTotalMark(), o.getTotalMark());
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.1f", this.id, this.name, this.dob, this.getTotalMark());
    }
}

public class J05009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new ThiSinh(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        double max = a.get(0).getTotalMark();
        for (ThiSinh x : a)
            if (max == x.getTotalMark()) System.out.println(x);
            else break;
        sc.close();
    }
}
sap xep danh sach mat hang
import java.io.*;
import java.util.*;

class MatHang implements Comparable<MatHang> {
    public static int ID = 0;
    private int id;
    private String name;
    private String group;
    private double buyPrice;
    private double sellPrice;

    public MatHang(String name, String group, double buyPrice, double sellPrice) {
        this.id = ++ID;
        this.name = name;
        this.group = group;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getProfit() {
        return this.sellPrice - this.buyPrice;
    }

    @Override
    public int compareTo(MatHang o) {
        return -Double.compare(this.getProfit(), o.getProfit());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", this.id, this.name, this.group, this.getProfit());
    }
}

public class J05010 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<MatHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new MatHang(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (MatHang x : a) System.out.println(x);
    }
}
tinh gio
import java.text.SimpleDateFormat;
import java.util.*;

class Gamer implements Comparable<Gamer> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private String id;
    private String name;
    private Date startDate;
    private Date endDate;

    public Gamer(String id, String name, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        try {
            this.startDate = dateFormat.parse(startDate);
            this.endDate = dateFormat.parse(endDate);
        } catch (Exception e) {

        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getTotalTime() {
        return endDate.getTime() - startDate.getTime();
    }

    @Override
    public int compareTo(Gamer o) {
        return -Long.compare(this.getTotalTime(), o.getTotalTime());
    }

    @Override
    public String toString() {
        return String.format("%s %s %d gio %d phut", this.id, this.name, (int) (this.getTotalTime() / (1000 * 60 * 60)), (int) (this.getTotalTime() / (1000 * 60) % 60));
    }
}

public class J05011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Gamer> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id=sc.next();
            sc.nextLine();
            String name=sc.nextLine();
            String startDate=sc.next();
            String endDate=sc.next();
            a.add(new Gamer(id, name, startDate, endDate));
        }
        Collections.sort(a);
        for (Gamer x : a) System.out.println(x);
        sc.close();
    }
}
bang diem hoc sinh
import java.util.*;

class HocSinh implements Comparable<HocSinh> {
    public static int ID = 0;
    public static final String KEY = "HS";
    private String id;
    private String name;
    private double[] mark;
    private String rank;

    public HocSinh(String name, double[] mark) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.mark = mark;
        double finalMark = this.getAverage();
        if (finalMark >= 9) this.rank = "XUAT SAC";
        else if (finalMark >= 8) this.rank = "GIOI";
        else if (finalMark >= 7) this.rank = "KHA";
        else if (finalMark >= 5) this.rank = "TB";
        else this.rank = "YEU";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getMark() {
        return mark;
    }

    public void setMark(double[] mark) {
        this.mark = mark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getAverage() {
        double s = 0;
        for (int i = 0; i < 10; ++i)
            if (i <= 1) s += 2 * this.mark[i];
            else s += this.mark[i];
        return s / 12;
    }

    @Override
    public int compareTo(HocSinh o) {
        if (this.getAverage() != o.getAverage()) return -Double.compare(this.getAverage(), o.getAverage());
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", this.id, this.name, Math.round(this.getAverage() * 10.f) / 10.f, this.rank);
    }
}

public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<HocSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            double[] mark = new double[10];
            for (int j = 0; j < 10; ++j) mark[j] = sc.nextDouble();
            a.add(new HocSinh(name, mark));
        }
        Collections.sort(a);
        for (HocSinh x : a) System.out.println(x);
        sc.close();
    }
}
sap xep sinh vien theo lop
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.grade, this.email);
    }

    @Override
    public int compareTo(SinhVien o) {
        if (!this.grade.equals(o.grade)) return this.grade.compareTo(o.grade);
        return this.id.compareTo(o.id);
    }
}

public class J05020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
sap xep theo ma sinh vien
import java.io.*;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.grade, this.email);
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.id.compareTo(o.id);
    }
}

public class J05021 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        while (sc.hasNext()) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
liet ke sinh vien theo lop
import java.io.*;
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.grade, this.email);
    }
}

public class J05022 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            String grade = sc.next();
            System.out.printf("DANH SACH SINH VIEN LOP %s:\n", grade);
            for (SinhVien x : a)
                if (x.getGrade().equals(grade)) System.out.println(x);
        }
        sc.close();
    }
}
liet ke sinh vien theo khoa 
import java.io.*;
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.grade, this.email);
    }
}

public class J05023 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            String course = sc.next();
            System.out.printf("DANH SACH SINH VIEN KHOA %s:\n", course);
            for (SinhVien x : a)
                if (x.getGrade().substring(1,3).equals(course.substring(2))) System.out.println(x);
        }
        sc.close();
    }
}
liet ke sinh vien theo nganh 
import java.io.*;
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.grade, this.email);
    }
}

public class J05024 {
    public static String res(String s) {
        if (s.equals("KE TOAN")) return "DCKT";
        if (s.equals("CONG NGHE THONG TIN")) return "DCCN";
        if (s.equals("AN TOAN THONG TIN")) return "DCAT";
        if (s.equals("VIEN THONG")) return "DCVT";
        return "DCDT";
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        int q = sc.nextInt();
        sc.nextLine();
        while (q-- > 0) {
            String major = sc.nextLine().toUpperCase();
            System.out.printf("DANH SACH SINH VIEN NGANH %s:\n", major);
            major = res(major);
            for (SinhVien x : a)
                if (x.getId().substring(3, 7).equals(major)) {
                    if (major.equals("DCCN") || major.equals("DCAT")) {
                        if (x.getGrade().charAt(0) != 'E') System.out.println(x);
                    } else System.out.println(x);
                }
        }
        sc.close();
    }
}
sap xep danh sach giang vien
import java.io.*;
import java.util.*;

class GiangVien implements Comparable<GiangVien> {
    public static int ID = 0;
    public static final String KEY = "GV";
    private String id;
    private String name;
    private String firstName;
    private String subject;

    public GiangVien(String name, String subject) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.firstName = "";
        for (int i = name.length() - 1; i >= 0 && name.charAt(i) != ' '; --i)
            this.firstName = name.charAt(i) + this.firstName;
        String[] tmp = subject.toUpperCase().split("\\s+");
        this.subject = "";
        for (String x : tmp) this.subject += x.charAt(0);
    }

    @Override
    public int compareTo(GiangVien o) {
        if (!this.firstName.equals(o.firstName)) return this.firstName.compareTo(o.firstName);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.subject);
    }
}

public class J05025 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<GiangVien> a = new ArrayList<GiangVien>();
        for (int i = 0; i < n; ++i) a.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        Collections.sort(a);
        for (GiangVien x : a) System.out.println(x);
        sc.close();
    }
}
danh sach giang vien theo bo mon
import java.io.*;
import java.util.*;

class GiangVien {
    public static int ID = 0;
    public static final String KEY = "GV";
    private String id;
    private String name;
    private String subject;

    public GiangVien(String name, String subject) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.subject = GiangVien.convertSubject(subject);
    }

    public static String convertSubject(String s) {
        String[] tmp = s.toUpperCase().split("\\s+");
        String ans = "";
        for (String x : tmp) ans += x.charAt(0);
        return ans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.subject);
    }
}

public class J05026 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<GiangVien> a = new ArrayList<GiangVien>();
        for (int i = 0; i < n; ++i) a.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        int q = sc.nextInt();
        sc.nextLine();
        while (q-- > 0) {
            String subject = GiangVien.convertSubject(sc.nextLine());
            System.out.printf("DANH SACH GIANG VIEN BO MON %s:\n", subject);
            for (GiangVien x : a)
                if (x.getSubject().equals(subject)) System.out.println(x);
        }
        sc.close();
    }
}
tim kiem giang vien
import java.io.*;
import java.util.*;

class GiangVien {
    public static int ID = 0;
    public static final String KEY = "GV";
    private String id;
    private String name;
    private String subject;

    public GiangVien(String name, String subject) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.subject = GiangVien.convertSubject(subject);
    }

    public static String convertSubject(String s) {
        String[] tmp = s.toUpperCase().split("\\s+");
        String ans = "";
        for (String x : tmp) ans += x.charAt(0);
        return ans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.subject);
    }
}

public class J05027 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<GiangVien> a = new ArrayList<GiangVien>();
        for (int i = 0; i < n; ++i) a.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        int q = sc.nextInt();
        sc.nextLine();
        while (q-- > 0) {
            String keyWord = sc.nextLine();
            System.out.printf("DANH SACH GIANG VIEN THEO TU KHOA %s:\n", keyWord);
            for (GiangVien x : a)
                if (x.getName().toLowerCase().contains(keyWord.toLowerCase())) System.out.println(x);
        }
        sc.close();
    }
}
danh sach doanh nghiep nhan sinh vien thuc tap-1
import java.util.*;

class DoanhNghiep implements Comparable<DoanhNghiep> {
    private String id;
    private String name;
    private int numOfSV;

    public DoanhNghiep(String id, String name, int numOfSV) {
        this.id = id;
        this.name = name;
        this.numOfSV = numOfSV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSV() {
        return numOfSV;
    }

    public void setNumOfSV(int numOfSV) {
        this.numOfSV = numOfSV;
    }

    @Override
    public int compareTo(DoanhNghiep o) {
        if (this.numOfSV != o.numOfSV) return -Integer.compare(this.numOfSV, o.numOfSV);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.numOfSV);
    }
}

public class J05028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DoanhNghiep> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int numOfSV = sc.nextInt();
            a.add(new DoanhNghiep(id, name, numOfSV));
        }
        Collections.sort(a);
        for (DoanhNghiep x : a) System.out.println(x);
        sc.close();
    }
}
danh sach doanh nghiep nhan sinh vien thuc tap-2
import java.util.*;

class DoanhNghiep implements Comparable<DoanhNghiep> {
    private String id;
    private String name;
    private int numOfSV;

    public DoanhNghiep(String id, String name, int numOfSV) {
        this.id = id;
        this.name = name;
        this.numOfSV = numOfSV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSV() {
        return numOfSV;
    }

    public void setNumOfSV(int numOfSV) {
        this.numOfSV = numOfSV;
    }

    @Override
    public int compareTo(DoanhNghiep o) {
        if (this.numOfSV != o.numOfSV) return -Integer.compare(this.numOfSV, o.numOfSV);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.numOfSV);
    }
}

public class J05029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DoanhNghiep> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int numOfSV = sc.nextInt();
            a.add(new DoanhNghiep(id, name, numOfSV));
        }
        Collections.sort(a);
        int q = sc.nextInt();
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n", l, r);
            for (DoanhNghiep x : a)
                if (l <= x.getNumOfSV() && x.getNumOfSV() <= r) System.out.println(x);
        }
        sc.close();
    }
}
bang diem thanh phan-1
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String grade;
    private double mark1;
    private double mark2;
    private double mark3;

    public SinhVien(String id, String name, String grade, double mark1, double mark2, double mark3) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %.1f %.1f", this.id, this.name, this.grade, this.mark1, this.mark2, this.mark3);
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.id.compareTo(o.id);
    }
}

public class J05030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            double mark1 = sc.nextDouble();
            double mark2 = sc.nextDouble();
            double mark3 = sc.nextDouble();
            a.add(new SinhVien(id, name, grade, mark1, mark2, mark3));
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); ++i) System.out.printf("%d %s\n", i + 1, a.get(i));
        sc.close();
    }
}
bang diem thanh phan-2
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String grade;
    private double mark1;
    private double mark2;
    private double mark3;

    public SinhVien(String id, String name, String grade, double mark1, double mark2, double mark3) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %.1f %.1f", this.id, this.name, this.grade, this.mark1, this.mark2, this.mark3);
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.name.compareTo(o.name);
    }
}

public class J05031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            double mark1 = sc.nextDouble();
            double mark2 = sc.nextDouble();
            double mark3 = sc.nextDouble();
            a.add(new SinhVien(id, name, grade, mark1, mark2, mark3));
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); ++i) System.out.printf("%d %s\n", i + 1, a.get(i));
        sc.close();
    }
}
tre nhat-gia nhat
import java.text.SimpleDateFormat;
import java.util.*;

class Person implements Comparable<Person> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private Date dob;

    public Person(String name, String dob) {
        this.name = name;
        try {
            this.dob = dateFormat.parse(dob);
        } catch (Exception e) {

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public int compareTo(Person o) {
        return -Long.compare(this.dob.getTime(), o.dob.getTime());
    }
}

public class J05032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Person> a = new ArrayList<Person>();
        for (int i = 0; i < n; ++i) {
            a.add(new Person(sc.next(), sc.next()));
        }
        Collections.sort(a);
        System.out.println(a.get(0).getName());
        System.out.println(a.get(a.size() - 1).getName());
        sc.close();
    }
}
danh sach thuc tap-1
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    public static int NUM = 0;
    private int stt;
    private String id;
    private String name;
    private String grade;
    private String email;
    private String company;

    public SinhVien(String id, String name, String grade, String email, String company) {
        this.stt = ++NUM;
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.company = company;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s", this.stt, this.id, this.name, this.grade, this.email, this.company);
    }
}

public class J05034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            String company = sc.next();
            a.add(new SinhVien(id, name, grade, email, company));
        }
        Collections.sort(a);
        int q = sc.nextInt();
        while (q-- > 0) {
            String company = sc.next();
            for (SinhVien x : a)
                if (x.getCompany().equals(company)) System.out.println(x);
        }
        sc.close();
    }
}
danh sach thuc tap-2
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    public static int NUM = 0;
    private int stt;
    private String id;
    private String name;
    private String grade;
    private String email;
    private String company;

    public SinhVien(String id, String name, String grade, String email, String company) {
        this.stt = ++NUM;
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.company = company;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s", this.stt, this.id, this.name, this.grade, this.email, this.company);
    }
}

public class J05035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            String company = sc.next();
            a.add(new SinhVien(id, name, grade, email, company));
        }
        Collections.sort(a);
        int q = sc.nextInt();
        while (q-- > 0) {
            String company = sc.next();
            for (SinhVien x : a)
                if (x.getCompany().equals(company)) System.out.println(x);
        }
        sc.close();
    }
}
tinh gia ban-1
import java.util.*;

class Goods {
    public static int ID = 0;
    public static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int unitPrice;
    private int amount;
    private int shipPrice;
    private int price;
    private int finalPrice;

    public Goods(String name, String unit, int unitPrice, int amount) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.shipPrice = Math.round((unitPrice * amount) * 0.05f);
        this.price = unitPrice * amount + this.shipPrice;
        this.finalPrice = Math.round(this.price * 1.02f);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(int shipPrice) {
        this.shipPrice = shipPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", this.id, this.name, this.unit, this.shipPrice, this.price, this.finalPrice);
    }
}

public class J05036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<Goods>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}
tinh gia ban-2
import java.util.*;

class Goods implements Comparable<Goods> {
    public static int ID = 0;
    public static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int unitPrice;
    private int amount;
    private int shipPrice;
    private int price;
    private int retailPrice;

    public Goods(String name, String unit, int unitPrice, int amount) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.shipPrice = Math.round((unitPrice * amount) * 0.05f);
        this.price = unitPrice * amount + this.shipPrice;
        this.retailPrice = (int) Math.ceil((this.price * 1.02f / amount) / 100) * 100;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(int shipPrice) {
        this.shipPrice = shipPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", this.id, this.name, this.unit, this.shipPrice, this.price, this.retailPrice);
    }

    @Override
    public int compareTo(Goods o) {
        return -Integer.compare(this.retailPrice, o.retailPrice);
    }
}

public class J05037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<Goods>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}
bang ke tien luong
import java.util.*;

class NhanVien {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private int baseSalary;
    private int workDay;
    private String position;
    private int salary;
    private int bonus;
    private int allowance;

    public NhanVien(String name, int baseSalary, int workDay, String position) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.baseSalary = baseSalary;
        this.workDay = workDay;
        this.position = position;
        this.salary = this.baseSalary * this.workDay;
        if (workDay >= 25) this.bonus = (int) (this.salary * 0.2);
        else if (workDay >= 22) this.bonus = (int) (this.salary * 0.1);
        else this.bonus = 0;
        switch (position) {
            case "GD":
                this.allowance = 250000;
                break;
            case "PGD":
                this.allowance = 200000;
                break;
            case "TP":
                this.allowance = 180000;
                break;
            case "NV":
                this.allowance = 150000;
                break;
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFinalSalary() {
        return this.salary + this.bonus + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.salary, this.bonus, this.allowance, this.getFinalSalary());
    }
}

public class J05038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.next()));
        }
        int s = 0;
        for (NhanVien x : a) {
            s += x.getFinalSalary();
            System.out.println(x);
        }
        System.out.printf("Tong chi phi tien luong: %d", s);
        sc.close();
    }
}
lap bang tinh cong
import java.util.*;

class NhanVien {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private int baseSalary;
    private int workDay;
    private String position;
    private int salary;
    private int bonus;
    private int allowance;

    public NhanVien(String name, int baseSalary, int workDay, String position) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.baseSalary = baseSalary;
        this.workDay = workDay;
        this.position = position;
        this.salary = this.baseSalary * this.workDay;
        if (workDay >= 25) this.bonus = (int) (this.salary * 0.2);
        else if (workDay >= 22) this.bonus = (int) (this.salary * 0.1);
        else this.bonus = 0;
        switch (position) {
            case "GD":
                this.allowance = 250000;
                break;
            case "PGD":
                this.allowance = 200000;
                break;
            case "TP":
                this.allowance = 180000;
                break;
            case "NV":
                this.allowance = 150000;
                break;
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFinalSalary() {
        return this.salary + this.bonus + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.salary, this.bonus, this.allowance, this.getFinalSalary());
    }
}

public class J05040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.next()));
        }
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
sap xep bang tinh cong
import java.util.*;

class NhanVien implements Comparable<NhanVien> {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private int baseSalary;
    private int workDay;
    private String position;
    private int salary;
    private int bonus;
    private int allowance;

    public NhanVien(String name, int baseSalary, int workDay, String position) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.baseSalary = baseSalary;
        this.workDay = workDay;
        this.position = position;
        this.salary = this.baseSalary * this.workDay;
        if (workDay >= 25) this.bonus = (int) (this.salary * 0.2);
        else if (workDay >= 22) this.bonus = (int) (this.salary * 0.1);
        else this.bonus = 0;
        switch (position) {
            case "GD":
                this.allowance = 250000;
                break;
            case "PGD":
                this.allowance = 200000;
                break;
            case "TP":
                this.allowance = 180000;
                break;
            case "NV":
                this.allowance = 150000;
                break;
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFinalSalary() {
        return this.salary + this.bonus + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.salary, this.bonus, this.allowance, this.getFinalSalary());
    }

    @Override
    public int compareTo(NhanVien o) {
        return -Integer.compare(this.getFinalSalary(), o.getFinalSalary());
    }
}

public class J05041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.next()));
        }
        Collections.sort(a);
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
bang xep hang
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String name;
    private int numOfAC;
    private int numOfSubmit;

    public SinhVien(String name, int numOfAC, int numOfSubmit) {
        this.name = name;
        this.numOfAC = numOfAC;
        this.numOfSubmit = numOfSubmit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfAC() {
        return numOfAC;
    }

    public void setNumOfAC(int numOfAC) {
        this.numOfAC = numOfAC;
    }

    public int getNumOfSubmit() {
        return numOfSubmit;
    }

    public void setNumOfSubmit(int numOfSubmit) {
        this.numOfSubmit = numOfSubmit;
    }

    @Override
    public int compareTo(SinhVien o) {
        if (this.numOfAC != o.numOfAC) return -Integer.compare(this.numOfAC, o.numOfAC);
        if (this.numOfSubmit != o.numOfSubmit) return Integer.compare(this.numOfSubmit, o.numOfSubmit);
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numOfAC, this.numOfSubmit);
    }
}

public class J05042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
tinh thu nhap cho nhan vien
import java.util.*;

class NhanVien {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private String position;
    private int baseSalary;
    private int numOfWork;
    private int allowance;
    private int mainSalary;
    private int advance;
    private int remain;

    public NhanVien(String name, String position, int baseSalary, int numOfWork) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.numOfWork = numOfWork;
        this.mainSalary = baseSalary * numOfWork;
        switch (position) {
            case "GD":
                this.allowance = 500;
                break;
            case "PGD":
                this.allowance = 400;
                break;
            case "TP":
                this.allowance = 300;
                break;
            case "KT":
                this.allowance = 250;
                break;
            default:
                this.allowance = 100;
                break;
        }
        this.advance = Math.min(Math.round((this.allowance + this.mainSalary) * 2 / 3.f / 1000) * 1000, 25000);
        this.remain = this.mainSalary - this.advance + this.allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumOfWork() {
        return numOfWork;
    }

    public void setNumOfWork(int numOfWork) {
        this.numOfWork = numOfWork;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getMainSalary() {
        return mainSalary;
    }

    public void setMainSalary(int mainSalary) {
        this.mainSalary = mainSalary;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.allowance, this.mainSalary, this.advance, this.remain);
    }
}

public class J05043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
liet ke nhan vien theo chuc vu
import java.util.*;

class NhanVien {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private String position;
    private int baseSalary;
    private int numOfWork;
    private int allowance;
    private int mainSalary;
    private int advance;
    private int remain;

    public NhanVien(String name, String position, int baseSalary, int numOfWork) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.numOfWork = numOfWork;
        this.mainSalary = baseSalary * numOfWork;
        switch (position) {
            case "GD":
                this.allowance = 500;
                break;
            case "PGD":
                this.allowance = 400;
                break;
            case "TP":
                this.allowance = 300;
                break;
            case "KT":
                this.allowance = 250;
                break;
            default:
                this.allowance = 100;
                break;
        }
        this.advance = Math.min(Math.round((this.allowance + this.mainSalary) * 2 / 3.f / 1000) * 1000, 25000);
        this.remain = this.mainSalary - this.advance + this.allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumOfWork() {
        return numOfWork;
    }

    public void setNumOfWork(int numOfWork) {
        this.numOfWork = numOfWork;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getMainSalary() {
        return mainSalary;
    }

    public void setMainSalary(int mainSalary) {
        this.mainSalary = mainSalary;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.allowance, this.mainSalary, this.advance, this.remain);
    }
}

public class J05043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
sap xep nhan vien theo thu nhap
import java.util.*;

class NhanVien implements Comparable<NhanVien> {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private String position;
    private int baseSalary;
    private int numOfWork;
    private int allowance;
    private int mainSalary;
    private int advance;
    private int remain;

    public NhanVien(String name, String position, int baseSalary, int numOfWork) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.numOfWork = numOfWork;
        this.mainSalary = baseSalary * numOfWork;
        switch (position) {
            case "GD":
                this.allowance = 500;
                break;
            case "PGD":
                this.allowance = 400;
                break;
            case "TP":
                this.allowance = 300;
                break;
            case "KT":
                this.allowance = 250;
                break;
            default:
                this.allowance = 100;
                break;
        }
        this.advance = Math.min(Math.round((this.allowance + this.mainSalary) * 2 / 3.f / 1000) * 1000, 25000);
        this.remain = this.mainSalary - this.advance + this.allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumOfWork() {
        return numOfWork;
    }

    public void setNumOfWork(int numOfWork) {
        this.numOfWork = numOfWork;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getMainSalary() {
        return mainSalary;
    }

    public void setMainSalary(int mainSalary) {
        this.mainSalary = mainSalary;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.allowance, this.mainSalary, this.advance, this.remain);
    }

    @Override
    public int compareTo(NhanVien o) {
        if (this.mainSalary + this.allowance != o.mainSalary + o.allowance)
            return -Integer.compare(this.mainSalary + this.allowance, o.mainSalary + o.allowance);
        return this.id.compareTo(o.id);
    }
}

public class J05045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
bang ke nhap kho
import java.util.*;

class NhanVien implements Comparable<NhanVien> {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private String position;
    private int baseSalary;
    private int numOfWork;
    private int allowance;
    private int mainSalary;
    private int advance;
    private int remain;

    public NhanVien(String name, String position, int baseSalary, int numOfWork) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.numOfWork = numOfWork;
        this.mainSalary = baseSalary * numOfWork;
        switch (position) {
            case "GD":
                this.allowance = 500;
                break;
            case "PGD":
                this.allowance = 400;
                break;
            case "TP":
                this.allowance = 300;
                break;
            case "KT":
                this.allowance = 250;
                break;
            default:
                this.allowance = 100;
                break;
        }
        this.advance = Math.min(Math.round((this.allowance + this.mainSalary) * 2 / 3.f / 1000) * 1000, 25000);
        this.remain = this.mainSalary - this.advance + this.allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumOfWork() {
        return numOfWork;
    }

    public void setNumOfWork(int numOfWork) {
        this.numOfWork = numOfWork;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getMainSalary() {
        return mainSalary;
    }

    public void setMainSalary(int mainSalary) {
        this.mainSalary = mainSalary;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.allowance, this.mainSalary, this.advance, this.remain);
    }

    @Override
    public int compareTo(NhanVien o) {
        if (this.mainSalary + this.allowance != o.mainSalary + o.allowance)
            return -Integer.compare(this.mainSalary + this.allowance, o.mainSalary + o.allowance);
        return this.id.compareTo(o.id);
    }
}

public class J05045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
bang ke nhap kho sap xep theo chiet khau
import java.util.*;

class Goods implements Comparable<Goods> {
    public static HashMap<String, Integer> map = new HashMap<>();
    private String id;
    private String name;
    private int amount;
    private int unitPrice;
    private int discount;
    private int finalPrice;

    public Goods(String name, int amount, int unitPrice) {
        String[] x = name.toUpperCase().split("\\s+");
        String y = String.valueOf(x[0].charAt(0)) + x[1].charAt(0);
        if (map.containsKey(y)) map.put(y, map.get(y) + 1);
        else map.put(y, 1);
        this.id = String.format("%s%02d", y, map.get(y));
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
        float tmp;
        if (amount > 10) tmp = 0.05f;
        else if (amount >= 8) tmp = 0.02f;
        else if (amount >= 5) tmp = 0.01f;
        else tmp = 0f;
        this.discount = (int) (unitPrice * amount * tmp);
        this.finalPrice = this.unitPrice * amount - this.discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", this.id, this.name, this.discount, this.finalPrice);
    }

    @Override
    public int compareTo(Goods o){
        return -Integer.compare(this.discount, o.discount);
    }
}

public class J05047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}
bang theo doi nhap xuat hang
import java.util.*;

class Goods implements Comparable<Goods> {
    public static HashMap<String, Integer> map = new HashMap<>();
    private String id;
    private String name;
    private int amount;
    private int unitPrice;
    private int discount;
    private int finalPrice;

    public Goods(String name, int amount, int unitPrice) {
        String[] x = name.toUpperCase().split("\\s+");
        String y = String.valueOf(x[0].charAt(0)) + x[1].charAt(0);
        if (map.containsKey(y)) map.put(y, map.get(y) + 1);
        else map.put(y, 1);
        this.id = String.format("%s%02d", y, map.get(y));
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
        float tmp;
        if (amount > 10) tmp = 0.05f;
        else if (amount >= 8) tmp = 0.02f;
        else if (amount >= 5) tmp = 0.01f;
        else tmp = 0f;
        this.discount = (int) (unitPrice * amount * tmp);
        this.finalPrice = this.unitPrice * amount - this.discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", this.id, this.name, this.discount, this.finalPrice);
    }

    @Override
    public int compareTo(Goods o){
        return -Integer.compare(this.discount, o.discount);
    }
}

public class J05047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}
liet ke nhap xuat hang theo kho
import java.util.*;

class Goods implements Comparable<Goods> {
    private String id;
    private int importAmount;
    private int exportAmount;
    private int unitPrice;
    private int price;
    private int tax;

    public Goods(String id, int importAmount) {
        this.id = id;
        this.importAmount = importAmount;
        if (id.charAt(0) == 'A') this.exportAmount = Math.round(importAmount * 0.6f);
        else if (id.charAt(0) == 'B') this.exportAmount = Math.round(importAmount * 0.7f);
        if (id.charAt(id.length() - 1) == 'Y') this.unitPrice = 110000;
        else if (id.charAt(id.length() - 1) == 'N') this.unitPrice = 135000;
        this.price = this.exportAmount * this.unitPrice;
        float tmp = 0f;
        if (id.charAt(0) == 'A') {
            if (id.charAt(id.length() - 1) == 'Y') tmp = 0.08f;
            else if (id.charAt(id.length() - 1) == 'N') tmp = 0.11f;
        } else if (id.charAt(0) == 'B') {
            if (id.charAt(id.length() - 1) == 'Y') tmp = 0.17f;
            else if (id.charAt(id.length() - 1) == 'N') tmp = 0.22f;
        }
        this.tax = Math.round(this.price * tmp / 10) * 10;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImportAmount() {
        return importAmount;
    }

    public void setImportAmount(int importAmount) {
        this.importAmount = importAmount;
    }

    public int getExportAmount() {
        return exportAmount;
    }

    public void setExportAmount(int exportAmount) {
        this.exportAmount = exportAmount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d %d", this.id, this.importAmount, this.exportAmount, this.unitPrice, this.price, this.tax);
    }

    @Override
    public int compareTo(Goods o) {
        return -Integer.compare(this.tax,o.tax);
    }
}

public class J05049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new Goods(sc.next(), sc.nextInt()));
        Collections.sort(a);
        String s=sc.next();
        for (Goods x : a)
            if (x.getId().contains(s)) System.out.println(x);
        sc.close();
    }
}
tinh tien dien
import java.util.*;

class KhachHang {
    public static int ID = 0;
    public static final String KEY = "KH";
    private String id;
    private String type;
    private int oldIndex;
    private int newIndex;
    private int coefficient;
    private int price;
    private int allowance;
    private int finalPrice;

    public KhachHang(String type, int oldIndex, int newIndex) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.type = type;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        switch (type) {
            case "KD":
                this.coefficient = 3;
                break;
            case "NN":
                this.coefficient = 5;
                break;
            case "TT":
                this.coefficient = 4;
                break;
            case "CN":
                this.coefficient = 2;
                break;
            default:
                break;
        }
        this.price = (newIndex - oldIndex) * this.coefficient * 550;
        if (newIndex - oldIndex > 100) this.allowance = this.price;
        else if (newIndex - oldIndex >= 50) this.allowance = Math.round(this.price * 0.35f);
        else this.allowance = 0;
        this.finalPrice = this.allowance + this.price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d", this.id, this.coefficient, this.price, this.allowance, this.finalPrice);
    }
}

public class J05050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new KhachHang(sc.next(), sc.nextInt(), sc.nextInt()));
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}
sap xep bang tinh tien dien
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    public static int ID = 0;
    public static final String KEY = "KH";
    private String id;
    private String type;
    private int oldIndex;
    private int newIndex;
    private int coefficient;
    private int price;
    private int allowance;
    private int finalPrice;

    public KhachHang(String type, int oldIndex, int newIndex) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.type = type;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        switch (type) {
            case "KD":
                this.coefficient = 3;
                break;
            case "NN":
                this.coefficient = 5;
                break;
            case "TT":
                this.coefficient = 4;
                break;
            case "CN":
                this.coefficient = 2;
                break;
            default:
                break;
        }
        this.price = (newIndex - oldIndex) * this.coefficient * 550;
        if (newIndex - oldIndex > 100) this.allowance = this.price;
        else if (newIndex - oldIndex >= 50) this.allowance = Math.round(this.price * 0.35f);
        else this.allowance = 0;
        this.finalPrice = this.allowance + this.price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d", this.id, this.coefficient, this.price, this.allowance, this.finalPrice);
    }

    @Override
    public int compareTo(KhachHang o){
        return -Integer.compare(this.finalPrice, o.finalPrice);
    }
}

public class J05051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new KhachHang(sc.next(), sc.nextInt(), sc.nextInt()));
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}
tra cuu don hang
import java.util.*;

class DonHang {
    private String name;
    private String id;
    private int unitPrice;
    private int amount;
    private String orderIndex;
    private int discount;
    private int finalPrice;

    public DonHang(String name, String id, int unitPrice, int amount) {
        this.name = name;
        this.id = id;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.orderIndex = id.substring(1, 4);
        if (id.charAt(id.length() - 1) == '1') this.discount = (int) (unitPrice * amount * 0.5f);
        else if (id.charAt(id.length() - 1) == '2') this.discount = (int) (unitPrice * amount * 0.3f);
        this.finalPrice = unitPrice * amount - this.discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", this.name, this.id, this.orderIndex, this.discount, this.finalPrice);
    }
}

public class J05052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DonHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new DonHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (DonHang x : a) System.out.println(x);
        sc.close();
    }
}
sap xep don hang
import java.util.*;

class DonHang implements Comparable<DonHang> {
    private String name;
    private String id;
    private int unitPrice;
    private int amount;
    private String orderIndex;
    private int discount;
    private int finalPrice;

    public DonHang(String name, String id, int unitPrice, int amount) {
        this.name = name;
        this.id = id;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.orderIndex = id.substring(1, 4);
        if (id.charAt(id.length() - 1) == '1') this.discount = (int) (unitPrice * amount * 0.5f);
        else if (id.charAt(id.length() - 1) == '2') this.discount = (int) (unitPrice * amount * 0.3f);
        this.finalPrice = unitPrice * amount - this.discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", this.name, this.id, this.orderIndex, this.discount, this.finalPrice);
    }

    @Override
    public int compareTo(DonHang o){
        return this.orderIndex.compareTo(o.orderIndex);
    }
}

public class J05053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DonHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new DonHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (DonHang x : a) System.out.println(x);
        sc.close();
    }
}
xep hang hoc sinh
import java.util.*;

class HocSinh {
    public static int ID = 0;
    public static final String KEY = "HS";
    private String id;
    private String name;
    private float averageMark;
    private String classification;
    private int rank;

    public HocSinh(String name, float averageMark) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.averageMark = averageMark;
        if (averageMark >= 9.f) this.classification = "Gioi";
        else if (averageMark >= 7.f) this.classification = "Kha";
        else if (averageMark >= 5.f) this.classification = "Trung Binh";
        else this.classification = "Yeu";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s %d", this.id, this.name, this.averageMark, this.classification, this.rank);
    }
}

public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<HocSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new HocSinh(sc.nextLine(), sc.nextFloat()));
        }
        Collections.sort(a, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return -Float.compare(o1.getAverageMark(), o2.getAverageMark());
            }
        });
        int currentRank = 0;
        float currentMark = 0.f;
        int tmp = 0;
        for (int i = 0; i < a.size(); ++i)
            if (currentMark == a.get(i).getAverageMark()) {
                a.get(i).setRank(currentRank);
                tmp += 1;
            } else {
                currentMark = a.get(i).getAverageMark();
                currentRank += (tmp + 1);
                tmp = 0;
                a.get(i).setRank(currentRank);
            }
        Collections.sort(a, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for (HocSinh x : a) System.out.println(x);
        sc.close();
    }
}
xep hang van dong vien-1
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class VanDongVien {
    public static int ID = 0;
    public static final String KEY = "VDV";
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private String id;
    private String name;
    private Date startTime;
    private Date endTime;
    private Date bonusTime;
    private Date realTime;
    private Date finalTime;
    private int rank;

    public VanDongVien(String name, String dob, String startTime, String endTime) throws ParseException {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.startTime = timeFormat.parse(startTime);
        this.endTime = timeFormat.parse(endTime);
        int age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        if (age >= 32) this.bonusTime = timeFormat.parse("00:00:03");
        else if (age >= 25) this.bonusTime = timeFormat.parse("00:00:02");
        else if (age >= 18) this.bonusTime = timeFormat.parse("00:00:01");
        else this.bonusTime = timeFormat.parse("00:00:00");
        this.realTime = MillisToTime(this.endTime.getTime() - this.startTime.getTime());
        this.finalTime = MillisToTime(this.realTime.getTime() - this.bonusTime.getTime());
    }

    public static Date MillisToTime(long millis) throws ParseException {
        int hour = (int) (millis / (1000 * 60 * 60));
        int minute = (int) (millis / (1000 * 60)) % 60;
        int second = (int) (millis / 1000) % 60;
        return timeFormat.parse(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d", this.id, this.name, timeFormat.format(this.realTime), timeFormat.format(this.bonusTime), timeFormat.format(this.finalTime), this.rank);
    }
}

public class J05055 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<VanDongVien> a = new ArrayList<>();
        TreeSet<Date> b = new TreeSet<>();
        ArrayList<Date> e = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            VanDongVien c = new VanDongVien(sc.nextLine(), sc.next(), sc.next(), sc.next());
            a.add(c);
            b.add(c.getFinalTime());
            e.add(c.getFinalTime());
        }
        int currentRank = 1;
        HashMap<Date,Integer> d = new HashMap<>();
        for (Date x : b) {
            d.put(x, currentRank);
            currentRank += Collections.frequency(e, x);
        }
        for (VanDongVien x : a) x.setRank(d.get(x.getFinalTime()));
        for (VanDongVien x : a) System.out.println(x);
        sc.close();
    }
}
xep hang van dong vien-2
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class VanDongVien implements Comparable<VanDongVien> {
    public static int ID = 0;
    public static final String KEY = "VDV";
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private String id;
    private String name;
    private Date startTime;
    private Date endTime;
    private Date bonusTime;
    private Date realTime;
    private Date finalTime;
    private int rank;

    public VanDongVien(String name, String dob, String startTime, String endTime) throws ParseException {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.startTime = timeFormat.parse(startTime);
        this.endTime = timeFormat.parse(endTime);
        int age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        if (age >= 32) this.bonusTime = timeFormat.parse("00:00:03");
        else if (age >= 25) this.bonusTime = timeFormat.parse("00:00:02");
        else if (age >= 18) this.bonusTime = timeFormat.parse("00:00:01");
        else this.bonusTime = timeFormat.parse("00:00:00");
        this.realTime = MillisToTime(this.endTime.getTime() - this.startTime.getTime());
        this.finalTime = MillisToTime(this.realTime.getTime() - this.bonusTime.getTime());
    }

    public static Date MillisToTime(long millis) throws ParseException {
        int hour = (int) (millis / (1000 * 60 * 60));
        int minute = (int) (millis / (1000 * 60)) % 60;
        int second = (int) (millis / 1000) % 60;
        return timeFormat.parse(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d", this.id, this.name, timeFormat.format(this.realTime), timeFormat.format(this.bonusTime), timeFormat.format(this.finalTime), this.rank);
    }

    @Override
    public int compareTo(VanDongVien o) {
        return Integer.compare(this.rank, o.rank);
    }
}

public class J05056 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<VanDongVien> a = new ArrayList<>();
        TreeSet<Date> b = new TreeSet<>();
        ArrayList<Date> e = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            VanDongVien c = new VanDongVien(sc.nextLine(), sc.next(), sc.next(), sc.next());
            a.add(c);
            b.add(c.getFinalTime());
            e.add(c.getFinalTime());
        }
        int currentRank = 1;
        HashMap<Date, Integer> d = new HashMap<>();
        for (Date x : b) {
            d.put(x, currentRank);
            currentRank += Collections.frequency(e, x);
        }
        for (VanDongVien x : a) x.setRank(d.get(x.getFinalTime()));
        Collections.sort(a);
        for (VanDongVien x : a) System.out.println(x);
        sc.close();
    }
}
bang diem tuyen sinh
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class VanDongVien implements Comparable<VanDongVien> {
    public static int ID = 0;
    public static final String KEY = "VDV";
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private String id;
    private String name;
    private Date startTime;
    private Date endTime;
    private Date bonusTime;
    private Date realTime;
    private Date finalTime;
    private int rank;

    public VanDongVien(String name, String dob, String startTime, String endTime) throws ParseException {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.startTime = timeFormat.parse(startTime);
        this.endTime = timeFormat.parse(endTime);
        int age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        if (age >= 32) this.bonusTime = timeFormat.parse("00:00:03");
        else if (age >= 25) this.bonusTime = timeFormat.parse("00:00:02");
        else if (age >= 18) this.bonusTime = timeFormat.parse("00:00:01");
        else this.bonusTime = timeFormat.parse("00:00:00");
        this.realTime = MillisToTime(this.endTime.getTime() - this.startTime.getTime());
        this.finalTime = MillisToTime(this.realTime.getTime() - this.bonusTime.getTime());
    }

    public static Date MillisToTime(long millis) throws ParseException {
        int hour = (int) (millis / (1000 * 60 * 60));
        int minute = (int) (millis / (1000 * 60)) % 60;
        int second = (int) (millis / 1000) % 60;
        return timeFormat.parse(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d", this.id, this.name, timeFormat.format(this.realTime), timeFormat.format(this.bonusTime), timeFormat.format(this.finalTime), this.rank);
    }

    @Override
    public int compareTo(VanDongVien o) {
        return Integer.compare(this.rank, o.rank);
    }
}

public class J05056 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<VanDongVien> a = new ArrayList<>();
        TreeSet<Date> b = new TreeSet<>();
        ArrayList<Date> e = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            VanDongVien c = new VanDongVien(sc.nextLine(), sc.next(), sc.next(), sc.next());
            a.add(c);
            b.add(c.getFinalTime());
            e.add(c.getFinalTime());
        }
        int currentRank = 1;
        HashMap<Date, Integer> d = new HashMap<>();
        for (Date x : b) {
            d.put(x, currentRank);
            currentRank += Collections.frequency(e, x);
        }
        for (VanDongVien x : a) x.setRank(d.get(x.getFinalTime()));
        Collections.sort(a);
        for (VanDongVien x : a) System.out.println(x);
        sc.close();
    }
}
sap xep ket qua tuyen sinh
import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    private String id;
    private String name;
    private float toan;
    private float ly;
    private float hoa;
    private float bonus;
    private String status;

    public ThiSinh(String id, String name, float toan, float ly, float hoa) {
        this.id = id;
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        switch (id.charAt(2)) {
            case '1':
                this.bonus = 0.5f;
                break;
            case '2':
                this.bonus = 1f;
                break;
            case '3':
                this.bonus = 2.5f;
                break;
            default:
                break;
        }
        float finalMark = this.getMark();
        if (finalMark >= 24.f) this.status = "TRUNG TUYEN";
        else this.status = "TRUOT";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getMark() {
        return this.toan * 2 + this.ly + this.hoa + this.bonus;
    }

    @Override
    public String toString() {
        return this.id + " " +
                this.name + " " +
                ((int) this.bonus == this.bonus ? String.format("%d", (int) this.bonus) : String.format("%.1f", this.bonus)) + " " +
                ((int) this.getMark() == this.getMark() ? String.format("%d", (int) this.getMark()) : String.format("%.1f", this.getMark())) + " " +
                this.status;
    }

    @Override
    public int compareTo(ThiSinh o) {
        if (this.getMark() != o.getMark()) return -Float.compare(this.getMark(), o.getMark());
        return this.id.compareTo(o.id);
    }
}

public class J05058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            float toan = sc.nextFloat();
            float ly = sc.nextFloat();
            float hoa = sc.nextFloat();
            a.add(new ThiSinh(id, name, toan, ly, hoa));
        }
        Collections.sort(a);
        for (ThiSinh x : a) System.out.println(x);
        sc.close();
    }
}
ket qua xet tuyen
import java.util.*;

class PhuHo {
    public static int ID = 0;
    public static final String KEY = "PH";
    private String id;
    private String name;
    private int age;
    private float theory;
    private float practice;
    private float bonus;
    private int finalMark;
    private String rank;

    public PhuHo(String name, String dob, float theory, float practice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.theory = theory;
        this.practice = practice;
        if (theory >= 8.f && practice >= 8.f) this.bonus = 1.f;
        else if (theory >= 7.5f && practice >= 7.5f) this.bonus = 0.5f;
        else this.bonus = 0.f;
        this.finalMark = Math.min(10, Math.round((this.theory + this.practice) / 2 + this.bonus));
        if (this.finalMark >= 9) this.rank = "Xuat sac";
        else if (this.finalMark == 8) this.rank = "Gioi";
        else if (this.finalMark == 7) this.rank = "Kha";
        else if (this.finalMark >= 5) this.rank = "Trung binh";
        else this.rank = "Truot";
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", this.id, this.name, this.age, this.finalMark, this.rank);
    }
}

public class J05060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<PhuHo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new PhuHo(sc.nextLine(), sc.next(), sc.nextFloat(), sc.nextFloat()));
        }
        for (PhuHo x : a) System.out.println(x);
        sc.close();
    }
}
sap xep ket qua xet tuyen 
import java.util.*;

class PhuHo implements Comparable<PhuHo> {
    public static int ID = 0;
    public static final String KEY = "PH";
    private String id;
    private String name;
    private int age;
    private float theory;
    private float practice;
    private float bonus;
    private int finalMark;
    private String rank;

    public PhuHo(String name, String dob, float theory, float practice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.theory = theory;
        this.practice = practice;
        if (theory >= 8.f && practice >= 8.f) this.bonus = 1.f;
        else if (theory >= 7.5f && practice >= 7.5f) this.bonus = 0.5f;
        else this.bonus = 0.f;
        this.finalMark = Math.min(10, Math.round((this.theory + this.practice) / 2 + this.bonus));
        if (this.finalMark >= 9) this.rank = "Xuat sac";
        else if (this.finalMark == 8) this.rank = "Gioi";
        else if (this.finalMark == 7) this.rank = "Kha";
        else if (this.finalMark >= 5) this.rank = "Trung binh";
        else this.rank = "Truot";
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", this.id, this.name, this.age, this.finalMark, this.rank);
    }

    @Override
    public int compareTo(PhuHo o) {
        if (this.finalMark != o.finalMark) return -Integer.compare(this.finalMark, o.finalMark);
        return this.id.compareTo(o.id);
    }
}

public class J05061 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<PhuHo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new PhuHo(sc.nextLine(), sc.next(), sc.nextFloat(), sc.nextFloat()));
        }
        Collections.sort(a);
        for (PhuHo x : a) System.out.println(x);
        sc.close();
    }
}
bang thu nhap giao vien
import java.util.*;

class GiaoVien {
    private String id;
    private String name;
    private long baseSalary;
    private long allowance;
    private int coefficient;

    public GiaoVien(String id, String name, long baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        switch (id.substring(0, 2)) {
            case "HT":
                this.allowance = 2000000;
                break;
            case "HP":
                this.allowance = 900000;
                break;
            case "GV":
                this.allowance = 500000;
                break;
            default:
                break;
        }
        this.coefficient = Integer.parseInt(id.substring(2));
    }

    public String getId() {
        return id;
    }

    public long getSalary() {
        return this.baseSalary * this.coefficient + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", this.id, this.name, this.coefficient, this.allowance, this.getSalary());
    }
}

public class J05064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<GiaoVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            long baseSalary = sc.nextLong();
            a.add(new GiaoVien(id, name, baseSalary));
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (GiaoVien x:a){
            if (x.getId().startsWith("HT")) {
                cnt1++;
                if (cnt1 <= 1) System.out.println(x);
            } else if (x.getId().startsWith("HP")) {
                cnt2++;
                if (cnt2 <= 2) System.out.println(x);
            } else System.out.println(x);
        }
        sc.close();
    }
}
quan li kho xang dau
import java.util.*;

class NhienLieu {
    private String id;
    private String name;
    private int unitPrice;
    private long tax;
    private long finalPrice;

    public NhienLieu(String id, int amount) {
        this.id = id;
        double tmp = 0;
        switch (id.charAt(0)) {
            case 'X':
                this.unitPrice = 128000;
                tmp = 0.03;
                break;
            case 'D':
                this.unitPrice = 11200;
                tmp = 0.035;
                break;
            case 'N':
                this.unitPrice = 9700;
                tmp = 0.02;
                break;
            default:
                break;
        }
        switch (id.substring(id.length() - 2)) {
            case "BP":
                this.name = "British Petro";
                break;
            case "ES":
                this.name = "Esso";
                break;
            case "SH":
                this.name = "Shell";
                break;
            case "CA":
                this.name = "Castrol";
                break;
            case "MO":
                this.name = "Mobil";
                break;
            case "TN":
                this.name = "Trong Nuoc";
                tmp = 0;
                break;
            default:
                break;
        }
        long price = (long) this.unitPrice * amount;
        this.tax = (long) (price * tmp);
        this.finalPrice = price + tax;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", this.id, this.name, this.unitPrice, this.tax, this.finalPrice);
    }
}

public class J05067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhienLieu> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new NhienLieu(sc.next(), sc.nextInt()));
        for (NhienLieu x : a) System.out.println(x);
        sc.close();
    }
}
sap xep bang gia xang dau
import java.util.*;

class NhienLieu implements Comparable<NhienLieu> {
    private String id;
    private String name;
    private int unitPrice;
    private long tax;
    private long finalPrice;

    public NhienLieu(String id, int amount) {
        this.id = id;
        double tmp = 0;
        switch (id.charAt(0)) {
            case 'X':
                this.unitPrice = 128000;
                tmp = 0.03;
                break;
            case 'D':
                this.unitPrice = 11200;
                tmp = 0.035;
                break;
            case 'N':
                this.unitPrice = 9700;
                tmp = 0.02;
                break;
            default:
                break;
        }
        switch (id.substring(id.length() - 2)) {
            case "BP":
                this.name = "British Petro";
                break;
            case "ES":
                this.name = "Esso";
                break;
            case "SH":
                this.name = "Shell";
                break;
            case "CA":
                this.name = "Castrol";
                break;
            case "MO":
                this.name = "Mobil";
                break;
            case "TN":
                this.name = "Trong Nuoc";
                tmp = 0;
                break;
            default:
                break;
        }
        long price = (long) this.unitPrice * amount;
        this.tax = (long) (price * tmp);
        this.finalPrice = price + tax;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", this.id, this.name, this.unitPrice, this.tax, this.finalPrice);
    }

    @Override
    public int compareTo(NhienLieu o){
        return -Long.compare(this.finalPrice, o.finalPrice);
    }
}

public class J05068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhienLieu> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new NhienLieu(sc.next(), sc.nextInt()));
        Collections.sort(a);
        for (NhienLieu x : a) System.out.println(x);
        sc.close();
    }
}
cau lac bo bong da-1
import java.util.*;

class CLB {
    private String id;
    private String name;
    private int price;

    public CLB(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Match {
    private String id;
    private int amount;
    private char nationId;
    private String clbId;
    private int order;
    private int profit;
    private String clbName;

    public Match(String id, int amount) {
        this.id = id;
        this.nationId = id.charAt(0);
        this.clbId = id.substring(1, 3);
        this.order = Integer.parseInt(id.substring(3));
        this.amount = amount;
    }

    public String getClbId() {
        return clbId;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setClbName(String clbName) {
        this.clbName = clbName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.clbName, this.profit);
    }
}

public class J05069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<CLB> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            a.add(new CLB(id, name, price));
        }
        int m = sc.nextInt();
        ArrayList<Match> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new Match(sc.next(), sc.nextInt()));
        for (int i = 0; i < m; ++i) {
            for (CLB x : a)
                if (b.get(i).getClbId().equals(x.getId())) {
                    b.get(i).setClbName(x.getName());
                    b.get(i).setProfit(b.get(i).getAmount() * x.getPrice());
                }
        }
        for (Match x : b) System.out.println(x);
        sc.close();
    }
}
cau lac bo bong da-2
import java.util.*;

class CLB {
    private String id;
    private String name;
    private int price;

    public CLB(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Match implements Comparable<Match> {
    private String id;
    private int amount;
    private char nationId;
    private String clbId;
    private int order;
    private int profit;
    private String clbName;

    public Match(String id, int amount) {
        this.id = id;
        nationId = id.charAt(0);
        clbId = id.substring(1, 3);
        order = Integer.parseInt(id.substring(3));
        this.amount = amount;
    }

    public String getClbId() {
        return clbId;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setClbName(String clbName) {
        this.clbName = clbName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.clbName, this.profit);
    }

    @Override
    public int compareTo(Match o) {
        if (this.profit != o.profit) return -Integer.compare(this.profit, o.profit);
        return this.clbName.compareTo(o.clbName);
    }
}

public class J05070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<CLB> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            a.add(new CLB(id, name, price));
        }
        int m = sc.nextInt();
        ArrayList<Match> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new Match(sc.next(), sc.nextInt()));
        for (int i = 0; i < m; ++i) {
            for (CLB x : a)
                if (b.get(i).getClbId().equals(x.getId())) {
                    b.get(i).setClbName(x.getName());
                    b.get(i).setProfit(b.get(i).getAmount() * x.getPrice());
                }
        }
        Collections.sort(b);
        for (Match x : b) System.out.println(x);
        sc.close();
    }
}
diem danh-1
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private int mark;
    private String note;

    public SinhVien(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mark = 10;
        this.note = "";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setMark(String data) {
        for (int i = 0; i < data.length(); ++i)
            if (data.charAt(i) == 'm') this.mark--;
            else if (data.charAt(i) == 'v') this.mark -= 2;
        this.mark = Math.max(this.mark, 0);
        if (this.mark == 0) this.note = "KDDK";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", this.id, this.name, this.grade, this.mark, this.note);
    }
}

public class J05074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            a.add(new SinhVien(id, name, grade));
        }
        for (int i = 0; i < n; ++i) {
            String svID = sc.next();
            for (int j = 0; j < n; ++j)
                if (a.get(j).getId().equals(svID)) a.get(j).setMark(sc.next());
        }
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
diem danh-2
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private int mark;
    private String note;

    public SinhVien(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mark = 10;
        this.note = "";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setMark(String data) {
        for (int i = 0; i < data.length(); ++i)
            if (data.charAt(i) == 'm') this.mark--;
            else if (data.charAt(i) == 'v') this.mark -= 2;
        this.mark = Math.max(this.mark, 0);
        if (this.mark == 0) this.note = "KDDK";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", this.id, this.name, this.grade, this.mark, this.note);
    }
}

public class J05075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            a.add(new SinhVien(id, name, grade));
        }
        for (int i = 0; i < n; ++i) {
            String svID = sc.next();
            for (int j = 0; j < n; ++j)
                if (a.get(j).getId().equals(svID)) a.get(j).setMark(sc.next());
        }
        String grade = sc.next();
        for (SinhVien x : a)
            if (x.getGrade().equals(grade)) System.out.println(x);
        sc.close();
    }
}
nhap xuat hang
import java.util.ArrayList;
import java.util.Scanner;

class HangHoa {
    private String id;
    private String name;
    private char rank;

    public HangHoa(String id, String name, char rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getRank() {
        return rank;
    }
}

public class J05076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<HangHoa> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            char rank = sc.next().charAt(0);
            a.add(new HangHoa(id, name, rank));
        }
        int m = sc.nextInt();
        while (m-- > 0) {
            String id = sc.next();
            int importAmount = sc.nextInt();
            int unitPrice = sc.nextInt();
            int exportAmount = sc.nextInt();
            for (HangHoa x : a)
                if (x.getId().equals(id)) {
                    int importPrice = importAmount * unitPrice;
                    int exportPrice = exportAmount * unitPrice;
                    switch (x.getRank()) {
                        case 'A':
                            exportPrice = (int) (exportPrice * (1 + 0.08));
                            break;
                        case 'B':
                            exportPrice = (int) (exportPrice * (1 + 0.05));
                            break;
                        case 'C':
                            exportPrice = (int) (exportPrice * (1 + 0.02));
                            break;
                        default:
                            break;
                    }
                    System.out.printf("%s %s %d %d\n", x.getId(), x.getName(), importPrice, exportPrice);
                    break;
                }
        }
        sc.close();
    }
}
tinh luong 
import java.util.*;

class PhongBan {
    private String id;
    private String name;

    public PhongBan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class NhanVien {
    private String id;
    private String name;
    private String phongBanId;
    private String phongBanName;
    private int salary;

    public NhanVien(String id, String name, int baseSalary, int numOfWorks) {
        this.id = id;
        this.name = name;
        char group = id.charAt(0);
        int numOfYears = Integer.parseInt(id.substring(1, 3));
        this.phongBanId = id.substring(3);
        int coefficient = 0;
        if (group == 'A') {
            if (numOfYears >= 16) coefficient = 20;
            else if (numOfYears >= 9) coefficient = 14;
            else if (numOfYears >= 4) coefficient = 12;
            else coefficient = 10;
        } else if (group == 'B') {
            if (numOfYears >= 16) coefficient = 16;
            else if (numOfYears >= 9) coefficient = 13;
            else if (numOfYears >= 4) coefficient = 11;
            else coefficient = 10;
        } else if (group == 'C') {
            if (numOfYears >= 16) coefficient = 14;
            else if (numOfYears >= 9) coefficient = 12;
            else if (numOfYears >= 4) coefficient = 10;
            else coefficient = 9;
        } else {
            if (numOfYears >= 16) coefficient = 13;
            else if (numOfYears >= 9) coefficient = 11;
            else if (numOfYears >= 4) coefficient = 9;
            else coefficient = 8;
        }
        this.salary = baseSalary * 1000 * numOfWorks * coefficient;
    }

    public String getPhongBanId() {
        return phongBanId;
    }

    public void setPhongBanName(String phongBanName) {
        this.phongBanName = phongBanName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", this.id, this.name, this.phongBanName, this.salary);
    }
}

public class J05077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<PhongBan> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            String name = sc.nextLine().trim();
            a.add(new PhongBan(id, name));
        }
        int m = sc.nextInt();
        ArrayList<NhanVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int baseSalary = sc.nextInt();
            int numOfWorks = sc.nextInt();
            b.add(new NhanVien(id, name, baseSalary, numOfWorks));
        }
        for (int i = 0; i < m; ++i) {
            for (PhongBan x : a)
                if (b.get(i).getPhongBanId().equals(x.getId())) b.get(i).setPhongBanName(x.getName());
        }
        for (NhanVien x : b) System.out.println(x);
        sc.close();
    }
}
bang luong theo phong ban
import java.util.*;

class PhongBan {
    private String id;
    private String name;

    public PhongBan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class NhanVien {
    private String id;
    private String name;
    private String phongBanId;
    private int salary;

    public NhanVien(String id, String name, int baseSalary, int numOfWorks) {
        this.id = id;
        this.name = name;
        char group = id.charAt(0);
        int numOfYears = Integer.parseInt(id.substring(1, 3));
        this.phongBanId = id.substring(3);
        int coefficient = 0;
        if (group == 'A') {
            if (numOfYears >= 16) coefficient = 20;
            else if (numOfYears >= 9) coefficient = 14;
            else if (numOfYears >= 4) coefficient = 12;
            else coefficient = 10;
        } else if (group == 'B') {
            if (numOfYears >= 16) coefficient = 16;
            else if (numOfYears >= 9) coefficient = 13;
            else if (numOfYears >= 4) coefficient = 11;
            else coefficient = 10;
        } else if (group == 'C') {
            if (numOfYears >= 16) coefficient = 14;
            else if (numOfYears >= 9) coefficient = 12;
            else if (numOfYears >= 4) coefficient = 10;
            else coefficient = 9;
        } else {
            if (numOfYears >= 16) coefficient = 13;
            else if (numOfYears >= 9) coefficient = 11;
            else if (numOfYears >= 4) coefficient = 9;
            else coefficient = 8;
        }
        this.salary = baseSalary * 1000 * numOfWorks * coefficient;
    }

    public String getPhongBanId() {
        return phongBanId;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.salary);
    }
}

public class J05078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<PhongBan> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            String name = sc.nextLine().trim();
            a.add(new PhongBan(id, name));
        }
        int m = sc.nextInt();
        ArrayList<NhanVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int baseSalary = sc.nextInt();
            int numOfWorks = sc.nextInt();
            b.add(new NhanVien(id, name, baseSalary, numOfWorks));
        }
        String phongBanId = sc.next();
        String phongBanName = "";
        for (PhongBan x : a)
            if (x.getId().equals(phongBanId)) phongBanName = x.getName();
        System.out.printf("Bang luong phong %s:\n", phongBanName);
        for (NhanVien x : b)
            if (x.getPhongBanId().equals(phongBanId)) System.out.println(x);
        sc.close();
    }
}
lop hoc phan-1
import java.util.*;

class LopHoc implements Comparable<LopHoc> {
    private String subjectId;
    private String subjectName;
    private String group;
    private String teacherName;

    public LopHoc(String subjectId, String subjectName, String group, String teacherName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.group = group;
        this.teacherName = teacherName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public int compareTo(LopHoc o) {
        return this.group.compareTo(o.group);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.group, this.teacherName);
    }
}

public class J05079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<LopHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String subjectId = sc.next();
            sc.nextLine();
            String subjectName = sc.nextLine();
            String group = sc.next();
            sc.nextLine();
            String teacherName = sc.nextLine();
            a.add(new LopHoc(subjectId, subjectName, group, teacherName));
        }
        Collections.sort(a);
        int m = sc.nextInt();
        while (m-- > 0) {
            String id = sc.next();
            String name = "";
            for (LopHoc x : a)
                if (x.getSubjectId().equals(id)) name = x.getSubjectName();
            System.out.printf("Danh sach nhom lop mon %s:\n", name);
            for (LopHoc x : a)
                if (x.getSubjectId().equals(id)) System.out.println(x);
        }
        sc.close();
    }
}
lop hoc phan-2
import java.util.*;

class LopHoc implements Comparable<LopHoc> {
    private String subjectId;
    private String subjectName;
    private String group;
    private String teacherName;

    public LopHoc(String subjectId, String subjectName, String group, String teacherName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.group = group;
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public int compareTo(LopHoc o) {
        if (!this.subjectId.equals(o.subjectId)) return this.subjectId.compareTo(o.subjectId);
        return this.group.compareTo(o.group);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.subjectId, this.subjectName, this.group);
    }
}

public class J05080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<LopHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String subjectId = sc.next();
            sc.nextLine();
            String subjectName = sc.nextLine();
            String group = sc.next();
            sc.nextLine();
            String teacherName = sc.nextLine();
            a.add(new LopHoc(subjectId, subjectName, group, teacherName));
        }
        Collections.sort(a);
        int m = sc.nextInt();
        sc.nextLine();
        while (m-- > 0) {
            String name = sc.nextLine();
            System.out.printf("Danh sach cho giang vien %s:\n", name);
            for (LopHoc x : a)
                if (x.getTeacherName().equals(name)) System.out.println(x);
        }
        sc.close();
    }
}
danh sach khach hang
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    public static int ID = 0;
    public static final String KEY = "KH";
    public static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.gender = gender;
        tmp = dob.split("/");
        this.dob = String.format("%02d/%02d/%s", Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]);
        this.address = address;
    }

    @Override
    public int compareTo(KhachHang o) {
        try {
            return Long.compare(format.parse(this.dob).getTime(), format.parse(o.dob).getTime());
        } catch (ParseException e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", this.id, this.name, this.gender, this.address, this.dob);
    }
}

public class J05082 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}
dien tich da giac
import java.util.*;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point o) {
        return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
    }
}

class Polygon {
    private Point[] p;

    public Polygon(Point[] p) {
        this.p = p;
    }

    public String getArea() {
        double area = 0.f;
        for (int i = 1; i < p.length - 1; ++i) {
            double a = p[0].distanceTo(p[i]);
            double b = p[0].distanceTo(p[i + 1]);
            double c = p[i].distanceTo(p[i + 1]);
            double half = (a + b + c) / 2;
            area += Math.sqrt(half * (half - a) * (half - b) * (half - c));
        }
        return String.format("%.3f", area);
    }
}

public class J05008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Point p[] = new Point[n];
            for (int i = 0; i < n; i++) {
                p[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
        sc.close();
    }
}
tinh tien 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Bill implements Comparable<Bill> {
    private String id;
    private String name;
    private int amount;
    private long unitPrice;
    private long discount;
    private long finalPrice;

    public Bill(String id, String name, int amount, long unitPrice, long discount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.finalPrice = unitPrice * amount - discount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.amount, this.unitPrice, this.discount, this.finalPrice);
    }

    @Override
    public int compareTo(Bill o) {
        return -Long.compare(this.finalPrice, o.finalPrice);
    }
}

public class J05012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Bill> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int amount = sc.nextInt();
            long unitPrice = sc.nextLong();
            long discount = sc.nextLong();
            a.add(new Bill(id, name, amount, unitPrice, discount));
        }
        Collections.sort(a);
        for (Bill x : a) System.out.println(x);
        sc.close();
    }
}
tuyen dung
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh> {
    private static int ID = 0;
    private static final String KEY = "TS";
    private String id;
    private String name;
    private double theory;
    private double practice;
    private double averageMark;
    private String status;

    public ThiSinh(String name, double theory, double practice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.theory = standardize(theory);
        this.practice = standardize(practice);
        this.averageMark = (this.theory + this.practice) / 2;
        if (this.averageMark > 9.5) this.status = "XUAT SAC";
        else if (this.averageMark >= 8) this.status = "DAT";
        else if (this.averageMark >= 5) this.status = "CAN NHAC";
        else this.status = "TRUOT";
    }

    public static double standardize(double n) {
        if (n > 10) return n / 10;
        return n;
    }

    @Override
    public int compareTo(ThiSinh o) {
        return -Double.compare(this.averageMark, o.averageMark);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", this.id, this.name, this.averageMark, this.status);
    }
}

public class J05013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new ThiSinh(sc.nextLine(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (ThiSinh x : a) System.out.println(x);
        sc.close();
    }
}
tuyen giao vien
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class GiaoVien implements Comparable<GiaoVien> {
    private static int ID = 0;
    private static final String KEY = "GV";
    private String id;
    private String name;
    private double computerMark;
    private double specialMark;
    private String subject;
    private double finalMark;
    private String status;

    public GiaoVien(String name, String admissionId, double computerMark, double specialMark) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.computerMark = computerMark;
        this.specialMark = specialMark;
        switch (admissionId.charAt(0)) {
            case 'A':
                this.subject = "TOAN";
                break;
            case 'B':
                this.subject = "LY";
                break;
            case 'C':
                this.subject = "HOA";
                break;
        }
        double priorityMark = 0;
        switch (admissionId.charAt(1)) {
            case '1':
                priorityMark = 2;
                break;
            case '2':
                priorityMark = 1.5;
                break;
            case '3':
                priorityMark = 1;
                break;
            case '4':
                priorityMark = 0;
                break;
        }
        this.finalMark = computerMark * 2 + specialMark + priorityMark;
        if (this.finalMark >= 18) this.status = "TRUNG TUYEN";
        else this.status = "LOAI";
    }

    @Override
    public int compareTo(GiaoVien o) {
        if (this.finalMark != o.finalMark) return -Double.compare(this.finalMark, o.finalMark);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %s", this.id, this.name, this.subject, this.finalMark, this.status);
    }
}

public class J05014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<GiaoVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new GiaoVien(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (GiaoVien x : a) System.out.println(x);
        sc.close();
    }
}
dua xe dap
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CuaRo implements Comparable<CuaRo> {
    private final SimpleDateFormat formatter = new SimpleDateFormat("h:mm");
    private final Date startTime = formatter.parse("6:00");
    private final int distance = 120;
    private String id;
    private String name;
    private String unit;
    private Date endTime;
    private float speed;

    public CuaRo(String name, String unit, String end) throws ParseException {
        this.name = name;
        this.unit = unit;
        this.id = shortcut(unit) + shortcut(name);
        this.endTime = formatter.parse(end);
        float totalTime = (float) (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60);
        this.speed = distance / totalTime;
    }

    public static String shortcut(String s) {
        String[] tmp = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String x : tmp) ans.append(x.substring(0, 1).toUpperCase());
        return ans.toString();
    }

    @Override
    public int compareTo(CuaRo o) {
        return -Float.compare(this.speed, o.speed);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d Km/h", this.id, this.name, this.unit, Math.round(this.speed));
    }
}

public class J05015 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<CuaRo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new CuaRo(sc.nextLine(), sc.nextLine(), sc.next()));
        }
        Collections.sort(a);
        for (CuaRo x : a) System.out.println(x);
        sc.close();
    }
}
hoa don khach san
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String roomId;
    private Date startDate;
    private Date endDate;
    private int otherPrice;
    private int unitPrice;
    private int amount;
    private int finalPrice;

    public KhachHang(String name, String roomId, String start, String end, int otherPrice) throws ParseException {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.roomId = roomId;
        this.startDate = formatter.parse(start);
        this.endDate = formatter.parse(end);
        this.otherPrice = otherPrice;
        this.amount = (int) ((this.endDate.getTime() - this.startDate.getTime()) / (1000 * 60 * 60 * 24) + 1);
        switch (roomId.charAt(0)) {
            case '1':
                this.unitPrice = 25;
                break;
            case '2':
                this.unitPrice = 34;
                break;
            case '3':
                this.unitPrice = 50;
                break;
            case '4':
                this.unitPrice = 80;
                break;
        }
        this.finalPrice = this.unitPrice * this.amount + this.otherPrice;
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(this.finalPrice, o.finalPrice);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", this.id, this.name, this.roomId, this.amount, this.finalPrice);
    }
}

public class J05016 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new KhachHang(sc.nextLine(), sc.next(), sc.next(), sc.next(), sc.nextInt()));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}
hoa don tien nuoc
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private String id;
    private String name;
    private int startIndex;
    private int endIndex;
    private int finalPrice;

    public KhachHang(String name, int startIndex, int endIndex) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        int amount = endIndex - startIndex;
        double allowance = 0;
        double price = 0;
        if (amount > 100) {
            price = 50 * 100 + 50 * 150 + (amount - 100) * 200;
            allowance = 0.05;
        } else if (amount > 50) {
            price = 50 * 100 + (amount - 50) * 150;
            allowance = 0.03;
        } else {
            price = amount * 100;
            allowance = 0.02;
        }
        this.finalPrice = (int) Math.round(price * (1 + allowance));
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(this.finalPrice, o.finalPrice);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.finalPrice);
    }
}

public class J05017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new KhachHang(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}
luong mua trung binh
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Tram {
    private static int ID = 0;
    private static final String KEY = "T";
    public static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private String id;
    private String name;
    private double hour;
    private int rainfall;

    public Tram(String name, double hour, int rainfall) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.hour = hour;
        this.rainfall = rainfall;
    }

    public String getName() {
        return name;
    }

    public void addTime(double hour) {
        this.hour += hour;
    }

    public void addRainfall(int rainfall) {
        this.rainfall += rainfall;
    }

    public double getAverageRainfall() {
        return this.rainfall / this.hour;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.id, this.name, this.getAverageRainfall());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((Tram) obj).name);
    }
}

public class J05019 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Tram> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            Date startTime = Tram.formatter.parse(sc.next());
            Date endTime = Tram.formatter.parse(sc.next());
            double hour = (double) (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60);
            int rainfall = sc.nextInt();
            boolean kt = false;
            for (Tram x : a)
                if (x.getName().equals(name)) {
                    x.addTime(hour);
                    x.addRainfall(rainfall);
                    kt = true;
                }
            if (!kt) a.add(new Tram(name, hour, rainfall));
        }
        for (Tram x : a) System.out.println(x);
        sc.close();
    }
}
xac dinh danh sach trung tuyen 
import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    private String id;
    private String name;
    private float toan;
    private float ly;
    private float hoa;
    private float bonus;
    private String status;

    public ThiSinh(String id, String name, float toan, float ly, float hoa) {
        this.id = id;
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        switch (id.charAt(2)) {
            case '1':
                this.bonus = 0.5f;
                break;
            case '2':
                this.bonus = 1f;
                break;
            case '3':
                this.bonus = 2.5f;
                break;
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getMark() {
        return this.toan * 2 + this.ly + this.hoa + this.bonus;
    }

    @Override
    public int compareTo(ThiSinh o) {
        return -Float.compare(this.getMark(), o.getMark());
    }

    @Override
    public String toString() {
        return  this.id + " " +
                this.name + " " +
                ((int) this.bonus == this.bonus ? String.format("%d", (int) this.bonus) : String.format("%.1f", this.bonus)) + " " +
                ((int) this.getMark() == this.getMark() ? String.format("%d", (int) this.getMark()) : String.format("%.1f", this.getMark())) + " " +
                this.status;
    }
}

public class J05059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            float toan = sc.nextFloat();
            float ly = sc.nextFloat();
            float hoa = sc.nextFloat();
            a.add(new ThiSinh(id, name, toan, ly, hoa));
        }
        int num = sc.nextInt();
        Collections.sort(a);
        float minMark = a.get(num - 1).getMark();
        System.out.printf("%.1f\n", minMark);
        for (ThiSinh x : a) x.setStatus(x.getMark() >= minMark ? "TRUNG TUYEN" : "TRUOT");
        for (ThiSinh x : a) System.out.println(x);
    }
}
hoc bong sinh vien
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String name;
    private double gpa;
    private int practiceMark;
    private String rank;

    public SinhVien(String name, double gpa, int practiceMark) {
        this.name = name;
        this.gpa = gpa;
        this.practiceMark = practiceMark;
        this.rank = "KHONG";
    }

    public boolean setRank() {
        if (this.gpa >= 3.6 && this.practiceMark >= 90) {
            this.rank = "XUATSAC";
            return true;
        } else if (this.gpa >= 3.2 && this.practiceMark >= 80) {
            this.rank = "GIOI";
            return true;
        } else if (this.gpa >= 2.5 && this.practiceMark >= 70) {
            this.rank = "KHA";
            return true;
        }
        return false;
    }

    public double getGpa() {
        return gpa;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(SinhVien o) {
        return -Double.compare(this.gpa, o.gpa);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.name, this.rank);
    }
}

public class J05062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.nextDouble(), sc.nextInt()));
        }
        ArrayList<SinhVien> b = new ArrayList<>(a);
        Collections.sort(b);
        int i = 0;
        while (m > 0 && i < n) {
            if (b.get(i).setRank()) {
                m--;
                int j = i + 1;
                while (j < n && b.get(j).getGpa() == b.get(i).getGpa()) {
                    b.get(j).setRank();
                    m--;
                    j++;
                }
                i = j;
            }
        }
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
liet ke nhan vien theo nhom
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NhanVien implements Comparable<NhanVien> {
    private String chucVu;
    private String heSoLuong;
    private String id;
    private String name;

    public NhanVien(String idStr, String name) {
        chucVu = idStr.substring(0, 2);
        heSoLuong = idStr.substring(2, 4);
        id = idStr.substring(4);
        this.name = name;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public int compareTo(NhanVien o) {
        if (!heSoLuong.equals(o.heSoLuong)) return -heSoLuong.compareTo(o.heSoLuong);
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, chucVu, id, heSoLuong);
    }
}

public class J05065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        int c = 0;
        int d = 0;
        int e = 0;
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String s = sc.nextLine();
            String idStr = "";
            String name = "";
            for (int j = 0; j < s.length(); ++j)
                if (s.charAt(j) != ' ') idStr += s.charAt(j);
                else {
                    name = s.substring(j + 1);
                    break;
                }
            NhanVien b = new NhanVien(idStr, name);
            if (idStr.contains("GD")) {
                if (c < 1) c++;
                else b.setChucVu("NV");
            } else if (idStr.contains("TP")) {
                if (d < 3) d++;
                else b.setChucVu("NV");
            } else if (idStr.contains("PP")) {
                if (e < 3) e++;
                else b.setChucVu("NV");
            }
            a.add(b);
        }
        Collections.sort(a);
        int m = sc.nextInt();
        while (m-- > 0) {
            String s = sc.next();
            for (NhanVien x : a)
                if (x.getChucVu().equals(s)) System.out.println(x);
            System.out.println();
        }
        sc.close();
    }
}
tim kiem nhan vien theo ten
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NhanVien implements Comparable<NhanVien> {
    private String chucVu;
    private String heSoLuong;
    private String id;
    private String name;

    public NhanVien(String idStr, String name) {
        chucVu = idStr.substring(0, 2);
        heSoLuong = idStr.substring(2, 4);
        id = idStr.substring(4);
        this.name = name.trim();
        int order = Integer.parseInt(id);
        if (chucVu.equals("GD") && order > 1) chucVu = "NV";
        else if ((chucVu.equals("TP") || (chucVu.equals("PP"))) && order > 3) chucVu = "NV";
    }

    public String getName() {
        return name;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public int compareTo(NhanVien o) {
        if (!heSoLuong.equals(o.heSoLuong)) return -heSoLuong.compareTo(o.heSoLuong);
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, chucVu, id, heSoLuong);
    }
}

public class J05066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<NhanVien> a = new ArrayList<>();
        int c = 0;
        int d = 0;
        int e = 0;
        for (int i = 0; i < n; ++i) {
            String s = sc.nextLine().trim();
            String idStr = "";
            String name = "";
            for (int j = 0; j < s.length(); ++j)
                if (s.charAt(j) != ' ') idStr += s.charAt(j);
                else {
                    name = s.substring(j + 1);
                    break;
                }
            NhanVien b = new NhanVien(idStr, name);
            if (idStr.contains("GD")) {
                if (c < 1) c++;
                else b.setChucVu("NV");
            } else if (idStr.contains("TP")) {
                if (d < 3) d++;
                else b.setChucVu("NV");
            } else if (idStr.contains("PP")) {
                if (e < 3) e++;
                else b.setChucVu("NV");
            }
            a.add(b);
        }
        Collections.sort(a);
        int m = sc.nextInt();
        sc.nextLine();
        while (m-- > 0) {
            String s = sc.nextLine().toLowerCase();
            for (NhanVien x : a)
                if (x.getName().toLowerCase().contains(s)) System.out.println(x);
            System.out.println();
        }
        sc.close();
    }
}
tinh cuoc dien thoai co dinh-1
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Tinh {
    private String id;
    private String name;
    private int unitPrice;

    public Tinh(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}

class CuocGoi {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private String thueBao;
    private Tinh tinh;
    private int numOfMinutes;
    private int price;

    public CuocGoi(String thueBao, String start, String end) throws ParseException {
        this.thueBao = thueBao;
        Date startTime = formatter.parse(start);
        Date endTime = formatter.parse(end);
        numOfMinutes = (int) ((endTime.getTime() - startTime.getTime()) / (1000 * 60));
    }

    public void setTinh(Tinh tinh) {
        this.tinh = tinh;
        if (tinh.getName().equals("Noi mang")) numOfMinutes = (int) Math.ceil(numOfMinutes / 3.0);
        price = tinh.getUnitPrice() * numOfMinutes;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", thueBao, tinh.getName(), numOfMinutes, price);
    }
}

public class J05071 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Tinh> a = new ArrayList<>();
        a.add(new Tinh("0", "Noi mang", 800));
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitPrice = sc.nextInt();
            a.add(new Tinh(id, name, unitPrice));
        }
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<CuocGoi> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String[] tmp = sc.nextLine().split("\\s+");
            CuocGoi c = new CuocGoi(tmp[0], tmp[1], tmp[2]);
            if (tmp[0].charAt(0) != '0') c.setTinh(a.get(0));
            else
                for (Tinh x : a)
                    if (x.getId().equals(tmp[0].substring(1, 3))) {
                        c.setTinh(x);
                        break;
                    }
            b.add(c);
        }
        for (CuocGoi x : b) System.out.println(x);
        sc.close();
    }
}
tinh cuoc dien thoai co dinh-2
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class Tinh {
    private String id;
    private String name;
    private int unitPrice;

    public Tinh(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}

class CuocGoi implements Comparable<CuocGoi> {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private String thueBao;
    private Tinh tinh;
    private int numOfMinutes;
    private int price;

    public CuocGoi(String thueBao, String start, String end) throws ParseException {
        this.thueBao = thueBao;
        Date startTime = formatter.parse(start);
        Date endTime = formatter.parse(end);
        numOfMinutes = (int) ((endTime.getTime() - startTime.getTime()) / (1000 * 60));
    }

    public void setTinh(Tinh tinh) {
        this.tinh = tinh;
        if (tinh.getName().equals("Noi mang")) numOfMinutes = (int) Math.ceil(numOfMinutes / 3.0);
        price = tinh.getUnitPrice() * numOfMinutes;
    }

    @Override
    public int compareTo(CuocGoi o) {
        return -Integer.compare(price, o.price);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", thueBao, tinh.getName(), numOfMinutes, price);
    }
}

public class J05072 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Tinh> a = new ArrayList<>();
        a.add(new Tinh("0", "Noi mang", 800));
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitPrice = sc.nextInt();
            a.add(new Tinh(id, name, unitPrice));
        }
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<CuocGoi> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String[] tmp = sc.nextLine().split("\\s+");
            CuocGoi c = new CuocGoi(tmp[0], tmp[1], tmp[2]);
            if (tmp[0].charAt(0) != '0') c.setTinh(a.get(0));
            else
                for (Tinh x : a)
                    if (x.getId().equals(tmp[0].substring(1, 3))) {
                        c.setTinh(x);
                        break;
                    }
            b.add(c);
        }
        Collections.sort(b);
        for (CuocGoi x : b) System.out.println(x);
        sc.close();
    }
}
tinh toan gia ban
import java.util.*;

class DonHang {
    private String id;
    private int unitPrice;
    private int amount;
    private double finalUnitPrice;

    public DonHang(String id, int unitPrice, int amount) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.amount = amount;
        double tax = 0;
        double ship = 0;
        switch (id.charAt(0)) {
            case 'T':
                tax = 0.29;
                ship = 0.04;
                break;
            case 'C':
                tax = 0.1;
                ship = 0.03;
                break;
            case 'D':
                tax = 0.08;
                ship = 0.025;
                break;
            case 'M':
                tax = 0.02;
                ship = 0.005;
                break;
            default:
                tax = 0;
                ship = 0;
                break;
        }
        double discount = 0;
        if (id.charAt(id.length() - 1) == 'C') discount = 0.05;
        double price = (double) unitPrice * amount;
        double taxPrice = price * tax * (1 - discount);
        double shipPrice = price * ship;
        this.finalUnitPrice = (price + taxPrice + shipPrice) * (1 + 0.2) / amount;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.id, this.finalUnitPrice);
    }
}

public class J05073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DonHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new DonHang(sc.next(), sc.nextInt(), sc.nextInt()));
        for (DonHang x : a) System.out.println(x);
        sc.close();
    }
}
tinh luong
import java.util.*;

class PhongBan {
    private String id;
    private String name;

    public PhongBan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class NhanVien {
    private String id;
    private String name;
    private String phongBanId;
    private String phongBanName;
    private int salary;

    public NhanVien(String id, String name, int baseSalary, int numOfWorks) {
        this.id = id;
        this.name = name;
        char group = id.charAt(0);
        int numOfYears = Integer.parseInt(id.substring(1, 3));
        this.phongBanId = id.substring(3);
        int coefficient = 0;
        if (group == 'A') {
            if (numOfYears >= 16) coefficient = 20;
            else if (numOfYears >= 9) coefficient = 14;
            else if (numOfYears >= 4) coefficient = 12;
            else coefficient = 10;
        } else if (group == 'B') {
            if (numOfYears >= 16) coefficient = 16;
            else if (numOfYears >= 9) coefficient = 13;
            else if (numOfYears >= 4) coefficient = 11;
            else coefficient = 10;
        } else if (group == 'C') {
            if (numOfYears >= 16) coefficient = 14;
            else if (numOfYears >= 9) coefficient = 12;
            else if (numOfYears >= 4) coefficient = 10;
            else coefficient = 9;
        } else {
            if (numOfYears >= 16) coefficient = 13;
            else if (numOfYears >= 9) coefficient = 11;
            else if (numOfYears >= 4) coefficient = 9;
            else coefficient = 8;
        }
        this.salary = baseSalary * 1000 * numOfWorks * coefficient;
    }

    public String getPhongBanId() {
        return phongBanId;
    }

    public void setPhongBanName(String phongBanName) {
        this.phongBanName = phongBanName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", this.id, this.name, this.phongBanName, this.salary);
    }
}

public class TN02012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<PhongBan> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            String name = sc.nextLine().trim();
            a.add(new PhongBan(id, name));
        }
        int m = sc.nextInt();
        ArrayList<NhanVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int baseSalary = sc.nextInt();
            int numOfWorks = sc.nextInt();
            b.add(new NhanVien(id, name, baseSalary, numOfWorks));
        }
        for (int i = 0; i < m; ++i) {
            for (PhongBan x : a)
                if (b.get(i).getPhongBanId().equals(x.getId())) b.get(i).setPhongBanName(x.getName());
        }
        for (NhanVien x : b) System.out.println(x);
        sc.close();
    }
}
KHAI BAO LOP
DIEN TICH TAM GIAC
import java.util.*;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

public class J04009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int t=sc.nextInt();
        while(t-->0){
            Point a=new Point(sc.nextDouble(),sc.nextDouble());
            Point b=new Point(sc.nextDouble(),sc.nextDouble());
            Point c=new Point(sc.nextDouble(),sc.nextDouble());
            double d1=a.distance(b);
            double d2=b.distance(c);
            double d3=c.distance(a);
            if (d1+d2>d3&&d2+d3>d1&&d3+d1>d2) System.out.printf("%.2f\n",Math.sqrt(d1+d2+d3)*Math.sqrt(d1+d2-d3)*Math.sqrt(d2+d3-d1)*Math.sqrt(d3+d1-d2)/4);
            else System.out.println("INVALID");
        }
        sc.close();
    }
}
DIEN TICH HINH TRON NGOAI TIEP TAM GIAC
import java.util.*;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

public class J04010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int t=sc.nextInt();
        while(t-->0){
            Point a=new Point(sc.nextDouble(),sc.nextDouble());
            Point b=new Point(sc.nextDouble(),sc.nextDouble());
            Point c=new Point(sc.nextDouble(),sc.nextDouble());
            double d1=a.distance(b);
            double d2=b.distance(c);
            double d3=c.distance(a);
            if (d1+d2>d3&&d2+d3>d1&&d3+d1>d2){
                double r=(d1*d2*d3)/(Math.sqrt(d1+d2+d3)*Math.sqrt(d1+d2-d3)*Math.sqrt(d2+d3-d1)*Math.sqrt(d3+d1-d2));
                System.out.printf("%.3f\n",Math.PI*r*r);
            }
            else System.out.println("INVALID");
        }
        sc.close();
    }
}
BON DIEM TREN MAT PHANG
import java.util.Scanner;

class Vector{
    private int x;
    private int y;
    private int z;

    public Vector(Point3D p1,Point3D p2){
        this.x=(int)p2.getX()-p1.getX();
        this.y=(int)p2.getY()-p1.getY();
        this.z=(int)p2.getZ()-p1.getZ();
    }

    public Vector(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public void setX(int x){
        this.x=x;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getY(){
        return this.y;
    }

    public void setZ(int z){
        this.z=z;
    }

    public int getZ(){
        return this.z;
    }

    public static Vector direction(Vector v1,Vector v2){
        return new Vector(v1.y*v2.z-v1.z*v2.y,v1.z*v2.x-v1.x*v2.z,v1.x*v2.y-v1.y*v2.x);
    }

    public static int undirection(Vector v1,Vector v2){
        return v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
    }
}

class Point3D{
    private short x;
    private short y;
    private short z;

    public Point3D(int x,int y,int z){
        this.x=(short)x;
        this.y=(short)y;
        this.z=(short)z;
    }

    public void setX(short x){
        this.x=x;
    }

    public short getX(){
        return this.x;
    }

    public void setY(short y){
        this.y=y;
    }

    public short getY(){
        return this.y;
    }

    public void setZ(short z){
        this.z=z;
    }

    public short getZ(){
        return this.z;
    }

    public static boolean check(Point3D p1,Point3D p2,Point3D p3,Point3D p4){
        return Vector.undirection(Vector.direction(new Vector(p1,p2),new Vector(p1,p3)),new Vector(p1,p4))==0;
    }
}

public class J04011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        if(Point3D.check(p1,p2,p3,p4)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}
BAI TOAN TINH CONG
import java.util.*;

class NhanVien {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private int baseSalary;
    private int workDay;
    private String position;
    private int salary;
    private int bonus;
    private int allowance;

    public NhanVien(String name, int baseSalary, int workDay, String position) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.baseSalary = baseSalary;
        this.workDay = workDay;
        this.position = position;
        this.salary = this.baseSalary * this.workDay;
        if (workDay>=25) this.bonus=(int)(this.salary*0.2);
        else if (workDay>=22) this.bonus=(int)(this.salary*0.1);
        else this.bonus=0;
        switch (position){
            case "GD":
                this.allowance=250000;
                break;
            case "PGD":
                this.allowance=200000;
                break;
            case "TP":
                this.allowance=180000;
                break;
            case "NV":
                this.allowance=150000;
                break;
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFinalSalary() {
        return this.salary + this.bonus + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d",this.id, this.name, this.salary, this.bonus, this.allowance, this.getFinalSalary());
    }
}

public class J04012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien a=new NhanVien(sc.nextLine(),sc.nextInt(),sc.nextInt(),sc.next());
        System.out.println(a);
        sc.close();
    }
}
BAI TOAN TUYEN SINH
import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    private String id;
    private String name;
    private float toan;
    private float ly;
    private float hoa;
    private float bonus;
    private String status;

    public ThiSinh(String id, String name, float toan, float ly, float hoa) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        switch (id.charAt(2)) {
            case '1':
                this.bonus = 0.5f;
                break;
            case '2':
                this.bonus = 1f;
                break;
            case '3':
                this.bonus = 2.5f;
                break;
            default:
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getMark() {
        return this.toan * 2 + this.ly + this.hoa;
    }

    public float getTotalMark() {
        return this.toan * 2 + this.ly + this.hoa + this.bonus;
    }

    @Override
    public int compareTo(ThiSinh o) {
        return -Float.compare(this.getMark(), o.getMark());
    }

    @Override
    public String toString() {
        return  this.id + " " +
                this.name + " " +
                ((int) this.bonus == this.bonus ? String.format("%d", (int) this.bonus) : String.format("%.1f", this.bonus)) + " " +
                ((int) this.getMark() == this.getMark() ? String.format("%d", (int) this.getMark()) : String.format("%.1f", this.getMark())) + " " +
                this.status;
    }
}

public class J04013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        String id = sc.next();
        sc.nextLine();
        String name = sc.nextLine();
        float toan = sc.nextFloat();
        float ly = sc.nextFloat();
        float hoa = sc.nextFloat();
        ThiSinh a = new ThiSinh(id, name, toan, ly, hoa);
        a.setStatus(a.getTotalMark() >= 24f ? "TRUNG TUYEN" : "TRUOT");
        System.out.println(a);
    }
}
TINH TOAN PHAN SO
import java.util.*;

class PhanSo {
    private long tu;
    private long mau;

    public PhanSo(long tu, long mau) {
        if (mau < 0){
            tu = -tu;
            mau = -mau;
        }
        long x = PhanSo.gcd(tu, mau);
        this.tu = tu / x;
        this.mau = mau / x;
    }

    public long getTu() {
        return tu;
    }

    public void setTu(long tu) {
        this.tu = tu;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public PhanSo add(PhanSo a) {
        long b = this.tu * a.mau + this.mau * a.tu;
        long c = this.mau * a.mau;
        return new PhanSo(b, c);
    }

    public PhanSo multi(PhanSo a) {
        long b = this.tu * a.tu;
        long c = this.mau * a.mau;
        return new PhanSo(b, c);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.tu, this.mau);
    }
}

public class J04014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo c = a.add(b);
            c = c.multi(c);
            PhanSo d = a.multi(b).multi(c);
            System.out.print(c+" ");
            System.out.println(d);
        }
        sc.close();
    }
}
LOP TRIANGLE-1
import java.util.*;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
}

class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public boolean valid() {
        double d1 = p1.distance(p2);
        double d2 = p2.distance(p3);
        double d3 = p3.distance(p1);
        return d1 + d2 > d3 && d2 + d3 > d1 && d3 + d1 > d2;
    }

    public String getPerimeter() {
        double d1 = p1.distance(p2);
        double d2 = p2.distance(p3);
        double d3 = p3.distance(p1);
        return String.format("%.3f", d1 + d2 + d3);
    }
}

public class J04019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
LOP PAIR
import java.io.*;
import java.util.*;

class Pair<X extends Number, Y extends Number> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public void setFirst(X first) {
        this.first = first;
    }

    public Y getSecond() {
        return second;
    }

    public void setSecond(Y second) {
        this.second = second;
    }

    private boolean nto(int x) {
        for (int i = 2; i * i <= x; ++i)
            if (x % i == 0) return false;
        return true;
    }

    public boolean isPrime() {
        return nto((Integer)this.first) && nto((Integer) this.second);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.first, this.second);
    }
}

public class J04020 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean check = false;
            for (int i = 2; i <= 2 * Math.sqrt(n); i++) {
                Pair<Integer, Integer> p = new Pair<>(i, n - i);
                if (p.isPrime()) {
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if (!check) System.out.println(-1);
        }
    }
}
LOP INTSET
import java.util.*;

class IntSet {
    private TreeSet<Integer> a;

    public IntSet(int[] a) {
        this.a = new TreeSet<>();
        for (int i : a) this.a.add(i);
    }

    public IntSet(TreeSet<Integer> a) {
        this.a = a;
    }

    public IntSet union(IntSet x) {
        TreeSet<Integer> y = new TreeSet<>();
        y.addAll(this.a);
        y.addAll(x.a);
        return new IntSet(y);
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer i : this.a) s += (i.toString() + " ");
        return s;
    }
}

public class J04021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
WORDSET
import java.util.*;

class WordSet {
    private TreeSet<String> treeSet;

    public WordSet(TreeSet<String> treeSet) {
        this.treeSet = treeSet;
    }

    public WordSet(String s) {
        this.treeSet = new TreeSet<>();
        String[] tmp = s.trim().toLowerCase().split("\\s+");
        this.treeSet.addAll(Arrays.asList(tmp));
    }

    public WordSet union(WordSet a) {
        TreeSet<String> b = new TreeSet<>();
        b.addAll(this.treeSet);
        b.addAll(a.treeSet);
        return new WordSet(b);
    }

    public WordSet intersection(WordSet a) {
        TreeSet<String> b = new TreeSet<>();
        for (String x : a.treeSet)
            if (this.treeSet.contains(x)) b.add(x);
        return new WordSet(b);
    }

    @Override
    public String toString() {
        String s = "";
        for (String x : this.treeSet) s += (x + " ");
        return s;
    }
}

public class J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
LOP INTSET-2
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class IntSet {
    private TreeSet<Integer> set;

    public IntSet(int[] arr) {
        set = new TreeSet<>();
        for (int x : arr) set.add(x);
    }

    public IntSet() {
        set = new TreeSet<>();
    }

    public IntSet intersection(IntSet o) {
        try {
            IntSet a = new IntSet();
            for (Integer x : set)
                if (o.set.contains(x)) a.set.add(x);
            return a;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer x : set) s += (x + " ");
        return s;
    }
}

public class J07009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
TICH HAI DOI TUONG MA TRAN
import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private ArrayList<ArrayList<Long>> matrix = new ArrayList<>();
    private int n;
    private int m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < this.n; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < this.m; ++j) tmp.add(sc.nextLong());
            this.matrix.add(tmp);
        }
    }

    public Matrix mul(Matrix o) {
        Matrix c = new Matrix(this.n, o.m);
        for (int i = 0; i < this.n; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < o.m; ++j) {
                long sum = 0;
                for (int z = 0; z < this.m; ++z) sum += this.matrix.get(i).get(z) * o.matrix.get(z).get(j);
                tmp.add(sum);
            }
            c.matrix.add(tmp);
        }
        return c;
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        for(int i=0;i<this.n;++i){
            for(int j=0;j<this.m;++j) s.append(this.matrix.get(i).get(j).toString()).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}

public class J04016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        Matrix a = new Matrix(n, m);
        a.nextMatrix(sc);
        Matrix b = new Matrix(m, p);
        b.nextMatrix(sc);
        System.out.println(a.mul(b));
    }
}
TICH MA TRAN VA CHUYEN VI CUA NO
import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private ArrayList<ArrayList<Long>> matrix = new ArrayList<>();
    private int n;
    private int m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < this.n; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < this.m; ++j) tmp.add(sc.nextLong());
            this.matrix.add(tmp);
        }
    }

    public Matrix trans() {
        Matrix c = new Matrix(this.m, this.n);
        for (int i = 0; i < this.m; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < this.n; ++j) tmp.add(this.matrix.get(j).get(i));
            c.matrix.add(tmp);
        }
        return c;
    }

    public Matrix mul(Matrix o) {
        Matrix c = new Matrix(this.n, o.m);
        for (int i = 0; i < this.n; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < o.m; ++j) {
                long sum = 0;
                for (int z = 0; z < this.m; ++z) sum += this.matrix.get(i).get(z) * o.matrix.get(z).get(j);
                tmp.add(sum);
            }
            c.matrix.add(tmp);
        }
        return c;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.m; ++j) s.append(this.matrix.get(i).get(j).toString()).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}

public class J04017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Matrix a = new Matrix(n, m);
            a.nextMatrix(sc);
            Matrix b = a.trans();
            System.out.println(a.mul(b));
        }
    }
}
TONG DA THUC
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DonThuc implements Comparable<DonThuc> {
    private final Pattern pattern = Pattern.compile("(\\d+)\\*x\\^(\\d+)");
    private int heSo;
    private int soMu;

    public DonThuc(int heSo, int soMu) {
        this.heSo = heSo;
        this.soMu = soMu;
    }

    public DonThuc(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            this.heSo = Integer.parseInt(matcher.group(1));
            this.soMu = Integer.parseInt(matcher.group(2));
        }
    }

    public int getHeSo() {
        return heSo;
    }

    public int getSoMu() {
        return soMu;
    }

    @Override
    public String toString() {
        return String.format("%d*x^%d", this.heSo, this.soMu);
    }

    @Override
    public int compareTo(DonThuc o) {
        return -Integer.compare(this.soMu, o.soMu);
    }
}

class DaThuc {
    private ArrayList<DonThuc> daThuc;

    public DaThuc(String str) {
        this.daThuc = new ArrayList<>();
        String[] tmp = str.split("\\s\\+\\s");
        for (int i = 0; i < tmp.length; ++i) this.daThuc.add(new DonThuc(tmp[i]));
    }

    public DaThuc(ArrayList<DonThuc> donThucs) {
        Collections.sort(donThucs);
        this.daThuc = donThucs;
    }

    public DaThuc cong(DaThuc o) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (DonThuc x : this.daThuc) hashMap.put(x.getSoMu(), hashMap.getOrDefault(x.getSoMu(), 0) + x.getHeSo());
        for (DonThuc x : o.daThuc) hashMap.put(x.getSoMu(), hashMap.getOrDefault(x.getSoMu(), 0) + x.getHeSo());
        ArrayList<DonThuc> donThucs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : hashMap.entrySet()) donThucs.add(new DonThuc(x.getValue(), x.getKey()));
        return new DaThuc(donThucs);
    }

    @Override
    public String toString() {
        String s = this.daThuc.get(0).toString();
        for (int i = 1; i < this.daThuc.size(); ++i) s += String.format(" + %s", this.daThuc.get(i).toString());
        return s;
    }
}

public class J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}
JAVA COLLECTION
TIM TU THUAN NGHICH DAI NHAT
import java.util.*;

public class J08010 {
    public static boolean res(String s){
        for(int i=0;i<s.length()/2;++i)
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> a=new LinkedHashMap<>();
        while(sc.hasNextLine()){
            String[] b=sc.nextLine().split("\\s+");
            for(String x:b)
                if (res(x)){
                    if (a.containsKey(x)) a.put(x,a.get(x)+1);
                    else a.put(x,1);
                }
            }
        int cnt=0;
        for(String x:a.keySet()) cnt=Math.max(cnt,x.length());
        for(String x:a.keySet())
            if (cnt==x.length()) System.out.printf("%s %d\n",x,a.get(x));
        sc.close();
    }
}
LIET KE VA DEM
import java.util.*;

public class J08011 {
    public static boolean res(String s){
        for(int i=0;i<s.length()-1;++i)
            if (s.charAt(i)>s.charAt(i+1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> a=new LinkedHashMap<>();
        while(sc.hasNext()){
            String s=sc.next();
            if (res(s)){
                if (a.containsKey(s)) a.put(s,a.get(s)+1);
                else a.put(s,1);
            }
        }
        ArrayList<Map.Entry<String,Integer>> b=new ArrayList<>(a.entrySet());
        Comparator<Map.Entry<String,Integer>> c=new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                return -o1.getValue().compareTo(o2.getValue());
            }
        };
        b.sort(c);
        for(Map.Entry<String,Integer> x:b) System.out.printf("%s %d\n",x.getKey(),x.getValue());
        sc.close();
    }
}
QUAY HINH VUONG
import java.util.*;

class Pair{
    public String first;
    public Integer second;

    Pair(String first,Integer second){
        this.first=first;
        this.second=second;
    }
}

public class J08025 {
    public static int[] l={3,0,2,4,1,5};
    public static int[] r={0,4,1,3,5,2};

    public static String left(String s){
        String ans="";
        for(int i=0;i<6;++i) ans+=s.charAt(l[i]);
        return ans;
    }

    public static String right(String s){
        String ans="";
        for(int i=0;i<6;++i) ans+=s.charAt(r[i]);
        return ans;
    }

    public static int bfs(String a,String b){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(a,0));
        HashSet<String> c=new HashSet<>();
        c.add(a);
        while(!q.isEmpty()){
            Pair x=q.remove();
            if (x.first.equals(b)) return x.second;
            String y=left(x.first);
            if (!c.contains(y)){
                q.offer(new Pair(y,x.second+1));
                c.add(y);
            }
            y=right(x.first);
            if (!c.contains(y)){
                q.offer(new Pair(y,x.second+1));
                c.add(y);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a="";
            for(int i=0;i<6;++i) a+=Integer.toString(sc.nextInt());
            String b="";
            for(int i=0;i<6;++i) b+=Integer.toString(sc.nextInt());
            System.out.println(bfs(a,b));
        }
        sc.close();
    }
}
BIEN DOI S-T
import java.util.*;

class Pair{
    public int first;
    public int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

public class J08026 {
    public static int bfs(int a,int b){
        Queue<Pair> q=new LinkedList<>();
        TreeSet<Integer> c=new TreeSet<>();
        q.offer(new Pair(a,0));
        c.add(a);
        while(!q.isEmpty()){
            Pair x=q.remove();
            if (x.first==b) return x.second;
            if (x.first<b&&!c.contains(x.first*2)){
                q.offer(new Pair(x.first*2,x.second+1));
                c.add(x.first*2);
            }
            if (x.first>1&&!c.contains(x.first-1)){
                q.offer(new Pair(x.first-1,x.second+1));
                c.add(x.first-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(bfs(a,b));
        }
        sc.close();
    }
}
GO BAN PHIM
import java.util.Scanner;
import java.util.Stack;

public class J08027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        for(int i=0;i<s.length();++i)
            if (s.charAt(i)=='-'){
                if (!s1.isEmpty()) s1.pop();
            }
            else if (s.charAt(i)=='<'){
                if (!s1.isEmpty()){
                    s2.push(s1.peek());
                    s1.pop();
                }
            }
            else if (s.charAt(i)=='>'){
                if (!s2.isEmpty()){
                    s1.push(s2.peek());
                    s2.pop();
                }
            }
            else s1.push(s.charAt(i));
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }
        while(!s2.isEmpty()){
            System.out.print(s2.peek());
            s2.pop();
        }
        sc.close();
    }
}
HINH CHU NHAT DON SAC
import java.util.*;

public class J08028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;++i){
            a[i]=sc.nextInt();
            b[i]=m-a[i];
        }
        Stack<Integer> s=new Stack<>();
        int[] l=new int[n];
        for(int i=0;i<n;++i){
            while(!s.isEmpty()&&a[i]<=a[s.peek()]) s.pop();
            if (s.isEmpty()) l[i]=0;
            else l[i]=s.peek()+1;
            s.add(i);
        }
        s=new Stack<>();
        int[] r=new int[n];
        for(int i=n-1;i>=0;--i){
            while(!s.isEmpty()&&a[i]<=a[s.peek()]) s.pop();
            if (s.isEmpty()) r[i]=n-1;
            else r[i]=s.peek()-1;
            s.add(i);
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<n;++i) ans=Math.max(ans,(long)a[i]*(r[i]-l[i]+1));
        s=new Stack<>();
        for(int i=0;i<n;++i){
            while(!s.isEmpty()&&b[i]<=b[s.peek()]) s.pop();
            if (s.isEmpty()) l[i]=0;
            else l[i]=s.peek()+1;
            s.add(i);
        }
        s=new Stack<>();
        for(int i=n-1;i>=0;--i){
            while(!s.isEmpty()&&b[i]<=b[s.peek()]) s.pop();
            if (s.isEmpty()) r[i]=n-1;
            else r[i]=s.peek()-1;
            s.add(i);
        }
        for(int i=0;i<n;++i) ans=Math.max(ans,(long)b[i]*(r[i]-l[i]+1));
        System.out.println(ans);
        sc.close();
    }
}
QUAN MA
import java.util.*;

class Triple{
    public int first;
    public int second;
    public int third;

    Triple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

public class J08029 {
    public static int[] dx={-2,-1,1,2,2,1,-1,-2};
    public static int[] dy={1,2,2,1,-1,-2,-2,-1};

    public static int bfs(int a,int b,int c,int d){
        Queue<Triple> q=new LinkedList<>();
        q.offer(new Triple(a,b,0));
        boolean[][] e=new boolean[9][9];
        e[a][b]=true;
        while(!q.isEmpty()){
            Triple x=q.remove();
            if (x.first==c&&x.second==d) return x.third;
            for(int i=0;i<8;++i){
                int u=x.first+dx[i];
                int v=x.second+dy[i];
                if (u>=1&&u<=8&&v>=1&&v<=8&&!e[u][v]){
                    q.offer(new Triple(u,v,x.third+1));
                    e[u][v]=true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String s;
        while(t-->0){
            s=sc.next();
            int a=s.charAt(0)-'a'+1;
            int b=s.charAt(1)-'0';
            s=sc.next();
            int c=s.charAt(0)-'a'+1;
            int d=s.charAt(1)-'0';
            System.out.println(bfs(a,b,c,d));
        }
        sc.close();
    }
}
HINH CHU NHAT LON NHAT
import java.util.*;

public class J08023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Stack<Integer> s=new Stack<>();
            int[] l=new int[n];
            for(int i=0;i<n;++i){
                while(!s.isEmpty()&&a[i]<=a[s.peek()]) s.pop();
                if (s.isEmpty()) l[i]=0;
                else l[i]=s.peek()+1;
                s.add(i);
            }
            s=new Stack<>();
            int[] r=new int[n];
            for(int i=n-1;i>=0;--i){
                while(!s.isEmpty()&&a[i]<=a[s.peek()]) s.pop();
                if (s.isEmpty()) r[i]=n-1;
                else r[i]=s.peek()-1;
                s.add(i);
            }
            long ans=Long.MIN_VALUE;
            for(int i=0;i<n;++i) ans=Math.max(ans,(long)a[i]*(r[i]-l[i]+1));
            System.out.println(ans);
        }
        sc.close();
    }
}

 */