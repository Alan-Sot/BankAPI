package com.example.bankapi.request;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBalanceWithBadRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/-1")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void addBalanceIsOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.patch("/accounts/maxUp").contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":1, \"amount\":25")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void badAmountOrRequestWhenMaxBalance() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.patch("/accounts/maxUp").contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":1, \"amount\":-1}")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void bedRequestOrIdInGetCards()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/-1/cards")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void postPreviouslyCreatedCard()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/newCard").contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":1," + " \"limit\":5000}")).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void badOrNotFoundAccountId()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/newCard").contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":-1," + " \"limit\":5000}")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void badRequestOrLimitInPostNewCard()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/newCard").contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":1," + " \"limit\":-1}")).andDo(print()).andExpect(status().isBadRequest());
    }
}
