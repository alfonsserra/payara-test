package com.systelab.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Patient")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Patient.findAll", query = "SELECT a FROM Patient a"),
        @NamedQuery(name = "Patient.findById", query = "SELECT a FROM Patient a WHERE a.id = :id"),
        @NamedQuery(name = "Patient.findByFirstName", query = "SELECT a FROM Patient a WHERE a.firstName = :firstName"),
        @NamedQuery(name = "Patient.findByLastName", query = "SELECT a FROM Patient a WHERE a.lastName = :lastName"),
        @NamedQuery(name = "Patient.findByStartDate", query = "SELECT a FROM Patient a WHERE a.startDate = :startDate"),
        @NamedQuery(name = "Patient.findByAge", query = "SELECT a FROM Patient a WHERE a.age = :age"),
        @NamedQuery(name = "Patient.findByStatus", query = "SELECT a FROM Patient a WHERE a.status = :status")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;

    public Patient() {
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.systelab.model.Patient[ id=" + id + " ]";
    }

}