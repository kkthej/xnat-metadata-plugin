package org.nrg.xnat.mbc.xmetadata.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xnat.mbc.xmetadata.entities.Xmetadata;
import org.nrg.xnat.mbc.xmetadata.services.XmetadataService;
//import org.nrg.xdat.rest.AbstractXnatRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;;

@Api(description = "Xnat Xmetadata API")
@XapiRestController
@RequestMapping(value = "/xmetadata")

public class XmetadataRestController extends AbstractXnatRestApi {
    @ApiOperation(value = "Returns a list of all xmetadata.",
                  notes = "Disregards source system.",
                  response = Xmetadata.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Xmetadata successfully retrieved."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<Xmetadata>> getEntities() {
        return new ResponseEntity<>(_service.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Creates a new subject mapping.",
                  notes = "Disregards source system.",
                  response = Xmetadata.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully created."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<Xmetadata> createEntity(@RequestBody final Xmetadata entity) {
        final Xmetadata created = _service.create(entity);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves the indicated subject mapping.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Xmetadata.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully retrieved."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<Xmetadata> getEntity(@PathVariable final Long id) {
        return new ResponseEntity<>(_service.retrieve(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Updates the indicated subject mapping.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Void.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully updated."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEntity(@PathVariable final Long id, @RequestBody final Xmetadata entity) {
        final Xmetadata existing = _service.retrieve(id);
        existing.setProjectId(entity.getProjectId());
        _service.update(existing);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes the indicated subject mapping.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Void.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully deleted."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEntity(@PathVariable final Long id) {
        final Xmetadata existing = _service.retrieve(id);
        _service.delete(existing);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    private XmetadataService _service;



}
