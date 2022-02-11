/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.preferences.TemplatePreferencesBean
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.mbc.xmetadata.preferences;

import lombok.extern.slf4j.Slf4j;
import org.nrg.framework.configuration.ConfigPaths;
import org.nrg.framework.utilities.OrderedProperties;
import org.nrg.prefs.annotations.NrgPreference;
import org.nrg.prefs.annotations.NrgPreferenceBean;
import org.nrg.prefs.beans.AbstractPreferenceBean;
import org.nrg.prefs.exceptions.InvalidPreferenceName;
import org.nrg.prefs.services.NrgPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NrgPreferenceBean(toolId = "xmetadata", toolName = "XNAT Xmetadata Plugin")
@Slf4j
public class XmetadataPreferencesBean extends AbstractPreferenceBean {
    @Autowired
    public XmetadataPreferencesBean(final NrgPreferenceService preferenceService, final ConfigPaths configFolderPaths, final OrderedProperties orderedProperties) {
        super(preferenceService, configFolderPaths, orderedProperties);
    }

    @NrgPreference(defaultValue = "['Standard']")
    public List<String> getXmetadataNames() {
        return getListValue("xmetadataNames");
    }

    @SuppressWarnings("unused")
    public void setXmetadtaNames(final List<String> xmetadataNames) {
        try {
            setListValue("xmetadataNames", xmetadataNames);
        } catch (InvalidPreferenceName invalidPreferenceName) {
            //
        }
    }

    @NrgPreference(defaultValue = "['standard']")
    public List<String> getXmetadataTypes() {
        return getListValue("xmetadataTypes");
    }

    @SuppressWarnings("unused")
    public void setXmetadataTypes(final List<String> xmetadataTypes) {
        try {
            setListValue("xmetadataTypes", xmetadataTypes);
        } catch (InvalidPreferenceName invalidPreferenceName) {
            //
        }
    }
}
