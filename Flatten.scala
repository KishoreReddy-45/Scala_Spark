Flatten Full Code


package pack

object obj {

	def main(args:Array[String]):Unit={


			println("======== STARTED =======")

			val lss = List ( "A~B" , "C~D" , "E~F" )
			
			println
			println("===raw data===")
			println			
			println(lss)
			lss.foreach(println)
					
			val flatten = lss.flatMap(x => x.split("~"))
			
			println
			println("===flatten data===")
			println			
			
			println(flatten)
			
			flatten.foreach(println)
		
	}
}