package de.steinuntersteinen.kontenplan.server.model;

import java.util.List;

public interface GLAccountRepository {

    void save(GLAccount theGLAccount);

    List<GLAccount> findAll();
}

