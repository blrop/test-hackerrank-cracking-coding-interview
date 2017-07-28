/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkLeftSubtree(Node root, int max) {
        boolean result = true;

        if (root.left != null) {
            result = (root.left.data < root.data) && checkLeftSubtree(root.left, root.data);
        }
        if (root.right != null) {
            int min = root.data;
            result = result && (root.right.data > root.data) && (root.right.data < max) && checkRightSubtree(root.right, min);
        }

        return result;
    }

    boolean checkRightSubtree(Node root, int min) {
        boolean result = true;

        if (root.left != null) {
            int max = root.data;
            result = (root.left.data < root.data) && (root.left.data > min) && checkLeftSubtree(root.left, max);
        }
        if (root.right != null) {
            result = result && (root.right.data > root.data) && checkRightSubtree(root.right, root.data);
        }

        return result;
    }

    boolean checkBST(Node root) {
        boolean result = true;

        if (root.left != null) {
            result = checkLeftSubtree(root.left, root.data);
        }
        if (root.right != null) {
            result = result && checkRightSubtree(root.right, root.data);
        }

        return result;
    }
