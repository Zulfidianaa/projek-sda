package json.hash;

public class Data {
    private String editor;
    private int freq;
    private Linkedlist titles;

    public Data(String title) {
        this.editor = title;
        this.freq = 1;
    }

    public Data(String editor, String title) {
        this.editor = editor;
        this.freq = 1;
        titles = new Linkedlist();
        this.addTitle(title);
    }

    public void addTitle(String title) {
        titles.add(title);
    }

    public Linkedlist getTitles() {
        return this.titles;
    }

    public void display() {
        this.titles.display(1);
    }

    public String getEditor() {
        return this.editor;
    }

    public int getFreq() {
        return this.freq;
    }

    public void incFreq() {
        this.freq += 1;
    }
}