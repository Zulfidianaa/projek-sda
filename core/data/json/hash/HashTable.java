package json.hash;

public class HashTable {
    Linkedlist[] hash;

    public HashTable(int size) {
        this.hash = new Linkedlist[size];
    }

    public void add(String editor, String title) {
        int index = this.key(editor);
        if (hash[index] == null)
            hash[index] = new Linkedlist();
        hash[index].add(editor, title);
    }

    public void display() {
        for (int a = 0; a < hash.length; a++)
            this.display(a);
    }

    public void display(int index) {
        if (this.hash[index] != null) {
            this.hash[index].display(0);
            if (index < 998)
                System.out.print(",");
        }
    }

    private int key(String editor) {
        int uplowchar = (int) Math.pow(2, 8);
        int digit = 1;
        int index = 0;

        for (char i : editor.toCharArray()) {
            index = (index + (i + 1) * digit) % hash.length;
            digit = (digit * uplowchar) % hash.length;
        }
        return index;
    }

    public void searchKey(String editor) {
        int index = this.key(editor);

        System.out.println("[");
        if (this.hash[index] != null) {
            Node current = this.hash[index].search(editor);
            if (current != null) {
                System.out.print("{\"editor\":" + "\"" + current.getData().getEditor() + "\",\n");
                System.out.print("\"freq\":" + "\"" + current.getData().getFreq() + "\"}");
            }
        } else
            System.out.println("\nEditor tidak ditemukan\n");
        System.out.println("]");
    }
}
