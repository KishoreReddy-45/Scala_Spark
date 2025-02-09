



package pack


import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import pack.orc_file.columns

object obj {


      case class columns(id:String,category:String,product:String,spendby:String)

      def main(args:Array[String]):Unit= {

        println("====started====")
        val conf = new SparkConf().setAppName("first").setMaster("local[*]").set("spark.driver.host", "localhost").set("spark.driver.allowMultipleContexts", "true")

        val sc = new SparkContext(conf)

        sc.setLogLevel("ERROR")

        val spark = SparkSession.builder().getOrCreate()

        import spark.implicits._


        println
        println("====CSV=====")
        println

        val csvdf = spark
          .read
          .format("csv")
          .option("header", "true")
          .load("file:///C:/Big DATA/usdata.csv") // CHANGE PATH ACCORDINGLY

        csvdf.show()


        println
        println("====parquet=====")
        println

        val parquetdf = spark
          .read
          .format("parquet")
          .load("file:///C:/Big DATA/part.parquet") // CHANGE PATH ACCORDINGLY

        parquetdf.show()


        println
        println("====ORC=====")
        println

        val orcdf = spark
          .read
          .format("orc")
          .load("file:///C:/Big DATA/part.orc") // CHANGE PATH ACCORDINGLY

        orcdf.show()

        println
        println("====Json=====")
        println

        val jsondf = spark
          .read
          .format("json")
          .load("file:///C:/Big DATA/devices.json") // CHANGE PATH ACCORDINGLY

        jsondf.show()


      }

}
