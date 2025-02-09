// Full Solution

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



			val sourcedf = Seq(
                         (1, "A"),
                         (2, "B"),
                         (3, "C"),
                         (4, "D")
                         )
                         .toDF("id","name")
			
			sourcedf.show()
			
			
			val targetdf = Seq(
                         (1, "A"),
                         (2, "B"),
                         (4, "X"),
                         (5, "F")
                         )
                         .toDF("id1","name1")
			
			targetdf.show()
			

			
			val  fulljoin = sourcedf.join(targetdf,sourcedf("id")===targetdf("id1"),"full")
			                  .orderBy("id")
			
			fulljoin.show()
			
			
			
			
			val matchdf= fulljoin.withColumn("comment",expr("""
			                                            
			                                            case when name=name1 then 'match'
			                                             else 'mismatch'
			                                             end     
			  
			  
			                                              """))
			
			matchdf.show()
			
			
			
			
			val mismatch = matchdf.filter("comment='mismatch'")
			
			
			mismatch.show()
			
			
			
			
			val  newdf = mismatch.withColumn("comment", expr("""
			  
			                                          case 
			                                          when id is null then 'new in target'
			                                          when id1 is null then 'new in source'
			                                          else
			                                          comment
			                                          end
			                """))
			
			
			newdf.show()
			
			
			
			
			val prefinaldf = newdf.withColumn("id",expr("""
			  
			                                    case when id is null then id1
			                                    else
			                                    id
			                                    end
			   """))
			
			prefinaldf.show()
			
			
			
			
			val finaldf = prefinaldf.select("id","comment")
			
			finaldf.show()
	
			
			
			

	}
}