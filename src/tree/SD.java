package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SD {
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serialize(list,root);
        return list.toString().replace("[","").replace("]","");;
    }

    private void serialize(List<String> list, TreeNode node) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));
        serialize( list,node.left);
        serialize(list,node.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<String>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        String s = list.remove(list.size()-1);
        if(s.contains("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s.trim()));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
