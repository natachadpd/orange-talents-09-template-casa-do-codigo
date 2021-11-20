package br.com.zupacademy.natacha.casadocodigo.controller;

import br.com.zupacademy.natacha.casadocodigo.Repository.AutorRepository;
import br.com.zupacademy.natacha.casadocodigo.controller.form.AutorForm;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AutorControllerTest {


    @Autowired
    private AutorRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    void deveRetornar200AoCadastrarNomeDoAutorEmBranco() throws Exception{
        URI uri = new URI("/autores");
        AutorForm autor = new AutorForm(
                "Joaquim Silva",
                "joaquim.silva@autor.com",
                "um autor da historia ensinada do Brasil"
        );

        String requestJson = gson.toJson(autor);

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }


    @Test
    void deveRetornar400AoCadastrarNomeDoAutorEmBranco() throws Exception{
        URI uri = new URI("/autores");
        AutorForm autor = new AutorForm(
                "",
                "joaquim.silva@autor.com",
                "um autor da historia ensinada do Brasil"
        );

        String requestJson = gson.toJson(autor);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    void deveRetornar400AoCadastrarEmailEmBranco() throws Exception{
        URI uri = new URI("/autores");
        AutorForm autor = new AutorForm(
                "Joaquim",
                "",
                "um autor da historia ensinada do Brasil"
        );

        String requestJson = gson.toJson(autor);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    void deveRetornar400AoCadastrarDescricaoEmBranco() throws Exception{
        URI uri = new URI("/autores");
        AutorForm autor = new AutorForm(
                "Joaquim",
                "joaqui.silva@autor.com",
                ""
        );

        String requestJson = gson.toJson(autor);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}