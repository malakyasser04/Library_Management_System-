package com.company;

public class Queue1 {

        public  static class Node1 {
            int key;
            Node1 next;

            Object data;
            public Node1(Object data) {
                this.data = data;
                this.next = next;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public void setNext(Node1 next) {
                this.next = next;
            }

            public void setData(Object data) {
                this.data = data;
            }
        }

        Node1 rear ,head;
        int size;
        public Queue1(){    this.rear= rear;this.head=head;
        }

        public void setRear(Node1 rear) {
            this.rear = rear;
        }

        public void setHead(Node1 head) {
            this.head = head;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String print (){
            String data="contents:\n";
            Node1 rear=head;
            while(rear!=null){
                data+=rear.data+"\n";
                rear=rear.next;}
            return data;
        }
        public void enqueue(Object x){
/*Node1 temp =new Node1();
temp.data=x;
        temp.next=null;
if (head == null){
    rear =head=temp;
}else head.next=temp;head=temp;size++;*/

     /*   if (head==null){
            head=new Node1(x); }
        else {Node1 newnode=new Node1(x);
           newnode.setNext(head);
            head=newnode;
        size++;
        }*/
            Node1 temp =new Node1(x);
            if (rear==null){
                head=rear=temp;return;
            }
            rear.next=temp;
            rear=temp;

        }

        public void dequeue (){
       /* if (isempty()) System.out.println("error");
       head=rear;
       head=head.next;
       size--;
       if (head==null)rear=null;*/
            if (head==null) return;
            Node1 temp =head;
            head=head.next;
            if (head==null)rear=null;

            library.dequeuedReq = temp.data;
        }

        public boolean isempty(){
            return head == null;
        }

        public Object search(Object x) {
   /* if (isempty()) return null;
    rear = head;
    Object target = null;
    for (int i = 0; i <= size; i++) {
        if (x == rear.data) {
            target = rear.data;
            break;}
        rear = rear.next;}
    if (target==null)return null;
else return target;*/
            Node1 temp=head;
            while (temp!=null){if (temp.data==x)return true;temp=temp.next;}
            return false;
        }
        public void Delet (Object x){
 /*Node1 temp =new Node1();Node1 prev =new Node1();

        rear=head;
        if (isempty()) System.out.println("error");
        for (int i = 0; i <size ; i++) {
            if (rear.data==x){
                temp=head;
                prev=temp;
                temp=temp.next;
prev.next=temp.next;


            }
 }
       Node1 temp =head;
       for (int i = 0; i <size ; i++) {
           temp=temp.next;
       }
       temp.next=temp.next.next;*/
            Node1 temp =head;
            Node1 prev =null;
            while(temp!=null&&temp.data!=x){
                prev=temp;
                temp=temp.next;}
            if (temp==null)return;;
            if (prev==null)head=temp.next;else prev.next=temp.next;

        }

        public void newrequests (Object x){
            if (search(x)==null){
                enqueue(x);
            }

        }

        public void available (Object x){

            if (search(x)!=null)Delet(x);
        }


    }
