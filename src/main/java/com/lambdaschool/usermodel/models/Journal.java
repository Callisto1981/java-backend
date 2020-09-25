package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "journals")
@JsonIgnoreProperties(value = "user")
public class Journal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long journalid;


    private String description;
    private String datestarted;
    private String location;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    //@JsonIgnoreProperties("journals")
    private User user;

    public Journal()
    {
    }

    public Journal(
        User user,
        String description,
        String datestarted,
        String location
        )
    {
        this.user = user;
        this.description = description;
        this.datestarted = datestarted;
        this.location = location;

    }

    public long getJournalid()
    {
        return journalid;
    }

    public void setJournalid(long journalid)
    {
        this.journalid = journalid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDatestarted()
    {
        return datestarted;
    }

    public void setDatestarted(String datestarted)
    {
        this.datestarted = datestarted;
    }


    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}

