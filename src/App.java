import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

public class App {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        UserService userService = new UserService();
        FoodService foodService = new FoodService();

        List<Restaurant> restaurantes = null;
        Map<Integer, Restaurant> restauranteMap = new HashMap<>();
        User user = null;
        List<Food> todasAsComidas = null;
        List<Food> comidasParaIndex = null;

        try {
            restaurantes = restaurantService.getAllRestaurants();
            System.out.println("Restaurantes carregados. Primeiro: " + (restaurantes != null && !restaurantes.isEmpty() ? restaurantes.get(0).getName() : "Nenhum"));

            if (restaurantes != null) {
                for (Restaurant r : restaurantes) {
                    restauranteMap.put(r.getId(), r);
                }
            }
            System.out.println("Mapa de restaurantes criado com " + restauranteMap.size() + " entradas.");

            user = userService.getUserById(2);
            System.out.println("Usuário carregado: " + (user != null ? user.getName() : "Nenhum"));

            todasAsComidas = foodService.getAllFoods();
            System.out.println("Comidas carregadas. Total: " + (todasAsComidas != null ? todasAsComidas.size() : 0));

            if (todasAsComidas != null && todasAsComidas.size() > 5) {
                comidasParaIndex = todasAsComidas.subList(0, 5);
                System.out.println("Comidas para index.html limitadas para: " + comidasParaIndex.size() + " itens.");
            } else {
                comidasParaIndex = todasAsComidas;
            }

        } catch (Exception e) {
            System.err.println("Erro ao carregar dados da API: " + e.getMessage());
            e.printStackTrace();
        }

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

       
        Context indexContext = new Context();
        indexContext.setVariable("comidas", comidasParaIndex);
        indexContext.setVariable("restaurantes", restaurantes);
        indexContext.setVariable("user", user);

        String indexOutputFileName = "index_output.html";
        String outputDirectory = "output";
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        try (FileWriter writer = new FileWriter(outputDirectory + File.separator + indexOutputFileName)) {
            templateEngine.process("home", indexContext, writer);
            System.out.println("HTML gerado com sucesso: " + outputDirectory + File.separator + indexOutputFileName);
        } catch (IOException e) {
            System.err.println("Erro ao gerar ou salvar o index_output.html: " + e.getMessage());
            e.printStackTrace();
        }

    
        Context emAltaContext = new Context();
        emAltaContext.setVariable("comidas", todasAsComidas);
        emAltaContext.setVariable("user", user);
        emAltaContext.setVariable("restauranteMap", restauranteMap);

        String emAltaOutputFileName = "emAlta_output.html";

        try (FileWriter writer = new FileWriter(outputDirectory + File.separator + emAltaOutputFileName)) {
            templateEngine.process("emAlta", emAltaContext, writer);
            System.out.println("HTML gerado com sucesso: " + outputDirectory + File.separator + emAltaOutputFileName);
        } catch (IOException e) {
            System.err.println("Erro ao gerar ou salvar o emAlta_output.html: " + e.getMessage());
            e.printStackTrace();
        }
    }
}