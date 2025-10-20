public class Singli_Linked_list {
    

        Node head;

        public void insert(int data){
            Node node = new Node();
            node.data = data;
            node.next = null;

            if(head == null){
                head = node;

            }else{
                Node n = head;
                while(n.next != null){
                    n = n.next;
                }

                n.next = node;

            }
            
        }

        public void show(){
            Node node = head;
            while(node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }

        public void insertAtStart(int data){
            Node node = new Node();
            node.data = data;
            //node.next = null;
            node.next = head;
            head = node;



        }



        public void insertAt(int index, int data){
            Node node = new Node();
            node.data = data;
            node.next = null;
            if(index == 0){
                insertAtStart(data);
            }else{
                Node n = head;
                for(int i = 0; i < index - 1; i++){
                    n = n.next;
                }
                node.next = n.next;
                n.next = node;
            }
            System.out.println("Inserted at index " + index);
        }

        public void deleteAt(int index){
            if(index == 0){
                head = head.next;
            }

            else{
                Node n = head;
                Node n1 = null;

                for(int i = 0; i < index - 1; i++){
                    n = n.next;
                }
                n1 = n.next;
                n.next = n1.next;
                System.out.println("Deleted at index " + index);
            }
        }

}
