package de.steinuntersteinen.kontenplan.server.model;

import java.util.List;

public interface GLAccountRepository {

    GLAccount save(GLAccount theGLAccount);

    List<GLAccount> findAll();

}

