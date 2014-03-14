
public class Locale {
	 //
    // Public
    //

    // Constructor
    public Locale(int id) {
        this.id = id;
    }

    // Getters and Setters
    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.name + "\n" + this.desc;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String value) {
        this.name = value;
    }

    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String value) {
        this.desc = value;
    }


    // Other methods
    @Override
    public String toString(){
        return "[Locale id="
                + this.id
                + " name="
                + this.name
                + " desc=" + this.desc;
    }

    //
    //  Private
    //
    private int     id;
    private String  name;
    private String  desc;

}