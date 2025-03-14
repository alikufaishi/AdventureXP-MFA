package com.example.adventurexp;

import com.example.adventurexp.model.Activity;
import com.example.adventurexp.model.Booking;
import com.example.adventurexp.model.SalesItem;
import com.example.adventurexp.service.ActivityService;
import com.example.adventurexp.service.BookingService;
import com.example.adventurexp.service.SalesItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Transactional medfører at testdata ikke gemmes i vores rigtige MySQL (eller rulles tilbage...)
@Transactional
@SpringBootTest
class AdventureXpApplicationTests {

    // Vi autowirer for at kunne udføre tests på disse services
    @Autowired
    private ActivityService activityService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private SalesItemService salesItemService;

    @Test
    void testActivityServiceNotNull() {
        // Tjekker om den er injiceret korrekt.
        assertNotNull(activityService, "ActivityService skal være injiceret og ikke være null.");
    }

    @Test
    void testFetchActivities() {
        // Tester at findAll() returnerer en liste der ikke er NULL og er større end 0
        List<Activity> activities = activityService.findAll();
        assertNotNull(activities, "Listen af aktiviteter skal ikke være null.");
        assertTrue(activities.size() > 0, "Der skal være mindst én aktivitet.");
    }

    @Test
    void testSaveSalesItem() {
        // Opretter ny sales item
        SalesItem salesItem = new SalesItem();
        salesItem.setType("Kalkunbacon");
        salesItem.setPrice(142);

        // Gemmer den nye item i DB
        salesItemService.saveSalesItem(salesItem);

        // Tester at navnet på det oprettede databaseelement er som forventet
        assertEquals("Kalkunbacon",salesItemService.saveSalesItem(salesItem).getType());

        // Laver en Liste af alle salesitems der hedder Kalkunbacon
        List<SalesItem> resultatSalesItems = salesItemService.findByType("Kalkunbacon");

        // Vi laver en string array så vi kan gemme alle types i databasen der hedder Kalkunbacon
        List<String> typeListe = new ArrayList<>();

        // Vi gemmer alle types i databasen
        for (SalesItem enkelt : resultatSalesItems) {
            typeListe.add(enkelt.getType());
        }

        // Vi laver assertion som tjekker om kalkunbacon er i databasen (altså i string arrayet)
        assertTrue(typeListe.contains("Kalkunbacon") == true, "Vi har kalkunbacon!");

    }

}
