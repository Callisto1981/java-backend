package com.lambdaschool.usermodel.models;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photos
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long photosid;

    private String photosname;
    private String photoslocation;

    public Photos()
    {
    }

    public Photos(
        String photosname,
        String photoslocation)
    {
        this.photosname = photosname;
        this.photoslocation = photoslocation;
    }

    public long getPhotosid()
    {
        return photosid;
    }

    public void setPhotosid(long photosid)
    {
        this.photosid = photosid;
    }

    public String getPhotosName()
    {
        return photosname;
    }

    public void setPhotosName(String photosname)
    {
        this.photosname = photosname;
    }

    public String getPhotosLocation()
    {
        return photoslocation;
    }

    public void setPhotosLocation(String photoslocation)
    {
        this.photoslocation = photoslocation;
    }
}
