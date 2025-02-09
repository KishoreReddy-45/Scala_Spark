package pack 

import org.apache.spark.sprkConf
import org.apache.spark.sparkContext
import org.apache.spark.sparkSession

object obj{

  case class columns(id:String,category:String,product:String,spendby:String)


  def main(args: Array[String]): Unit = {

    println("====started====")

    val conf = new SparkConf().setAppName("first").setMaster("local[*]").set("spark.driver.host", "localhost").set("spark.driver.allowMultipleContexts", "true")

    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    println
    println("=============Read Data=============")
    println

    val data = sc.textFile("file:///C:/Big DATA/dr.txt")

    val mapsplit = data.map( x => x.split(","))

    val schemardd = mapsplit.map( x => columns( x(0),x(1),x(2),x(3)))

    val fildata = schemardd.filter( x => x.product.contains("Gymnastics"))

    fildata.foreach(println)


  }


}