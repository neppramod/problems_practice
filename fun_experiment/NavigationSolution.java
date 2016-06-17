import java.util.*;

public class NavigationSolution
{
    public static class NavigationItem  {
        public String url;
        public String label;
        public List<NavigationItem> children;
    }
    
    public void navigate(NavigationItem root)
    {
        navigate(root, 0);
    }

    private void navigate(NavigationItem cur, int level)
    {
        if (cur == null) {
            return;
        } 

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(cur.label);

        if (cur.children != null) {
            for (NavigationItem it : cur.children) {         
                navigate(it, level+1);
            }
        }

    }

    public static void main(String[] args)
    {
        NavigationItem a = new NavigationItem();
        a.label = "A";

        NavigationItem b = new NavigationItem();
        b.label = "B";

        NavigationItem c = new NavigationItem();
        c.label = "C";

        NavigationItem d = new NavigationItem();
        d.label = "D";


        NavigationItem e = new NavigationItem();
        e.label = "E";


        NavigationItem f = new NavigationItem();
        f.label = "F";


        NavigationItem g = new NavigationItem();
        g.label = "G";


        NavigationItem h = new NavigationItem();
        h.label = "H";

        a.children = new ArrayList<>();
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);

        b.children = new ArrayList<>();
        b.children.add(e);
        b.children.add(f);

        e.children = new ArrayList<>();
        e.children.add(h);

        c.children = new ArrayList<>();
        c.children.add(g);

        NavigationSolution ns = new NavigationSolution();
        ns.navigate(a);
    }
}
