/**
Restore IP Addresses

25525511135

255.255.111.35
255.255.11.135

1. DFS
2. I will build a list of list of blocks containing the ip addresses like 255 is a block, 35 is a block
3. I will use a tmp list to fill up the digits and when the list size is 4, and all the digits of the input string are consumed I add it to result
3. If when the tmp list is filled and still the input digits are not consumed we escape
4. There must be at least 4 digits to create the ip addresses: This we can check by adding the tmp list size with remaining characters in the input, which should not be less than 4.
5. Loop the input string 1,2,3 to create all the combinations.

**/

void dfs(ArrayList<ArrayList<String>> result, String str, int start, ArrayList<String> tmpList)
{
    if (tmpList.size() >= 4 && start != str.length())
        return;

    if ((tmpList.size() + str.length() - start + 1) < 4)
        return;

    if (tmpList.size() == 4 && start == str.length()) {
        ArrayList<String> tmp = new ArrayList<>(tmpList);
        result.add(tmp);
        return;
    }

    for (int i = 1; i <= 3; i++) {
        if (start + i > str.length())
            break;

        String sub = str.substring(start, start + i);

		// process things like 001
        if (i > 1 && sub.charAt(0) == '0')
            break;

		// greater than 255 not accepted
        if (Integer.valueOf(sub) > 255)
            break;


        tmpList.add(sub);
        dfs(result, str, start + i, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }
}


