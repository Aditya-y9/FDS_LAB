# PriorityQueue

## collection of elements with priority

# Remove the largest or the smallest element

PriorityQueue is a collection of elements with priority. Elements are sorted by priority and not by insertion order. Elements with the same priority are sorted by insertion order.

an associated key is used to determine the priority of each element. The element with the lowest key has the highest priority.

arbitrary insertion

first element is removed

key can be any java object of comparable type
one can develop own notion of priority

sample
    
    ```java
    public interface MaxPQ<Key extends Comparable<Key>> {
        // create an empty priority queue
        MaxPQ();

        // create a priority queue with given keys
        MaxPQ(Key[] a);

        // insert a key into the priority queue
        void insert(Key v);

        // return the largest key
        Key max();

        // return and remove the largest key
        Key delMax();

        // is the priority queue empty?
        boolean isEmpty();

        // number of keys in the priority queue
        int size();
    }


Find the largest M items in a stream of N items.


Sample

            // insert first M items in the PQ
            MinPQ<Transaction> pq = new MinPQ<Transaction>();

            // read in lines of data
            while (StdIn.hasNextLine()) {
                String line = StdIn.readLine();

            // create an entry from the line and put on the PQ
            Transaction item = new Transaction(line);

            // put the new item on the PQ
            pq.insert(item);

            // remove minimum if M+1 entries on the PQ
            if (pq.size() > M)
                pq.delMin();
            }

We  deleted because we want to always keep the M largest items in the PQ. If we didn't delete, the PQ would grow without bound.

The M largest items are the M items left in the PQ.

<ul>
Implementation
<li>Sort time: NlogN,  space: N</li>
<li>elementary PQ: MN, space: M</li>
<li>binary heap: NlogM, space: M</li>
<li>best: N, space: M</li>
</ul>

# Binary Heap

Keys in nodes
Parent's key no smaller than children's keys

1. Preorder array representation

## Binary Heap Properties
1. Largest key is a[1], which is root of binary tree
2. Array index starts at 1, so parent of node at k is at k/2
3. Array indices are keys

4. Children of node at k are at 2k and 2k+1


## Promotion in a heap

When a child's key becomes larger than its parent's key

To eliminate the violation, we exchange the child with the parent

```java
private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
        exch(k, k/2);
        k = k/2;
    }
}
```

## Insertion in a heap

Insert new node at end, then swim it up

```java
public void insert(Key x) {
    pq[++N] = x;
    swim(N);
}
```

## Demotion in a heap

When a parent's key becomes smaller than one (or both) of its children's

To eliminate the violation, we exchange the parent with the larger of its two children

```java
private void sink(int k) {
    // while there is a child
    while (2*k <= N) {
        // find the largest child
        int j = 2*k;
        // if there is a right child and that child is larger
        if (j < N && less(j, j+1)) j++;
        // if parent is >= to the largest child, stop
        if (!less(k, j)) break;
        // exchange parent with largest child
        exch(k, j);
        // move down
        k = j;
    }
}
```



