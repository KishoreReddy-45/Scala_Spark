def main(args:Array[String]):Unit={

    println("====started====")
    val conf = new SparkConf().setAppName("first").setMaster("local[*]").set("spark.driver.host", "localhost").set("spark.driver.allowMultipleContexts", "true")

    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    val spark = SparkSession.builder().getOrCreate()

    import spark.implicits._

    val data1 = spark.read.csv("file:///C:/Big DATA/usdata.csv").show()

    println("=======CSV=========")

    val data = sc.textFile("file:///C:/Big DATA/usdata.csv")

    data.foreach(println)


    println("=======length of 200 =========")

    val filterdata = data.filter( x => x.length > 200 )

    filterdata.foreach(println)

    println("=======split comma=========")


    val flatdata = filterdata.flatMap(x => x.split(","))

    flatdata.foreach(println)

    println("=======remove hyphens =========")

    val removehyp = flatdata.map( x => x.replace("-",""))

    removehyp.foreach(println)

    println("=======add zeyo =========")

    val addzeyo = removehyp.map( x => x + ",zeyo")

    addzeyo.foreach(println)

    //addzeyo.saveAsTextFile("file:///c:/Big data/")



      }

}