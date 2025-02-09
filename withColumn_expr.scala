// Pre Code

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
			
		

			val data = Seq(
					("00000000", "06-26-2011", 200, "Exercise", "GymnasticsPro", "cash"),
					("00000001", "05-26-2011", 300, "Exercise", "Weightlifting", "credit"),
					("00000002", "06-01-2011", 100, "Exercise", "GymnasticsPro", "cash"),
					("00000003", "06-05-2011", 100, "Gymnastics", "Rings", "credit"),
					("00000004", "12-17-2011", 300, "Team Sports", "Field", "paytm"),
					("00000005", "02-14-2011", 200, "Gymnastics", null, "cash")
					)


			val df = data.toDF("id", "tdate", "amount", "category", "product", "spendby")


			df.show()

			df.printSchema()

			// ==================  WORK SPACE ===========================


			val colist= List("id", "amount", "status", "category", "product", "spendby")

			val procdf = df.withColumn( "category" , expr("upper(category)") )
						   .withColumn("product" ,expr("lower(product)"))
						   .withColumn("status", expr("case when spendby='cash' then 0 else 1 end"))
                           .withColumn("spendby", expr("concat(spendby, '-zeyo')"))
						   .drop("tdate")
						   .select(colist.map(col) :_* )

		    procdf.show()
			procdf.printSchema()


	}
}