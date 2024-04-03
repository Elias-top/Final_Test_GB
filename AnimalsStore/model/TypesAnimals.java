package model;

import java.io.Serializable;

public abstract class TypesAnimals implements Serializable{
    private String description;
    private String commonType;

    public TypesAnimals(String description, String commonType) {
        this.description = description;
        this.commonType = commonType;
    }
    
    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return description + " ( " + commonType + " )";
    }
}
