/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.rest.TemplateApi
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.mbc.xmetadata.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.nrg.framework.annotations.XapiRestController;
import org.nrg.xapi.exceptions.NotFoundException;
import org.nrg.xapi.rest.AbstractXapiRestController;
import org.nrg.xapi.rest.XapiRequestMapping;
import org.nrg.xdat.security.services.RoleHolder;
import org.nrg.xdat.security.services.UserManagementServiceI;
import org.nrg.xnat.mbc.xmetadata.entities.Xmetadata;
import org.nrg.xnat.mbc.xmetadata.services.XmetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api("Xmetadata API")
@XapiRestController
@RequestMapping(value = "/xmetadata/entities")
@Slf4j
public class XmetadataApi extends AbstractXapiRestController {
    @Autowired
    protected XmetadataApi(final UserManagementServiceI userManagementService, final RoleHolder roleHolder, final XmetadataService xmetadataService) {
        super(userManagementService, roleHolder);
        _xmetadataService = xmetadataService;
    }

    @ApiOperation(value = "Returns a list of all templates.", response = Xmetadata.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Templates successfully retrieved."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @XapiRequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Xmetadata> getEntities() {
        return _xmetadataService.getAll();
    }

    @ApiOperation(value = "Creates a new template.", response = Xmetadata.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Template successfully created."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @XapiRequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Xmetadata createEntity(@RequestBody final Xmetadata entity) {
        return _xmetadataService.create(entity);
    }

    @ApiOperation(value = "Retrieves the indicated template.",
                  notes = "Based on the template ID, not the primary key ID.",
                  response = Xmetadata.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Template successfully retrieved."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @XapiRequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Xmetadata getEntity(@PathVariable final String id) throws NotFoundException {
        if (!_xmetadataService.exists("projectId", id)) {
            throw new NotFoundException("No template with the ID \"" + id + "\" was found.");
        }
        return _xmetadataService.findByProjectId(id);
    }

    @ApiOperation(value = "Updates the indicated template.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Long.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Template successfully updated."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @XapiRequestMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public long updateEntity(@PathVariable final Long id, @RequestBody final Xmetadata entity) throws NotFoundException {
        if (!_xmetadataService.exists("projectId", id)) {
            throw new NotFoundException("No template with the ID \"" + id + "\" was found.");
        }
        final Xmetadata existing = _xmetadataService.retrieve(id);
        existing.set_projectID(entity.get_projectID());
        _xmetadataService.update(existing);
        return id;
    }

    @ApiOperation(value = "Deletes the indicated template.",
                  notes = "Based on primary key ID, not subject or record ID.",
                  response = Long.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Template successfully deleted."),
                   @ApiResponse(code = 401, message = "Must be authenticated to access the XNAT REST API."),
                   @ApiResponse(code = 500, message = "Unexpected error")})
    @XapiRequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public long deleteEntity(@PathVariable final Long id) {
        final Xmetadata existing = _xmetadataService.retrieve(id);
        _xmetadataService.delete(existing);
        return id;
    }

    private final XmetadataService _xmetadataService;
}
