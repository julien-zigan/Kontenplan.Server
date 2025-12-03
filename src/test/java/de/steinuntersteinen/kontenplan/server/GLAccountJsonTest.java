package de.steinuntersteinen.kontenplan.server;

import de.steinuntersteinen.kontenplan.server.model.GLAccount;
import de.steinuntersteinen.kontenplan.server.model.GLAccountType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class GLAccountJsonTest {

    @Autowired
    private JacksonTester<GLAccount> json;

    @Test
    public void GLAccountSerializationTest() throws IOException {

        GLAccount glAccount = new GLAccount("4", GLAccountType.CLASS, "Test", null, null, null);

        JsonContent<GLAccount> actualJson = json.write(glAccount);

        assertThat(actualJson).isStrictlyEqualToJson("expected-gl-account.json");
    }

    @Test
    public void GLAccountDeserializationTest() throws IOException {

        GLAccount expected = new GLAccount("4", GLAccountType.CLASS, "Test", null, null, null);
        String jsonToParse = """
                {
                  "no": "4",
                  "type": "CLASS",
                  "name": "Test",
                  "description": null,
                  "balance": null,
                  "parentNo": null
                }""";

        ObjectContent<GLAccount> actual = json.parse(jsonToParse);

        assertThat(actual).isEqualTo(expected);

    }
}
