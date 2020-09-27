package countdown;

class List {

    private static Node root;

    static void createCircle(int N){

        root = new Node(1);
        Node current = root;

        for(int k = 2; k <= N; k++){

            Node temp = new Node(k);
            current.next = temp;
            temp.previous = current;
            current = current.next;
        }
        current.next = root;
        root.previous = current;
    }

    static int deleteEveryK(int K){

        int i = 1;
        while(root.next != root){

            if(i == K){
//                printDeletedIndex(root);
                deleteNode(root);
                root = root.next;
                i = 1;

            }else{
                root = root.next;
                i++;
            }
        }
        return root.k;
    }

    private static void deleteNode(Node current){

        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

//    static void printDeletedIndex(Node current){
//
//        System.out.println("deleted person index - " + current.k);
//    }

    static class Node {

        int k;
        Node next;
        Node previous;

        Node(int k){

            this.k = k;
            next = null;
            previous = null;
        }
    }
}
