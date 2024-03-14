public class ArrayListImpl<T> {

    T [] data;
    int size;

    @SuppressWarnings("unchecked")
    public ArrayListImpl(){
        size = 0;
        data = (T[])new Object[10];
    }

    //add
    public void add(T obj){
        
        //if size less 70% of array capacity then add elem
        //else double the size of array
        int capacity = (size*100)/data.length;
        System.out.println(obj);

        if(capacity < 70){
            size++;
            data[size-1] = obj;
        }else{
            doubleCapacity();
            size++;
            data[size-1] = obj;
        }
        
    }

    public void doubleCapacity(){
        System.out.println("Size Doubled");

        @SuppressWarnings("unchecked")
        T [] temp = (T[]) new Object[data.length*2];

        for(int i=0;i < size;i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    //get Size
    public int size(){
        return size();
    }


    //fetch
    public T get(int index){
        if(index < size)
            return data[index];
        else
            return null;
    }


    public static void main(String[] args) {
        ArrayListImpl<String> obj = new ArrayListImpl<>();

        for(int i=0;i<100;i++){
            obj.add("Hi");
        }
        
    }



    
}
