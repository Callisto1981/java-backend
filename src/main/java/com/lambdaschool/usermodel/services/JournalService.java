package com.lambdaschool.usermodel.services;


import com.lambdaschool.usermodel.models.Journal;

import java.util.List;

public interface JournalService
{

    List<Journal> findAll();

    Journal update(Journal journal, long id);

    Journal save(Journal journal);


}
