package com.lambdaschool.usermodel.controllers;


import com.lambdaschool.usermodel.models.Journal;
import com.lambdaschool.usermodel.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/journals")
public class JournalController
{
    @Autowired
    JournalService journalService;

    @PostMapping(value = "/journal",
        consumes = {"application/json"})
    public ResponseEntity<?> addJournal(@Valid
                                        @RequestBody Journal newjournal)
    {
        newjournal.setJournalid(0);
        newjournal = journalService.save(newjournal);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newJournalURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{journalid}")
            .buildAndExpand(newjournal.getJournalid())
            .toUri();
        responseHeaders.setLocation(newJournalURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }



    @GetMapping(value = "/journals",
        produces = {"application/json"})
    public ResponseEntity<?> listAllJournals() {
        List<Journal> myjournals = journalService.findAll();
        return new ResponseEntity<>(myjournals, HttpStatus.OK);
    }

    @PutMapping(value = "/journal/{journalid}",
        consumes = {"application/json"})
    public ResponseEntity<?> updateJournals(@RequestBody Journal updatejournal,
                                          @PathVariable long journalid)
    {
        updatejournal.setJournalid(journalid);
        journalService.save(updatejournal);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/journal/{journaloid}", consumes = "application/json")
    public ResponseEntity<?> updateJournal(@RequestBody Journal updatejournal, @PathVariable long journalid)
    {
        journalService.update(updatejournal, journalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/journal/{id}")
    public ResponseEntity<?> deleteJournalById(
        @PathVariable
            long id)
    {
        //       howtoService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
