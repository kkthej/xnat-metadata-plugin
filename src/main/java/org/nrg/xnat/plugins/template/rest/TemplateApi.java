/*
 * xnat-workshop-plugin: org.nrg.xnat.plugins.template.rest.TemplateApi
 * XNAT http://www.xnat.org
 * Copyright (c) 2016, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xnat.plugins.template.entities.Template;
import org.nrg.xnat.plugins.template.preferences.TemplatePreferencesBean;
import org.nrg.xnat.plugins.template.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(description = "XNAT 1.7 Template Plugin API")
@XapiRestController
@RequestMapping(value = "/template")
public class TemplateApi {
    public TemplateApi(final TemplateService service, final TemplatePreferencesBean preferences) {
        _service = service;
        _preferences = preferences;
    }

//    @ApiOperation(value = "Returns a list of all subject mappings.",
//                  notes = "Disregards source system.",
//                  response = Template.class, responseContainer = "List")
//    @ApiResponses({@ApiResponse(code = 200, message = "Subject mappings successfully retrieved."),
//                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//                   @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
//    public ResponseEntity<List<Template>> getEntities() {
//        return new ResponseEntity<>(_templateService.getAll(), HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Creates a new subject mapping.",
//                  notes = "Disregards source system.",
//                  response = Template.class)
//    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully created."),
//                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//                   @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
//    public ResponseEntity<Template> createEntity(@RequestBody final Template entity) {
//        final Template created = _templateService.create(entity);
//        return new ResponseEntity<>(created, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Retrieves the indicated subject mapping.",
//                  notes = "Based on primary key ID, not subject or record ID.",
//                  response = Template.class)
//    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully retrieved."),
//                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//                   @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
//    public ResponseEntity<Template> getEntity(@PathVariable final Long id) {
//        return new ResponseEntity<>(_templateService.retrieve(id), HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Updates the indicated subject mapping.",
//                  notes = "Based on primary key ID, not subject or record ID.",
//                  response = Void.class)
//    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully updated."),
//                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//                   @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT)
//    public ResponseEntity<Void> updateEntity(@PathVariable final Long id, @RequestBody final Template entity) {
//        final Template existing = _templateService.retrieve(id);
//        existing.setSubjectId(entity.getSubjectId());
//        existing.setSource(entity.getSource());
//        _templateService.update(existing);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Deletes the indicated subject mapping.",
//                  notes = "Based on primary key ID, not subject or record ID.",
//                  response = Void.class)
//    @ApiResponses({@ApiResponse(code = 200, message = "Subject mapping successfully deleted."),
//                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//                   @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteEntity(@PathVariable final Long id) {
//        final Template existing = _templateService.retrieve(id);
//        _templateService.delete(existing);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Returns a list of the source system IDs.", response = String.class, responseContainer = "List")
//    @ApiResponses({@ApiResponse(code = 200, message = "Source system IDs successfully retrieved."),
//            @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//            @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(value = "sources", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
//    public ResponseEntity<List<String>> getSourceIds() {
//        return new ResponseEntity<>(_preferences.getSourceSystemIds(), HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Sets the submitted source system IDs.",
//            response = Void.class)
//    @ApiResponses({@ApiResponse(code = 200, message = "Source system IDs successfully created."),
//            @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
//            @ApiResponse(code = 500, message = "Unexpected error")})
//    @RequestMapping(value = "sources", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
//    public ResponseEntity<Void> setSourceIds(@RequestBody final List<String> sourceIds) {
//        _preferences.setSourceSystemIds(sourceIds);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    private final TemplateService         _service;
    private final TemplatePreferencesBean _preferences;
}
