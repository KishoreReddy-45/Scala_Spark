package pack

object obj {
  def main(args:Array[String]):Unit={

    println("===== started ======")


    val listr = List ( "zeyobron" , "zeyo"  , "lakes" )


    println
    println("==== raw list======")
    
    println(listr)

    val cl = listr.map( x  =>  x +  " analytics")

    println
    println("==== con list===")

    println(cl)
	
	val el = listr.filter( x  =>  x.equals("zeyo"))

    println
    println("==== Equals list======")

    println(el)

    val rl = listr.map( x  =>  x.replace("zeyo","tera"))

    println
    println("==== Replace list======")

    println(rl)



  }

}