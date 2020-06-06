package json.hash;

public class Linkedlist {
    private Node head;
    private int size;

    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int Size() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public void add(String editor, String title) {
        Node current = this.search(editor);
        if (current == null)
            this.setHead(new Node(new Data(editor, title), this.getHead()));
        else {
            current.getData().incFreq();
            current.getData().addTitle(title);
        }
    }

    public void add(String title) {
        this.setHead(new Node(new Data(title), this.getHead()));
    }

    public Node search(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getEditor().contains(editor)) {
                return current;
            }
            if (!current.hasNext())
                break;
            current = current.getNext();
        }
        return null;
    }

    public void display(int option) {
        Node current = this.getHead();
        int number = 1;

        while (current != null) {
            if (option == 0) {
                System.out.print("{\"editor\":" + "\"" + current.getData().getEditor() + "\",");
                System.out.print("\"freq\":" + "\"" + current.getData().getFreq() + "\"}");
            } else if (option == 1)
                System.out.println("   " + String.format("%3d", number++) + ". " + current.getData().getEditor());
            if (current.getNext() == null) {
                break;
            }
            System.out.print(",");
            current = current.getNext();
        }
    }
}