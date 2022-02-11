package org.nrg.xnat.mbc.xmetadata.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "projectID"))
@Slf4j

@Getter @Setter
public class Xmetadata extends AbstractHibernateEntity {
    private String _projectID;

    public String get_projectID() {
        return _projectID;
    }

    public void set_projectID(String _projectID) {
        this._projectID = _projectID;
    }
    

}
