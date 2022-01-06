import java.util.HashMap;

class LRUCache {
    Node head, tail;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;

        }
    }
    //always add after dummy head
    void addToHead(Node node) {
        Node second = head.next;

        node.next = second;
        node.prev = head;
        head.next = node;
        second.prev = node;

    }
    //remove from linked list
    void remove(Node node) {
        Node first = node.prev;
        Node second = node.next;
        first.next = second;
        second.prev = first;
    }
    //get the last accessed just before tail
    int popTail() {
        Node toRemove = tail.prev;
        remove(toRemove);
        return toRemove.key; //very important I used key and spent 30 mins debugging
    }

    int max_capacity;
    HashMap<Integer, Node> hashMap = new HashMap();

    public LRUCache(int capacity) {
        max_capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        //connect the nodes
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key))
            return -1;
        Node node = hashMap.get(key);
        //move to first
        remove(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            //if val is changed
            node.val = value;
            remove(node);
            addToHead(node);
        } else {
            if (hashMap.size() >= max_capacity) { //== because we are checking before inserting
                int removed = popTail();
                hashMap.remove(removed);

            }
            Node node = new Node(key, value);
            addToHead(node);
            hashMap.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */