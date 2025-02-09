package pack


object lambda {


  def main(args:Array[String]):Unit={

    println("===== RAW LIST ===== ")

    val lsin = List( 1, 2, 3, 4 )

    println(lsin)

#use lambda function to iterate the list(=>)
 
    println("===== Add LIST ===== ")

    val addlis = lsin.map (x => x + 2)

    println(addlis)

    println("===== MUL LIST ===== ")

    val Mullis = lsin.map (y => y * 2)

    println(Mullis)
	
	println("===== filter LIST ===== ")

    val fillis = lsin.filter (x => x > 2)

    println(fillis)
	
	println("===== Reversed LIST ===== ")

    val rlis = lsin.reverse

    println(rlis)

  }

}