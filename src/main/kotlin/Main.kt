open class Animal

class Dog:Animal() {
    override fun toString(): String {
        return "Dog"
    }
}

class BloodHound() {
    override fun toString(): String {
        return "Bloodhound"
    }
}

open class Shark:Animal() {
    override fun toString(): String {
        return "Shark"
    }
}

class GreatWhiteShark:Shark() {
    override fun toString(): String {
        return "Jaws"
    }
}

fun sayHelloToTheAnimal(animal:Animal) {
    println("Hello $animal")
}

fun dogConverter(dog:Dog, converter:(Dog)->Shark ):Shark {
    return converter(dog)
}

fun convertToShark(dog:Dog):Shark {
    println("Goodby $dog")
    return Shark()
}

val convertDogToShark =  { dog:Dog ->
    println("Goodby $dog")
    Shark()
}

val convertAnimalToShark = { animal:Animal ->
    println("Goodby $animal")
    Shark()
}

val convertBloodHoundToShark =  { hound:BloodHound ->
    println("Goodby $hound")
    Shark()
}

val convertAnimalToJaws = { animal:Animal ->
    println("Goodby $animal")
    GreatWhiteShark()
}

fun main(args: Array<String>) {

    val rover = Dog()
    val shark1 = dogConverter(rover, converter = convertDogToShark)
    sayHelloToTheAnimal(shark1)

    val shark2 = dogConverter(rover, converter = convertAnimalToShark) //this is OK because input of converter is contravariant
    sayHelloToTheAnimal(shark2)

    //val shark3 = dogConverter(rover, converter = convertBloodHoundToShark) //this won't work as can't use subtype of dog

    val shark4 = dogConverter(rover, converter = convertAnimalToJaws) //this is OK because output of converter is covariant
    sayHelloToTheAnimal(shark4)

}
