package de.steinuntersteinen.kontenplan.server.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GLAccountRepositoryImpl implements GLAccountRepository {

    private final EntityManager entityManager;

    @Autowired
    public GLAccountRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(GLAccount theGLAccount) {
        entityManager.persist(theGLAccount);
    }

    @Override
    public List<GLAccount> findAll() {
        TypedQuery<GLAccount> query = entityManager.createQuery("From GLAccount", GLAccount.class);
        return query.getResultList();
    }
}
