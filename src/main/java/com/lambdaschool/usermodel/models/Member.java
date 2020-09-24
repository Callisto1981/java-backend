package com.lambdaschool.usermodel.models;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memberid;

    private String membername;
    private String notes;
    private double contact;
    private String location;
    private int photo;

    public Member()
    {
    }

    public Member(
        String membername,
        String notes,
        double contact,
        String location,
        int photo)
    {
        this.membername = membername;
        this.notes = notes;
        this.contact = contact;
        this.location = location;
        this.photo = photo;
    }

    public long getMemberid()
    {
        return memberid;
    }

    public void setMemberid(long memberid)
    {
        this.memberid = memberid;
    }

    public String getMembername()
    {
        return membername;
    }

    public void setMembername(String membername)
    {
        this.membername = membername;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public double getContact()
    {
        return contact;
    }

    public void setContact(double contact)
    {
        this.contact = contact;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getPhoto()
    {
        return photo;
    }

    public void setPhoto(int photo)
    {
        this.photo = photo;
    }
}
