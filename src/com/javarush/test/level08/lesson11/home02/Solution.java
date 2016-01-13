package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    static Cat cat1 = new Cat("Cat1");
    static Cat cat2 = new Cat("Cat2");
    static Cat cat3 = new Cat("Cat3");
    static Cat cat4 = new Cat("Cat4");

    static Dog dog1 = new Dog("Dog1");
    static Dog dog2 = new Dog("Dog2");
    static Dog dog3 = new Dog("Dog3");

    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
      //  System.out.println("-------------");

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> catHashSet = new HashSet<Cat>();

        catHashSet.add(cat1);
        catHashSet.add(cat2);
        catHashSet.add(cat3);
        catHashSet.add(cat4);

        return catHashSet;
    }

    public static Set<Dog> createDogs()
    {
        Set<Dog> dogHashSet = new HashSet<Dog>();
        dogHashSet.add(dog1);
        dogHashSet.add(dog2);
        dogHashSet.add(dog3);

        return dogHashSet;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        Set<Object> pets = new HashSet<Object>();
        {
            for (Dog dogSet: dogs) {
             //   System.out.println(dogSet.name);
                pets.add(dogSet);
            }
            for (Cat catSet: cats) {
             //   System.out.println(catSet.name);
                pets.add(catSet);
            }
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        /*Iterator<Object> iteratorPets = pets.iterator();

        while(iteratorPets.hasNext()){
            Object petIterator = iteratorPets.next();
            //System.out.println(petIterator+" petIterator "+i++);
            Iterator<Cat> iteratorCats = cats.iterator();

                while(iteratorCats.hasNext()){
                    Cat catIterator = iteratorCats.next();
                    //System.out.println(catIterator+" catIterator "+j++);
                    if (catIterator.equals(petIterator)){
                      //  System.out.println(catIterator+" "+petIterator+" equals");
                        iteratorPets.remove();
                    }
                }
            }*/

        Set<Object> tempPets = new HashSet<Object>(pets);
        for (Object petsSet: tempPets)
        {
            for (Cat catSet : cats)
            {
                //Cat tempCatSet = catSet;
              //  Object tempPetsSet = petsSet;
               // System.out.println(tempCatSet+" "+tempPetsSet);
                if (catSet.equals(petsSet))
                {
                  //  System.out.println(tempCatSet + " equal " + tempPetsSet);
                    pets.remove(catSet);
                }

            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        for (Object setPets: pets) {
            System.out.println(setPets);
        }
    }

    public static class Cat
    {
           String name;

        public Cat(String name){
                   this.name=name;
        }
    }
    public static class Dog
    {
           String name;

        public Dog(String name){
                   this.name=name;
        }
    }
}
