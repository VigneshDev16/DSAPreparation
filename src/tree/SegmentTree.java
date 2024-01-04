package tree;

public class SegmentTree {
    private class Node{
        int data;
        Node right;
        Node left;
        int startInterval;
        int endInterval;

        public Node (int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if(start == end){
            Node node = new Node(start,end);
            node.data = arr[start];
            return node;
        }
        
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);
        
        node.data = node.left.data + node.right.data;
        
        return node;
    }

    public void display(){
        display(root,0);
    }
    private void display(Node node, int level){
        if(node == null){
            return;
        }

        display(node.right,level+1);
        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+node.data+'('+node.startInterval+','+node.endInterval+')');
        }else{
            System.out.println(node.data+"("+node.startInterval+","+node.endInterval+")");
        }
        display(node.left,level+1);
    }

    public int sumRange(int start, int end){
        return sumRange(root,start,end);
    }

    //query
    private int sumRange(Node node, int start, int end) {
        if(node.endInterval < start || end < node.startInterval){
            return 0;
        }
        else if(node.startInterval >= start && node.endInterval <= end){
            return node.data;
        }else{
            return sumRange(node.left,start,end) + sumRange(node.right,start,end);
        }
    }

    public void update(int index,int value){
        root.data = update(root,index,value);
    }

    private int update(Node node, int index, int value) {
        if(node.startInterval == index && node.endInterval == index){
            node.data = value;
            return node.data;
        }
        if(node.startInterval <= index && node.endInterval >= index){
            node.data = update(node.left,index,value) + update(node.right,index,value);
            return node.data;
        }

        return node.data;
    }

}
