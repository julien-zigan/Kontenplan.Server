package de.steinuntersteinen.kontenplan.server.controller;

import de.steinuntersteinen.kontenplan.server.model.GLAccount;
import de.steinuntersteinen.kontenplan.server.model.GLAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/glaccounts")
public class GLAccountController {

    private final GLAccountRepository glAccountRepository;

    @Autowired
    public GLAccountController(GLAccountRepository glAccountRepository) {
        this.glAccountRepository = glAccountRepository;
    }

    @GetMapping
    public List<GLAccount> getGLAccounts() {
        return glAccountRepository.findAll();
    }
}
