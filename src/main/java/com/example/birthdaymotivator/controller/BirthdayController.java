package com.example.birthdaymotivator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

@Controller
public class BirthdayController {

    private static final String[] MOTIVATIONAL_SPEECHES = {
            "Believe in yourself and all that you are. Happy Birthday!",
            "Every year is a new chapter. Make this one the best yet!",
            "Your potential is endless. Keep shining bright!",
            "Age is merely the number of years the world has been enjoying you.",
            "Dream big and dare to fail. Happy Birthday!",
            "May your year be filled with success, joy, and laughter!",
            "Your journey is inspiring. Keep pushing forward!",
            "Celebrate your achievements and look forward to new goals."
    };

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateAge(@RequestParam("dob") String dobStr, Model model) {
        try {
            LocalDate birthDate = LocalDate.parse(dobStr);
            LocalDate today = LocalDate.now();

            int age = Period.between(birthDate, today).getYears();

            model.addAttribute("age", age);

            if (birthDate.getMonth() == today.getMonth() && birthDate.getDayOfMonth() == today.getDayOfMonth()) {
                model.addAttribute("message", "Happy Birthday! 🎉");
                model.addAttribute("motivation", getRandomMotivationalSpeech());
            } else {
                model.addAttribute("message", "Hello! Your birthday is on " + birthDate.getMonth() + " " + birthDate.getDayOfMonth() + ".");
                model.addAttribute("motivation", "We will wish you a happy birthday on your special day!");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Invalid date format. Please use YYYY-MM-DD.");
        }
        return "index";
    }

    private String getRandomMotivationalSpeech() {
        Random rand = new Random();
        int index = rand.nextInt(MOTIVATIONAL_SPEECHES.length);
        return MOTIVATIONAL_SPEECHES[index];
    }
}

