package net.johnbrooks.NW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by John on 5/16/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        String searchFor;

        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("What food do you want to search for? ");
            searchFor = br.readLine();
            System.out.println("Searching for " + searchFor + "...");
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        NutritionIXItem[] items = NutritionIXQuery.searchForItems(searchFor);
        for (NutritionIXItem item : items)
            System.out.println(item);
    }
}