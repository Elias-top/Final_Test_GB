package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable{
    private int id;
    private String type;
    private LocalDate birthDay;
    private String name;
    private List<String> doingsList;

    public Animal(int id, String type, LocalDate birthDay, String name) {
        this.id = id;
        this.type = type;
        this.birthDay = birthDay;
        this.name = name;
        doingsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }
    
    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getDoings() {
        return doingsList;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBirthDay(LocalDate date) {
        this.birthDay = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDoing(String doing) {
        doingsList.add(doing);
    }

    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(getId());
        sb.append(", name: ");
        sb.append(getName());
        sb.append(", BirthDay: ");
        sb.append(getBirthDay());
        sb.append(", type: ");
        sb.append(getType());
        sb.append(", doings: ");
        sb.append(getDoings());

        return sb.toString();
    }
}
