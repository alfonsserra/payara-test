package com.systelab.resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.systelab.model.Patient;


@Stateless
@Path("patient")
public class PatientResource {

    @PersistenceContext(unitName = "PatientPersistenceContext")
    private EntityManager em;

    public PatientResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Patient> findAll() {
        List<Patient> patientList = null;
        try {
            patientList = em.createQuery("select object(o) from Patient o").getResultList();
        } catch (NoResultException e) {

        }
        return patientList;
    }
}