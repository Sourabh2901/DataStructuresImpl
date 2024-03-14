import java.util.ArrayList;

class MapNode<T,V>{
    T key;
    V value;
    MapNode<T,V> next;

    public MapNode(T key ,V value){
        this.key = key;
        this.value = value;
    }
}

class Map<T,V>{

    private ArrayList<MapNode<T,V>> bucket;
    int size;
    int numBuckets;
    double loadFactor;

    public Map(){
        bucket = new ArrayList<>();
        size = 0;
        numBuckets=20;
        loadFactor = (double)(size/numBuckets);
        for(int i=1;i <= numBuckets;i++){
            bucket.add(null);
        }
    }

    public int getHashCode(T key){
        int index = key.hashCode() % numBuckets;
        return index;
    }

    public void put(T key, V value) {
        int bucketIndex = getHashCode(key);
        MapNode<T,V> head = bucket.get(bucketIndex);

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                break;
            }
            head = head.next;
        }

        MapNode<T,V> newNode = new MapNode<>(key, value);  
        head = bucket.get(bucketIndex);
        newNode.next = head;
        bucket.set(bucketIndex, newNode);

        size++;
        double loadFactor = (double)((size*1.0)/numBuckets);
        if(loadFactor >= 0.7){
            rehashing();
        }
    }

    private void rehashing() {
        ArrayList<MapNode<T,V>> temp = new ArrayList<>();

        for(int i=0;i <= numBuckets*2;i++){
            temp.add(null);
        }

        for(int i=0;i < numBuckets;i++){
            MapNode<T,V> head = bucket.get(i);

            while(head != null){
                T key = head.key;
                V value = head.value;

                put(key, value);

                head = head.next;
            }
        }

        bucket = temp;
        numBuckets *= 2;
    }

    public V get(T key) {
        int bucketIndex = getHashCode(key);
        MapNode<T,V> head = bucket.get(bucketIndex);

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(T key) {
        int bucketIndex = getHashCode(key);
        MapNode<T,V> head = bucket.get(bucketIndex);

        MapNode<T,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                V res = head.value;
                if(prev == null){
                    bucket.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }
                size--;
                return res;
            }
            prev = head;
            head = head.next;
        }

        return null;

    }
       
}

public class HashMapImpl {
    
    public static void main(String[] args) {
        Map<String,Integer> map = new Map<>();

        map.put("a" ,1);
        map.put("b" ,2);
        map.put("c" ,3);
        map.put("d" ,4);
        map.put("e" ,5);

        System.out.println(map.get("a"));
        
        
    }

}
