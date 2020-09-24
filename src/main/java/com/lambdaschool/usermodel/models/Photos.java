package com.lambdaschool.usermodel.models;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photos
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long photoid;

    private String name;
    private String location;

    public Photos()
    {
    }

    public Photos(
        String name,
        String location)
    {
        this.name = name;
        this.location = location;
    }

    public long getPhotoid()
    {
        return photoid;
    }

    public void setPhotoid(long photoid)
    {
        this.photoid = photoid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
