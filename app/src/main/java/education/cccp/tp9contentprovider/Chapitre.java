package education.cccp.tp9contentprovider;

import static java.lang.String.format;

import android.annotation.SuppressLint;

public class Chapitre {
    private int id;
    private String name;
    private String description;

    public Chapitre(String name,
                    String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return format("Chapitre{id=%d, name='%s', description='%s'}",
                id,
                name,
                description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
