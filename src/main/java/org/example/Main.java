package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Publicatie> publicatii = readJson("/Users/fnxr/IdeaProjects/TESTJ/src/main/java/org/example/data.json");

        while (true){
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Pentru vizualizare publicatii apasa 1");
            System.out.println("Pentru filtrare publicatii dupan an apasa 2");
            System.out.println("Pentru filtrare publicatii dupa tip apasa 3");
            System.out.println("Pentru adaugare publicatii apaasa  4");

            switch (keyboard.nextLine()){
                case "1":
                   publicatii.forEach(publicatie -> {
                       System.out.println(publicatie.toString());
                   });
                    break;
                case "2":
                    var result =  publicatii.stream().sorted((pub1,pub2)-> String.valueOf(pub1.getAnPublicare()).compareTo(String.valueOf(pub2.getAnPublicare()))).collect(Collectors.toList());
                    result.forEach(elm -> {
                        System.out.println(elm.toString());
                    });
                    break;
                case "3":
                    Scanner keyboard2 = new Scanner(System.in);
                    if(keyboard2.nextLine().equals("Carte")){
                      publicatii.stream().filter(publicatie -> publicatie instanceof  Carte)
                              .map(Publicatie::toString)
                              .forEach(System.out::println);
                    }
                    else if(keyboard2.nextLine().equals("Revista")){
                        publicatii.stream().filter(publicatie -> publicatie instanceof  Revista)
                                .map(Publicatie::toString)
                                .forEach(System.out::println);

                    }
                    break;
                    case "4":
                        Scanner keyboard3 = new Scanner(System.in);
                        if(keyboard3.nextLine().equals("Carte")){
                            String titlu = keyboard3.next().toString();
                            String autor =  keyboard3.next().toString();
                            String anPublicare =  keyboard3.next().toString();
                            String numarPagni = keyboard3.next().toString();;
                            publicatii.add(new Carte(titlu,autor,Integer.parseInt(anPublicare),Integer.parseInt(numarPagni)));
                        }
                        else if(keyboard3.nextLine().equals("Revista")){
                            String titlu =  keyboard3.next().toString();;
                            String autor =  keyboard3.next().toString();;
                            String anPublicare = keyboard3.next().toString();;
                            String numarExemplar =  keyboard3.next().toString();;
                            publicatii.add(new Revista(titlu,autor,Integer.parseInt(anPublicare),Integer.parseInt(numarExemplar)));
                        }
                        break;


            }



        }

    }


    public static List<Publicatie> readJson(String file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Publicatie> publicatii= new ArrayList<>();

        JsonNode node = mapper.readTree(new File(file));

        node.forEach((element)->{
            String titlu = element.get("titlu").asText();
            String autor = element.get("autor").asText();
            String anPublicare = element.get("anPublicare").asText();
            String numarExemplare = (element.get("numarExemplar") == null) ? "" : element.get("numarExemplar").asText();
            String numarPagini = (element.get("numarPagini") == null) ? "" : element.get("numarPagini").asText();

            if(numarExemplare.isEmpty() == false){

                publicatii.add(new Revista(titlu,autor,Integer.parseInt(anPublicare),Integer.parseInt(numarExemplare)));

            }

            else {
                publicatii.add(new Carte(titlu,autor,Integer.parseInt(anPublicare),Integer.parseInt(numarPagini)));
            }

        });

               return publicatii;
    }
}