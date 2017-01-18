/*
 * xnat-workshop-plugin: org.nrg.xnat.plugins.template.preferences.SubjectMappingPreferencesBean
 * XNAT http://www.xnat.org
 * Copyright (c) 2016, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.preferences;

import org.nrg.framework.configuration.ConfigPaths;
import org.nrg.prefs.annotations.NrgPreference;
import org.nrg.prefs.annotations.NrgPreferenceBean;
import org.nrg.prefs.beans.AbstractPreferenceBean;
import org.nrg.prefs.exceptions.InvalidPreferenceName;
import org.nrg.prefs.services.NrgPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NrgPreferenceBean(toolId = "template", toolName = "XNAT 1.7 Template Plugin")
public class TemplatePreferencesBean extends AbstractPreferenceBean {
    @Autowired
    public TemplatePreferencesBean(final NrgPreferenceService preferenceService, final ConfigPaths configFolderPaths) {
        super(preferenceService, configFolderPaths);
    }

    @NrgPreference
    public List<String> getTemplateIds() {
        return getListValue("templateIds");
    }

    public void setTemplateIds(final List<String> templateIds) {
        try {
            setListValue("templateIds", templateIds);
        } catch (InvalidPreferenceName invalidPreferenceName) {
            //
        }
    }
}
