package com.rutik.urlshortner;


import jakarta.persistence.*;

@Entity
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_seq")
    @SequenceGenerator(name = "url_seq", sequenceName = "url_sequence", initialValue = 1_00_00_000,allocationSize = 1)
    private long id;

    @Column(nullable = false, length = 2048)
    private String longUrl;

    private String shortCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
