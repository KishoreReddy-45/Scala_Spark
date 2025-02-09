//Actors flatten Code

package pack

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SparkSession, Row}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._
import scala.io.Source


object api {


	def main(args:Array[String]):Unit={

			println("===Hello====")

			val conf = new SparkConf().setAppName("first").setMaster("local[*]").set("spark.driver.host","localhost")
			.set("spark.driver.allowMultipleContexts", "true")

			val sc = new SparkContext(conf)

			sc.setLogLevel("ERROR")

			val spark = SparkSession.builder.getOrCreate()

			import spark.implicits._

			val data= """{
			"country" : "US",
			"version" : "0.6",
			"Actors": [
			{
			"name": "Tom Cruise",
			"age": 56,
			"BornAt": "Syracuse, NY",
			"Birthdate": "July 3, 1962",
			"photo": "https://jsonformatter.org/img/tom-cruise.jpg",
			"wife": null,
			"weight": 67.5,
			"hasChildren": true,
			"hasGreyHair": false,
			"picture": {
			"large": "https://randomuser.me/api/portraits/men/73.jpg",
			"medium": "https://randomuser.me/api/portraits/med/men/73.jpg",
			"thumbnail": "https://randomuser.me/api/portraits/thumb/men/73.jpg"
			}
			},
			{
			"name": "Robert Downey Jr.",
			"age": 53,
			"BornAt": "New York City, NY",
			"Birthdate": "April 4, 1965",
			"photo": "https://jsonformatter.org/img/Robert-Downey-Jr.jpg",
			"wife": "Susan Downey",
			"weight": 77.1,
			"hasChildren": true,
			"hasGreyHair": false,
			"picture": {
			"large": "https://randomuser.me/api/portraits/men/78.jpg",
			"medium": "https://randomuser.me/api/portraits/med/men/78.jpg",
			"thumbnail": "https://randomuser.me/api/portraits/thumb/men/78.jpg"
			}
			}
			]
			}"""


			val df = spark.read.json(sc.parallelize(List(data)))

			df.show()

			df.printSchema()

			val explodedf = df.withColumn("Actors",expr("explode(Actors)"))

			explodedf.show()
			
			explodedf.printSchema()
			   

			val finalflatten = explodedf.selectExpr(
			    
			
			                          "Actors.Birthdate",
			                          "Actors.BornAt",
			                          "Actors.age",
			                          "Actors.hasChildren",
			                          "Actors.hasGreyHair",
			                          "Actors.name",
			                          "Actors.photo",
			                          "Actors.picture.large",
			                          "Actors.picture.medium",
			                          "Actors.picture.thumbnail",
			                          "Actors.weight",
			                          "Actors.wife",
			                          "country",
			                          "version"

			
			
			)
			
			finalflatten.show()
			
			finalflatten.printSchema()
			



	}

}