package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.models.Photos;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.services.PhotosService;
import com.lambdaschool.usermodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotosController
{
    @Autowired
    PhotosService photosService;

    @GetMapping(value = "/photos", produces = "application/json")
    public ResponseEntity<?> getAllPhotos()
    {

        List<Photos> myPhotos = photosService.findAll();
        return new ResponseEntity<>(myPhotos, HttpStatus.OK);
    }

    @GetMapping(value = "/photos/{photosid}",
        produces = "application/json")
    public ResponseEntity<?> getPhotoById(
        @PathVariable
            Long photosid)
    {
        Photos p = photosService.findPhotosById(photosid);
        return new ResponseEntity<>(p,
            HttpStatus.OK);
    }

    @PostMapping(value = "/photo",
        consumes = "application/json")
    public ResponseEntity<?> addNewPhotos(
        @Valid
        @RequestBody
            Photos newphotos) throws
                          URISyntaxException
    {
        newphotos.setPhotosid(0);
        photosService.save(newphotos);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPhotoURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{newphotos}")
            .buildAndExpand(newphotos.getPhotosid())
            .toUri();
        responseHeaders.setLocation(newPhotoURI);

        return new ResponseEntity<>(null,
            responseHeaders,
            HttpStatus.CREATED);
    }


    @PutMapping(value = "/user/{userid}",
        consumes = "application/json")
    public ResponseEntity<?> updateFullUser(
        @Valid
        @RequestBody
            Photos updatePhotos,
        @PathVariable
            long photosid)
    {
        updatePhotos.setPhotosid(photosid);
        photosService.save(updatePhotos);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping(value = "/user/{id}",
        consumes = "application/json")
    public ResponseEntity<?> updateUser(
        @RequestBody
            Photos updatephotos,
        @PathVariable
            long id)
    {
        photosService.update(updatephotos, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a given user along with associated emails and roles
     * <br>Example: <a href="http://localhost:2019/users/user/14">http://localhost:2019/users/user/14</a>
     *
     * @param id the primary key of the user you wish to delete
     * @return Status of OK
     */
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUserById(
        @PathVariable
            long id)
    {
        photosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
