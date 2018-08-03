//log level configuration
Logger.getLogger("org").setLevel(Level.ERROR)

//Spark API basic Configuration using all cpu's
val conf = new SparkConf().setAppName("xxxxx").setMaster("local[*]")
val sc = new SparkContext(conf)

//ingesting data from a csv into a RDD
val data = sc.textFile( "in/a_file.csv")

