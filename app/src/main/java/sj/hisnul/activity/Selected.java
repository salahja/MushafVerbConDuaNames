package sj.hisnul.activity;

public class Selected {
    private String id;
    private String name;
    private String header;

    public Selected() {
    }

    public Selected(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
