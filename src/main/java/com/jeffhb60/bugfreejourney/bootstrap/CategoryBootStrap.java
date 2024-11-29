package com.jeffhb60.bugfreejourney.bootstrap;


import com.jeffhb60.bugfreejourney.model.Category;
import com.jeffhb60.bugfreejourney.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component @AllArgsConstructor
public class CategoryBootStrap implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Category> categories = null;
        if (categoryRepository.count() == 0) {

            categories = List.of(
                    new Category("Electronics"),
                    new Category("Clothing"),
                    new Category("Home Decor"),
                    new Category("Toys"),
                    new Category("Books"),
                    new Category("Shoes"),
                    new Category("Beauty Products"),
                    new Category("Sports Equipment"),
                    new Category("Kitchen Appliances"),
                    new Category("Outdoor Gear"),
                    new Category("Pet Supplies"),
                    new Category("Health and Wellness"),
                    new Category("Stationery"),
                    new Category("Gaming"),
                    new Category("Automotive"),
                    new Category("Jewelry"),
                    new Category("Art Supplies"),
                    new Category("Baby Products"),
                    new Category("Musical Instruments"),
                    new Category("Furniture"),
                    new Category("Groceries"),
                    new Category("Office Supplies"),
                    new Category("Seasonal Items"),
                    new Category("Bags and Accessories"),
                    new Category("Craft Supplies"),
                    new Category("Garden Supplies"),
                    new Category("Lighting"),
                    new Category("Travel Essentials"),
                    new Category("Fitness Gear"),
                    new Category("Electronics Accessories"),
                    new Category("Luxury Items"),
                    new Category("Cleaning Supplies"),
                    new Category("DIY Tools"),
                    new Category("Wine and Spirits"),
                    new Category("Gourmet Foods")
            );
            categoryRepository.saveAll(categories);
        }
        List<Category> allCategories = categoryRepository.findAll();
        if (allCategories.isEmpty()) {
            System.err.println("Categories could not be initialized.");
            return;
        }

        assert categories != null;
        Category electronics = categories.stream().filter(c -> c.getCategoryName().equals("Electronics")).findFirst().orElse(null);
        Category clothing = categories.stream().filter(c -> c.getCategoryName().equals("Clothing")).findFirst().orElse(null);
        Category homeDecor = categories.stream().filter(c -> c.getCategoryName().equals("Home Decor")).findFirst().orElse(null);
        Category toys = categories.stream().filter(c -> c.getCategoryName().equals("Toys")).findFirst().orElse(null);
        Category books = categories.stream().filter(c -> c.getCategoryName().equals("Books")).findFirst().orElse(null);
        Category shoes = categories.stream().filter(c -> c.getCategoryName().equals("Shoes")).findFirst().orElse(null);
        Category beautyProducts = categories.stream().filter(c -> c.getCategoryName().equals("Beauty Products")).findFirst().orElse(null);
        Category sportsEquipment = categories.stream().filter(c -> c.getCategoryName().equals("Sports Equipment")).findFirst().orElse(null);
        Category kitchenAppliances = categories.stream().filter(c -> c.getCategoryName().equals("Kitchen Appliances")).findFirst().orElse(null);
        Category outdoorGear = categories.stream().filter(c -> c.getCategoryName().equals("Outdoor Gear")).findFirst().orElse(null);
        Category petSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Pet Supplies")).findFirst().orElse(null);
        Category healthAndWellness = categories.stream().filter(c -> c.getCategoryName().equals("Health and Wellness")).findFirst().orElse(null);
        Category stationery = categories.stream().filter(c -> c.getCategoryName().equals("Stationery")).findFirst().orElse(null);
        Category gaming = categories.stream().filter(c -> c.getCategoryName().equals("Gaming")).findFirst().orElse(null);
        Category automotive = categories.stream().filter(c -> c.getCategoryName().equals("Automotive")).findFirst().orElse(null);
        Category jewelry = categories.stream().filter(c -> c.getCategoryName().equals("Jewelry")).findFirst().orElse(null);
        Category artSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Art Supplies")).findFirst().orElse(null);
        Category babyProducts = categories.stream().filter(c -> c.getCategoryName().equals("Baby Products")).findFirst().orElse(null);
        Category musicalInstruments = categories.stream().filter(c -> c.getCategoryName().equals("Musical Instruments")).findFirst().orElse(null);
        Category furniture = categories.stream().filter(c -> c.getCategoryName().equals("Furniture")).findFirst().orElse(null);
        Category groceries = categories.stream().filter(c -> c.getCategoryName().equals("Groceries")).findFirst().orElse(null);
        Category officeSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Office Supplies")).findFirst().orElse(null);
        Category seasonalItems = categories.stream().filter(c -> c.getCategoryName().equals("Seasonal Items")).findFirst().orElse(null);
        Category bagsAndAccessories = categories.stream().filter(c -> c.getCategoryName().equals("Bags and Accessories")).findFirst().orElse(null);
        Category craftSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Craft Supplies")).findFirst().orElse(null);
        Category gardenSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Garden Supplies")).findFirst().orElse(null);
        Category lighting = categories.stream().filter(c -> c.getCategoryName().equals("Lighting")).findFirst().orElse(null);
        Category travelEssentials = categories.stream().filter(c -> c.getCategoryName().equals("Travel Essentials")).findFirst().orElse(null);
        Category fitnessGear = categories.stream().filter(c -> c.getCategoryName().equals("Fitness Gear")).findFirst().orElse(null);
        Category electronicsAccessories = categories.stream().filter(c -> c.getCategoryName().equals("Electronics Accessories")).findFirst().orElse(null);
        Category luxuryItems = categories.stream().filter(c -> c.getCategoryName().equals("Luxury Items")).findFirst().orElse(null);
        Category cleaningSupplies = categories.stream().filter(c -> c.getCategoryName().equals("Cleaning Supplies")).findFirst().orElse(null);
        Category diyTools = categories.stream().filter(c -> c.getCategoryName().equals("DIY Tools")).findFirst().orElse(null);
        Category wineAndSpirits = categories.stream().filter(c -> c.getCategoryName().equals("Wine and Spirits")).findFirst().orElse(null);
        Category gourmetFoods = categories.stream().filter(c -> c.getCategoryName().equals("Gourmet Foods")).findFirst().orElse(null);

    }
}
