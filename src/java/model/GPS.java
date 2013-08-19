/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mary
 */
@Entity
public class GPS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private double latitude;
    private double longitude;
    private double speed;
    private boolean bearing;
    private String deviceID;
    private long dateTime;
    private int idle;

    public GPS() {
    }

    public GPS(String id, double latitude, double longitude, double speed, boolean bearing, String deviceID, long date, int idle) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.bearing = bearing;
        this.deviceID = deviceID;
        this.dateTime = date;
        this.idle = idle;
    }

    /**
     * Get the value of idle
     *
     * @return the value of idle
     */
    public int getIdle() {
        return idle;
    }

    /**
     * Set the value of idle
     *
     * @param idle new value of idle
     */
    public void setIdle(int idle) {
        this.idle = idle;
    }

    /**
     * Get the value of dateTime
     *
     * @return the value of dateTime
     */
    public long getDateTime() {
        return dateTime;
    }

    /**
     * Set the value of dateTime
     *
     * @param dateTime new value of dateTime
     */
    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Get the value of deviceID
     *
     * @return the value of deviceID
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Set the value of deviceID
     *
     * @param deviceID new value of deviceID
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * Get the value of bearing
     *
     * @return the value of bearing
     */
    public boolean isBearing() {
        return bearing;
    }

    /**
     * Set the value of bearing
     *
     * @param bearing new value of bearing
     */
    public void setBearing(boolean bearing) {
        this.bearing = bearing;
    }

    /**
     * Get the value of longitude
     *
     * @return the value of longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Set the value of longitude
     *
     * @param longitude new value of longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the value of speed
     *
     * @return the value of speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Set the value of speed
     *
     * @param speed new value of speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Get the value of latitude
     *
     * @return the value of latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Set the value of latitude
     *
     * @param latitude new value of latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GPS)) {
            return false;
        }
        GPS other = (GPS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GPS[ id=" + id + " ]";
    }
}
