package com.em.grapes.main.fomanticUI;

import org.junit.jupiter.api.Test;

import com.em.grapes.main.fomanticUI.Toast;

import static org.junit.jupiter.api.Assertions.*;

class ToastTest {

    @Test
    void shouldCreateProperInstance() {

        var toast = Toast.success("test", "test message");

        assertAll(
                () -> assertEquals("test", toast.title()),
                () -> assertEquals("test message", toast.message()),
                () -> assertEquals("success", toast.clazz())
        );
    }

}