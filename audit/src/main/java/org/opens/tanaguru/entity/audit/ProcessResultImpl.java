/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.entity.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import org.opens.tanaguru.entity.reference.Test;
import org.opens.tanaguru.entity.reference.TestImpl;
import org.opens.tanaguru.entity.subject.WebResource;
import org.opens.tanaguru.entity.subject.WebResourceImpl;

/**
 * 
 * @author jkowalczyk
 */
@Entity
@Table(name = "PROCESS_RESULT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Id_Test", "Id_Web_Resource",
        "Id_Audit_Gross_Result"}),
    @UniqueConstraint(columnNames = {"Id_Test", "Id_Web_Resource",
        "Id_Audit_Net_Result"})})
public abstract class ProcessResultImpl implements ProcessResult, Serializable {

    private static final long serialVersionUID = -6016677895001819904L;
    @OneToMany(mappedBy = "parentResult", cascade = CascadeType.ALL)
    protected List<ProcessResultImpl> childResultList = new ArrayList<ProcessResultImpl>();
    @ManyToOne
    @JoinColumn(name = "Id_Audit_Gross_Result")
    protected AuditImpl grossResultAudit;
    @Id
    @GeneratedValue
    @Column(name = "Id_Process_Result")
    protected Long id;
    @ManyToOne
    @JoinColumn(name = "Id_Audit_Net_Result")
    protected AuditImpl netResultAudit;
    @ManyToOne
    @JoinColumn(name = "Id_Process_Result_Parent")
    protected ProcessResultImpl parentResult;
    @OneToMany(mappedBy = "processResult", cascade = {CascadeType.PERSIST})
    protected Set<ProcessRemarkImpl> remarkList = new LinkedHashSet<ProcessRemarkImpl>();
    @ManyToOne
    @JoinColumn(name = "Id_Web_Resource", nullable = false)
    protected WebResourceImpl subject;
    @ManyToOne
    @JoinColumn(name = "Id_Test")
    protected TestImpl test;
    @Column(name = "Element_Counter")
    protected int elementCounter;

    public ProcessResultImpl() {
        super();
    }

    @Override
    public void addAllRemark(Collection<? extends ProcessRemark> remarkSet) {
        if (remarkSet == null) {
            return;
        }

        for (ProcessRemark remark : remarkSet) {
            addRemark(remark);
        }
    }

    @Override
    public void addChildResult(ProcessResult childResult) {
        childResult.setParentResult(this);
        this.childResultList.add((ProcessResultImpl) childResult);
    }

    @Override
    public void addRemark(ProcessRemark remark) {
        remark.setProcessResult(this);
        remarkList.add((ProcessRemarkImpl) remark);
    }

    @Override
    @XmlElementWrapper
    @XmlElementRefs({
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.DefiniteResultImpl.class),
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.IndefiniteResultImpl.class)})
    public List<ProcessResultImpl> getChildResultList() {
        return childResultList;
    }

    @Override
    @XmlTransient
    public Audit getGrossResultAudit() {
        return grossResultAudit;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    @XmlTransient
    public Audit getNetResultAudit() {
        return netResultAudit;
    }

    @Override
    @XmlTransient
    public ProcessResult getParentResult() {
        return parentResult;
    }

    @Override
    @XmlElementWrapper
    @XmlElementRefs({
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.ProcessRemarkImpl.class),
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.SourceCodeRemarkImpl.class)})
    public Collection<ProcessRemarkImpl> getRemarkSet() {
        return remarkList;
    }

    @Override
    @XmlElementRefs({
        @XmlElementRef(type = org.opens.tanaguru.entity.subject.PageImpl.class),
    @XmlElementRef(type = org.opens.tanaguru.entity.subject.SiteImpl.class)})
    public WebResource getSubject() {
        return subject;
    }

    @Override
    @XmlElementRef(type = org.opens.tanaguru.entity.reference.TestImpl.class)
    public Test getTest() {
        return test;
    }

    @Override
    public int getElementCounter(){
       return elementCounter;
    }

    @Override
    public void setChildResultList(
            Collection<? extends ProcessResult> childResultList) {
        for (ProcessResult processResult : childResultList) {
            processResult.setParentResult(this);
        }
        this.childResultList = (List<ProcessResultImpl>) childResultList;
    }

    @Override
    public void setGrossResultAudit(Audit grossResultAudit) {
        this.grossResultAudit = (AuditImpl) grossResultAudit;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setNetResultAudit(Audit netResultAudit) {
        this.netResultAudit = (AuditImpl) netResultAudit;
    }

    @Override
    public void setParentResult(ProcessResult parentResult) {
        this.parentResult = (ProcessResultImpl) parentResult;
    }

    @Override
    public void setRemarkSet(Collection<? extends ProcessRemark> remarkSet) {
        for (ProcessRemark processRemark : remarkSet) {
            processRemark.setProcessResult(this);
        }
        this.remarkList = (Set<ProcessRemarkImpl>) remarkSet;
    }

    @Override
    public void setSubject(WebResource subject) {
        this.subject = (WebResourceImpl) subject;
    }

    @Override
    public void setTest(Test test) {
        this.test = (TestImpl) test;
    }
    
    @Override
    public void setElementCounter(int elementCounter){
       this.elementCounter = elementCounter;
    }

}