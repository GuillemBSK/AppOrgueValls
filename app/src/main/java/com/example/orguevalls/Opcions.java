package com.example.orguevalls;

public class Opcions {

    public static String question[] ={
            "Busqueu aquest carreu i situeu-lo al plànol.",
            "Segons la imatge, on creieu que estava situat l’orgue anterior? Situeu-lo al plànol.",
            "Segons la imatge, on creieu que estava situat l’orgue anterior? Situeu-lo al plànol.",
    };

    public static int choices[][] = {
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
            {R.id.top_left,R.id.top_right,R.id.middle_left, R.id.middle_right, R.id.bottom_left, R.id.bottom_right},
    };

    public static int correctAnswers[] = {
            R.id.bottom_left,
            R.id.top_right,
            R.id.top_right,
    };

    public static int[] images = {
            R.drawable.pregunta1,
            R.drawable.pregunta2,
            R.drawable.pregunta3,
    };
}
