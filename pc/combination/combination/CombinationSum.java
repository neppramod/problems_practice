import java.util.*;
public class CombinationSum
{
public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    dfs(result, 1, n, list, k);
    return result;
}
 
public void dfs1(List<List<Integer>> result, int start, int sum, List<Integer> list, int k){
    if(sum==0 && list.size()==k){
        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(list);
        result.add(temp);
    }
 
    for(int i=start; i<=9; i++){
        if(sum-i<0) break;
        if(list.size()>k) break;
 
        list.add(i);
        dfs1(result, i+1, sum-i, list, k);
        list.remove(list.size()-1);
    }
}


    public void dfs(List<List<Integer>> result, int start, int n, List<Integer> temp, int k){
        if (temp.size() == k && sum(temp) == n) {
            result.add(new ArrayList<Integer>(temp));
        }

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(result, i+1, n, temp, k);
            temp.remove(temp.size() - 1);
        }
    }

    int sum(List<Integer> numbers)
    {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        CombinationSum cs = new CombinationSum();        
        for (List list : cs.combinationSum3(3, 9)) {
            System.out.println(list);
        }
    }
}
