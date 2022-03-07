package FinalProject;

import java.util.ArrayList; // it help to set an ArrayList
import java.util.Iterator;
import java.util.Scanner; // is used for taking input from user

/**
 *
 * @author
 * This program(app) help user to add the recipe, view the
 * recipes in the recipe box and detailed ideas of the recipe if required
 *
 * Also it helps how to cook
 */
public class RecipeBox {
 static private ArrayList<Recipe> listOfRecipes = new ArrayList();
 static private Recipe r = new Recipe();
 static private RecipeBox rb = new RecipeBox();

 public ArrayList<Recipe> getListOfRecipes() {
 return listOfRecipes;
 }

 public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
 this.listOfRecipes = listOfRecipes;
 }
 
 public RecipeBox() { // Constructor
 }
 
 public RecipeBox(ArrayList<Recipe> listOfRecipes) { // Parameterized constructor
 this.listOfRecipes = listOfRecipes;
 }

 public static void printAllRecipeDetails(String selectedRecipeName) throws Exception { 
// throws exception
 int j = -1;
 
 for (int i = 0; i < listOfRecipes.size(); i++) {
    if (listOfRecipes.get(i).getRecipeName().endsWith(selectedRecipeName.trim())) {
        j = i;
        r.setRecipeName(selectedRecipeName);
        r.setServings(listOfRecipes.get(i).getServings());

        r.setRecipeIngredients(listOfRecipes.get(i).getRecipeIngredients());

        r.setTotalRecipeCalories(listOfRecipes.get(i).getTotalRecipeCalories());
        r.printRecipe();
    }
 }

    if (j == -1) {
        System.out.println("The selected Recipe is not in recipe box");
    }
 }
 
