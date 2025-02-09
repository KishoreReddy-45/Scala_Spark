package pack

object obj {

	def main(args:Array[String]):Unit={

			println("======== STARTED =======")

			val lss = List(
					"hadoop",
					"hive",
					"sqoop",
					"hadoop",
					"hive"
					)
			println
			println("====Raw list=====")
			println

			lss.foreach(println)
			
			val dlss = lss.distinct
			
			println
			println("====distinct list=====")
			println

			dlss.foreach(println)			
			
			val upper = dlss.map( x => x.toUpperCase())
			
			println
			println("====upper list=====")
			println

			upper.foreach(println)						
			
			val finalist = upper.map(  x =>  "Tech -> " +    x   + " Trainer -> Kishore"  )
			
			println
			println("====finalist list=====")
			println

			finalist.foreach(println)						
			
			
			
			

	}
}
