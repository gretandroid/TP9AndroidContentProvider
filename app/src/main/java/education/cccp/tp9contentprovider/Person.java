package education.cccp.tp9contentprovider;


public class Person {
    public static final String TABLE_PERSON = "table_person";
    public static final String TABLE_PERSON_COL_ID = "ID";
    public static final String TABLE_PERSON_COL_FIRST_NAME = "FIRST_NAME";
    public static final String TABLE_PERSON_COL_LAST_NAME = "LAST_NAME";

    public static final String CREATE_TABLE_PERSON = "CREATE TABLE " +
            TABLE_PERSON + " (" +
            TABLE_PERSON_COL_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_PERSON_COL_FIRST_NAME + " TEXT NOT NULL, " +
            TABLE_PERSON_COL_LAST_NAME + " TEXT NOT NULL);";
    private Long id;
    private String firstName;
    private String lastName;

    public Person(String firstName,
                  String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new StringBuilder("Person{")
                .append("id=").append(id)
                .append(", firstName='").append(firstName).append('\'')
                .append(", lastName='").append(lastName).append('\'')
                .append('}')
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
