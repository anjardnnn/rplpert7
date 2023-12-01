/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.springHibernate.dao;

import com.labti.springHibernate.model.Databarang;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DatabarangDAOImpl implements DatabarangDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Databarang mahasiswa){
        sessionFactory.getCurrentSession().save(mahasiswa);
    }
    
    @Override
    public void update(Databarang mahasiswa){
        sessionFactory.getCurrentSession().update(mahasiswa);
    }
    
    @Override
    public void delete(Databarang mahasiswa){
        sessionFactory.getCurrentSession().delete(mahasiswa);
    }
    
    @Override
    public Databarang getMahasiswa(String npm){
        return (Databarang) sessionFactory.getCurrentSession().get(Databarang.class, npm);        
    }
    
    @Override
    public List<Databarang> getMahasiswas(){
        return sessionFactory.getCurrentSession().createCriteria(Databarang.class).list();
    }
}