/**
 *
 * Here the user can edit the recipe servings by providing the recipe name
and can
 * add can add the ingredients to the recipe.
 *
 */
 
 public void editRecipe(String selectedRecipeName) throws Exception {
 int j = -1;
 
 for (int i = 0; i < listOfRecipes.size(); i++) {
 
     if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName.trim())) {
        j = i;
        System.out.println("Edit servings (y or n)");
        Scanner scnr = new Scanner(System.in);
        char c = scnr.next().charAt(0);
        
        if (c == 'y') {
            r.inputServings(r , scnr);
            r.setRecipeName(selectedRecipeName);
            r.setRecipeIngredients(listOfRecipes.get(i).getRecipeIngredients());

            r.setTotalRecipeCalories(listOfRecipes.get(i).getTotalRecipeCalories());
            listOfRecipes.set(j, r);
            System.out.println("Edit Ingredients (y or n)");
            Scanner scnr1 = new Scanner(System.in);
            char c1 = scnr.next().charAt(0);
 
                if (c1 == 'y') {
                    r. inputIngredients(r , scnr1);
                    r.setRecipeName(selectedRecipeName);
                    r.setServings(listOfRecipes.get(i).getServings());

                    r.setTotalRecipeCalories(listOfRecipes.get(i).getTotalRecipeCalories());
                    listOfRecipes.set(j, r);
                } else {
                    r.setRecipeName(selectedRecipeName);
                    r.setServings(listOfRecipes.get(i).getServings());
                    r.setRecipeIngredients(listOfRecipes.get(i).getRecipeIngredients());

                    r.setTotalRecipeCalories(listOfRecipes.get(i).getTotalRecipeCalories());
                    r.printRecipe();
                 }
        } else {
            System.out.println("Edit Ingredients (y or n)");
            Scanner scnr1 = new Scanner(System.in);
            char c1 = scnr.next().charAt(0);
            
                if (c1 == 'y') {
                    r. inputIngredients(r , scnr1);
                    r.setRecipeName(selectedRecipeName);
                    r.setServings(listOfRecipes.get(i).getServings());

                    r.setTotalRecipeCalories(listOfRecipes.get(i).getTotalRecipeCalories());
                    listOfRecipes.set(j, r);
                }          
         }
    }
 }
 /**
 *
 * Here user can delete the recipe by proving the recipe name
 *
 */
 
    if (j == -1) {
        System.out.println("The selected Recipe is not in recipe box");
    }  
 }
 
 public void deleteRecipe(String name) throws Exception {
    int j = -1;
    
    for (int i = 0; i < listOfRecipes.size(); i++) {
 
        if (listOfRecipes.get(i).getRecipeName().contains(name.trim())) {
            j = i;

            listOfRecipes.remove(i);
            System.out.println("The recipe is deleted successfully" + "\n");
        }
 
//setListOfRecipes(listOfRecipes);
    }
    
    if (j == -1) {
        System.out.println("No");
    }
 }

 /**
 *
 * Here this method prints all the recipe names which are in the recipe box
 *
 */
 
 public void printAllRecipeNames() throws Exception {
    System.out.println("Below are the recipes in the recipe box:"
    + "\n");
 
    for (int i = 0; i < listOfRecipes.size(); i++) {
        System.out.println(i + 1 + ": " +
        listOfRecipes.get(i).getRecipeName() + "\n");
    }
    
    if (listOfRecipes.isEmpty()) {
        System.out.println("There are no recipes in the recipe box");
    }
 }

 /**
 *
 * Here method allows the users to add the new recipe
 *
 */
 
 public void addNewRecipe() throws Exception {
    listOfRecipes.add(r. createNewRecipe ());
    System.out.println("Recipe added successfully" +"\n");
 }
 
 public void menu() throws Exception {
    RecipeBox myRecipeBox = new RecipeBox();
    Scanner menuScnr = new Scanner(System.in);
/**
 *
 * Here prints a menu for the user to select one of the three options
 *
 */
    System.out.println("1. Add Recipe\n" + "2. Print All Recipe Details\n" + 
        "3. Print All Recipe Names\n" + "4. Edit Recipe\n" + "5. Delete Recipe\n" +
        "6. Add Recipe Instructions\n" +"7. Exit\n" + "Please select a menu item:");

 while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
    int input = menuScnr.nextInt();
    System.out.println("");
    
    switch (input) {
        case 1:
            myRecipeBox.addNewRecipe();
            break;
        case 2:
            Scanner scnrMenu = new Scanner(System.in);
            System.out.println("Which recipe?\n");
            String selectedRecipeName = scnrMenu.nextLine();

            myRecipeBox. printAllRecipeDetails( selectedRecipeName);
            break;
        case 3:
            myRecipeBox.printAllRecipeNames();
            break;
        case 4:
            Scanner scnrEdit = new Scanner(System.in);
            System.out.println("Which recipe to edit?\n");
            String editRecipeDetails = scnrEdit.nextLine();
            myRecipeBox.editRecipe(editRecipeDetails);
            break;
        case 5:
            Scanner scnrDlt = new Scanner(System.in);
            System.out.println("Which recipe to delete?\n");
            String dltRecipe = scnrDlt.nextLine();
            myRecipeBox.deleteRecipe(dltRecipe);
            break;
        case 6:
            Recipe r = new Recipe();
            Scanner scnrRecipe = new Scanner(System.in);
            System.out.println("Which recipe ?\n");
            String recipeIngredients =
            scnrRecipe.nextLine();

            int j = -1;
            
            for (int i = 0; i < listOfRecipes.size(); i++) {
                
                if (listOfRecipes.get(i).getRecipeName().endsWith(recipeIngredients.trim())) {
                j = i;
                r.setRecipeName(recipeIngredients);
                r.setServings(listOfRecipes.get(i).getServings());

                r.setRecipeIngredients(listOfRecipes.get(i).getRecipeIngredients());

                r.setTotalRecipeCalories(listOfRecipes.get(i).getTotalRecipeCalories());
                }
            }
            
            if (j == -1) {
                System.out.println("The selected Recipe is not in recipe box");
            }
    
            r.setRecipeName(recipeIngredients);
            r. addRecipeInstructions ();
            r. printRecipeInstructions ();
        case 7:
            System.exit(0);
        default:
            System.out.println("\nMenu:\n" + "1. Add Recipe\n" + "2. Print Recipe\n" + 
               "3. Adjust Recipe Servings\n" + "\nPlease select a menu item:");
            break;
    } //End switch
 
    
    System.out.println("Menu:\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + 
        "3. Print All Recipe Names\n" + "4. Edit Recipe\n" + "5. Delete Recipe\n" + 
        "6. Add Recipe Instructions\n" +"7. Exit\n"+ "Please select a menu item:");
  }
 }
 
 public static void main (String[] args) throws Exception {
    RecipeBox rb = new RecipeBox();
    rb.menu();
  }
 }
 