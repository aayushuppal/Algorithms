package interQ;

/**
 * Created by hellsapphire on 9/21/2015.
 */
public class MyCircularQueue<T> {
    T[] QueueArr;
    int size;
    int occupied;

    int head;
    int tail;

    public MyCircularQueue(int size){
        this.head = -1;
        this.tail = -1;
        this.size = size;
        QueueArr = (T[]) new Object[size];
        for (int i=0; i<size; i++){
            QueueArr[i] = null;
        }
    }

    public void enqueue(T val){
        if (occupied < size){

            if (head == -1 && tail == -1){
                QueueArr[0] = val;
                head = 0;
                tail = 0;
                occupied++;
                return;
            } else {
                tail = convertIndex(++tail);
                QueueArr[tail] = val;
                occupied++;
                return;
            }

        }
    }

    public T dequeue(){
        if (occupied > 0){
            T temp = (T) QueueArr[head];
            QueueArr[head] = null;
            head = convertIndex(++head);
            occupied--;
            return temp;
        }
        return null;
    }

    private int convertIndex(int a){
        return a%size;
    }

    public static void main(String[] args){
        MyCircularQueue<Integer> mcl = new MyCircularQueue<Integer>(3);
        System.out.println(mcl.head+"-- "+mcl.tail);
        mcl.enqueue(10);
        System.out.println(mcl.head + "--" + mcl.tail);
        mcl.enqueue(11);
        System.out.println(mcl.head + "--" + mcl.tail);
        mcl.enqueue(12);
        System.out.println(mcl.head + "--" + mcl.tail);
        System.out.println(mcl.dequeue());
        System.out.println(mcl.head+"--"+mcl.tail);
        mcl.enqueue(101);
        System.out.println(mcl.dequeue());
        System.out.println(mcl.head+"--"+mcl.tail);
        System.out.println(mcl.dequeue());
        System.out.println(mcl.dequeue());

        System.out.println(mcl.head+"--"+mcl.tail);
    }
}
