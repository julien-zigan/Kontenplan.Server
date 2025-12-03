package de.steinuntersteinen.kontenplan.server.controller;

import de.steinuntersteinen.kontenplan.server.model.GLAccount;
import de.steinuntersteinen.kontenplan.server.model.GLAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> createGLAccount(@RequestBody GLAccount glAccount2create, UriComponentsBuilder uriComponentsBuilder) {
        GLAccount createdGLAccount = glAccountRepository.save(glAccount2create);
        URI uriOfcreatedGLAccoutn = uriComponentsBuilder
                .path("/api/v1/glaccounts/{no}")
                .buildAndExpand(createdGLAccount.getNo())
                .toUri();
        return ResponseEntity.created(uriOfcreatedGLAccoutn).build();
    }
}
