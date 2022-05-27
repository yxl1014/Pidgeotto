package yxl;

public class LruNode {


    private Integer key;
    private String data;
    private LruNode next;
    private LruNode pre;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LruNode getNext() {
        return next;
    }

    public void setNext(LruNode next) {
        this.next = next;
    }

    public LruNode getPre() {
        return pre;
    }

    public void setPre(LruNode pre) {
        this.pre = pre;
    }

    public LruNode(Integer key, String data) {
        this.key = key;
        this.data = data;
    }
}
