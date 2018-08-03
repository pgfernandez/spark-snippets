//cleaning the header of a csv file
val cleanData = data.filter(!_.contains("column"))



/**** TYPICAL PAIR-RDD WITH TOTAL AMOUNT, COUNTERS AND MEAN *******/
//creating a pairRDD chosing 2 fields of the csv and adding a counter for future data aggregation
val pairRDDWithSomeColumns = cleanData.map(line => (line.split(",")(1),(1,line.split(",")(9).toDouble)))

//total amount of second value of the tuple and total records (counter)
val totalAmount = pairRDDWithSomeColumns.reduceByKey((x,y) => (x._1 + y._1, x._2 + y._2))

//collect the RDD data and show the data expressed in x and y
for ((x, y) <- totalAmount.collect()) println(......)

//map a mean function
val meanAmount = totalAmount.mapValues(consumption => consumption._2 / consumption._1)
