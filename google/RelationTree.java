import java.util.*;

/**
 * Given you the sets of relations in the aspect of the tree.
 * Each tree node can have multiple children.
 * Example:
 *
 * ----
 * input.add(new Relation("animal", "mammal"));
 * input.add(new Relation("animal", "bird"));
 * input.add(new Relation("lifeform", "animal"));
 * input.add(new Relation("cat", "lion"));
 * input.add(new Relation("mammal", "cat"));
 * input.add(new Relation("animal", "fish"));
 *
 * Expected output:
 * lifeform
 *      animal
 *          mammal
 *              cat
 *                  lion
 *          bird
 *          lion
 */
public class RelationTree {

    private static class Relation{
        public String parent;
        public String child;
        public Relation(String parent, String child){
            this.parent = parent;
            this.child = child;
        }
    }

    private static void print(HashMap<String, LinkedList<String>> map, String node, int level){
        for(int i = 0; i < level; i ++) System.out.print(" ");
        System.out.println(node);

        LinkedList<String> children = map.getOrDefault(node, null);
        if(children != null)
            for(String child: children){
                print(map, child, level + 1);
            }

    }

    private static void solve(List<Relation> relations){
        HashMap<String, LinkedList<String>> nodeMap = new HashMap<>();
        String root = "";

        for(Relation relation: relations){
            LinkedList<String> childrenList = nodeMap.getOrDefault(relation.parent, new LinkedList<String>());
            childrenList.add(relation.child);
            nodeMap.put(relation.parent, childrenList);

            if(root.isEmpty())
                root = relation.parent;
            else if(relation.child.equals(root))
                root = relation.parent;
        }

        // print out
        print(nodeMap, root, 0);
    }

    public static void main(String[] args) {
        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation("animal", "mammal"));
        relations.add(new Relation("animal", "bird"));
        relations.add(new Relation("lifeform", "animal"));
        relations.add(new Relation("cat", "lion"));
        relations.add(new Relation("mammal", "cat"));
        relations.add(new Relation("animal", "fish"));

        solve(relations);
    }
}
