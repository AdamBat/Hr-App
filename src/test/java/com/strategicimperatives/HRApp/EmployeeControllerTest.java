package com.strategicimperatives.HRApp;

import com.strategicimperatives.HRApp.controllers.EmployeeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void addEmployeeTest() throws Exception {
        this.mockMvc.perform(post("/addEmployee")
                .param("firstName", "Adam")
                .param("lastName", " Bator")
                .param("salary", "30000"))
                .andExpect(status().isOk());

    }

    @Test
    public void listAllEmployeesTest() throws Exception {
        this.mockMvc.perform(get("/allEmployees")).andExpect(status().isOk());
    }
}

