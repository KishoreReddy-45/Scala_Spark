//  lead and Lag Code

// full join code

package pack // change your package name

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions.Window

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
					("DEPT3", 500),
					("DEPT3", 200 ),
					("DEPT1", 1000 ),
					("DEPT1", 700 ),
					("DEPT1", 700 ),
					("DEPT1", 500 ),
					("DEPT2", 400 ),
					("DEPT2", 200)
					)


			val df: DataFrame = data.toDF("department", "salary")


			df.show()

			
			//      WAY 1 
			
			
			val departwindow = Window
			
			                      .partitionBy("department")
			                      
			                      .orderBy( col("salary") desc )
			
			
      println
      println ("==== lead====")
      println
      
			val  lead1 = df.withColumn("lead", lead(col("salary"),1) over departwindow) 
			
			lead1.show()
			
 			
      println
      println ("==== lag====")
      println
      
			val  lag1 = df.withColumn("lag", lag(col("salary"),1) over departwindow) 
			
			lag1.show()
	
			

			


	}
}