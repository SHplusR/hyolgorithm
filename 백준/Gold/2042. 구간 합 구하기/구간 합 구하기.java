import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	String[] strings = br.readLine().split(" ");
    	int n = Integer.valueOf(strings[0]);
    	int m = Integer.valueOf(strings[1]);
    	int k = Integer.valueOf(strings[2]);
    	int offset = 1;
    	
		for(offset =1; offset<n; offset *=2) {
		}
		long[]idxtree = new long[offset*2+2]; 
		
    	for(int i=0; i<n; i++) {
    		idxtree[offset+i] = Long.parseLong(br.readLine());
    	}
    	
    	for(int i=offset-1; i>=1; i--) {
    		idxtree[i] = idxtree[i*2] + idxtree[i*2+1];
    	}
    	
    	for(int i =0; i<m+k; i++) {
    		String[] strarr = br.readLine().split(" ");
    		int a = Integer.valueOf(strarr[0]);
    		int b = Integer.valueOf(strarr[1]);
    		long c = Long.valueOf(strarr[2]);
    		if(a == 1) {
    			int x = (int)(offset+b-1);
    			idxtree[x] = c;
    			while(x>1) {
    				x /=2;
    				idxtree[x] = idxtree[x*2] + idxtree[x*2+1];
    			}
    		}
    		else {
    			int l = (int)b+offset-1;
    			int r = (int)c+offset-1;
    			long ret = 0;
    			while(l <=r) {
    				if((l&1) == 1) {ret+= idxtree[l++];}
    				if((r&1) == 0) {ret+= idxtree[r--];}
    				l /=2;
    				r /=2;
    			}
    			sb.append(ret+"\n");
    		}
    	}
    	System.out.println(sb);
    }
}