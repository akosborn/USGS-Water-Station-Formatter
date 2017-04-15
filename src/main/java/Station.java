public class Station
{
    private String orgId;
    private String siteId;
    private String siteDescription;
    private String HUC8Code;
    private Double latitude;
    private Double longitude;
    private String CRS;
    private Double elevation;
    private String elevationUnit;
    private Integer stateCode;
    private Integer countyCode;

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public String getSiteDescription()
    {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription)
    {
        this.siteDescription = siteDescription;
    }

    public String getHUC8Code()
    {
        return HUC8Code;
    }

    public void setHUC8Code(String HUC8Code)
    {
        this.HUC8Code = HUC8Code;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public String getCRS()
    {
        return CRS;
    }

    public void setCRS(String CRS)
    {
        this.CRS = CRS;
    }

    public Double getElevation()
    {
        return elevation;
    }

    public void setElevation(Double elevation)
    {
        this.elevation = elevation;
    }

    public String getElevationUnit()
    {
        return elevationUnit;
    }

    public void setElevationUnit(String elevationUnit)
    {
        this.elevationUnit = elevationUnit;
    }

    public Integer getStateCode()
    {
        return stateCode;
    }

    public void setStateCode(Integer stateCode)
    {
        this.stateCode = stateCode;
    }

    public Integer getCountyCode()
    {
        return countyCode;
    }

    public void setCountyCode(Integer countyCode)
    {
        this.countyCode = countyCode;
    }
}
