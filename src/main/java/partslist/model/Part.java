package partslist.model;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "importance")
    private boolean importance;
    @Column(name = "count")
    private int count = 0;

    @Override
    public String toString() {
        return id + " " + name + " " + count + " " + importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isImportance() {
        return importance;
    }

    public void setImportance(boolean importance) {
        this.importance = importance;
    }
}
