package com.lambdaschool.usermodel.services;


import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.models.*;
import com.lambdaschool.usermodel.repository.JournalRepository;
import com.lambdaschool.usermodel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "journalService")
public class JournalServiceImpl implements JournalService
{
    @Autowired
    JournalRepository journalrepos;

    @Autowired
    UserRepository userrepos;

    @Autowired
    JournalService journalService;

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public List<Journal> findAll() {
        List<Journal> list = new ArrayList<>();
        journalrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Journal update(Journal journal, long journalid) {
        Journal currentJournal = journalrepos.findById(journalid).orElseThrow(() ->
            new EntityNotFoundException(Long.toString(journalid)));

        if (journal.getDescription() != null) {
            currentJournal.setDescription(journal.getDescription());
        }
        if (journal.getDatestarted() != null)
        {
            currentJournal.setDatestarted(journal.getDatestarted());
        }
        if (journal.getLocation() != null)
        {
            currentJournal.setLocation(journal.getLocation());
        }

        return journalrepos.save(currentJournal);
    }

    @Transactional
    @Override
    public Journal save(Journal journal) {
        Journal addJournal = new Journal();

        if (journal.getJournalid() != 0)
        {
            journalrepos.findById(journal.getJournalid())
                .orElseThrow(()-> new ResourceNotFoundException("Journal id " + journal.getJournalid() + " not found!"));
        }

        addJournal.setDescription(journal.getDescription());
        addJournal.setDatestarted(journal.getDatestarted());
        addJournal.setLocation(journal.getLocation());

        //addJournal.setUser(userService.findUserById(journalid));
        return journalrepos.save(addJournal);
    }


}
