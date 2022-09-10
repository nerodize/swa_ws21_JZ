import java.util.*
import kotlin.system.measureNanoTime



fun addMe(a: Int, b: Int) = a+b

fun main(args: Array<String>) {
    val addMeTwice = { a: Int, b: Int -> a + b }
    val result = addMeTwice(42, 1337)



    //Lambda
    var list = (1..20).toList()
    list = list.filter { it % 2 == 0 } //it == current number
    println(list)

    //Funktioniert genauso ==> bol(it)
    fun bol (a: Int): Boolean {
        return a % 2 == 1
    }

    val listV2 = (1..10).toList() //wichtiger step für lambda
    val sum = listV2.customSum {bol(it)} //if true ==> += item // oder eben it % 2 == 1
    println("The sum is: $sum")

    //Destructuring
    val person = Person("Alex", "Seitz", 22)

    val (firstName,lastName, age) = person

    println(firstName)
    println(lastName)
    println(age)

    val obj = Foo()
    obj.a = 43
    val obj2 = Foo()
    println(obj.a)
    println(obj2.a)
    println(Foo.b)
    Foo.b = 1338
    println(Foo.b)

    //Ranges with repeat() ==> Counting from zero 9 times 
    repeat(9) {println(it)}

    println(::x.name)


    //Output normal Function
    println(double(8))

    //Output single Expression Function
    println(triple(10))

    val behin = BehindertPrivatkunde(behindertenId = 20, id = 1234, nachname = "Seitz", vorname = "Seitz")

    println("Die BehindertenID des Menschen lautet: ${behin.behindertenId}!")
    println(behin.toString())


    /**
     * Scope Function that lets you do assignations/assignment that otherwise wouldn't be possible
     * we only execute let if nummer is not null ==> then access to it which is basically nummer in the first line we also could assign another variable.
     * it == nummer
     * let saves the nummer at the time we call the let function
     * let apparently, returns last line
     *  @author [Alexander Seitz](mailto: alexseitz248@gmail.com)
     */
    nummer?.let {
                              //we only execute let if nummer is not null ==> then access to it which is basically nummer
        val nummer2 = it + 1 //it == nummer
                            //let saves the nummer at the time we call the let function
                            //nummer2 is nummer + 1
    }

    println("Here we have the result of the function: getSquaredI()  ${getSquaredI()}")
    println("Here we have the result of the function: getSquaredI()  ${getSquaredI()}")


    val listForEach = (1..100).toList()

    listForEach.filter{it % 2 == 0}.forEach{println("Die gerade Zahl: $it")}

    println("ForEach Time: " + measureNanoTime {
        (0 .. 10).forEach{println("Talon $it")}
    } +  "ns")

    println("Bitte Key angeben!")
    val key: String = readln()
    val value = "Alex"

    val res: String
    when (key) {
        "2324" -> {
            res = "Der name lautet $value Seitz"
        }
        else -> {
            res = "Der Spast hat keinen Namen"
        }
    }

    println(res)

    repeat(20){
        println("-----------------------")
    }

    val myNumbers: List<Int> = listOf(2,3,4,6,23,90)

    val mySquaredNums: List<Int> = myNumbers.map {it * it} //num -> num * num

    mySquaredNums.forEach {println(it)}


    repeat(5){
        println("----")
    }
    val student = Student()
    println("Die Matrikelnummer lautet: ${student.matrikelnummer}")

    //list.filter{it % 2 == 0}.forEach {println("true")}
    val listEarly = (1 .. 20 ).toList()
    for(i in listEarly) {
        if (i % 2 == 0) {
            println("true")
        } else {
            println("false")
        }
    }


// FizzBuzz
    val array = 1..100
    println(array)
}

val x = 1

data class Person(val firstName: String, val lastName: String, val age: Int)

/**
 * CustomSum Funktion, ist eine Extension Function gepaart mit Lambda Ausdruck
 * @param sumFunction
 * @return Ein Integer, der nach den Suchkriterien die Liste filtert.
 * @author [Alexander Seitz](mailto: alexseitz248@gmail.com)
 */
fun List<Int>.customSum(sumFunction: (Int) -> (Boolean)): Int {
    var sum = 0
    for (item in this) {
        if (sumFunction(item)){
            sum += item
        }
    }
    return sum
}

//Sealed Classes, clean code better Enum classes
sealed class SealedCar(val model: String) {
    object BMW: SealedCar("m6")
    object AUDI: SealedCar("a3")
}

class Foo{
    var a: Int = 42
    companion object {
        var b: Int = 1337
    }
}

/**
 * Function double
 * @param num
 * @author [Alexander Seitz](mailto: alexseitz248@gmail.com)
 */
fun double(num: Int): Int{
    return num * 2
}

/**
 * Function triple
 * @param number
 * @return An Integer three times as much as the passed number
 * @author [Alexander Seitz](mailto: alexseitz248@gmail.com)
 */
fun triple(number: Int) = number * 3


private var nummer: Int? = null  //declared globally, not sure whether or not other threads are accessing nummer at the same time

private var i = 0

/**
 * *get SquaredI* function (actually Single Expression Function) linked with an also block
 * Unlike let, it takes the variables it was called on not the last line in the curly brackets
 */
fun getSquaredI() = (i * i).also{
    i++
}

//Superklasse eher Basisklasse (nach unten betrachtet)
abstract class AbstractKunde (
    val nachname: String,
    val vorname: String,) {

    override fun toString () =
        "AbstractKunde(nachname= $nachname, vorname=$vorname)"
}

//Unterklasse und Basis zugleich (kommt auf die Sichtweise drauf an)
 open class Privatkunde (
    private val id: Int,
    nachname: String,
    vorname: String) : AbstractKunde(nachname, vorname) {

    override fun toString() =
        "Privatkunde (id=$id, ${super.toString()})"
}

//Nur Unterklasse
class BehindertPrivatkunde (
    val behindertenId: Int,
    id: Int,
    nachname: String,
    vorname: String,) : Privatkunde(id, nachname, vorname) {

    override fun toString() =
        "Behinderter Privatkunde (behindertenId=$behindertenId, ${super.toString()})"
}

data class Student(
    val matrikelnummer: UUID = UUID.randomUUID(),
    val name: String = "Seitz",
    val nachname: String = "Alexander",
)

var a: String = "Alex"













