package com.bank.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutdownController implements ApplicationContextAware {
    
    private ApplicationContext context;
    
    @GetMapping("/shutdownContext")
    public String shutdownContext() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait to let HTTP response complete
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ((ConfigurableApplicationContext) context).close(); // Gracefully shutdown
        });
        thread.setDaemon(false); // JVM waits for this thread to finish
        thread.start();
        return "Shutting down application context...";
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
        
    }
    
    
}