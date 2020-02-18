import java.util.*;

/*
A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.



Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation:
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation:
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation:
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".


Note:

1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
All strings consists only of lower and upper case English letters.
 */

public class Solution
{
    static final int MAX = 512;

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        //TrieNode root = new TrieNode();
        //for (String query : queries) {
        //    insert(root, query);
        //}

        List<Boolean> list = new ArrayList<>();
        for (String query : queries) {
            if (isValid( query, pattern)) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> result = camelMatch(queries, pattern);
        System.out.println(result);
    }

    static boolean isValid(String query, String pattern) {
        //if (root == null) {
        //    return false;
        //}

        for (char ch : query.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (pattern.length() == 0 || (ch != pattern.charAt(0))) {
                    return false;
                } else {
                    pattern = pattern.substring(1);
                }
            } else {
                if (pattern.length() > 0 && pattern.charAt(0) == ch) {
                    pattern = pattern.substring(1);
                }
            }
        }

        return pattern.length() == 0;


    }

    static void insert(TrieNode root, String query)
    {
        TrieNode node = root;
        for (char ch : query.toCharArray()) {
            int chInd = ch - 'A';
            if (node.child[chInd] == null) {
                node.child[chInd] = new TrieNode();
            }

            node = node.child[chInd];
        }

        node.isLeaf = true;
    }

    static class TrieNode
    {
        TrieNode[] child = new TrieNode[MAX];
        boolean isLeaf = false;
    }
}
