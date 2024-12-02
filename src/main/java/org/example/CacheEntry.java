package org.example;

public class CacheEntry {
    private String objectId;
    private String propertyId;
    private String value;

    public CacheEntry(String objectId, String propertyId, String value) {
        this.objectId = objectId;
        this.propertyId = propertyId;
        this.value = value;
    }

    // Getters and setters
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
