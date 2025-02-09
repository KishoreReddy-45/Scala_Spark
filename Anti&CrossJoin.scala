// full join code

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
			val rightids = rightdf
			                  .select("id")
			                  .rdd
			                  .map( x =>x.mkString(""))
			                  .collect()
			                  .toList
			println(rightids)
			
			val  filleftdf = leftdf.filter(!(col("id").isin(rightids: _*)))
			
			filleftdf.show()
			
			val  filterdf = leftdf.join(rightdf,Seq("id"),"left_anti")
			
			filterdf.show()
			
			val crossjoin = leftdf.crossJoin(rightdf)
			
			crossjoin.show()

	}
}
