class Node<T>{
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
    }
}

public class LinkedListImpl<T> {

    public static void main(String[] args) {
        
        LinkedListImpl<Integer> list = new LinkedListImpl<>();

        //Add element in List
        for(int i=0;i < 10;i++){
            list.add(i+1);
        }

        //fetch one element from list
        System.out.println(list.get(51) +" fetch from list");

        //delete 5 from list
        System.out.println("Deleted -> "+list.delete(1));

        //print list
        Node<Integer> h1 = list.head;
        while(h1 != null){
            System.out.print(h1.data+" -> ");
            h1 = h1.next;
        }

    }

    //Important datatype for LinkedList
    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedListImpl(){
        head = null;
        tail = null;
        size=0;
    }

    // Addition of elements in LinkedList
    private void add(T data) {
        Node<T> newNode = new Node<>(data);

        // If list is empty
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    //Deletion
    public T delete(T data){
        if(size == 0){
            return null;
        }else{
            Node<T> tmp = head;
            Node<T> prev = null;
            while(tmp != null){
                if(tmp.data.equals(data)){

                    if(prev == null){
                        //when elem is at front of list execution will come here
                        prev = tmp.next;
                        head = prev;    
                        tmp.next = null;    //making tmp object eligible for garbage collection
                    }else if(tmp.next == null){
                        //when elem is at end of list execution will come here
                        prev.next = null;
                        tail = prev;
                    }else{
                        prev.next = tmp.next;
                        tmp.next = null;    //making tmp object eligible for garbage collection
                        return tmp.data;
                    }

                    return tmp.data;
                }
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return null;
    }

    //get
    private T get(T data){
        if(size == 0){
            return null;
        }else{
            Node<T> temp = head;

            while(temp != null){
                if(temp.data.equals(data)){
                    return temp.data;
                }
                temp = temp.next;
            }
        }
        return null;
    }


}
