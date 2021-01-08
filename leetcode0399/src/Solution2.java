import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len=values.length;
        HashMap<String,Integer> map=new HashMap<>();
        int index=0;
        for(int i=0;i<len;i++) {
            String s1=equations.get(i).get(0);
            String s2=equations.get(i).get(1);
            if(!map.containsKey(s1)) map.put(s1,index++);
            if(!map.containsKey(s2)) map.put(s2,index++);
        }
        UF1 uf=new UF1(index);
        for(int i=0;i<len;i++) {
            String s1=equations.get(i).get(0);
            String s2=equations.get(i).get(1);
            uf.union(map.get(s1),map.get(s2), values[i]);
        }
        int num=queries.size();
        double[] res=new double[num];
        for(int i=0;i<num;i++) {
            String s1=queries.get(i).get(0);
            String s2=queries.get(i).get(1);
            if(s1.equals(s2))
                res[i]=1;
            if(!map.containsKey(s1)||!map.containsKey(s2))
                res[i]=-1;
            else {
                int k1=map.get(s1);
                int k2=map.get(s2);
                if(uf.find(k1)==uf.find(k2))
                    res[i]=uf.v[k1]/uf.v[k2];
                else
                    res[i]=-1;
            }
        }
        return res;
    }
}

class UF1 {
    public int[] p;
    public double[] v;
    public UF1(int n) {
        p=new int[n];
        v=new double[n];
        for(int i=0;i<n;i++) {
            p[i]=i;
            v[i]=1;
        }
    }

    public int find(int x) {
        if(p[x]!=x) {
            int fa=p[x];
            p[x]=find(p[x]);
            v[x]=v[x]*v[fa];
        }
        return p[x];
    }
    public void union(int x, int y,double value) {
        int p1=find(x);
        int p2=find(y);
        if(p1!=p2) {
            v[p1]=v[y]/v[x]*value;
            p[p1]=p2;
        }
    }
}
