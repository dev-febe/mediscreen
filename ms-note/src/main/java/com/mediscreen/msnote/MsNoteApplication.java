package com.mediscreen.msnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsNoteApplication.class, args);
    }

}
