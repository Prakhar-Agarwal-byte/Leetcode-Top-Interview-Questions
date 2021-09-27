import java.util.HashMap;

class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node last;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        last = new Node(0,0);
        this.capacity = capacity;
        head.next = last;
        last.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } 
        if (map.size() == capacity) {
            remove(head);
        }
        insert(new Node(key, value));
    }

    private void insert(Node node) {
        Node prevNode = last.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = last;
        last.prev = node;
        map.put(node.key, node);
    }

    private void remove(Node node) {
        map.remove(node.key);
        Node prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
