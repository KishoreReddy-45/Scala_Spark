// TWO COLUMN GROUP NAME

// full join code

package pack // change your package name

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.sql.types._

object obj {  // change your object name


	def main(args:Array[String]):Unit={

			println("====started====")
			val conf = new SparkConf().setAppName("first").setMaster("local[*]")
			.set("spark.driver.host","localhost").set("spark.driver.allowMultipleContexts", "true")


			val sc = new SparkContext(conf)

			sc.setLogLevel("ERROR")

			val spark = SparkSession.builder().getOrCreate()

			import spark.implicits._			








			// ======================= WORKSPACE ==============



			val data = Seq(
					("sai","hyderabad","10"),
					("sai","chennai","5"),
					("sai","hyderabad","15"),
					("sai","chennai","10"),
					("sai","hyderabad","5")
					)


			val df = data.toDF("name","location","amount")


			df.show()



			val aggdf = df.groupBy("name","location")
			
			              .agg(
			                    sum("amount").cast(IntegerType).alias("total"),
			                    count("amount").as("cnt")
			              
			              
			              
			              )
			
			
			aggdf.show()
			
		


	}
}