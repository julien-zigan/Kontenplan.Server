package de.steinuntersteinen.kontenplan.server.model;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
