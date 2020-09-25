package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Photos;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photos, Long>
{
}
