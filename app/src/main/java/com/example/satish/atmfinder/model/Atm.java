
package com.example.satish.atmfinder.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Atm {

    @SerializedName("errors")
    @Expose
    private List<Object> errors = new ArrayList<Object>();
    @SerializedName("locations")
    @Expose
    private List<Location> locations = new ArrayList<Location>();

    /**
     * 
     * @return
     *     The errors
     */
    public List<Object> getErrors() {
        return errors;
    }

    /**
     * 
     * @param errors
     *     The errors
     */
    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    /**
     * 
     * @return
     *     The locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The locations
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}
