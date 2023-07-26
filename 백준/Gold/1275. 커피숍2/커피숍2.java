import java.io.*;

public class Main {

	static int n;
	static int q;
	static int offset;
	static StringBuilder sb;
	static long[] idxtree;
	static int x,y,a;
	static long b;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	String[] strings = br.readLine().split(" ");
    	n = Integer.valueOf(strings[0]);
    	q = Integer.valueOf(strings[1]);

    	offset = 1;
    	
		for(offset =1; offset<n; offset *=2) {
		}
		
		//인덱스드트리 크기 측정 선언
		idxtree = new long[offset*2+2]; 
		String[] idxarr = br.readLine().split(" ");
		//인덱스드트리에 값 넣기
    	for(int i=0; i<n; i++) {
    		idxtree[offset+i] = Long.parseLong(idxarr[i]);
    	}
    	
    	//구간합 데이터 만들기
    	for(int i=offset-1; i>=1; i--) {
    		idxtree[i] = idxtree[i*2] + idxtree[i*2+1];
    	}
    	
    	for(int i =0; i<q; i++) {
    		String[] strarr = br.readLine().split(" ");
    		x = Integer.valueOf(strarr[0]);
    		y = Integer.valueOf(strarr[1]);
    		a = Integer.valueOf(strarr[2]);
    		b = Long.valueOf(strarr[3]);	
    		sum(x,y);
    		update(a, b);	
    	}
    	System.out.println(sb);
    }
    
    static void update(int id,long value) {
		int x = (int)(offset+id-1);
		idxtree[x] = value;
		while(x>1) {
			x /=2;
			idxtree[x] = idxtree[x*2] + idxtree[x*2+1];
		}
    }
    
    static void sum(int x, int y) {
    	int start;
    	int end;
    	if(x>y) {
    		start = y;
    		end = x;
    	}
    	else {
    		start = x;
    		end = y;
    	}
		int l = start+offset-1;
		int r = end+offset-1;
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