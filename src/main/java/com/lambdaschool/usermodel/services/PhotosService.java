package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Photos;
import com.lambdaschool.usermodel.models.User;

import java.util.List;

public interface PhotosService
{
    void delete(long id);

    void update(Photos photos, long id);

    void save(Photos photos);

    Photos findPhotosById(Long photosid);

    List<Photos> findAll();
}
