println("======== STARTED =======")

    val citylist = List(
      "State->Telangana,City->Hyderabad",
      "State->Gujarat,City->GandhiNagar",
      "State->UttarPradesh,City->Lucknow"
    )

    println
    println("====raw list=====")
    println

    println(citylist)

    val flatdata = citylist.flatMap(x => x.split(","))


    println
    println("====Flatdata list=====")
    println


    flatdata.foreach(println)

    val cityfilter = flatdata.filter(x => x.contains("City"))


    println
    println("====cityfilter list=====")
    println


    cityfilter.foreach(println)

    val repcity = cityfilter.map(x => x.replace("City->",""))

    println
    println("====repcity list=====")
    println


    repcity.foreach(println)

    val statefilter = flatdata.filter(x => x.contains("State"))


    println
    println("====statefilter list=====")
    println


    statefilter.foreach(println)

    val repstate = statefilter.map(x => x.replace("State->",""))

    println
    println("====repcity list=====")
    println


    repstate.foreach(println)
  }

}