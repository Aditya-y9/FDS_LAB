// interfaces enable multiple inheritance
// interface only contain method signatures
// all methods are
// abstract
// and public
// interfaces can extend other interfaces

// interfaces enable abstraction and polymorphism
// only the fn name without knowing ht efunctions does what
public class stack1{


    // <T>
    // is for generic classes in java
    // class<T> object = new class<T>()
    public interface Stack<T>{
        int size();

        boolean isEmpty();

        void push(T e);

        // t because it return element of the t datatype
        T top();

        T pop();
    }
    // array based stack implementation


    public class ArrayStack<T> implements Stack<T>{

        // array of generic data type
        private T[] data;

        // index of top element
        private int top = -1;

        // constructor for array stack of given caacity
        public ArrayStack(int capacity){
            // type casting from Object to T

            // java does not allow direct creation of generic array
            // you create an array of Object class and then type cast it to generic type.
            data = (T[]) new Object[capacity];
            
        }
        public int size(){
            return (top+1);
        }
        public boolean isEmpty(){
            return (top==-1);
        }
        public void push(T t) throws IllegalStateException{
            if(size()==data.length){
                throw new IllegalStateException("Array size is full");
            }
            // increment first as it is -1 earlier and insert data.
            data[++top]=t;
        }
        public T top(){
            if (isEmpty()){
                return null;
            }
            return data[top];
        }
        

    }
}