// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.torm.domain;

import com.torm.domain.Admin;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Admin_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Admin.entityManager;
    
    public static final EntityManager Admin.entityManager() {
        EntityManager em = new Admin().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Admin.countAdmins() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Admin o", Long.class).getSingleResult();
    }
    
    public static List<Admin> Admin.findAllAdmins() {
        return entityManager().createQuery("SELECT o FROM Admin o", Admin.class).getResultList();
    }
    
    public static Admin Admin.findAdmin(Long id_) {
        if (id_ == null) return null;
        return entityManager().find(Admin.class, id_);
    }
    
    public static List<Admin> Admin.findAdminEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Admin o", Admin.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Admin.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Admin.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Admin attached = Admin.findAdmin(this.id_);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Admin.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Admin.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Admin Admin.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Admin merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
