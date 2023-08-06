package link;

/**
 * @description: 链表测试
 * @author: 22783
 * @date: 2023/7/27
 **/
public class LinkNode {


    /*只想下一个node节点*/
    private Node next;

    /*指向前一个node节点*/
    private Node prev;

    //链表的大小
    private int size = 0;

    public LinkNode() {
    }

    public LinkNode( Node prev, Node next) {
        this.next = next;
        this.prev = prev;
    }

    /*尾插法*/
    public void add(Object obj){
        Node link = next;
        Node linkNode = new Node(link,obj,null);
        next = linkNode;
        if (link == null) {
            //说明链表里面没有东西
            prev = linkNode;
        }
        else {
            link.next = linkNode;
        }
        size++;

    }


    /*删除链表的最后一个元素*/
    public boolean remove(Object obj){
        if (obj == null){
            for (Node i = prev;i!=null;i= i.next){
                if (i.item == null) {
                    unlink(i);
                    return true;
                }
            }

        }
        else{
            for (Node i = prev;i!=null;i= i.next){
                if (obj.equals(i.item)){
                    unlink(i);
                    return true;
                }
            }
        }
        return false;
    }



    public Object unlink(Node x){
        /*获取到x节点的数据域*/
        final Object element = x.item;
        /*获取x节点的下一个节点*/
        final Node last = x.next;
        /*获取x节点的上一个节点*/
        final Node first = x.prev;

        /*如果说x上一个节点为空的话，
        * 将，x的下一个节点作为头节点
        * */
        if (first == null){
            prev = last;
        }
        /*如果不是，x的前一个节点的next指针指向x节点的下一个节点*/
        else {
            first.next = last;
            /*x的前指针指向null*/
            x.prev = null;
        }
        /*如果x的下一个节点为空，那么x的前一个节点作为链表的尾节点*/
        if (last == null){
            next = first;
        }
        /*否则，x的后一个节点的前去指针指向x的前一个结点
        * x的next指针指向null
        * */
        else {
            last.prev = first;
            x.next = null;
        }
        /*将x的item数据变为null*/
        x.item = null;
        size--;
        return element;
    }

    private static class Node{
        //node节点的数据部分
        Object item;
        //node的next指针
        Node next;
        //node的前一个指针
        Node prev;

        //构造函数
        public Node(Node prev ,Object item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }


    }


    @Override
    public String toString() {
        return "LinkNode{" +
                "next=" + next +
                ", prev=" + prev +
                ", size=" + size +
                '}';
    }
}
