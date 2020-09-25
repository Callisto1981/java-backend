package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Journal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface JournalRepository extends CrudRepository<Journal, Long>
{
    @Transactional
    @Modifying
    @Query(value = "UPDATE journal SET name = :name, " +
        "last_modified_by = :uname, last_modified_date = CURRENT_TIMESTAMP WHERE journal = :journal",
        nativeQuery = true)
    void updateRoleName(
        String uname,
        long journalid,
        String description);
}
