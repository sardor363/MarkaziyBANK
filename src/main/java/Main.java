import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.ResponseItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1=> Continue\t0=> Exit");
            int of = scanner.nextByte();
            if (of == 1) {
                menu1();
            } else {
                System.exit(0);
            }
        }
    }

    public static void menu1() {
        System.out.println("Currency => Sum");
        System.out.println("1=> USD");
        System.out.println("2=> EUR");
        System.out.println("3=> RUB");
        System.out.println("4=> 🔄🔄🔄");
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> Dollar();
            case 2 -> EURO();
            case 3 -> RUB();
            case 4 -> menu2();
        }
    }

    public static void menu2() {
        System.out.println("Sum => Currency");
        System.out.println("1=> USD");
        System.out.println("2=> EUR");
        System.out.println("3=> RUB");
        System.out.println("4=> 🔄🔄🔄");
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> Dollar2();
            case 2 -> EURO2();
            case 3 -> RUB2();
            case 4 -> menu1();
        }
    }

    public static void Dollar() {

        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();
            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);
            ResponseItem responseItem = responses.get(0);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the dollar amount: ");
            double dollar = scanner.nextDouble();
            double v = Double.parseDouble(responseItem.getRate());
            Double bd = v * dollar;
            System.out.println("Dollar to Uzbek sum: " + bd.longValue() + " Sum");


        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void EURO() {

        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();
            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);
            ResponseItem responseItem = responses.get(1);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the euro amount: ");
            double EURO2 = scanner.nextDouble();
            double v = Double.parseDouble(responseItem.getRate());
            Double bd = v * EURO2;
            System.out.println("Euro to Uzbek sum: " + bd.longValue() + " Sum");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void RUB() {

        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();
            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);
            ResponseItem responseItem = responses.get(2);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the ruble amount: ");
            double RU = scanner.nextDouble();
            double v = Double.parseDouble(responseItem.getRate());
            Double bd = v * RU;
            System.out.println("Ruble to Uzbek sum: " + bd.longValue() + " Sum");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void Dollar2() {

        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();
            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);
            ResponseItem responseItem = responses.get(0);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the sum amount: ");
            double dollar = scanner.nextDouble();
            double v = Double.parseDouble(responseItem.getRate());
            System.out.println(" Uzbek to Dollar: " + dollar / v + " $");


        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void EURO2() {

        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();
            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);
            ResponseItem responseItem = responses.get(1);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the sum amount: ");
            double EURO2 = scanner.nextDouble();
            double v = Double.parseDouble(responseItem.getRate());
            System.out.println("Uzbek to Dollar : " + EURO2 / v + " €");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void RUB2() {

        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type = new TypeToken<ArrayList<ResponseItem>>() {
            }.getType();
            ArrayList<ResponseItem> responses = gson.fromJson(bufferedReader, type);
            ResponseItem responseItem = responses.get(2);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the sum amount: ");
            double RU = scanner.nextDouble();
            double v = Double.parseDouble(responseItem.getRate());
            System.out.println("Uzbek to Ruble: " + RU / v + " Ruble");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}