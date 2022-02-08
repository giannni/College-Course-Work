public class Application
{
    public static void main()
    {
        BTree<String, String> st = new BTree<>();
        //course number, name, ranking
        st.put("CS 230", "Gaming");
        st.put("CS 350", "Data Structures & Algorithm Analysis");
        st.put("CS 300", "Computational Architecture");
        st.put("CS 150", "Computer Science 1");
        st.put("ENG 201", "Wrt Brit Lit:Passion & Tragedy");
        st.put("ENG 203", "Wrtg Abt Amer Lit True Crime");
        st.put("CS 250", "Computer & Info Science II");
        st.put("ENG 102", "Intermediate Composition");
        st.put("HIST 122", "Modern Europe Since 1848");
        st.put("HIST 102", "Hist of the United States II");
        //search and display the three nodes with highest rank
        System.out.println(("CS 230: ") + st.get("CS 230"));
        System.out.println(("CS 350: ") + st.get("CS 350"));
        System.out.println(("CS 300: ") + st.get("CS 300"));
        //output tree
        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
    }
}
