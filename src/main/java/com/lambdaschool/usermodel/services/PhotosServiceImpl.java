package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.models.*;
import com.lambdaschool.usermodel.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "PhotosService")
public class PhotosServiceImpl implements PhotosService
{
    @Autowired
    private PhotosRepository photosrepos;

    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public void delete(long id)
    {
        photosrepos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
        photosrepos.deleteById(id);
    }

    @Override
    public void update(Photos photos, long id)
    {
        Photos currentPhotos = findPhotosById(id);

        if (helperFunctions.isAuthorizedToMakeChange(currentPhotos.getPhotosName()))
        {
            if (photos.getPhotosName() != null)
            {
                currentPhotos.setPhotosName(photos.getPhotosName()
                    .toLowerCase());
            }

            photosrepos.save(currentPhotos);
        }
//        } else
//        {
//            // note we should never get to this line but is needed for the compiler
//            // to recognize that this exception can be thrown
//            throw new ResourceNotFoundException("This Photo is not authorized to make change");
//        }

    }

    @Override
    public void save(Photos photos)
    {
        Photos newphotos = new Photos();

        if (photos.getPhotosid() != 0)
        {
            photosrepos.findById(photos.getPhotosid())
                .orElseThrow(() -> new ResourceNotFoundException("Photo id " + photos.getPhotosid() + " not found!"));
            newphotos.setPhotosid(photos.getPhotosid());
        }


        photosrepos.save(newphotos);
    }

    @Override
    public Photos findPhotosById(Long photosid)
    {
        return null;
    }

    @Override
    public List<Photos> findAll()
    {
        List<Photos> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        photosrepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }
}
