/*
MIT License

Copyright (c) 2025, Nuno Datia, Matilde Pato, ISEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package isel.sisinf.ui;

import isel.sisinf.jpa.Dal;
import isel.sisinf.jpa.repo.JPAContext;
import isel.sisinf.model.entities.Cliente;
import isel.sisinf.model.entities.Doca;
import isel.sisinf.model.entities.Passe;
import isel.sisinf.model.entities.Pessoa;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

/**
 * 
 * Didactic material to support 
 * to the curricular unit of 
 * Introduction to Information Systems 
 *
 * The examples may not be complete and/or totally correct.
 * They are made available for teaching and learning purposes and 
 * any inaccuracies are the subject of debate.
 */

interface DbWorker
{
    void doWork();
}
class UI
{
    private enum Option
    {
        // DO NOT CHANGE ANYTHING!
        Unknown,
        Exit,
        createCostumer,
        listCostumer,
        listDocks,
        startTrip,
        parkScooter,
        about
    }
    private static UI __instance = null;
  
    private HashMap<Option,DbWorker> __dbMethods;

    private UI()
    {
        // DO NOT CHANGE ANYTHING!
        __dbMethods = new HashMap<Option,DbWorker>();
        __dbMethods.put(Option.createCostumer, () -> UI.this.createCostumer());
        __dbMethods.put(Option.listCostumer, () -> UI.this.listCostumer()); 
        __dbMethods.put(Option.listDocks, () -> UI.this.listDocks());
        __dbMethods.put(Option.startTrip, new DbWorker() {public void doWork() {UI.this.startTrip();}});
        __dbMethods.put(Option.parkScooter, new DbWorker() {public void doWork() {UI.this.parkScooter();}});
        __dbMethods.put(Option.about, new DbWorker() {public void doWork() {UI.this.about();}});
    }

    public static UI getInstance()
    {
        // DO NOT CHANGE ANYTHING!
        if(__instance == null)
        {
            __instance = new UI();
        }
        return __instance;
    }

    private Option DisplayMenu()
    {
        Option option = Option.Unknown;
        Scanner s = new Scanner(System.in); //Scanner closes System.in if you call close(). Don't do it
        try
        {
            // DO NOT CHANGE ANYTHING!
            System.out.println("CITES Manadgement DEMO");
            System.out.println();
            System.out.println("1. Exit");
            System.out.println("2. Create Costumer");
            System.out.println("3. List Existing Costumer");
            System.out.println("4. List Docks");
            System.out.println("5. Start Trip");
            System.out.println("6. Park Scooter");
            System.out.println("8. About");
            System.out.print(">");
            int result = s.nextInt();
            option = Option.values()[result];
        }
        catch(RuntimeException ex)
        {
            //nothing to do.
        }
        
        return option;

    }
    private static void clearConsole() throws Exception
    {
        // DO NOT CHANGE ANYTHING!
        for (int y = 0; y < 25; y++) //console is 80 columns and 25 lines
            System.out.println("\n");
    }

    public void Run() throws Exception
    {
        // DO NOT CHANGE ANYTHING!
        Option userInput;
        do
        {
            clearConsole();
            userInput = DisplayMenu();
            clearConsole();
            try
            {
                __dbMethods.get(userInput).doWork();
                System.in.read();
            }
            catch(NullPointerException ex)
            {
                //Nothing to do. The option was not a valid one. Read another.
            }

        }while(userInput!=Option.Exit);
    }

    /**
    To implement from this point forward. 
    -------------------------------------------------------------------------------------     
        IMPORTANT:
    --- DO NOT MESS WITH THE CODE ABOVE. YOU JUST HAVE TO IMPLEMENT THE METHODS BELOW ---
    --- Other Methods and properties can be added to support implementation. 
    ---- Do that also below                                                         -----
    -------------------------------------------------------------------------------------
    
    */

    private static final int TAB_SIZE = 24;

    JPAContext ctxt = new JPAContext("cites-pu");

    private void createCostumer() {
        Pessoa p = new Pessoa();
        Scanner s = new Scanner(System.in);

        System.out.println("Insert your name:");
        String name = s.nextLine();
        p.setName(name);

        System.out.println("Insert your email:");
        String email = s.nextLine();
        p.setEmail(email);

        System.out.println("Insert your NIF (Tax Number):");
        int taxNumber = Integer.parseInt(s.nextLine());
        p.setTaxnumber(taxNumber);


        ctxt.beginTransaction();
        ctxt.getPessoas().Create(p);
        ctxt.commit();
        System.out.println("createCostumer()");
    }
  
    private void listCostumer()
    {
        ctxt.beginTransaction();
        List<Cliente> clientes = ctxt.getClientes().findAll();

        System.out.printf("%-20s %-30s %-15s %-10s%n", "Name", "Email", "Tax Number", "Pass Type");
        for (Cliente cliente : clientes) {
            Pessoa pessoa = cliente.getPersonEntity();

            List<Passe> passes = ctxt.getPasses().find("SELECT p FROM Passe p WHERE p.client.id = ?1", pessoa.getId());
            String passType = passes.stream()
                    .map(pass -> pass.getTypeofcard().getReference())
                    .findFirst()
                    .orElse("No Pass");

            System.out.printf("%-30s %-40s %-15d %-10s%n",
                    pessoa.getName(),
                    pessoa.getEmail(),
                    pessoa.getTaxnumber(),
                    passType
            );
        }

        ctxt.commit();
        System.out.println("listCostumer()");
    }

    private void listDocks()
    {
        // TODO()
        System.out.println("listDocks()");
    }

    private void startTrip() {
        // TODO
        System.out.println("startTrip()");
    }

    private void parkScooter()
    {
        // TODO
        System.out.println("parkScooter()");
        
    }

    private void about()
    {
        System.out.println("Group number: 41");
        System.out.println("Group members: Tomás Fonseca, Tiago Gonçalves, Rodrigo Duarte");
        System.out.println("DAL version:"+ Dal.version());
        System.out.println("Core version:"+ isel.sisinf.model.Core.version());
        
    }
}

public class App{
    public static void main(String[] args) throws Exception{
        UI.getInstance().Run();
    }
}