/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author T
 */
public class ChargingStat
{
    private String taID;
    private String started;
    private String stopped;
    private String duration; 
    private String uID;
    
    public ChargingStat(String taID, String started, String stopped, String duration, String uID)
    {
        this.taID = taID;
        this.started = started;
        this.stopped = stopped;
        this.duration = duration;
        this.uID = uID;
    }
    
    /**
     * Get the value of taID
     *
     * @return the value of taID
     */
    public String getTaID()
    {
        return taID;
    }
    /**
     * Set the value of taID
     *
     * @param taID new value of taID
     */
    public void setTAID(String taID)
    {
        this.taID = taID;
    }
    /**
     * Get the value of started
     *
     * @return the value of started
     */
    public String getStarted()
    {
        return started;
    }

    /**
     * Set the value of started
     *
     * @param started new value of started
     */
    public void setStarted(String started)
    {
        this.started = started;
    }
    /**
     * Get the value of stopped
     *
     * @return the value of stopped
     */
    public String getStopped()
    {
        return stopped;
    }

    /**
     * Set the value of stopped
     *
     * @param stopped new value of stopped
     */
    public void setStopped(String stopped)
    {
        this.stopped = stopped;
    }
    /**
     * Get the value of duration
     *
     * @return the value of duration
     */
    public String getDuration()
    {
        return duration;
    }

    /**
     * Set the value of duration
     *
     * @param duration new value of duration
     */
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    /**
     * Get the value of uID
     *
     * @return the value of uID
     */
    public String getUID()
    {
        return uID;
    }

    /**
     * Set the value of uID
     *
     * @param uID new value of uID
     */
    public void setUID(String uID)
    {
        this.uID = uID;
    }
}
