package pack // change your package name

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

object obj {  // change your object name


	def main(args:Array[String]):Unit={

			println("====started====")
			val conf = new SparkConf().setAppName("first").setMaster("local[*]")
			.set("spark.driver.host","localhost").set("spark.driver.allowMultipleContexts", "true")


			val sc = new SparkContext(conf)

			sc.setLogLevel("ERROR")

			val spark = SparkSession.builder().getOrCreate()

			import spark.implicits._			



			val leftdata = Seq(
					("1","raj"),
					("2","ravi"),
					("3","sai"),
					("5","rani")
					)


			val leftdf = leftdata.toDF("id", "name")


			leftdf.show()

			//	leftdf.printSchema()


			val rightdata = Seq(
					("1","mouse"),
					("3","mobile"),
					("7","laptop")
					)


			val rightdf = rightdata.toDF("id", "product")



			rightdf.show()

			val rightdf1 = rightdata.toDF("id", "product").withColumnRenamed("id","cid")



			rightdf1.show()

			//	rightdf.printSchema()





			// ==================  WORK SPACE ===========================


			println
			println("==== inner====")
			println

			val innerjoin = leftdf.join(rightdf,Seq("id"),"inner")

			innerjoin.show()

			println
			println("==== left====")
			println			

			val leftjoin = leftdf.join(rightdf,Seq("id"),"left")

			leftjoin.show()			

			println
			println("==== RIGHT====")
			println	


			val rightjoin = leftdf.join(rightdf,Seq("id"),"right")

			rightjoin.show()	


			println
			println("==== full====")
			println	


			val fulljoin = leftdf.join(rightdf,Seq("id"),"full")

			fulljoin.show()		


			println
			println("==== inner with different column name====")
			println	



			val innerjoin1 =leftdf.join(rightdf1, leftdf("id") === rightdf1("cid"),"inner")

			innerjoin1



	}
}