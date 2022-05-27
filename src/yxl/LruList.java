package yxl;

import java.util.HashMap;
import java.util.Objects;
import java.util.Queue;

public class LruList {
    private LruNode head;

    private LruNode tail;

    private int maxsize;

    private int size = 0;

    public LruList(int size) {
        this.maxsize = size;
    }

    public String addData(int key, String data) {
        if (data.isEmpty())
            throw new NullPointerException(key + "'s value is null");

        LruNode node = new LruNode(key, data);
        if (size == 0) {
            head = node;
            tail = node;
            ++size;
            return null;
        }

        String r = addNode(node);
        if (r == null) ++size;
        if (size > maxsize)
            rmLastNode();
        return r;
    }

    private String addNode(LruNode node) {
        LruNode temp = this.head;
        String old = null;
        while (temp != null) {
            if (Objects.equals(node.getKey(), temp.getKey())) {
                old = temp.getData();
                temp.setData(node.getData());
                uplevel(temp);
                break;
            }
            temp = temp.getNext();
        }

        if (temp == null) {
            node.setNext(head);
            head.setPre(node);
            node.setPre(null);
            head = node;
        }
        return old;
    }


    private void uplevel(LruNode node) {
        LruNode p = null, temp = head;
        while (temp != null) {
            if (temp.equals(node)) {
                break;
            }
            p = temp;
            temp = temp.getNext();
        }
        if (p != null) {
            p.setNext(temp.getNext());
            if (temp.getNext() == null) {
                tail = p;
            } else {
                temp.getNext().setPre(p);
            }
            temp.setNext(head);
            head.setPre(temp);
            head = temp;
        }
    }

    private void rmLastNode() {
        LruNode t = tail.getPre();
        tail.setPre(null);
        t.setNext(null);
        tail = t;
        --size;
    }

    public void display() {
        LruNode t = head;
        while (t != null) {
            System.out.println("key: " + t.getKey() + ", value: " + t.getData() + "\t");
            t = t.getNext();
        }
    }

    public String getData(int key) {
        String r = null;
        LruNode temp = this.head;
        while (temp != null) {
            if (Objects.equals(key, temp.getKey())) {
                r = temp.getData();
                uplevel(temp);
                break;
            }
            temp = temp.getNext();
        }
        return r;
    }

}
