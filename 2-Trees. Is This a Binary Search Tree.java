/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkSubtree(Node root, int min, int max) {
        boolean result = true;

        if (root.left != null) {
            result = result && (root.left.data < root.data) && checkSubtree(root.left, min, root.data);
            if (min != -1) {
                result = result && (root.left.data > min);
            }
        }
        if (root.right != null) {
            result = result && (root.right.data > root.data) && checkSubtree(root.right, root.data, max);
            if (max != -1) {
                result = result && (root.right.data < max);
            }
        }

        return result;
    }

    boolean checkBST(Node root) {
        return checkSubtree(root, -1, -1);
    }
