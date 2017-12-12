package plantparent.api;

public class PlantMedium {

    private int id;

    private String type;

    private String composition;

    public PlantMedium(int id, String type, String composition){
        this.id = id;
        this.type = type;
        this.composition = composition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }
}
