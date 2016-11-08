package ua.goit.java.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.java.restaurant.DAO.interfaces.*;
import ua.goit.java.restaurant.model.*;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDB {
    @Autowired
    private DishDAO dishDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private IngredientDAO ingredientDAO;
    @Autowired
    private WarehouseDAO warehouseDAO;
    @Autowired
    private PreparedDishDAO preparedDishDAO;

    @PostConstruct
    public void init() {
        System.out.println("*** INIT DB START ***");

        Employee moreno = new Employee();
        moreno.setFirstName("Antonio");
        moreno.setLastName("Moreno");
        moreno.setBirthday(Date.valueOf("1970-01-01"));
        moreno.setPhoneNumber("+38(099)999-00-01");
        moreno.setPosition(Position.DIRECTOR);
        moreno.setSalary(400000);
        employeeDAO.save(moreno);

        Employee kipko = new Employee();
        kipko.setFirstName("Sergiy");
        kipko.setLastName("Kipko");
        kipko.setBirthday(Date.valueOf("1981-02-02"));
        kipko.setPhoneNumber("+38(099)999-00-02");
        kipko.setPosition(Position.ACCOUNTANT);
        kipko.setSalary(300000);
        employeeDAO.save(kipko);


        Employee iryna = new Employee();
        iryna.setFirstName("Iryna");
        iryna.setLastName("Sydorenko");
        iryna.setBirthday(Date.valueOf("1992-01-11"));
        iryna.setPhoneNumber("+38(099)999-00-11");
        iryna.setPosition(Position.WAITER);
        iryna.setSalary(160000);
        iryna.setBiography("Just a best waiter!");
        employeeDAO.save(iryna);

        Employee anna = new Employee();
        anna.setFirstName("Anna");
        anna.setLastName("Drob");
        anna.setBirthday(Date.valueOf("1993-01-12"));
        anna.setPhoneNumber("+38(099)999-00-12");
        anna.setPosition(Position.WAITER);
        anna.setSalary(155000);
        anna.setBiography("Just another best waiter!");
        employeeDAO.save(anna);

        Cook volodymyr = new Cook();
        volodymyr.setFirstName("Volodymyr");
        volodymyr.setLastName("Petrenko");
        volodymyr.setBirthday(Date.valueOf("1981-01-02"));
        volodymyr.setPhoneNumber("+38(099)999-00-08");
        volodymyr.setPosition(Position.COOK);
        volodymyr.setSalary(200000);
        employeeDAO.save(volodymyr);

        Cook vadim = new Cook();
        vadim.setFirstName("Vadim");
        vadim.setLastName("Pydgaychenko");
        vadim.setBirthday(Date.valueOf("1990-01-09"));
        vadim.setPhoneNumber("+38(099)999-00-09");
        vadim.setPosition(Position.COOK);
        vadim.setSalary(200000);
        employeeDAO.save(vadim);

        Cook oleg = new Cook();
        oleg.setFirstName("Oleg");
        oleg.setLastName("Stepanenko");
        oleg.setBirthday(Date.valueOf("1978-01-10"));
        oleg.setPhoneNumber("+38(099)999-00-10");
        oleg.setPosition(Position.COOK);
        oleg.setSalary(200001);
        employeeDAO.save(oleg);


        Ingredient dough = new Ingredient();
        dough.setName("dough");
        ingredientDAO.save(dough);
        Ingredient pizzaCheese = new Ingredient();
        pizzaCheese.setName("pizza cheese");
        ingredientDAO.save(pizzaCheese);
        Ingredient parmesanCheese = new Ingredient();
        parmesanCheese.setName("parmesan cheese");
        ingredientDAO.save(parmesanCheese);
        Ingredient mozzarellaCheese = new Ingredient();
        mozzarellaCheese.setName("mozzarella cheese");
        ingredientDAO.save(mozzarellaCheese);
        Ingredient fetaCheese = new Ingredient();
        fetaCheese.setName("feta cheese");
        ingredientDAO.save(fetaCheese);
        Ingredient cheddarCheese = new Ingredient();
        cheddarCheese.setName("cheddar cheese");
        ingredientDAO.save(cheddarCheese);
        Ingredient sausage = new Ingredient();
        sausage.setName("sausage");
        ingredientDAO.save(sausage);
        Ingredient ham = new Ingredient();
        ham.setName("ham");
        ingredientDAO.save(ham);
        Ingredient chicken = new Ingredient();
        chicken.setName("chicken");
        ingredientDAO.save(chicken);
        Ingredient bacon = new Ingredient();
        bacon.setName("bacon");
        ingredientDAO.save(bacon);
        Ingredient salami = new Ingredient();
        salami.setName("salami");
        ingredientDAO.save(salami);
        Ingredient pepperoni = new Ingredient();
        pepperoni.setName("pepperoni");
        ingredientDAO.save(pepperoni);
        Ingredient mussels = new Ingredient();
        mussels.setName("mussels");
        ingredientDAO.save(mussels);
        Ingredient shrimps = new Ingredient();
        shrimps.setName("shrimps");
        ingredientDAO.save(shrimps);
        Ingredient tuna = new Ingredient();
        tuna.setName("tuna");
        ingredientDAO.save(tuna);
        Ingredient seaCocktail = new Ingredient();
        seaCocktail.setName("sea cocktail");
        ingredientDAO.save(seaCocktail);
        Ingredient anchovies = new Ingredient();
        anchovies.setName("anchovies");
        ingredientDAO.save(anchovies);
        Ingredient lemon = new Ingredient();
        lemon.setName("lemon");
        ingredientDAO.save(lemon);
        Ingredient vegetableMix = new Ingredient();
        vegetableMix.setName("vegetable mix");
        ingredientDAO.save(vegetableMix);
        Ingredient onion = new Ingredient();
        onion.setName("onion");
        ingredientDAO.save(onion);
        Ingredient mushrooms = new Ingredient();
        mushrooms.setName("mushrooms");
        ingredientDAO.save(mushrooms);
        Ingredient tomatoes = new Ingredient();
        tomatoes.setName("tomatoes");
        ingredientDAO.save(tomatoes);
        Ingredient sweetPepper = new Ingredient();
        sweetPepper.setName("sweet pepper");
        ingredientDAO.save(sweetPepper);
        Ingredient greenOlives = new Ingredient();
        greenOlives.setName("green olives");
        ingredientDAO.save(greenOlives);
        Ingredient corn = new Ingredient();
        corn.setName("corn");
        ingredientDAO.save(corn);
        Ingredient cucumbers = new Ingredient();
        cucumbers.setName("cucumbers");
        ingredientDAO.save(cucumbers);
        Ingredient pickledCucumbers = new Ingredient();
        pickledCucumbers.setName("pickled cucumbers");
        ingredientDAO.save(pickledCucumbers);
        Ingredient capers = new Ingredient();
        capers.setName("capers");
        ingredientDAO.save(capers);
        Ingredient pineapples = new Ingredient();
        pineapples.setName("pineapples");
        ingredientDAO.save(pineapples);
        Ingredient carrot = new Ingredient();
        carrot.setName("carrot");
        ingredientDAO.save(carrot);
        Ingredient lettuces = new Ingredient();
        lettuces.setName("lettuces");
        ingredientDAO.save(lettuces);
        Ingredient beet = new Ingredient();
        beet.setName("beet");
        ingredientDAO.save(beet);
        Ingredient spices = new Ingredient();
        spices.setName("spices");
        ingredientDAO.save(spices);
        Ingredient oregano = new Ingredient();
        oregano.setName("oregano");
        ingredientDAO.save(oregano);
        Ingredient garlic = new Ingredient();
        garlic.setName("garlic");
        ingredientDAO.save(garlic);
        Ingredient parsley = new Ingredient();
        parsley.setName("parsley");
        ingredientDAO.save(parsley);
        Ingredient basil = new Ingredient();
        basil.setName("basil");
        ingredientDAO.save(basil);
        Ingredient rucola = new Ingredient();
        rucola.setName("rucola");
        ingredientDAO.save(rucola);
        Ingredient oliveOil = new Ingredient();
        oliveOil.setName("olive oil");
        ingredientDAO.save(oliveOil);
        Ingredient sugar = new Ingredient();
        sugar.setName("sugar");
        ingredientDAO.save(sugar);
        Ingredient salt = new Ingredient();
        salt.setName("salt");
        ingredientDAO.save(salt);
        Ingredient tabascoSauce = new Ingredient();
        tabascoSauce.setName("tabasco sauce");
        ingredientDAO.save(tabascoSauce);
        Ingredient tomatoSauce = new Ingredient();
        tomatoSauce.setName("tomato sauce ");
        ingredientDAO.save(tomatoSauce);
        Ingredient whiteSauce = new Ingredient();
        whiteSauce.setName("white sauce");
        ingredientDAO.save(whiteSauce);
        Ingredient spinachSauce = new Ingredient();
        spinachSauce.setName("spinach sauce");
        ingredientDAO.save(spinachSauce);
        Ingredient meatSauce = new Ingredient();
        meatSauce.setName("meat sauce");
        ingredientDAO.save(meatSauce);
        Ingredient spaghetti = new Ingredient();
        spaghetti.setName("spaghetti");
        ingredientDAO.save(spaghetti);
        Ingredient cream = new Ingredient();
        cream.setName("cream");
        ingredientDAO.save(cream);
        Ingredient creamButter = new Ingredient();
        creamButter.setName("cream butter ");
        ingredientDAO.save(creamButter);
        Ingredient lasagna = new Ingredient();
        lasagna.setName("lasagna");
        ingredientDAO.save(lasagna);
        Ingredient saladDressing = new Ingredient();
        saladDressing.setName("salad dressing");
        ingredientDAO.save(saladDressing);
        Ingredient raspberryDressing = new Ingredient();
        raspberryDressing.setName("raspberry dressing");
        ingredientDAO.save(raspberryDressing);
        Ingredient croutons = new Ingredient();
        croutons.setName("croutons");
        ingredientDAO.save(croutons);
        Ingredient lemonJuice = new Ingredient();
        lemonJuice.setName("lemon juice");
        ingredientDAO.save(lemonJuice);
        Ingredient balsamicVinegar = new Ingredient();
        balsamicVinegar.setName("balsamic vinegar");
        ingredientDAO.save(balsamicVinegar);
        Ingredient cherry = new Ingredient();
        cherry.setName("cherry");
        ingredientDAO.save(cherry);
        Ingredient orange = new Ingredient();
        orange.setName("orange");
        ingredientDAO.save(orange);
        Ingredient coffee = new Ingredient();
        coffee.setName("coffee");
        ingredientDAO.save(coffee);
        Ingredient tea = new Ingredient();
        tea.setName("tea");
        ingredientDAO.save(tea);
        Ingredient milk = new Ingredient();
        milk.setName("milk");
        ingredientDAO.save(milk);
        Ingredient chocolate = new Ingredient();
        chocolate.setName("chocolate");
        ingredientDAO.save(chocolate);
        Ingredient mint = new Ingredient();
        mint.setName("mint");
        ingredientDAO.save(mint);
        Ingredient beer = new Ingredient();
        beer.setName("beer");
        ingredientDAO.save(beer);
        Ingredient cocaCola = new Ingredient();
        cocaCola.setName("coca-cola");
        ingredientDAO.save(cocaCola);
        Ingredient sprite = new Ingredient();
        sprite.setName("sprite");
        ingredientDAO.save(sprite);
        Ingredient squid = new Ingredient();
        squid.setName("squid");
        ingredientDAO.save(squid);
        Ingredient darkChocolate = new Ingredient();
        darkChocolate.setName("dark chocolate");
        ingredientDAO.save(darkChocolate);
        Ingredient potato = new Ingredient();
        potato.setName("potato");
        ingredientDAO.save(potato);
        Ingredient cabbage = new Ingredient();
        cabbage.setName("cabbage");
        ingredientDAO.save(cabbage);
        Ingredient kidneyBeans = new Ingredient();
        kidneyBeans.setName("kidney beans ");
        ingredientDAO.save(kidneyBeans);


        List<Ingredient> margaritaIngredients = new ArrayList<>();
        margaritaIngredients.add(dough);
        margaritaIngredients.add(pizzaCheese);
        margaritaIngredients.add(basil);
        margaritaIngredients.add(tomatoSauce);

        Dish margarita = new Dish();
        margarita.setName("MARGARITA");
        margarita.setDishCategory(DishCategory.PIZZA);
        margarita.setPrice(158);
        margarita.setWeight(1250);
        margarita.setIngredients(margaritaIngredients);
        margarita.setDescription("The classic. Italian tomatoes, cheese and basil.");

        List<Ingredient> fourCheeseIngredients = new ArrayList<>();
        fourCheeseIngredients.add(dough);
        fourCheeseIngredients.add(whiteSauce);
        fourCheeseIngredients.add(pizzaCheese);
        fourCheeseIngredients.add(mozzarellaCheese);
        fourCheeseIngredients.add(fetaCheese);
        fourCheeseIngredients.add(parmesanCheese);
        fourCheeseIngredients.add(oregano);

        Dish fourCheese = new Dish();
        fourCheese.setName("FOUR CHEESE");
        fourCheese.setDishCategory(DishCategory.PIZZA);
        fourCheese.setPrice(226);
        fourCheese.setWeight(1450);
        fourCheese.setIngredients(fourCheeseIngredients);
        fourCheese.setDescription("This is the classic version of one of the most wonderful combinations of bread and cheese imaginable");

        List<Ingredient> caesarSaladIngredients = new ArrayList<>();
        caesarSaladIngredients.add(lettuces);
        caesarSaladIngredients.add(croutons);
        caesarSaladIngredients.add(parmesanCheese);
        caesarSaladIngredients.add(saladDressing);

        Dish caesarSalad = new Dish();
        caesarSalad.setName("CAESAR SALAD");
        caesarSalad.setDishCategory(DishCategory.SALADS);
        caesarSalad.setPrice(70);
        caesarSalad.setWeight(180);
        caesarSalad.setIngredients(caesarSaladIngredients);
        caesarSalad.setDescription("A selection of lettuces, croutons, parmezan, and our own Caesar salad dressing");

        List<Ingredient> greekSaladIngredients = new ArrayList<>();
        greekSaladIngredients.add(lettuces);
        greekSaladIngredients.add(sweetPepper);
        greekSaladIngredients.add(cucumbers);
        greekSaladIngredients.add(tomatoes);
        greekSaladIngredients.add(onion);
        greekSaladIngredients.add(fetaCheese);
        greekSaladIngredients.add(greenOlives);
        greekSaladIngredients.add(lemonJuice);
        greekSaladIngredients.add(oliveOil);
        greekSaladIngredients.add(oregano);
        greekSaladIngredients.add(spices);

        Dish greekSalad = new Dish();
        greekSalad.setName("GREEK SALAD");
        greekSalad.setDishCategory(DishCategory.SALADS);
        greekSalad.setPrice(80);
        greekSalad.setWeight(220);
        greekSalad.setIngredients(greekSaladIngredients);
        greekSalad.setDescription("A selection of lettuces, sweet pepper, cucumbers, tomatoes, onion, Feta cheese, olives, lemon juice, olive oil, oregano and spices");

        dishDAO.save(margarita);
        dishDAO.save(fourCheese);
        dishDAO.save(caesarSalad);
        dishDAO.save(greekSalad);

        List<Dish> pizzaDishes = new ArrayList<>();
        pizzaDishes.add(margarita);
        pizzaDishes.add(fourCheese);

        Menu pizza = new Menu();
        pizza.setName("PIZZA");
        pizza.setDishes(pizzaDishes);
        menuDAO.save(pizza);

        List<Dish> saladsDishes = new ArrayList<>();
        saladsDishes.add(caesarSalad);
        saladsDishes.add(greekSalad);

        Menu salads = new Menu();
        salads.setName("SALADS");
        salads.setDishes(saladsDishes);
        menuDAO.save(salads);

        Order order1 = new Order();
        order1.setWaiter(employeeDAO.findByName("Iryna"));
        order1.setDishes(pizzaDishes);
        order1.setTableNumber(1);
        order1.setOrderDate(new java.util.Date());
//        order1.setOrderStatus(OrderStatus.OPENED);
        orderDAO.save(order1);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setIngredient(dough);
        warehouse1.setMeasure(Measure.GRAM);
        warehouse1.setQuantity(100000.0);
        warehouseDAO.save(warehouse1);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setIngredient(pizzaCheese);
        warehouse2.setMeasure(Measure.GRAM);
        warehouse2.setQuantity(50000.0);
        warehouseDAO.save(warehouse2);

        Warehouse warehouse3 = new Warehouse();
        warehouse3.setIngredient(basil);
        warehouse3.setMeasure(Measure.PIECES);
        warehouse3.setQuantity(300.0);
        warehouseDAO.save(warehouse3);

        Warehouse warehouse4 = new Warehouse();
        warehouse4.setIngredient(tomatoSauce);
        warehouse4.setMeasure(Measure.LITER);
        warehouse4.setQuantity(45.0);
        warehouseDAO.save(warehouse4);

        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setCook(volodymyr);
        preparedDish.setDish(margarita);
        preparedDish.setCookingDate(new java.util.Date());
        preparedDishDAO.save(preparedDish);

        System.out.println("*** INIT DB DONE ***");

    }
}
