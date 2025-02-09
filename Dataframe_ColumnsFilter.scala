package pack


import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import pack.orc_file.columns

object obj {

  def main(args:Array[String]):Unit={

    println("====started====")

    val conf = new SparkConf().setAppName("first").setMaster("local[*]").set("spark.driver.allowMultipleContexts", "true").set("spark.driver.host","localhost")

    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    val spark = SparkSession.builder().getOrCreate()

    import spark.implicits._

    println

    val data = sc.textFile("file:///C:/Big DATA/dr.txt",1) // CHANGE PATH ACCORDING TO YOUR PATH

    println
    println("========RAW DATA top 10 rows=======")
    println

    data.take(10).foreach(println)

    val mapsplit = data.map( x => x.split(","))

    val schemardd = mapsplit.map(x => columns(x(0),x(1),x(2),x(3)))

    val prodfil = schemardd.filter(x => x.product.contains("Gymnastics"))


    println
    println("========prodfil=======")
    println

    prodfil.foreach(println)

    val df = prodfil.toDF()

    println
    println("========df=======")
    println

    df.show()
    df.createOrReplaceTempView("iplfinal")

    val prodf = spark.sql("select id,product from iplfinal")

    prodf.show()

    println("===== all work done========")

  }

}










/*
--------------------Steps -------------------------------


Read the data--Done
Do Mapsplit--Done
Define case class columns schema--Done
Impose this columns schema on top of Mapsplit--Done
Do column filters--Done
SparkSession to be Done--Done
Convert it to Dataframe (toDF) and write it as parquet--Done
Give some name to the dataframe (table)--Done
Shoot sql query on top of that table--Done
Write the data as orc--Done


*/