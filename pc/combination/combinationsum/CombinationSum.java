import java.util.*;

public class CombinationSum
{

public List<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(num == null || num.length == 0)
        return result;
 
    Arrays.sort(num);            
 
    ArrayList<Integer> temp = new ArrayList<Integer>();    
    //getCombination(num, 0, target, temp, result);
    dfs(num, 0, target, temp, result);
 
    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);
 
    //remove duplicate lists
    result.clear();
    result.addAll(set);
 
    return result;
}



    public void dfs(int[] num, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result)
    {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = start; i < num.length; i++) {
            
            if ((target - num[i]) < 0) break;
            temp.add(num[i]);
            // dfs(num, i, target-num[i], temp, result); //same number used twice
            dfs(num, i+1, target-num[i], temp, result); //same number not used twice
            temp.remove(temp.size() - 1);
        }
    }
    
 
public void getCombination(int[] num, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
    if(target == 0){
        ArrayList<Integer> t = new ArrayList<Integer>(temp);
        result.add(t);
        return;
    }
 
    for(int i=start; i<num.length; i++){
        if(target < num[i])
            continue;
 
        temp.add(num[i]);
        getCombination(num, i+1, target-num[i], temp, result);
        temp.remove(temp.size()-1);
    }
}
    public static void main(String[] args)
    {
        int[] C = {1,3,4,7,6};
        CombinationSum cs = new CombinationSum();

        for (ArrayList<Integer> res : cs.combinationSum2(C, 10)) {
            System.out.println(res);
        }
    }
}
