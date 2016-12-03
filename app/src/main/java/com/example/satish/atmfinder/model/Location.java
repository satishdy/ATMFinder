
package com.example.satish.atmfinder.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Location implements Serializable {

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("locType")
    @Expose
    private String locType;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("lobbyHrs")
    @Expose
    private List<String> lobbyHrs = new ArrayList<String>();
    @SerializedName("driveUpHrs")
    @Expose
    private List<String> driveUpHrs = new ArrayList<String>();
    @SerializedName("atms")
    @Expose
    private Integer atms;
    @SerializedName("services")
    @Expose
    private List<Object> services = new ArrayList<Object>();
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("access")
    @Expose
    private String access;
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The locType
     */
    public String getLocType() {
        return locType;
    }

    /**
     * 
     * @param locType
     *     The locType
     */
    public void setLocType(String locType) {
        this.locType = locType;
    }

    /**
     * 
     * @return
     *     The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * 
     * @param zip
     *     The zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return
     *     The bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * 
     * @param bank
     *     The bank
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The lobbyHrs
     */
    public List<String> getLobbyHrs() {
        return lobbyHrs;
    }

    /**
     * 
     * @param lobbyHrs
     *     The lobbyHrs
     */
    public void setLobbyHrs(List<String> lobbyHrs) {
        this.lobbyHrs = lobbyHrs;
    }

    /**
     * 
     * @return
     *     The driveUpHrs
     */
    public List<String> getDriveUpHrs() {
        return driveUpHrs;
    }

    /**
     * 
     * @param driveUpHrs
     *     The driveUpHrs
     */
    public void setDriveUpHrs(List<String> driveUpHrs) {
        this.driveUpHrs = driveUpHrs;
    }

    /**
     * 
     * @return
     *     The atms
     */
    public Integer getAtms() {
        return atms;
    }

    /**
     * 
     * @param atms
     *     The atms
     */
    public void setAtms(Integer atms) {
        this.atms = atms;
    }

    /**
     * 
     * @return
     *     The services
     */
    public List<Object> getServices() {
        return services;
    }

    /**
     * 
     * @param services
     *     The services
     */
    public void setServices(List<Object> services) {
        this.services = services;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * 
     * @return
     *     The access
     */
    public String getAccess() {
        return access;
    }

    /**
     * 
     * @param access
     *     The access
     */
    public void setAccess(String access) {
        this.access = access;
    }

    /**
     * 
     * @return
     *     The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     * 
     * @param languages
     *     The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

}
