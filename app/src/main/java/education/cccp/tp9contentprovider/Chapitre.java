package education.cccp.tp9contentprovider;

public class Chapitre {
    public static final String TABLE_CHAPITRE = "table_chapitre";
    public static final String TABLE_CHAPITRE_COL_ID = "ID";
    public static final String TABLE_CHAPITRE_COL_NAME = "NAME";
    public static final String TABLE_CHAPITRE_COL_DESC = "DESCRIPTION";
    public static final String CREATE_TABLE_CHAPITRE = new StringBuilder()
            .append("CREATE TABLE ")
            .append(TABLE_CHAPITRE)
            .append(" (")
            .append(TABLE_CHAPITRE_COL_ID)
            .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(TABLE_CHAPITRE_COL_NAME)
            .append(" TEXT NOT NULL, ")
            .append(TABLE_CHAPITRE_COL_DESC)
            .append(" TEXT NOT NULL);")
            .toString();
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
        return new StringBuilder("Chapitre{")
                .append("id=").append(id)
                .append(", name='").append(name).append('\'')
                .append(", description='").append(description).append('\'')
                .append('}').toString();
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
