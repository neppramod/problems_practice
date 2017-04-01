import java.util.*;
import java.text.*;
import javax.script.*;  // Nashorn javascript engine

// - 33.0

public class Solution
{
    public static void main(String[] args) {
        try {
        ScriptEngine se = new ScriptEngineManager().getEngineByName("nashorn"); // or "javascript"
        String expression = "3 + (8 - 7.5) * 10 / 5 - (2 + 5 * 7)";
        System.out.println(se.eval(expression));
        } catch (ScriptException ex) { ex.printStackTrace();}
    }
}
