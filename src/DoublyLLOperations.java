import java.util.Scanner;

public class DoublyLLOperations {
    public static class Node {

       Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev=null;
        }
    }

    Node head = null;
    Node tail=null;


    void insertionDoublyLl() {
        int n = 0;
        do {
            System.out.println("Enter data for insertion");
            int data = new Scanner(System.in).nextInt();
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
                tail=newnode;
                System.out.println(data + "inserted successfully");
            } else {
                System.out.println("Enter your choice for Insertion");
                System.out.println("\n1. At beg \n2. At Specific Location \n3. At end");
                int m = new Scanner(System.in).nextInt();
                switch (m) {
                    case 1:
                  Node temp=head;
                  newnode.next=temp;
                  temp.prev=newnode;
                  head=newnode;

                        break;

                    case 2:
                        Node temp_mid = head;
                        Node ptr = temp_mid.next;
                        System.out.println("Enter position for insertion");
                        int p = new Scanner(System.in).nextInt();
                        for (int i = 0; i < (p - 2); i++) {
                            temp_mid = ptr;
                            ptr = ptr.next;
                        }
                      newnode.next=ptr;
                        temp_mid.next=newnode;
                        newnode.prev=temp_mid;
                        ptr.prev=newnode;

                        break;


                    case 3:
                       tail.next=newnode;
                       newnode.prev=tail;
                       tail=newnode;
                        break;


                    default:
                        System.out.println("Press enter valid choice");
                }
                System.out.println(data + "inserted successfully");
            }
            System.out.println("Press 1 for continue insertion, else press any key");
            n = new Scanner(System.in).nextInt();
        } while (n == 1);

    }

    void displaySinglyLL() {
        if (head == null) {
            System.out.println("Linked List is empty, so no data is displayed");
        }
        else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
       DoublyLLOperations i = new DoublyLLOperations();



        int n=0;
        do {
            System.out.println("Enter your choice for operations \n1 For insertion \n2 For Deletion" +
                    "\n3 For Display \n4 For Count Nodes \n5 Max  \n6 Min \n7 Even_Nodes  \n8 OddNodes" );
            System.out.println("Please Enter: ");
            int m=new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    i.insertionDoublyLl();
                    break;


                case 2:
                    i.deletionDoublyLl();
                    break;

                case 3:
                    i.displayDoublyLL();
                    break;

                case 4:
                    i.count_NodesDoubly();
                    break;

                case 5:
                    i.Max_FindDoubly();
                    break;

                case 6:
                    i.Min_FindDoubly();
                    break;

                case 7:
                    i.Even_NodesDoubly();
                    break;


                case 8:
                    i.Odd_NodesDoubly();
                    break;

                default:
                    System.out.println("Please Enter Valid choice");


            }

            System.out.println("Press 100 for continue operations, else press any key");
            n = new Scanner(System.in).nextInt();
        }
        while (n==100);
    }

   void count_NodesDoubly() {
       if (head == null) {
           System.out.println("Linked List is empty, so no data is displayed");
       } else {
           int count=0;
           Node temp = head;
           while (temp != null) {
               count++;
               temp = temp.next;
           }
           System.out.println("Total Nodes"+count);
       }
    }

    void deletionDoublyLl() {
        int n = 0;
        do {
            System.out.println("Enter data for deletion");
            int data = new Scanner(System.in).nextInt();

            if (head == null) {

                System.out.println("Linked list empty, not able to delete data ");
            } else {
                System.out.println("Enter your choice for Deletion");
                System.out.println("\n1. At beg \n2. At Specific Location \n3. At end");
                int m = new Scanner(System.in).nextInt();
                switch (m) {
                    case 1:
                        head=head.next;
                        head.prev=null;
                        break;

                    case 2:
                        Node temp_mid=head;
                        Node ptr_mid=temp_mid.next;
                        System.out.println("Enter position for Insertion");
                        int p=new Scanner(System.in).nextInt();
                        for (int i = 0; i <(p-2) ; i++) {
                            temp_mid=ptr_mid;
                            ptr_mid=ptr_mid.next;
                        }
                      temp_mid.next=ptr_mid.next;
                        ptr_mid.next.prev=temp_mid;
                        break;


                    case 3:
                        tail.prev.next=null;
                        tail=tail.prev;
                        break;


                    default:
                        System.out.println("Press enter valid choice");
                }
                System.out.println(data+"successfully deleted");
            }
            System.out.println("Press 1 for continue deletion, else press any key");
            n = new Scanner(System.in).nextInt();
        } while (n == 1);
    }

   void Max_FindDoubly() {
       if (head == null) {
           System.out.println("Linked List is empty, NOT able to find max because there is no element");
       }

       else {
           int max = Integer.MIN_VALUE;
           Node temp = head;
           while (temp != null) {
               if (temp.data > max) {
                   max = temp.data;

               }
               temp = temp.next;
           }
           System.out.println("Max Element: " + max);
       }
    }

    void Min_FindDoubly() {
        if (head == null) {
            if (head == null) {
                System.out.println("Linked List is empty, NOT able to find min because there is no element");
            }
        }
        else
        {
            int min=Integer.MAX_VALUE;
            Node temp=head;
            while (temp!=null){
                if(temp.data<min){
                    min=temp.data;

                }
                temp=temp.next;
            }
            System.out.println("Min Element: "+min);
        }
    }

  void Even_NodesDoubly() {
      if (head == null) {
          System.out.println("Linked List is empty, so no data is displayed");
      } else {
          System.out.println("\n..... Even NUMBER NODES....");
          int count=0;
          Node temp = head;
          while (temp != null) {
              count++;

              if(count%2==0){
                  System.out.println(temp.data);
              }
              temp = temp.next;
          }

      }
    }

   void Odd_NodesDoubly() {
       if (head == null) {
           System.out.println("Linked List is empty, so no data is displayed");
       } else {
           System.out.println("\n.....ODD NUMBER NODES....");
           int count=0;
           Node temp = head;
           while (temp != null) {
               count++;

               if(count%2!=0){
                   System.out.println(temp.data);
               }
               temp = temp.next;
           }

       }
    }

    void displayDoublyLL() {
        if (head == null) {
            System.out.println("Linked List is empty, so no data is displayed");
        }
        else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }    }
}
