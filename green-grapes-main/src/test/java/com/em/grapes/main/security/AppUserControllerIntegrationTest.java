package com.em.grapes.main.security;

import com.em.grapes.main.db.CleanUpTestData;
import com.em.grapes.main.security.AppUserService;
import com.em.grapes.main.security.db.UserEntityRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.em.grapes.main.fomanticUI.ToastFeatureMatchers.clazz;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("postgres")
@CleanUpTestData
class AppUserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AppUserService appUserService;

    @Autowired
    UserEntityRepository userEntityRepository;


    @Test
    void usersCanSignUp() throws Exception {
        assertFalse(userEntityRepository.existsById("test"));
        assertFalse(appUserService.userExists("test"));

        mockMvc.perform(post("/user/sign-up")
                        .with(csrf())
                        .param("username", "test")
                        .param("password", "test password")
                )
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"))
                .andExpect(flash().attributeExists("toast"))
                .andExpect(flash().attribute("toast", clazz(is("success"))))
        ;

        assertTrue(userEntityRepository.existsById("test"));
        assertTrue(appUserService.userExists("test"));
    }

}