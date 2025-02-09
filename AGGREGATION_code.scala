// AGGREGATION cODE

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
					("kishore","10"),
					("Reddy","5"),
					("Krishna","5"),
					("Kittu","20"),
					("sai","10")
					)


			val df = data.toDF("name","amount")


			df.show()



			
			val aggdf = df.groupBy("name")
			              .agg(
			                  
			                    sum("amount").cast(IntegerType).alias("total"),
			                    count("amount").alias("cnt"),
			                    size(collect_set("amount")).alias("distinct_cnt")
			                    
			              
			                    
			                  )
			
			              
			
			aggdf.show()
			






	}
}
