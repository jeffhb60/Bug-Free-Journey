package com.jeffhb60.bugfreejourney.bootstrap;


import com.jeffhb60.bugfreejourney.model.*;
import com.jeffhb60.bugfreejourney.repositories.CategoryRepository;
import com.jeffhb60.bugfreejourney.repositories.ProductRepository;
import com.jeffhb60.bugfreejourney.repositories.RoleRepository;
import com.jeffhb60.bugfreejourney.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component @RequiredArgsConstructor
public class DataBootStrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

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

        if (productRepository.count() == 0) {
            List<Product> products = List.of(
                    new Product("Smartphone", "Latest smartphone with cutting-edge features.", 100, 699.99, 10, electronics),
                    new Product("Laptop", "High-performance laptop for professionals.", 50, 1199.99, 15, electronics),
                    new Product("Headphones", "Noise-cancelling wireless headphones.", 80, 199.99, 20, electronics),
                    new Product("Television", "4K Ultra HD Smart TV.", 30, 899.99, 10, electronics),
                    new Product("Gaming Console", "Next-gen gaming console.", 40, 499.99, 5, gaming),
                    new Product("Jeans", "Stylish denim jeans for casual wear.", 150, 49.99, 10, clothing),
                    new Product("T-shirt", "Comfortable cotton T-shirt in various colors.", 200, 19.99, 5, clothing),
                    new Product("Sneakers", "Lightweight running sneakers.", 100, 89.99, 15, shoes),
                    new Product("Dress", "Elegant evening dress.", 60, 129.99, 20, clothing),
                    new Product("Wristwatch", "Stylish analog wristwatch.", 80, 249.99, 25, jewelry),
                    new Product("Necklace", "Beautiful gold-plated necklace.", 50, 299.99, 30, jewelry),
                    new Product("Cookware Set", "Premium stainless steel cookware set.", 40, 199.99, 10, kitchenAppliances),
                    new Product("Blender", "High-speed blender for smoothies.", 70, 59.99, 15, kitchenAppliances),
                    new Product("Air Fryer", "Oil-free air fryer for healthy cooking.", 50, 119.99, 20, kitchenAppliances),
                    new Product("Book - Science Fiction", "Bestselling science fiction novel.", 120, 14.99, 10, books),
                    new Product("Book - Mystery", "A thrilling mystery novel.", 80, 19.99, 5, books),
                    new Product("Soccer Ball", "Professional-grade soccer ball.", 100, 29.99, 10, sportsEquipment),
                    new Product("Basketball", "Durable outdoor basketball.", 120, 39.99, 15, sportsEquipment),
                    new Product("Yoga Mat", "Non-slip yoga mat for fitness.", 150, 25.99, 20, fitnessGear),
                    new Product("Dumbbells", "Adjustable dumbbell set.", 60, 49.99, 15, fitnessGear),
                    new Product("Wall Art", "Abstract canvas wall art.", 30, 89.99, 20, homeDecor),
                    new Product("Floor Lamp", "Modern LED floor lamp.", 40, 79.99, 10, lighting),
                    new Product("Baby Stroller", "Lightweight baby stroller.", 25, 159.99, 15, babyProducts),
                    new Product("Baby Monitor", "Digital baby monitor with camera.", 50, 99.99, 20, babyProducts),
                    new Product("Guitar", "Acoustic guitar for beginners.", 30, 149.99, 10, musicalInstruments),
                    new Product("Piano Keyboard", "61-key electronic keyboard.", 20, 199.99, 15, musicalInstruments),
                    new Product("Sketchbook", "Premium sketchbook for artists.", 100, 14.99, 5, artSupplies),
                    new Product("Paint Set", "Acrylic paint set for art projects.", 80, 29.99, 10, artSupplies),
                    new Product("Car Tire", "All-season car tire.", 50, 99.99, 10, automotive),
                    new Product("Car Wax", "Premium car wax for a shiny finish.", 150, 19.99, 15, automotive),
                    new Product("Tent", "Waterproof camping tent for 4 people.", 30, 129.99, 20, outdoorGear),
                    new Product("Sleeping Bag", "Comfortable sleeping bag for camping.", 50, 59.99, 15, outdoorGear),
                    new Product("Dog Food", "Nutritious dog food.", 200, 49.99, 10, petSupplies),
                    new Product("Cat Toy", "Interactive toy for cats.", 150, 14.99, 5, petSupplies),
                    new Product("Water Bottle", "Stainless steel insulated water bottle.", 100, 24.99, 10, travelEssentials),
                    new Product("Backpack", "Durable hiking backpack.", 80, 59.99, 15, travelEssentials),
                    new Product("Wine Glasses", "Set of crystal wine glasses.", 30, 39.99, 20, wineAndSpirits),
                    new Product("Cheese Platter", "Gourmet cheese platter for events.", 20, 49.99, 15, gourmetFoods),
                    new Product("Robot Vacuum", "Smart robot vacuum cleaner for effortless cleaning.", 40, 299.99, 25, cleaningSupplies),
                    new Product("Toolbox", "Complete DIY toolbox with essential tools.", 60, 79.99, 10, diyTools),
                    new Product("Cordless Drill", "High-performance cordless drill.", 50, 119.99, 20, diyTools),
                    new Product("Luxury Watch", "Premium Swiss luxury watch.", 15, 4999.99, 30, luxuryItems),
                    new Product("Perfume", "Exclusive designer perfume.", 60, 199.99, 20, beautyProducts),
                    new Product("Lipstick Set", "Matte lipstick set in vibrant shades.", 100, 49.99, 15, beautyProducts),
                    new Product("Exercise Bike", "Indoor exercise bike for cardio workouts.", 30, 499.99, 25, fitnessGear),
                    new Product("Pull-Up Bar", "Wall-mounted pull-up bar.", 80, 59.99, 10, fitnessGear),
                    new Product("Garden Shovel", "Heavy-duty garden shovel.", 100, 29.99, 15, gardenSupplies),
                    new Product("Lawn Mower", "Electric lawn mower for large yards.", 20, 399.99, 20, gardenSupplies),
                    new Product("Desk Lamp", "LED desk lamp with adjustable brightness.", 120, 39.99, 10, lighting),
                    new Product("Chandelier", "Elegant crystal chandelier.", 10, 599.99, 25, lighting),
                    new Product("Leather Bag", "Premium leather travel bag.", 40, 199.99, 15, bagsAndAccessories),
                    new Product("Wallet", "Compact leather wallet.", 150, 49.99, 10, bagsAndAccessories),
                    new Product("Notebook", "Spiral-bound notebook for daily use.", 200, 5.99, 10, stationery),
                    new Product("Planner", "2024 daily planner.", 100, 14.99, 15, stationery),
                    new Product("Craft Glue", "Strong adhesive craft glue.", 120, 3.99, 5, craftSupplies),
                    new Product("Sewing Kit", "Portable sewing kit for crafts.", 60, 19.99, 10, craftSupplies),
                    new Product("Wine Bottle", "Premium red wine from Italy.", 50, 29.99, 20, wineAndSpirits),
                    new Product("Cheeseboard", "Rustic wooden cheeseboard.", 40, 39.99, 10, gourmetFoods),
                    new Product("Espresso Machine", "Automatic espresso machine for coffee lovers.", 30, 699.99, 20, kitchenAppliances),
                    new Product("Microwave Oven", "Compact microwave oven with multiple settings.", 50, 199.99, 15, kitchenAppliances),
                    new Product("Basketball Hoop", "Adjustable outdoor basketball hoop.", 20, 349.99, 25, sportsEquipment),
                    new Product("Tennis Racket", "Lightweight professional tennis racket.", 60, 149.99, 15, sportsEquipment),
                    new Product("Playhouse", "Outdoor playhouse for kids.", 15, 399.99, 20, toys),
                    new Product("Action Figures", "Set of collectible action figures.", 100, 59.99, 10, toys),
                    new Product("Electric Kettle", "Stainless steel electric kettle.", 80, 49.99, 15, kitchenAppliances),
                    new Product("Dog Bed", "Comfortable dog bed for all sizes.", 70, 79.99, 20, petSupplies),
                    new Product("Cat Litter Box", "Odor-free litter box for cats.", 90, 49.99, 15, petSupplies),
                    new Product("Bookshelf", "Compact wooden bookshelf.", 40, 99.99, 15, furniture),
                    new Product("Office Chair", "Ergonomic office chair for comfort.", 30, 299.99, 20, furniture),
                    new Product("Notebook", "Portable notebook for jotting down ideas.", 200, 4.99, 5, stationery),
                    new Product("Candle Set", "Aromatic candle set for relaxation.", 80, 19.99, 10, seasonalItems),
                    new Product("Holiday Lights", "Colorful LED holiday lights.", 100, 29.99, 15, seasonalItems),
                    new Product("Bluetooth Speaker", "Portable Bluetooth speaker with powerful bass.", 70, 99.99, 10, electronicsAccessories),
                    new Product("Power Bank", "High-capacity portable power bank.", 120, 49.99, 15, electronicsAccessories),
                    new Product("Leather Gloves", "Premium leather gloves for winter.", 60, 39.99, 10, clothing),
                    new Product("Scarf", "Soft woolen scarf for cold weather.", 100, 19.99, 5, clothing)

            );
            productRepository.saveAll(products);
        }

        if (userRepository.count() == 0) {
            // Retrieve or create roles
            Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER)
                    .orElseGet(() -> {
                        Role newUserRole = new Role(AppRole.ROLE_USER);
                        return roleRepository.save(newUserRole);
                    });

            Role sellerRole = roleRepository.findByRoleName(AppRole.ROLE_SELLER)
                    .orElseGet(() -> {
                        Role newSellerRole = new Role(AppRole.ROLE_SELLER);
                        return roleRepository.save(newSellerRole);
                    });

            Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
                    .orElseGet(() -> {
                        Role newAdminRole = new Role(AppRole.ROLE_ADMIN);
                        return roleRepository.save(newAdminRole);
                    });

            Set<Role> userRoles = Set.of(userRole);
            Set<Role> sellerRoles = Set.of(sellerRole);
            Set<Role> adminRoles = Set.of(userRole, sellerRole, adminRole);


            // Create users if not already present
            if (!userRepository.existsByUserName("user1")) {
                User user1 = new User("user1", "user1@example.com", passwordEncoder.encode("password1"));
                userRepository.save(user1);
            }

            if (!userRepository.existsByUserName("seller1")) {
                User seller1 = new User("seller1", "seller1@example.com", passwordEncoder.encode("password2"));
                userRepository.save(seller1);
            }

            if (!userRepository.existsByUserName("admin")) {
                User admin = new User("admin", "admin@example.com", passwordEncoder.encode("adminPass"));
                userRepository.save(admin);
            }

            // Update roles for existing users
            userRepository.findByUserName("user1").ifPresent(user -> {
                user.setRoles(userRoles);
                userRepository.save(user);
            });

            userRepository.findByUserName("seller1").ifPresent(seller -> {
                seller.setRoles(sellerRoles);
                userRepository.save(seller);
            });

            userRepository.findByUserName("admin").ifPresent(admin -> {
                admin.setRoles(adminRoles);
                userRepository.save(admin);
            });
        }
    }
}
